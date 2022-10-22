package daniel.mythicmania.item.material.tool;

import daniel.mythicmania.item.MythicManiaItems;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public final class MythicManiaToolMaterials {
    public static final ToolMaterial INTOXICATED =
            new CustomToolMaterial(
                    673, 6.0f, 0.0f, 2, 14,
                    Ingredient.ofItems(MythicManiaItems.TOXIC_PEBBLE)
            );
}