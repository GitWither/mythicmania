package daniel.mythicmania.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class OrbiterEntity extends HostileEntity {
    short xp = 210;

    protected OrbiterEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
        this.experiencePoints = xp;
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new LookAtEntityGoal(this, PlayerEntity.class, 6));
        this.goalSelector.add(1, new LookAroundGoal(this));
        this.goalSelector.add(2, new AttackGoal(this));
        this.goalSelector.add(3, new SwimGoal(this));
        this.goalSelector.add(0, new ShootCoreGoal(this));
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

    public void tickMovement() {
        for(int i = 0; i < 2; ++i) {
            this.world.addParticle(ParticleTypes.FLAME, this.getParticleX(1), this.getRandomBodyY(), this.getParticleZ(0.2), 0.0, 0.2, 0.0);
        }

        super.tickMovement();
    }

    @Override
    public boolean tryAttack(Entity target) {
        if (super.tryAttack(target) && target instanceof LivingEntity livingEntity) {
            livingEntity.setOnFireFor(3);
            return true;
        }

        return false;
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
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 8f);
    }

    class ShootCoreGoal extends Goal {
        private final OrbiterEntity orbiter;
        public int cooldown;

        public ShootCoreGoal(OrbiterEntity orbiter) {
            this.orbiter = orbiter;
        }

        @Override
        public boolean canStart() {
            return this.orbiter.getTarget() != null;
        }

        @Override
        public void start() {
            this.cooldown = 0;
        }

        @Override
        public void tick() {
            LivingEntity livingEntity = this.orbiter.getTarget();
            assert livingEntity != null;
            Vec3d vec3d = this.orbiter.getRotationVec(1.0F);
            double f = livingEntity.getX() - (this.orbiter.getX() + vec3d.x * 4.0);
            double g = livingEntity.getBodyY(0.5) - (0.5 + this.orbiter.getBodyY(0.5));
            double h = livingEntity.getZ() - (this.orbiter.getZ() + vec3d.z * 4.0);
            FireballEntity fireballEntity = new FireballEntity(world, this.orbiter, f, g, h, 1);
            fireballEntity.setPosition(this.orbiter.getX() + vec3d.x * 4, this.orbiter.getBodyY(0.5) + 0.5, fireballEntity.getZ() + vec3d.z * 4.0);

            if (livingEntity.squaredDistanceTo(this.orbiter) < 49 && this.orbiter.canSee(livingEntity)) {
                ++this.cooldown;

                if (this.cooldown % 15 == 0) {
                    world.spawnEntity(fireballEntity);
                }
            } else if (this.cooldown > 0) {
                --this.cooldown;
            }

            System.out.println(this.cooldown);
        }
    }
}