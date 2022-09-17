package daniel.mythicmania.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

public class RinthBlock extends Block {
    public static final BooleanProperty HANGING = Properties.HANGING;

    public RinthBlock() {
        super(FabricBlockSettings.of(Material.PLANT, MapColor.GREEN).nonOpaque().sounds(BlockSoundGroup.AZALEA_LEAVES));
        this.setDefaultState(this.getStateManager().getDefaultState().with(HANGING, false));
    }

    private static VoxelShape SHAPE = Block.createCuboidShape(1, 0, 1, 15, 4, 15);

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
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
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(HANGING);
    }
}
