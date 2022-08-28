package daniel.mythicmania.world.gen;

import daniel.mythicmania.MythicMania;
import net.fabricmc.fabric.api.biome.v1.BiomeModification;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

import java.util.Arrays;

public final class MythicManiaFeatures {

    public static ConfiguredFeature<?, ?> OVERWORLD_TOXIC_ORE_CONFIGURED_FEATURE = Registry.register(
            BuiltinRegistries.CONFIGURED_FEATURE,
            new Identifier(MythicMania.MOD_ID, "overworld_toxic_ore"),
            new ConfiguredFeature<>(
                    Feature.ORE,
                    new OreFeatureConfig(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, Blocks.SPONGE.getDefaultState(), 9)
            )
    );

    public static PlacedFeature OVERWORLD_TOXIC_ORE_PLACED_FEATURE = Registry.register(
            BuiltinRegistries.PLACED_FEATURE,
            new Identifier(MythicMania.MOD_ID, "overworld_toxic_ore"),
            new PlacedFeature(
                    RegistryEntry.of(OVERWORLD_TOXIC_ORE_CONFIGURED_FEATURE),
                    Arrays.asList(
                            CountPlacementModifier.of(20),
                            SquarePlacementModifier.of(),
                            HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.getTop())
                    )
            )
    );

    public static void registerFeatures() {
        BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES,
                BuiltinRegistries.PLACED_FEATURE.getKey(OVERWORLD_TOXIC_ORE_PLACED_FEATURE).orElseThrow()
        );
    }
}
