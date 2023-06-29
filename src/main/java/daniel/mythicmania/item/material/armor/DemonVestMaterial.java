package daniel.mythicmania.item.material.armor;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class DemonVestMaterial implements ArmorMaterial {
    public static final DemonVestMaterial INSTANCE = new DemonVestMaterial();

    @Override
    public int getDurability(ArmorItem.Type type) {
        return 165;
    }

    @Override
    public int getProtection(ArmorItem.Type type) {
        return 8;
    }

    @Override
    public int getEnchantability() {
        return 7;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_GENERIC;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.EMPTY;
    }

    @Override
    public String getName() {
        return "demon";
    }

    @Override
    public float getToughness() {
        return 2;
    }

    @Override
    public float getKnockbackResistance() {
        return 0;
    }
}
