package daniel.mythicmania.item.material.tool;

import daniel.mythicmania.item.MythicManiaItems;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

import javax.annotation.Nullable;

public final class MythicManiaToolMaterials {
    public static final ToolMaterial NUCLEAR = new CustomToolMaterial(
            673, 6.0f, 0.0f, 2, 14,
            Ingredient.ofItems(MythicManiaItems.TOXIC_PEBBLE)
    );

    public static final ToolMaterial RUINOUS = new CustomToolMaterial(
            721, 6.0f, 0.0f, 2, 10,
            Ingredient.ofItems(MythicManiaItems.WASTED_ESSENCE)
    );

    public static final ToolMaterial WASTED_STAFF = new CustomToolMaterial(
            800, 6.0f, 0.0f, 0, 6,
            Ingredient.ofItems((ItemConvertible) null)
    );

    public static final ToolMaterial SHOCK_BOLT_STAFF = new CustomToolMaterial(
            640, 6.0f, 0.0f, 0, 6,
            Ingredient.ofItems((ItemConvertible) null)
    );
}