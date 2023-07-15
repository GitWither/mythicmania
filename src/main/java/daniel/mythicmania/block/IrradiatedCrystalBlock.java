package daniel.mythicmania.block;

import daniel.mythicmania.particle.MythicManiaParticles;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.World;

public class IrradiatedCrystalBlock extends Block {
    public IrradiatedCrystalBlock(Settings settings) {
        super(settings);
    }

    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        // TODO: Make position of particles more scattered
        VoxelShape voxelShape = this.getOutlineShape(state, world, pos, ShapeContext.absent());
        Vec3d vec3d = voxelShape.getBoundingBox().getCenter();
        double xPos = (double) pos.getX() + vec3d.x + (world.random.nextFloat() * 0.4f);
        double yPos = pos.getY();
        double zPos = (double) pos.getZ() + vec3d.z + (world.random.nextFloat() * 0.4f);

        for(int i = 0; i < 1; ++i) {
            if (random.nextBoolean()) {
                world.addParticle(
                    MythicManiaParticles.POISON_CLOUD,  // particle type
                    xPos + random.nextDouble() / 2.0, // x poses
                    yPos + (random.nextDouble()) + 0.5, // y poses
                    zPos + random.nextDouble() / 2.0,  // z poses
                    0, 0, 0 // velocities
                );
            }
        }
    }
}
