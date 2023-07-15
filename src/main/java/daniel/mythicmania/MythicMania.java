package daniel.mythicmania;

import daniel.mythicmania.client.sound.MythicManiaSoundEvents;
import daniel.mythicmania.entity.MythicManiaEntityTypes;
import daniel.mythicmania.item.*;
import daniel.mythicmania.world.gen.MythicManiaLootTableModifier;
import daniel.mythicmania.world.gen.MythicManiaFeatures;
import net.fabricmc.api.ModInitializer;

public class MythicMania implements ModInitializer {
    public static final String MOD_ID = "mythicmania";

    @Override
    public void onInitialize() {
        MythicManiaItems.registerItems();
        MythicManiaItems.registerBlockItems();
        MythicManiaItemGroups.registerItemGroups();

        MythicManiaFeatures.registerFeatures();
        MythicManiaEntityTypes.registerEntityAttributes();
        MythicManiaSoundEvents.registerSoundEvents();
        MythicManiaLootTableModifier.registerLootTableModifiers();
    }
}
