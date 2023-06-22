package daniel.mythicmania.entity.mob;

import daniel.mythicmania.entity.abstract_entity.AbstractOrbiterEntity;
import daniel.mythicmania.entity.goals.OrbiterShootCoreGoal;
import daniel.mythicmania.entity.goals.ToxicOrbiterShootCoreGoal;
import daniel.mythicmania.entity.projectile.OrbiterProjectileEntity;
import daniel.mythicmania.item.MythicManiaItems;
import daniel.mythicmania.particle.MythicManiaParticles;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.world.World;

public class ToxicOrbiterEntity extends AbstractOrbiterEntity {
	public ToxicOrbiterEntity(EntityType<? extends HostileEntity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	protected void initGoals() {
		super.initGoals();
		this.goalSelector.add(0, new ToxicOrbiterShootCoreGoal(this));
	}

	@Override
	protected ParticleEffect getParticle() {
		return MythicManiaParticles.POISON_CLOUD;
	}
}