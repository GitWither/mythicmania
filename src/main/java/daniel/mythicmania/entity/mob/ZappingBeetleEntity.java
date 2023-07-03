package daniel.mythicmania.entity.mob;

import daniel.mythicmania.entity.abstract_entity.AbstractFlyingEntity;
import daniel.mythicmania.entity.goals.FlyAroundGoal;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class ZappingBeetleEntity extends AbstractFlyingEntity {
    public ZappingBeetleEntity(EntityType<? extends AbstractFlyingEntity> entityType, World world) {
        super(entityType, world);
        this.experiencePoints = 75;
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new MeleeAttackGoal(this, 1f, false));
        this.goalSelector.add(2, new FlyAroundGoal(this, 8, 5));
        this.targetSelector.add(0, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
    }

    @Override
    public boolean tryAttack(Entity target) {
        boolean canAttack = super.tryAttack(target) && target instanceof LivingEntity;
        if (canAttack) ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 5 * 20, 0), this);
        return canAttack;
    }

    public static DefaultAttributeContainer.Builder createZappingBeetleAttributes() {
        return AbstractFlyingEntity
            .createBeetleAttributes()
            .add(EntityAttributes.GENERIC_MAX_HEALTH, 8)
            .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.61D);
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }
}
