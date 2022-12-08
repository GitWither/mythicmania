package daniel.mythicmania.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.world.World;
/*
- Make core emissive
- Animate it
- Add translations
 */
public class OrbiterEntity extends HostileEntity {
    protected OrbiterEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new LookAtEntityGoal(this, PlayerEntity.class, 6));
        this.goalSelector.add(0, new LookAroundGoal(this));
        this.goalSelector.add(2, new AttackGoal(this));
        this.goalSelector.add(1, new LookAtEntityGoal(this, PlayerEntity.class, 6));
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

    public void tickMovement() {
        for(int i = 0; i < 2; ++i) {
            this.world.addParticle(ParticleTypes.FLAME, this.getParticleX(0.2), this.getRandomBodyY(), this.getParticleZ(0.2), 0.0, 0.0, 0.0);
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

    public static DefaultAttributeContainer.Builder createOrbiterAttributes() {
        return HostileEntity
                .createHostileAttributes()
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.23f)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2f);
    }
}