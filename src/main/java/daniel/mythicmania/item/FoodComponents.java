package daniel.mythicmania.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class FoodComponents {

    public static final FoodComponent POISONOUS_BERRY = new FoodComponent.Builder()
            .saturationModifier(1.1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 3, 1), 1)
            .build();
}
