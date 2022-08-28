package daniel.mythicmania.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class WastedDemonEntity extends HostileEntity {
    public double prevCapeX;
    public double prevCapeY;
    public double prevCapeZ;
    public double capeX;
    public double capeY;
    public double capeZ;

    protected WastedDemonEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(1, new LookAroundGoal(this));
        this.goalSelector.add(2, new AttackGoal(this));
        this.goalSelector.add(3, new WanderAroundGoal(this, 1, 2, false));
        this.targetSelector.add(0, new ActiveTargetGoal<>(this, PlayerEntity.class, false));
    }

    @Override
    public boolean tryAttack(Entity target) {
        if (super.tryAttack(target) && target instanceof LivingEntity livingEntity) {

            return livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 5 * 20, 3), this);
        }
        return false;
    }

    public static DefaultAttributeContainer.Builder createWastedDemonAttributes() {
        return HostileEntity
                .createHostileAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 22)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 35.0D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 7.0D)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 2.0D);
    }

    @Override
    public void tick() {
        super.tick();
        this.updateCapeAngles();
    }

    private void updateCapeAngles() {
        this.prevCapeX = this.capeX;
        this.prevCapeY = this.capeY;
        this.prevCapeZ = this.capeZ;

        double deltaX = this.getX() - this.capeX;
        double deltaY = this.getY() - this.capeY;
        double deltaZ = this.getZ() - this.capeZ;

        final double threshold = 10.0;

        if (deltaX > threshold) {
            this.prevCapeX = this.capeX = this.getX();
        }
        if (deltaZ > threshold) {
            this.prevCapeZ = this.capeZ = this.getZ();
        }
        if (deltaY > threshold) {
            this.prevCapeY = this.capeY = this.getY();
        }

        if (deltaX < -threshold) {
            this.prevCapeX = this.capeX = this.getX();
        }
        if (deltaZ < -threshold) {
            this.prevCapeZ = this.capeZ = this.getZ();
        }
        if (deltaY < -threshold) {
            this.prevCapeY = this.capeY = this.getY();
        }

        this.capeX += deltaX * 0.25;
        this.capeZ += deltaZ * 0.25;
        this.capeY += deltaY * 0.25;
    }
}
