package daniel.mythicmania.block;

import daniel.mythicmania.MythicMania;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public final class MythicManiaBlocks {
    public static final Block RINTH_BLOCK = Registry.register(
            Registries.BLOCK,
            new Identifier(MythicMania.MOD_ID, "rinth"),
            new RinthBlock()
    );

    public static final Block HARVESTER_BLOCK = Registry.register(
            Registries.BLOCK,
            new Identifier(MythicMania.MOD_ID, "harvester"),
            new HarvesterBlock()
    );

    public static final Block TRIBUS_BLOCK = Registry.register(
            Registries.BLOCK,
            new Identifier(MythicMania.MOD_ID, "tribus"),
            new TribusBlock()
    );

    public static final Block ANCIENT_ALTAR = Registry.register(
            Registries.BLOCK,
            new Identifier(MythicMania.MOD_ID, "ancient_altar"),
            new AncientAltarBlock()
    );

    public static final Block TOXIC_ORE = Registry.register(
            Registries.BLOCK,
            new Identifier(MythicMania.MOD_ID, "toxic_ore"),
            new ToxicOreBlock(FabricBlockSettings.of(Material.STONE).requiresTool().strength(3.0f, 3.0f))
    );

    public static final Block LUMINESCENT_SAC = Registry.register(
            Registries.BLOCK,
            new Identifier(MythicMania.MOD_ID, "luminescent_sac"),
            new LuminescentSacBlock()
    );

    public static final Block PULSATING_BLACKSTONE = Registry.register(
            Registries.BLOCK,
            new Identifier(MythicMania.MOD_ID, "pulsating_blackstone"),
            new Block(FabricBlockSettings.of(Material.STONE).requiresTool().luminance((state) -> 5).strength(2, 6).sounds(BlockSoundGroup.GILDED_BLACKSTONE))
    );

    public static final Block ORBITER_PROJECTILE = Registry.register(
            Registries.BLOCK,
            new Identifier(MythicMania.MOD_ID, "orbiter_projectile"),
            new Block(FabricBlockSettings.of(Material.STONE).luminance((state) -> 5))
    );

    public static final Block TOXIC_ORBITER_PROJECTILE = Registry.register(
            Registries.BLOCK,
            new Identifier(MythicMania.MOD_ID, "toxic_orbiter_projectile"),
            new Block(FabricBlockSettings.of(Material.STONE).luminance((state) -> 5))
    );

    public static void registerBlockRendering() {
        BlockRenderLayerMap.INSTANCE.putBlock(RINTH_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(HARVESTER_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TRIBUS_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(LUMINESCENT_SAC, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ORBITER_PROJECTILE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(TOXIC_ORBITER_PROJECTILE, RenderLayer.getCutout());
    }
}
