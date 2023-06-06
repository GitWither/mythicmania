package daniel.mythicmania;

import daniel.mythicmania.client.sound.MythicManiaSoundEvents;
import daniel.mythicmania.entity.MythicManiaEntityTypes;
import daniel.mythicmania.item.*;
import daniel.mythicmania.world.gen.MythicManiaFeatures;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;

public class MythicMania implements ModInitializer {
    public static final String MOD_ID = "mythicmania";

    public static final ItemGroup MYTHICMANIA_BLOCK_ITEM_GROUP = FabricItemGroup.builder(new Identifier(MOD_ID, "blocks")).icon(() -> new ItemStack(MythicManiaItems.PULSATING_BLACKSTONE)).build();
    public static final ItemGroup MYTHICMANIA_ITEMS_ITEM_GROUP = FabricItemGroup.builder(new Identifier(MOD_ID, "items")).icon(() -> new ItemStack(MythicManiaItems.EMPTY_ORB)).build();
    public static final ItemGroup MYTHICMANIA_COMBAT_ITEM_GROUP = FabricItemGroup.builder(new Identifier(MOD_ID, "combat")).icon(() -> new ItemStack(MythicManiaItems.RUINOUS_SWORD)).build();
    public static final ItemGroup MYTHICMANIA_TOOLS_ITEM_GROUP = FabricItemGroup.builder(new Identifier(MOD_ID, "tools")).icon(() -> new ItemStack(MythicManiaItems.NUCLEAR_AXE)).build();
    public static final ItemGroup MYTHICMANIA_FOOD_ITEM_GROUP = FabricItemGroup.builder(new Identifier(MOD_ID, "food")).icon(() -> new ItemStack(MythicManiaItems.TRIBUS_FRUIT)).build();

    @Override
    public void onInitialize() {
        MythicManiaItems.registerItems();
        MythicManiaItems.registerBlockItems();

        MythicManiaFeatures.registerFeatures();
        MythicManiaEntityTypes.registerEntityAttributes();
        MythicManiaSoundEvents.registerSoundEvents();
    }
}
