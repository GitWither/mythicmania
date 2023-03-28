package daniel.mythicmania.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class PoisonousGrubEntity extends AbstractGrubEntity {
    public PoisonousGrubEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
        this.experiencePoints = 50;
    }

    @Override
    protected void initGoals() {
        // TODO: Weird priorities
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(3, new PounceAtTargetGoal(this, 0.4f));
        this.goalSelector.add(4, new AttackGoal(this));
        this.goalSelector.add(5, new WanderAroundFarGoal(this, 0.8));
        this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 8.0f));
        this.goalSelector.add(6, new LookAroundGoal(this));
        this.targetSelector.add(1, new RevengeGoal(this));
    }

    @Override
    public boolean tryAttack(Entity target) {
        // TODO: Rewrite
        if (super.tryAttack(target) && target instanceof LivingEntity) {
            ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 5 * 20, 0), this);
            return true;
        }

        return false;
    }

    public static DefaultAttributeContainer.Builder createPoisonousGrubAttributes() {
        return AbstractGrubEntity
                .createGrubAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 8)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.28D);
    }
}
