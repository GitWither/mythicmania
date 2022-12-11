package daniel.mythicmania.item.material.tool;

import daniel.mythicmania.item.MythicManiaItems;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

import javax.annotation.Nullable;

public final class MythicManiaToolMaterials {
    public static final ToolMaterial INTOXICATED = new CustomToolMaterial(
            673, 6.0f, 0.0f, 2, 14,
            Ingredient.ofItems(MythicManiaItems.TOXIC_PEBBLE)
    );

    public static final ToolMaterial WASTED_STAFF = new CustomToolMaterial(
            488, 6.0f, 0.0f, 0, 6,
            Ingredient.ofItems((ItemConvertible) null)
    );
}