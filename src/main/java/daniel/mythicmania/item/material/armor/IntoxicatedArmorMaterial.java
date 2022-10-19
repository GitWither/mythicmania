package daniel.mythicmania.item.material.armor;

import daniel.mythicmania.item.MythicManiaItems;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class IntoxicatedArmorMaterial implements ArmorMaterial {
    public static final IntoxicatedArmorMaterial INSTANCE = new IntoxicatedArmorMaterial();

    private static final int[] BASE_DURABILITY = new int[] {230, 255, 260, 211};
    private static final int[] PROTECTION_VALUES = new int[] {5, 8, 11, 5};

    @Override
    public int getDurability(EquipmentSlot slot) {
        return BASE_DURABILITY[slot.getEntitySlotId()];
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return PROTECTION_VALUES[slot.getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        return 4;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_GENERIC;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(MythicManiaItems.TOXIC_PEBBLE);
    }

    @Override
    public String getName() {
        return "intoxicated";
    }

    @Override
    public float getToughness() {
        return 0;
    }

    @Override
    public float getKnockbackResistance() {
        return 0;
    }
}
