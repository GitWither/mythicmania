package daniel.mythicmania.entity.mob;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class DemonGuardianEntity extends HostileEntity {
    public DemonGuardianEntity(EntityType<? extends DemonGuardianEntity> entityType, World world) {
        super(entityType, world);
        this.experiencePoints = 150;
    }

    @Override
    protected void initGoals() {
        // TODO: Weird priorities here. Also add attack
        this.goalSelector.add(2, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(3, new LookAroundGoal(this));
        this.goalSelector.add(4, new AttackGoal(this));
        this.goalSelector.add(5, new WanderAroundGoal(this, 1, 2, false));
        this.goalSelector.add(5, new SwimGoal(this));
        this.targetSelector.add(0, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, IronGolemEntity.class, true));
    }
    
    @Override
    protected void initEquipment(Random random, LocalDifficulty localDifficulty) {
        boolean offhand = random.nextInt(3) == 0;

        if (offhand) this.equipStack(EquipmentSlot.OFFHAND, new ItemStack(Items.SHIELD));
        else this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.STONE_SWORD));
        this.equipStack(EquipmentSlot.HEAD, new ItemStack(Items.IRON_HELMET));

        super.initEquipment(random, localDifficulty);
    }

    @Nullable
    @Override
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {
        Random random = world.getRandom();
        this.initEquipment(random, difficulty);

        return super.initialize(world, difficulty, spawnReason, entityData, entityNbt);
    }

    // TODO: Check concerns about stack overflow
    @Override
    public boolean tryAttack(Entity target) {
        boolean canAttack = super.tryAttack(target) && target instanceof LivingEntity;
        if (canAttack) ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 5 * 20, 0), this);
        return canAttack;
    }

    public static DefaultAttributeContainer.Builder createDemonGuardianAttributes() {
        return HostileEntity
                .createHostileAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 15)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 32.0D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.23D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 3.0D)
                .add(EntityAttributes.GENERIC_ARMOR_TOUGHNESS, 2);
    }
}
