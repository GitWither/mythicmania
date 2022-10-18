package daniel.mythicmania.item;

import daniel.mythicmania.entity.PoisonousGrubEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class PoisonSpikeItem extends Item {
    private static final int duration = 20*2;
    private static final int amplifier = 2;

    public PoisonSpikeItem(Settings settings) {
        super(settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, duration, amplifier));
        return super.postHit(stack, target, attacker);
    }
}