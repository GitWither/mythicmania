package daniel.mythicmania.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class FoodComponents {

    public static final FoodComponent POISONOUS_BERRY = new FoodComponent.Builder()
            .saturationModifier(1.1f)
            .hunger(1)
            .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 20*3, 1), 1)
            .build();

    public static final FoodComponent TRIBUS_FRUIT = new FoodComponent.Builder()
            .saturationModifier(1.1f)
            .hunger(3)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 10*20, 0), 1)
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 8*20, 0), 1)
            .build();

    public static final FoodComponent ENCHANTED_TRIBUS_FRUIT = new FoodComponent.Builder()
            .hunger(4)
            .saturationModifier(1.2F)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 50*20, 2), 1)
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 50*20, 2), 1)
            .statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 60*20, 0), 1)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 40*20, 3), 1)
            .alwaysEdible()
            .build();

    public static final FoodComponent HEALING_BERRY = new FoodComponent.Builder()
            .saturationModifier(1.1f)
            .hunger(4)
            .alwaysEdible()
            .build();
}
