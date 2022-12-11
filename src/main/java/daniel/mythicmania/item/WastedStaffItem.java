package daniel.mythicmania.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class WastedStaffItem extends SwordItem {
    public WastedStaffItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        final StatusEffectInstance instantHealing = new StatusEffectInstance(StatusEffects.ABSORPTION, 5, 0);
        attacker.addStatusEffect(instantHealing);
        target.setOnFireFor(6);

        return super.postHit(stack, target, attacker);
    }
}