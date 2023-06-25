package daniel.mythicmania.item;

import daniel.mythicmania.entity.projectile.WastedStaffChargeEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class WastedStaffChargeItem extends Item {
    public WastedStaffChargeItem(Settings settings) {
        super(settings);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);

        if (!world.isClient) {
            ItemStack charge = new ItemStack(MythicManiaItems.WASTED_STAFF_CHARGE);
            WastedStaffChargeEntity projectile = new WastedStaffChargeEntity(world, user);
            projectile.setItem(charge);
            projectile.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 0.6F, 0F);
            world.spawnEntity(projectile);

            user.incrementStat(Stats.USED.getOrCreateStat(this));
            // TODO: This looks wrong
            if (!user.getAbilities().creativeMode) {
                itemStack.decrement(1);
                user.getItemCooldownManager().set(this, 4);
            }
        }

        return TypedActionResult.success(itemStack, !world.isClient());
    }
}
