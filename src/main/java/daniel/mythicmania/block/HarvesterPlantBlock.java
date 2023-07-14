package daniel.mythicmania.block;

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
import net.minecraft.state.property.IntProperty;
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

public class HarvesterPlantBlock extends PlantBlock implements Fertilizable {
    public static final IntProperty AGE = Properties.AGE_5;
    private static final VoxelShape SHAPE = Block.createCuboidShape(3, 0, 3, 13, 2, 13);

    public HarvesterPlantBlock() {
        super(FabricBlockSettings.copyOf(Blocks.FLOWERING_AZALEA).nonOpaque().sounds(BlockSoundGroup.AZALEA_LEAVES));
        this.setDefaultState(this.stateManager.getDefaultState().with(AGE, 1));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
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
        return !isFullyGrown(state);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!isFullyGrown(state) && player.getStackInHand(hand).isOf(Items.BONE_MEAL)) {
            return ActionResult.PASS;
        }

        if (isFullyGrown(state)) {
            int berryCount = 1 + world.random.nextInt(2);
            SweetBerryBushBlock.dropStack(world, pos, new ItemStack(MythicManiaItems.POISONOUS_BERRY, berryCount));

            BlockState noBerriesState = state.with(AGE, 4);
            world.setBlockState(pos, noBerriesState, Block.NOTIFY_LISTENERS);

            world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(player, noBerriesState));
            world.playSound(null, pos, SoundEvents.BLOCK_SWEET_BERRY_BUSH_PICK_BERRIES, SoundCategory.BLOCKS, 1.0f, 0.8f + world.random.nextFloat() * 0.4f);

            return ActionResult.success(world.isClient);
        }

        return super.onUse(state, world, pos, player, hand, hit);
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state, boolean isClient) {
        return !isFullyGrown(state);
    }

    private boolean isFullyGrown(BlockState state) {
        return state.get(AGE) == 5;
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return !isFullyGrown(state);
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        world.setBlockState(pos, state.with(AGE, state.get(AGE) + 1), Block.NOTIFY_LISTENERS);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!isFullyGrown(state) && random.nextInt(5) == 0 && world.getBaseLightLevel(pos.up(), 0) >= 9) {
            BlockState stateWithBerries = state.with(AGE, 5);

            world.setBlockState(pos, stateWithBerries, Block.NOTIFY_LISTENERS);
            world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(stateWithBerries));
        }
    }
}