package daniel.mythicmania.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.boss.BossBar.Color;
import net.minecraft.entity.boss.BossBar.Style;
import net.minecraft.entity.boss.ServerBossBar;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class WastedDemonEntity extends HostileEntity {
    public double prevCapeX;
    public double prevCapeY;
    public double prevCapeZ;
    public double capeX;
    public double capeY;
    public double capeZ;
    private final ServerBossBar bossBar;

    public WastedDemonEntity(EntityType<? extends WastedDemonEntity> entityType, World world) {
        super(entityType, world);
        this.bossBar = new ServerBossBar(this.getDisplayName(), Color.RED, Style.PROGRESS);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(2, new LookAroundGoal(this));
        this.goalSelector.add(3, new AttackGoal(this));
        this.goalSelector.add(4, new WanderAroundGoal(this, 1, 2, false));
        this.goalSelector.add(4, new SwimGoal(this));
        this.targetSelector.add(0, new ActiveTargetGoal<>(this, PlayerEntity.class, false));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, MobEntity.class, 5, false, false, (entity) -> entity instanceof Entity && !(entity instanceof WastedDemonEntity) && !(entity instanceof DemonGuardianEntity)));
    }

    public boolean hurtByWater() {
        return true;
    }

    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        if (this.hasCustomName()) {
            this.bossBar.setName(this.getDisplayName());
        }
    }

    public void setCustomName(@Nullable Text name) {
        super.setCustomName(name);
        this.bossBar.setName(this.getDisplayName());
    }

    protected void mobTick() {
        if (this.age % 100 == 0) {
            this.heal(4.0F);
        }

        if (this.getHealth() < 31) {
            this.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 20*120, 2));
        }

        super.mobTick();
        this.bossBar.setPercent(this.getHealth() / this.getMaxHealth());
    }

    public void tickMovement() {
        for(int i = 0; i < 2; ++i) {
            this.world.addParticle(ParticleTypes.SMOKE, this.getParticleX(0.2), this.getRandomBodyY(), this.getParticleZ(0.5), 0.0, 0.0, 0.0);
        }
        super.tickMovement();
    }

    public void onSummoned() {
        this.bossBar.setPercent(0.0F);
        this.setHealth(this.getMaxHealth() / 3.0F);
    }

    public void onStartedTrackingBy(ServerPlayerEntity player) {
        super.onStartedTrackingBy(player);
        this.bossBar.addPlayer(player);
    }

    public void onStoppedTrackingBy(ServerPlayerEntity player) {
        super.onStoppedTrackingBy(player);
        this.bossBar.removePlayer(player);
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
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 85)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 35.0D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.35D)
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
