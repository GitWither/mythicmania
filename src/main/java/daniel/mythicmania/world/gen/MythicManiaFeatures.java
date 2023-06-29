package daniel.mythicmania.world.gen;

import daniel.mythicmania.MythicMania;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;

public final class MythicManiaFeatures {
    public static RegistryKey<ConfiguredFeature<?, ?>> TOXIC_ORE_KEY = RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(MythicMania.MOD_ID, "toxic_ore"));
    public static RegistryKey<ConfiguredFeature<?, ?>> RUINED_ORE_KEY = RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(MythicMania.MOD_ID, "ruined_ore"));

    public static final RegistryKey<PlacedFeature> TOXIC_ORE_PLACED = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(MythicMania.MOD_ID, "toxic_ore_placed"));
    public static final RegistryKey<PlacedFeature> RUINED_ORE_PLACED = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(MythicMania.MOD_ID, "ruined_ore_placed"));

    public static void registerFeatures() {
        BiomeModifications.addFeature(
            BiomeSelectors.foundInOverworld(),
            GenerationStep.Feature.UNDERGROUND_ORES,
            TOXIC_ORE_PLACED
        );

        BiomeModifications.addFeature(
            BiomeSelectors.foundInOverworld(),
            GenerationStep.Feature.UNDERGROUND_ORES,
            RUINED_ORE_PLACED
        );
    }
}
