package daniel.mythicmania.entity.abstract_entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class AbstractOrbiterEntity extends AbstractFlyingEntity {
    protected AbstractOrbiterEntity(EntityType<? extends AbstractFlyingEntity> entityType, World world) {
        super(entityType, world);
        this.experiencePoints = 210;
    }

    @Override
    protected void initGoals() {
        // TODO: Weird priorities
        this.goalSelector.add(1, new LookAtEntityGoal(this, PlayerEntity.class, 6));
        this.goalSelector.add(1, new LookAroundGoal(this));
        this.goalSelector.add(2, new AttackGoal(this));
        this.goalSelector.add(3, new SwimGoal(this));
        this.goalSelector.add(4, new WanderAroundGoal(this, 1, 2, true));

        this.targetSelector.add(0, new RevengeGoal(this));
    }

    @Override
    protected void mobTick() {
        if (this.age % 170 == 0) {
            this.heal(2);
        }

        super.mobTick();
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }

    public void tickMovement() {
        // TODO: Don't do this in movement
        if (this.age % 10 == 0) {
            this.world.addParticle(getParticle(), this.getParticleX(1), this.getRandomBodyY(), this.getParticleZ(0.2), 0.0, 0.05, 0.0);
        }

        super.tickMovement();
    }

    protected ParticleEffect getParticle() {
        return ParticleTypes.FLAME;
    }

    @Override
    protected boolean isDisallowedInPeaceful() {
        return false;
    }

    public static DefaultAttributeContainer.Builder createOrbiterAttributes() {
        return HostileEntity
                .createHostileAttributes()
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.23f)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2f)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 8f)
			    .add(EntityAttributes.GENERIC_FLYING_SPEED, 0.3D);
    }
}