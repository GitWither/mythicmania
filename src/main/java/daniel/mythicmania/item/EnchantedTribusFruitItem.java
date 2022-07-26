package daniel.mythicmania.item;

import daniel.mythicmania.MythicMania;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class EnchantedTribusFruitItem extends Item {
    public EnchantedTribusFruitItem() {
        super(new Item.Settings().food(FoodComponents.ENCHANTED_TRIBUS_FRUIT).group(MythicMania.MYTHICMANIA_FOOD_ITEM_GROUP));
    }

    public boolean hasGlint(ItemStack stack) {
        return true;
    }
}
