package daniel.mythicmania.item;

import daniel.mythicmania.MythicMania;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.world.World;

import java.util.Iterator;

public class AntiOxidantBerryItem extends Item {
    public AntiOxidantBerryItem() {
        super(new Item.Settings().food(FoodComponents.ANTI_OXIDANT_BERRY).group(MythicMania.MYTHICMANIA_ITEM_GROUP));
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (user instanceof ServerPlayerEntity serverPlayerEntity) {
            Criteria.CONSUME_ITEM.trigger(serverPlayerEntity, stack);
            serverPlayerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
        }

        if (user instanceof PlayerEntity && !((PlayerEntity)user).getAbilities().creativeMode) {
            stack.decrement(1);
        }

        if (!world.isClient) {
            user.removeStatusEffect(StatusEffects.POISON);
        }

        return stack;
    }

//    @Override
//    public int getMaxUseTime(ItemStack stack) {
//        return 22;
//    }
//
//    @Override
//    public UseAction getUseAction(ItemStack stack) {
//        return UseAction.EAT;
//    }
//
//    @Override
//    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
//        return ItemUsage.consumeHeldItem(world, user, hand);
//    }
}
