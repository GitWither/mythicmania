package daniel.mythicmania.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class RuinedOreBlock extends ExperienceDroppingBlock {
	public RuinedOreBlock(AbstractBlock.Settings settings) {
		super(settings, UniformIntProvider.create(3, 5));
	}

	@Override
	public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
		Random random = world.getRandom();
		double xPos = (double)pos.getX() + random.nextDouble();
		double yPos = (double)pos.getY() + 0.8;
		double zPos = (double)pos.getZ() + random.nextDouble();

		world.addParticle(ParticleTypes.FLAME, xPos, yPos, zPos, random.nextInt(2) / 3, 0.1f, random.nextInt(2) / 3);
		super.onSteppedOn(world, pos, state, entity);
	}
}