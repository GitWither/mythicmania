package daniel.mythicmania.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.World;

public class DemonGuardianEntity extends HostileEntity {
    public DemonGuardianEntity(EntityType<? extends DemonGuardianEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(2, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(3, new LookAroundGoal(this));
        this.goalSelector.add(4, new AttackGoal(this));
        this.goalSelector.add(5, new WanderAroundGoal(this, 1, 2, false));
        this.goalSelector.add(5, new SwimGoal(this));
        this.targetSelector.add(0, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, IronGolemEntity.class, true));
    }
    
    @Override
    public boolean tryAttack(Entity entity) {
        if (super.tryAttack(entity) && entity instanceof LivingEntity livingEntity) {
            return tryAttack(entity);
        }

        return false;
    }

    public static DefaultAttributeContainer.Builder createDemonGuardianAttributes() {
        return HostileEntity
                .createHostileAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 15)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 32.0D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.40D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 3.0D)
                .add(EntityAttributes.GENERIC_ARMOR_TOUGHNESS, 2);
    }
}
