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
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class ShockBoltStaffItem extends SwordItem {
    public ShockBoltStaffItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        final ItemStack shockBoltItem = new ItemStack(MythicManiaItems.SHOCK_BOLT);

        if (!user.getAbilities().creativeMode) {
            int slotWithShockBolt = user.getInventory().getSlotWithStack(shockBoltItem);
            if (slotWithShockBolt < 0) return TypedActionResult.pass(user.getStackInHand(hand));

            user.getInventory().getStack(slotWithShockBolt).decrement(1);
            user.getStackInHand(hand).damage(1, user, (p) -> p.sendToolBreakStatus(user.getActiveHand()));
            user.getItemCooldownManager().set(this, 8);
        }

        // Store projectiles in an array and then iterate through each one (saves repetitive code).
        // TODO: Awkward logic. Can just instantiate them in the loop as needed
        ShockBoltEntity[] projectiles = {
                new ShockBoltEntity(world, user),
                new ShockBoltEntity(world, user),
                new ShockBoltEntity(world, user)
        };

        for (ShockBoltEntity projectile : projectiles) {
            projectile.setItem(shockBoltItem);
            projectile.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 1, world.random.nextInt(4));
            world.spawnEntity(projectile);
        }

        world.playSound(null, user.getX(), user.getY(), user.getZ(), MythicManiaSoundEvents.SHOCK_BOLT_STAFF_FIRE, SoundCategory.NEUTRAL, 0.7F, 2.5F);

        // TODO: Are we sure about client/server safety?
        return super.use(world, user, hand);
    }
}
