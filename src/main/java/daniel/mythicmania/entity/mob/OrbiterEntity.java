package daniel.mythicmania.entity.mob;

import daniel.mythicmania.entity.abstract_entity.AbstractOrbiterEntity;
import daniel.mythicmania.entity.goals.FlyAroundGoal;
import daniel.mythicmania.entity.goals.OrbiterShootCoreGoal;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.world.World;

public class OrbiterEntity extends AbstractOrbiterEntity {
	public OrbiterEntity(EntityType<? extends AbstractOrbiterEntity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	protected void initGoals() {
		super.initGoals();
		this.goalSelector.add(0, new OrbiterShootCoreGoal(this, false));
		this.goalSelector.add(1, new FlyAroundGoal(this, 20, 12));
		this.targetSelector.add(0, new ActiveTargetGoal<>(this, ToxicOrbiterEntity.class, true));
	}

	@Override
	public boolean tryAttack(Entity target) {
		boolean canAttack = super.tryAttack(target) && target instanceof LivingEntity;
		if (canAttack) target.setOnFireFor(3);
		return canAttack;
	}
}
