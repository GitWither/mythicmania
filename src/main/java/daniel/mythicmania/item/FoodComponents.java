package daniel.mythicmania.item;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.world.World;

public class FoodComponents {

    public static final FoodComponent POISONOUS_BERRY = new FoodComponent.Builder()
            .saturationModifier(1.1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 3, 1), 1)
            .build();

    public static final FoodComponent TRIBUS_FRUIT = new FoodComponent.Builder()
            .saturationModifier(1.1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 10, 1), 1)
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 8, 1), 1)
            .build();
}
