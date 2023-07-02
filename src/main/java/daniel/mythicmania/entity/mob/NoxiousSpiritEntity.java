package daniel.mythicmania.entity.mob;

import daniel.mythicmania.entity.MythicManiaEntityTypes;
import daniel.mythicmania.particle.MythicManiaParticles;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.boss.BossBar;
import net.minecraft.entity.boss.ServerBossBar;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class NoxiousSpiritEntity extends HostileEntity {
    private final ServerBossBar bossBar;

    public NoxiousSpiritEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
        this.bossBar = new ServerBossBar(this.getDisplayName(), BossBar.Color.GREEN, BossBar.Style.PROGRESS);
    }

    @Override
    protected void initGoals() {
        // TODO: Add AI
    }

    public static DefaultAttributeContainer.Builder createNoxiousSpiritAttributes() {
        return HostileEntity
                .createHostileAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 200)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 35.0D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 10.0D)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 2.0D);
    }

    @Override
    public void tickMovement() {
        // TODO: Don't do this in movement
        if (this.age % 10 == 0) {
            this.getWorld().addParticle(MythicManiaParticles.POISON_CLOUD, this.getParticleX(1), this.getRandomBodyY(), this.getParticleZ(0.2), 0.0, 0.05, 0.0);
        }

        super.tickMovement();
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        if (this.hasCustomName()) {
            this.bossBar.setName(this.getDisplayName());
        }
    }

    @Override
    public void setCustomName(@Nullable Text name) {
        super.setCustomName(name);
        this.bossBar.setName(this.getDisplayName());
    }

    @Override
    protected void mobTick() {
        if (this.getHealth() < 21)
            this.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 20 * 120, 4, false, false, false));

        super.mobTick();
        this.bossBar.setPercent(this.getHealth() / this.getMaxHealth());
    }

    @Override
    public void onStartedTrackingBy(ServerPlayerEntity player) {
        super.onStartedTrackingBy(player);
        this.bossBar.addPlayer(player);
    }

    @Override
    public void onStoppedTrackingBy(ServerPlayerEntity player) {
        super.onStoppedTrackingBy(player);
        this.bossBar.removePlayer(player);
    }

    @Override
    public void kill() {
        super.kill();

        if (!getWorld().isClient) {
            for (int i = 0; i < 3; i++) {
                ToxicOrbiterEntity toxicOrbiter = MythicManiaEntityTypes.TOXIC_ORBITER_ENTITY.create(getWorld());
                if (toxicOrbiter == null) return;
                toxicOrbiter.refreshPositionAndAngles(this.getX(), this.getY(), this.getZ(), this.getYaw(), 0.0F);
                getWorld().spawnEntity(toxicOrbiter);
            }
        }
    }
}
