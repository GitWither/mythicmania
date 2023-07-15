package daniel.mythicmania.entity.goals;

import daniel.mythicmania.item.MythicManiaItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.AbstractSkeletonEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;

public class SummonMinionGoal extends Goal {
    private final HostileEntity mob;
    private final EntityType<? extends LivingEntity> minion;
    private final int numberOfMinions;
    private int cooldown = 0;

    public SummonMinionGoal(HostileEntity mob, EntityType<? extends LivingEntity> minion, int numberOfMinions) {
        this.mob = mob;
        this.minion = minion;
        this.numberOfMinions = numberOfMinions;
    }

    @Override
    public boolean canStart() {
        return mob != null && mob.getHealth() < mob.getMaxHealth();
    }

    @Override
    public void tick() {
        cooldown++;
        World world = mob.getWorld();
        if (!canSpawnMinions(world, mob.getAttacker())) return;

        for (int i = 0; i < numberOfMinions + world.random.nextInt(3); i++) {
            Entity minionEntity = minion.create(world);
            if (minionEntity == null) return;
            minionEntity.refreshPositionAndAngles(mob.getX() + world.random.nextInt(3), mob.getY(), mob.getZ() + world.random.nextInt(3), mob.getYaw(), 0.0F);

            // Random variables
            int chestRand = world.random.nextInt(3);
            int swordRand = world.random.nextInt(17);

            // Handle gear equipping
            if (minionEntity instanceof AbstractSkeletonEntity) {
                if (chestRand == 0)
                    minionEntity.equipStack(EquipmentSlot.CHEST, new ItemStack(MythicManiaItems.RUINOUS_CHESTPLATE));

                switch(swordRand) {
                    case 0, 1, 2 -> equipMainHandWith(minionEntity, Items.STONE_SWORD);
                    case 3, 4 -> equipMainHandWith(minionEntity, Items.IRON_SWORD);
                    case 5, 6 -> equipMainHandWith(minionEntity, MythicManiaItems.RUINOUS_SWORD);
                    case 7 -> {
                        equipMainHandWith(minionEntity, MythicManiaItems.RUINOUS_SWORD);
                        minionEntity.equipStack(EquipmentSlot.OFFHAND, new ItemStack(MythicManiaItems.RUINOUS_SWORD));
                    }
                }
            }

            world.spawnEntity(minionEntity);
        }

        cooldown = 0;
    }

    public void equipMainHandWith(Entity entity, Item item) {
        entity.equipStack(EquipmentSlot.MAINHAND, new ItemStack(item));
    }

    public boolean canSpawnMinions(World world, LivingEntity attacker) {
        return !world.isClient && cooldown % 40 == 0 && world.random.nextInt(8) == 0 && attacker instanceof PlayerEntity;
    }
}