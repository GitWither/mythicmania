package daniel.mythicmania.entity.mob;

import daniel.mythicmania.entity.abstract_entity.AbstractOrbiterEntity;
import daniel.mythicmania.entity.goals.OrbiterShootCoreGoal;
import daniel.mythicmania.particle.MythicManiaParticles;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.world.World;

public class ToxicOrbiterEntity extends AbstractOrbiterEntity {
	public ToxicOrbiterEntity(EntityType<? extends AbstractOrbiterEntity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	protected void initGoals() {
		this.goalSelector.add(2, new LookAtEntityGoal(this, PlayerEntity.class, 6));
		this.goalSelector.add(3, new LookAroundGoal(this));
		this.goalSelector.add(0, new AttackGoal(this));
		this.goalSelector.add(0, new SwimGoal(this));
		this.goalSelector.add(1, new WanderAroundGoal(this, 1, 2, true));
		this.goalSelector.add(0, new OrbiterShootCoreGoal(this, true));

		this.targetSelector.add(0, new RevengeGoal(this));
		this.targetSelector.add(0, new ActiveTargetGoal<>(this, OrbiterEntity.class, true));
	}

	@Override
	protected ParticleEffect getParticle() {
		return MythicManiaParticles.POISON_CLOUD;
	}
}