package daniel.mythicmania.item.combat;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class NuclearDaggerItem extends SwordItem {
    public NuclearDaggerItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        StatusEffectInstance targetPoison = new StatusEffectInstance(StatusEffects.POISON, 20 * 7, 0);
        StatusEffectInstance attackerPoison = new StatusEffectInstance(StatusEffects.POISON, 20 * 2, 0);

        target.addStatusEffect(targetPoison);
        attacker.addStatusEffect(attackerPoison);

        return super.postHit(stack, target, attacker);
    }
}