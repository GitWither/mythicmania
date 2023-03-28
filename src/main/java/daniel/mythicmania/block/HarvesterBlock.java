package daniel.mythicmania.block;

import daniel.mythicmania.MythicMania;
import daniel.mythicmania.item.MythicManiaItems;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.event.GameEvent;

public class HarvesterBlock extends PlantBlock implements Fertilizable {
    public static final BooleanProperty BERRIES = Properties.BERRIES;
    private static final VoxelShape SHAPE = Block.createCuboidShape(3, 0, 3, 13, 2, 13);

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    public HarvesterBlock() {
        super(FabricBlockSettings.of(Material.PLANT, MapColor.GREEN).nonOpaque().sounds(BlockSoundGroup.AZALEA_LEAVES));
    }

    @Override
    public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
        return MythicManiaItems.POISONOUS_BERRY.getDefaultStack();
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public boolean hasRandomTicks(BlockState state) {
        return !hasBerries(state);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        boolean hasBerries = hasBerries(state);
        if (!hasBerries && player.getStackInHand(hand).isOf(Items.BONE_MEAL)) {
            return ActionResult.PASS;
        }

        if (hasBerries) {
            int berryCount = 1 + world.random.nextInt(2);
            SweetBerryBushBlock.dropStack(world, pos, new ItemStack(MythicManiaItems.POISONOUS_BERRY, berryCount));
            world.playSound(null, pos, SoundEvents.BLOCK_SWEET_BERRY_BUSH_PICK_BERRIES, SoundCategory.BLOCKS, 1.0f, 0.8f + world.random.nextFloat() * 0.4f);

            BlockState noBerriesState = state.with(BERRIES, false);
            world.setBlockState(pos, state.with(BERRIES, false), Block.NOTIFY_LISTENERS);
            world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(player, noBerriesState));

            return ActionResult.success(world.isClient);
        }

        return super.onUse(state, world, pos, player, hand, hit);
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state, boolean isClient) {
        return !hasBerries(state);
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        world.setBlockState(pos, state.with(BERRIES, true), Block.NOTIFY_LISTENERS);
    }

    private boolean hasBerries(BlockState state) {
        return state.get(BERRIES);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(BERRIES);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!hasBerries(state) && random.nextInt(5) == 0 && world.getBaseLightLevel(pos.up(), 0) >= 9) {
            BlockState stateWithBerries = state.with(BERRIES, true);
            world.setBlockState(pos, stateWithBerries, Block.NOTIFY_LISTENERS);
            world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(stateWithBerries));
        }
    }
}
