package daniel.mythicmania.item.combat;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class RuinousSwordItem extends SwordItem {
    StatusEffectInstance regeneration = new StatusEffectInstance(StatusEffects.REGENERATION, 20*3, 0);
    public RuinousSwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        attacker.addStatusEffect(regeneration);
        target.setOnFireFor(4);
        return super.postHit(stack, target, attacker);
    }
}
