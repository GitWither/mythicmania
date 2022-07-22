package daniel.mythicmania.item;

import daniel.mythicmania.MythicMania;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class OrbItem extends Item {
    private final boolean hasGlint;

    public OrbItem(boolean hasGlint) {
        super(new Item.Settings().group(MythicMania.MYTHICMANIA_ITEM_GROUP));
        this.hasGlint = hasGlint;
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return hasGlint;
    }
}
