package daniel.mythicmania.block;

import daniel.mythicmania.MythicMania;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public final class MythicManiaBlocks {
    public static final Block RINTH_BLOCK = Registry.register(
            Registries.BLOCK,
            new Identifier(MythicMania.MOD_ID, "rinth"),
            new RinthPlantBlock()
    );

    public static final Block HARVESTER_BLOCK = Registry.register(
            Registries.BLOCK,
            new Identifier(MythicMania.MOD_ID, "harvester"),
            new HarvesterPlantBlock()
    );

    public static final Block TRIBUS_BLOCK = Registry.register(
            Registries.BLOCK,
            new Identifier(MythicMania.MOD_ID, "tribus"),
            new TribusBushBlock()
    );

    public static final Block ANCIENT_ALTAR = Registry.register(
            Registries.BLOCK,
            new Identifier(MythicMania.MOD_ID, "ancient_altar"),
            new AncientAltarBlock()
    );

    public static final Block TOXIC_ORE = Registry.register(
            Registries.BLOCK,
            new Identifier(MythicMania.MOD_ID, "toxic_ore"),
            new ToxicOreBlock(FabricBlockSettings.copyOf(Blocks.STONE).requiresTool().strength(3.0f, 3.0f))
    );

    public static final Block RUINED_ORE = Registry.register(
            Registries.BLOCK,
            new Identifier(MythicMania.MOD_ID, "ruined_ore"),
            new RuinedOreBlock(FabricBlockSettings.copyOf(Blocks.STONE).requiresTool().strength(3.5f, 3.5f))
    );

    public static final Block BLACKSTONE_RUINED_ORE = Registry.register(
            Registries.BLOCK,
            new Identifier(MythicMania.MOD_ID, "blackstone_ruined_ore"),
            new RuinedOreBlock(FabricBlockSettings.copyOf(Blocks.BLACKSTONE).requiresTool().strength(3.5f, 3.5f))
    );

    public static final Block LUMINESCENT_SAC = Registry.register(
            Registries.BLOCK,
            new Identifier(MythicMania.MOD_ID, "luminescent_sac"),
            new LuminescentSacBlock()
    );

    public static final Block PULSATING_BLACKSTONE = Registry.register(
            Registries.BLOCK,
            new Identifier(MythicMania.MOD_ID, "pulsating_blackstone"),
            new Block(FabricBlockSettings.copyOf(Blocks.BLACKSTONE).requiresTool().luminance((state) -> 5).strength(2, 6).sounds(BlockSoundGroup.GILDED_BLACKSTONE))
    );

    public static final Block IRRADIATED_CRYSTAL = Registry.register(
            Registries.BLOCK,
            new Identifier(MythicMania.MOD_ID, "irradiated_crystal"),
            new IrradiatedCrystalBlock(FabricBlockSettings.copyOf(Blocks.LARGE_AMETHYST_BUD).nonOpaque().luminance((state) -> 5).strength(2, 2).sounds(BlockSoundGroup.LARGE_AMETHYST_BUD))
    );

    public static final Block ORBITER_PROJECTILE = Registry.register(
            Registries.BLOCK,
            new Identifier(MythicMania.MOD_ID, "orbiter_projectile"),
            new Block(FabricBlockSettings.create().luminance((state) -> 5))
    );

    public static final Block TOXIC_ORBITER_PROJECTILE = Registry.register(
            Registries.BLOCK,
            new Identifier(MythicMania.MOD_ID, "toxic_orbiter_projectile"),
            new Block(FabricBlockSettings.copyOf(ORBITER_PROJECTILE).luminance((state) -> 5))
    );

    public static void registerBlockRendering() {
        BlockRenderLayerMap.INSTANCE.putBlock(RINTH_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(HARVESTER_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TRIBUS_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(LUMINESCENT_SAC, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ORBITER_PROJECTILE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TOXIC_ORBITER_PROJECTILE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(IRRADIATED_CRYSTAL, RenderLayer.getCutout());
    }
}
