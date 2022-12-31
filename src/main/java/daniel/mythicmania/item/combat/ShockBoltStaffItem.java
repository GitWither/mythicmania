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

            // Cooldown manager
            user.getItemCooldownManager().set(this, 8);

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

            // Checks if the user has the shock bolt item and is not in creative mode
            if (user.getInventory().contains(shockBoltItem) && !user.getAbilities().creativeMode) {
                ItemStack wand = user.getStackInHand(Hand.MAIN_HAND);

                // Damage wand by 1
                wand.damage(1, user, (p) -> p.sendToolBreakStatus(user.getActiveHand()));

                user.getInventory().removeOne(shockBoltItem);
                user.playerScreenHandler.sendContentUpdates();
            }

            world.playSound(null, user.getX(), user.getY(), user.getZ(), MythicManiaSoundEvents.SHOCK_BOLT_STAFF_FIRE, SoundCategory.NEUTRAL, 0.7F, 2.5F);

            // Summon projectiles
            world.spawnEntity(projectile);
            world.spawnEntity(projectile2);
            world.spawnEntity(projectile3);
        }

        return super.use(world, user, hand);
    }
}
