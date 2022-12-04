package daniel.mythicmania.block;

import daniel.mythicmania.particle.MythicManiaParticles;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

public class LuminescentSacBlock extends Block {
    public static final BooleanProperty isHanging = Properties.HANGING;

    public LuminescentSacBlock() {
        super(FabricBlockSettings.of(Material.PLANT, MapColor.BLUE).nonOpaque().sounds(BlockSoundGroup.SLIME).strength(0.5f, 0.5f).luminance((state) -> 10));
    }

    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        VoxelShape voxelShape = this.getOutlineShape(state, world, pos, ShapeContext.absent());
        Vec3d vec3d = voxelShape.getBoundingBox().getCenter();
        double d = (double)pos.getX() + vec3d.x;
        double e = (double)pos.getZ() + vec3d.z;

        for(int i = 0; i < 3; ++i) {
            if (random.nextBoolean()) {
                world.addParticle(MythicManiaParticles.SAC_PARTICLE, d + random.nextDouble() / 2.0, (double)pos.getY() + (random.nextDouble()), e + random.nextDouble() / 5.0, 0.0, 0.0, 0.0);
            }
        }
    }

    private static VoxelShape SHAPE = Block.createCuboidShape(0, 11, 0, 16, 16, 16);

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        if (ctx.getSide() == Direction.DOWN) return this.getDefaultState().with(isHanging, true);
        return this.getDefaultState().with(isHanging, true);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return !world.isAir(pos.up());
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(isHanging);
    }
}
