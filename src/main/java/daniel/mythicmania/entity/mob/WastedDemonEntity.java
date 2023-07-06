package daniel.mythicmania.entity.mob;

import daniel.mythicmania.entity.MythicManiaEntityTypes;
import daniel.mythicmania.entity.goals.*;
import daniel.mythicmania.item.MythicManiaItems;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.boss.BossBar.Color;
import net.minecraft.entity.boss.BossBar.Style;
import net.minecraft.entity.boss.ServerBossBar;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.AbstractSkeletonEntity;
import net.minecraft.entity.mob.FlyingEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.VexEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
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
        this.experiencePoints = 2100;
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(4, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(2, new LookAroundGoal(this));
        this.goalSelector.add(3, new WanderAroundGoal(this, 1, 2, false));
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(0, new MoveOutOfWaterGoal(this));
        this.goalSelector.add(2, new AvoidSunlightGoal(this));

        // Attack goals
        this.goalSelector.add(this.getHealth() / 2 < this.getMaxHealth() ? 0 : 2, new DemonStaffAttackGoal(this));
        this.goalSelector.add(0, new MeleeAttackGoal(this, 1, false));
        this.goalSelector.add(1, new TeleportBehindPlayerGoal(this));
        this.goalSelector.add(2, new StrikeAttackerWithLightningGoal(this));
        this.goalSelector.add(this.getHealth() / 1.5f < getMaxHealth() ? 3 : 7, new SummonMinionGoal(this, EntityType.SKELETON, 2));
        this.goalSelector.add(this.getHealth() / 1.5f < getMaxHealth() ? 3 : 6, new SummonMinionGoal(this, EntityType.VEX, 1));

        this.initActiveTargetGoals();
    }

    protected void initActiveTargetGoals() {
        this.targetSelector.add(0, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, LivingEntity.class, 5, false, false, (entity) ->
            entity != null &&
            !(entity instanceof WastedDemonEntity) &&
            !(entity instanceof DemonGuardianEntity) &&
            !(entity instanceof AbstractSkeletonEntity) &&
            !(entity instanceof VexEntity) && 
            !(entity instanceof FlyingEntity)
        ));
    }

    @Override
    protected boolean isDisallowedInPeaceful() {
        return false;
    }

    @Override
    protected void initEquipment(Random random, LocalDifficulty localDifficulty) {
        this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(MythicManiaItems.WASTED_STAFF));
        super.initEquipment(random, localDifficulty);
    }

    @Nullable
    @Override
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {
        Random random = world.getRandom();
        this.initEquipment(random, difficulty);
        this.handDropChances[EquipmentSlot.MAINHAND.getEntitySlotId()] = 0.0F; // TODO: Looks weird..

        return super.initialize(world, difficulty, spawnReason, entityData, entityNbt);
    }

    /*
    TODO:
     Fix method
     Use method in lightning and staff goal properly
     Make demon use more of lightning and staff goal when far away and melee when close
    */
    public boolean isCloseTo(LivingEntity target, int distance) {
        return Math.abs(this.getPos().x - target.getPos().x) < distance ||
                Math.abs(this.getPos().y - target.getPos().y) < distance ||
                Math.abs(this.getPos().z - target.getPos().z) < distance;
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
        if (this.age % 100 == 0) this.heal(4.0F);

        if (this.getHealth() < 31)
            this.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 20 * 120, 2, false, false, false));

        super.mobTick();
        this.bossBar.setPercent(this.getHealth() / this.getMaxHealth());
    }

    public void tickMovement() {
        for (int i = 0; i < 2; ++i) {
            this.getWorld().addParticle(ParticleTypes.SMOKE, this.getParticleX(0.2), this.getRandomBodyY(), this.getParticleZ(0.5), 0.0, 0.0, 0.0);
        }

        super.tickMovement();
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
        boolean canAttack = super.tryAttack(target) && target instanceof LivingEntity;
        if (canAttack && this.random.nextInt(5) == 0) target.setOnFireFor(3);
        return canAttack;
    }

    public static DefaultAttributeContainer.Builder createWastedDemonAttributes() {
        return HostileEntity
                .createHostileAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 200)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 35.0D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.28D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 7.0D)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 2.0D);
    }

    @Override
    public void tick() {
        super.tick();
        this.updateCapeAngles();
    }

    @Override
    public void kill() {
        super.kill();

        if (!getWorld().isClient) {
            for (int i = 0; i < 4; i++) {
                WastrelGliderEntity wastrelGlider = MythicManiaEntityTypes.WASTREL_GLIDER_ENTITY.create(getWorld());
                if (wastrelGlider == null) return;
                wastrelGlider.refreshPositionAndAngles(this.getX(), this.getY(), this.getZ(), this.getYaw(), 0.0F);
                getWorld().spawnEntity(wastrelGlider);
            }
        }
    }

    private void updateCapeAngles() {
        this.prevCapeX = this.capeX;
        this.prevCapeY = this.capeY;
        this.prevCapeZ = this.capeZ;

        double deltaX = this.getX() - this.capeX;
        double deltaY = this.getY() - this.capeY;
        double deltaZ = this.getZ() - this.capeZ;

        final double threshold = 10.0;

        if (deltaX > threshold) this.prevCapeX = this.capeX = this.getX();
        if (deltaZ > threshold) this.prevCapeZ = this.capeZ = this.getZ();
        if (deltaY > threshold) this.prevCapeY = this.capeY = this.getY();

        if (deltaX < -threshold) this.prevCapeX = this.capeX = this.getX();
        if (deltaZ < -threshold) this.prevCapeZ = this.capeZ = this.getZ();
        if (deltaY < -threshold) this.prevCapeY = this.capeY = this.getY();

        this.capeX += deltaX * 0.25;
        this.capeZ += deltaZ * 0.25;
        this.capeY += deltaY * 0.25;
    }
}
