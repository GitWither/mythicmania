package daniel.mythicmania.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class ShockBoltItem extends Item {
    public ShockBoltItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);

        if (!world.isClient) {
            user.incrementStat(Stats.USED.getOrCreateStat(this));
            // TODO: This looks wrong
            if (!user.getAbilities().creativeMode) {
                itemStack.decrement(1);
            }
        }

        return TypedActionResult.success(itemStack, !world.isClient());
    }
}
