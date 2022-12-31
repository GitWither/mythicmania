package daniel.mythicmania.item.combat;

import daniel.mythicmania.client.sound.MythicManiaSoundEvents;
import daniel.mythicmania.entity.ShockBoltEntity;
import daniel.mythicmania.item.MythicManiaItems;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class ShockBoltStaffItem extends SwordItem {
    public ShockBoltStaffItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient) {
            ItemStack shockBoltItem = new ItemStack(MythicManiaItems.SHOCK_BOLT);

            // Stores the projectiles in variables
            ShockBoltEntity projectile = new ShockBoltEntity(world, user);
            ShockBoltEntity projectile2 = new ShockBoltEntity(world, user);
            ShockBoltEntity projectile3 = new ShockBoltEntity(world, user);

            projectile.setItem(shockBoltItem);

            // Sets the velocity of projectiles
            projectile.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 1, world.random.nextInt(4));
            projectile2.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 1, world.random.nextInt(4));
            projectile3.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 1, world.random.nextInt(4));

            int slotWithShockBolt = user.getInventory().getSlotWithStack(shockBoltItem);
            ItemStack projectileSlot = user.getInventory().getStack(slotWithShockBolt);

            if (!user.getAbilities().creativeMode) {
                if (user.getInventory().contains(shockBoltItem)) {
                    projectileSlot.decrement(1);

                    ItemStack wand = user.getStackInHand(Hand.MAIN_HAND);
                    wand.damage(1, user, (p) -> p.sendToolBreakStatus(user.getActiveHand()));

                    world.spawnEntity(projectile);
                    world.spawnEntity(projectile2);
                    world.spawnEntity(projectile3);
                    user.getItemCooldownManager().set(this, 8);
                    world.playSound(null, user.getX(), user.getY(), user.getZ(), MythicManiaSoundEvents.SHOCK_BOLT_STAFF_FIRE, SoundCategory.NEUTRAL, 0.7F, 2.5F);
                }
            } else {
                world.spawnEntity(projectile);
                world.spawnEntity(projectile2);
                world.spawnEntity(projectile3);
                user.getItemCooldownManager().set(this, 8);
                world.playSound(null, user.getX(), user.getY(), user.getZ(), MythicManiaSoundEvents.SHOCK_BOLT_STAFF_FIRE, SoundCategory.NEUTRAL, 0.7F, 2.5F);
            }
        }

        return super.use(world, user, hand);
    }
}
