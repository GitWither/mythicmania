package daniel.mythicmania.item.material.armor;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class DemonVestMaterial implements ArmorMaterial {
    public static final DemonVestMaterial INSTANCE = new DemonVestMaterial();

    private static final int[] BASE_DURABILITY = new int[] {1, 1, 165, 1};
    private static final int[] PROTECTION_VALUES = new int[] {1, 1, 8, 1};

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
        return 7;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_GENERIC;
    }

    @Override
    public Ingredient getRepairIngredient() {
        //TODO: Change it to appropriate ingredient
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
