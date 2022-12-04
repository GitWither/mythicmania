package daniel.mythicmania;

import daniel.mythicmania.entity.MythicManiaEntityTypes;
import daniel.mythicmania.item.*;
import daniel.mythicmania.world.gen.MythicManiaFeatures;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;

public class MythicMania implements ModInitializer {
    public static final String MOD_ID = "mythicmania";

    public static final ItemGroup MYTHICMANIA_BLOCK_ITEM_GROUP = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "blocks"), () -> new ItemStack(MythicManiaItems.PULSATING_BLACKSTONE));
    public static final ItemGroup MYTHICMANIA_ITEMS_ITEM_GROUP = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "items"), () -> new ItemStack(MythicManiaItems.EMPTY_ORB));
    public static final ItemGroup MYTHICMANIA_COMBAT_ITEM_GROUP = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "combat"), () -> new ItemStack(MythicManiaItems.INTOXICATED_SWORD));
    public static final ItemGroup MYTHICMANIA_TOOLS_ITEM_GROUP = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "tools"), () -> new ItemStack(MythicManiaItems.INTOXICATED_AXE));
    public static final ItemGroup MYTHICMANIA_FOOD_ITEM_GROUP = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "food"), () -> new ItemStack(MythicManiaItems.TRIBUS_FRUIT));

    @Override
    public void onInitialize() {
        MythicManiaItems.registerBlockItems();
        MythicManiaItems.registerSpawnEggs();

        MythicManiaFeatures.registerFeatures();
        MythicManiaEntityTypes.registerEntityAttributes();
    }
}
