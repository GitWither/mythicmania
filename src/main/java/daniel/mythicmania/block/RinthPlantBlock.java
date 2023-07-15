package daniel.mythicmania.block;

import daniel.mythicmania.item.MythicManiaItems;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

public class RinthPlantBlock extends PlantBlock implements Fertilizable {
    public static final BooleanProperty HANGING = Properties.HANGING;
    public static final IntProperty AGE = Properties.AGE_5;
    private static final VoxelShape SHAPE = Block.createCuboidShape(1, 0, 1, 15, 4, 15);

    public RinthPlantBlock() {
        super(FabricBlockSettings.copyOf(Blocks.FLOWERING_AZALEA).nonOpaque().sounds(BlockSoundGroup.AZALEA_LEAVES));
        this.setDefaultState(this.getStateManager().getDefaultState().with(HANGING, false).with(AGE, 1));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state, boolean isClient) {
        return !isFullyGrown(state);
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
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!isFullyGrown(state) && player.getStackInHand(hand).isOf(Items.BONE_MEAL)) {
            return ActionResult.PASS;
        }

        if (isFullyGrown(state)) {
            int berryCount = 2 + world.random.nextInt(3);
            SweetBerryBushBlock.dropStack(world, pos, new ItemStack(MythicManiaItems.RINTH_BERRY, berryCount));

            BlockState noBerriesState = state.with(AGE, 4);
            world.setBlockState(pos, noBerriesState, Block.NOTIFY_LISTENERS);

            world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(player, noBerriesState));
            world.playSound(null, pos, SoundEvents.BLOCK_CHERRY_LEAVES_BREAK, SoundCategory.BLOCKS, 1.0f, 0.4f + world.random.nextFloat() * 0.4f);

            return ActionResult.success(world.isClient);
        }

        return super.onUse(state, world, pos, player, hand, hit);
    }

    private boolean isFullyGrown(BlockState state) {
        return state.get(AGE) == 5;
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return !world.isAir(pos.down()) || !world.isAir(pos.up());
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        if (ctx.getSide() == Direction.DOWN) return this.getDefaultState().with(HANGING, true);
        return this.getDefaultState().with(HANGING, false);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!isFullyGrown(state) && random.nextInt(4) == 0 && world.getBaseLightLevel(pos.up(), 0) >= 8) {
            BlockState stateWithBerries = state.with(AGE, 5);

            world.setBlockState(pos, stateWithBerries, Block.NOTIFY_LISTENERS);
            world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(stateWithBerries));
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(HANGING).add(AGE);
    }
}
