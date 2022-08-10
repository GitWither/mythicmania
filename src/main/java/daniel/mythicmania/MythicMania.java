package daniel.mythicmania;

import daniel.mythicmania.entity.MythicManiaEntityTypes;
import daniel.mythicmania.item.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.dimension.v1.FabricDimensions;
import net.minecraft.client.render.DimensionEffects;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;

public class MythicMania implements ModInitializer {

    public static final String MOD_ID = "mythicmania";

    public static final ItemGroup MYTHICMANIA_ITEM_GROUP = FabricItemGroupBuilder.build(new Identifier(MOD_ID, MOD_ID), () -> new ItemStack(Items.BEDROCK));

    @Override
    public void onInitialize() {
        MythicManiaItems.registerBlockItems();
        MythicManiaItems.registerSpawnEggs();

        MythicManiaEntityTypes.registerEntityAttributes();
    }
}
