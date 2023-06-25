package daniel.mythicmania.item;

import daniel.mythicmania.entity.projectile.WaterParcelEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class WaterParcelItem extends Item {
    short cooldown = 3;

    public WaterParcelItem(Settings settings) {
        super(settings);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);

        if (!world.isClient) {
            world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_SPLASH_POTION_THROW, SoundCategory.NEUTRAL, 0.5F, 1F);

            user.getItemCooldownManager().set(this, cooldown);

            // Spawns the projectile
            WaterParcelEntity projectile = new WaterParcelEntity(world, user);
            projectile.setItem(itemStack);
            projectile.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 0.8F, 0F);
            world.spawnEntity(projectile);

            user.incrementStat(Stats.USED.getOrCreateStat(this));
            // TODO: This looks wrong
            if (!user.getAbilities().creativeMode) {
                itemStack.decrement(1);
            }
        }

        return TypedActionResult.success(itemStack, !world.isClient());
    }
}
