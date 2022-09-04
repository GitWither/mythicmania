package daniel.mythicmania.item.material.armor;

import net.minecraft.item.ArmorItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class DemonVestArmor extends ArmorItem {

    public DemonVestArmor(ArmorMaterial material, EquipmentSlot slot, Settings settings) {
        super(material, slot, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(!world.isClient()) {
            if(entity instanceof PlayerEntity player) {
                if(isChestplate(player) && hasCorrectArmorOn(DemonVestMaterial.INSTANCE, player)) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 40, 0));
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 40, 0));
                }
            }
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private boolean isChestplate(PlayerEntity player) {
        ItemStack chest = player.getInventory().getArmorStack(2);
        return !chest.isEmpty();
    }

    private boolean hasCorrectArmorOn(ArmorMaterial material, PlayerEntity player) {
        ArmorItem chest = (ArmorItem)player.getInventory().getArmorStack(2).getItem();

        return chest.getMaterial() == material;
    }
}
