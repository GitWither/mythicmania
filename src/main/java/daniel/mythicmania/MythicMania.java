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

    public static final ItemGroup MYTHICMANIA_ITEM_GROUP = FabricItemGroupBuilder.build(new Identifier(MOD_ID, MOD_ID), () -> new ItemStack(Items.BEDROCK));
    public static final ItemGroup MYTHICMANIA_BLOCK_ITEM_GROUP = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "blocks"), () -> new ItemStack(Items.BEDROCK));
    public static final ItemGroup MYTHICMANIA_ITEMS_ITEM_GROUP = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "items"), () -> new ItemStack(Items.BEDROCK));
    public static final ItemGroup MYTHICMANIA_COMBAT_ITEM_GROUP = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "combat"), () -> new ItemStack(Items.BEDROCK));
    public static final ItemGroup MYTHICMANIA_TOOLS_ITEM_GROUP = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "tools"), () -> new ItemStack(Items.BEDROCK));

    @Override
    public void onInitialize() {
        MythicManiaItems.registerBlockItems();
        MythicManiaItems.registerSpawnEggs();

        MythicManiaFeatures.registerFeatures();

        MythicManiaEntityTypes.registerEntityAttributes();
    }
}
