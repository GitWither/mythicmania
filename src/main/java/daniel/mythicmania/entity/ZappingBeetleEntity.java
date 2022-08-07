package daniel.mythicmania.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.Comparator;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;

public class ZappingBeetleEntity extends PathAwareEntity {
    Vec3d targetPosition;

    protected ZappingBeetleEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
        this.targetPosition = Vec3d.ZERO;
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(3, new PounceAtTargetGoal(this, 0.4f));
        this.goalSelector.add(2, new WanderAroundFarGoal(this, 0.6D));
        this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 8.0f));
        this.goalSelector.add(5, new LookAroundGoal(this));
        this.goalSelector.add(2, new MeleeAttackGoal(this, 0.82F, false));
        this.goalSelector.add(4, new AttackGoal(this));
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
    }

    @Override
    public boolean tryAttack(Entity target) {
        if (super.tryAttack(target) && target instanceof LivingEntity) {
            return true;
        }
        return false;
    }

    class StingGoal extends MeleeAttackGoal {
        StingGoal(PathAwareEntity mob, double speed, boolean pauseWhenMobIdle) {
            super(mob, speed, pauseWhenMobIdle);
        }

        public boolean canStart() {
            return super.canStart();
        }

        public boolean shouldContinue() {
            return super.shouldContinue();
        }
    }

    public static DefaultAttributeContainer.Builder createZappingBeetleAttributes() {
        return AbstractBeetleEntity
                .createBeetleAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 8)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.61D);
    }
}
