package daniel.mythicmania.block;

import daniel.mythicmania.MythicMania;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;

public final class MythicManiaBlocks {
    public static final Block RINTH_BLOCK = Registry.register(
            Registry.BLOCK,
            new Identifier(MythicMania.MOD_ID, "rinth"),
            new RinthBlock()
    );

    public static final Block HARVESTER_BLOCK = Registry.register(
            Registry.BLOCK,
            new Identifier(MythicMania.MOD_ID, "harvester"),
            new HarvesterBlock()
    );

    public static final Block TRIBUS_BLOCK = Registry.register(
            Registry.BLOCK,
            new Identifier(MythicMania.MOD_ID, "tribus"),
            new TribusBlock()
    );

    public static final Block ANCIENT_ALTAR = Registry.register(
            Registry.BLOCK,
            new Identifier(MythicMania.MOD_ID, "ancient_altar"),
            new AncientAltarBlock()
    );

    public static final Block TOXIC_ORE = Registry.register(
            Registry.BLOCK,
            new Identifier(MythicMania.MOD_ID, "toxic_ore"),
            new ToxicOreBlock(OreBlock.Settings.of(Material.STONE).requiresTool().strength(3.0f, 3.0f))
    );

    public static final Block LUMINESCENT_SAC = Registry.register(
            Registry.BLOCK,
            new Identifier(MythicMania.MOD_ID, "luminescent_sac"),
            new LuminescentSacBlock()
    );

    public static final Block PULSATING_BLACKSTONE = Registry.register(
            Registry.BLOCK,
            new Identifier(MythicMania.MOD_ID, "pulsating_blackstone"),
            new Block(FabricBlockSettings.of(Material.STONE).requiresTool().luminance((state) -> 5).strength(2, 6).sounds(BlockSoundGroup.GILDED_BLACKSTONE))
    );

    public static void registerBlockRendering() {
        BlockRenderLayerMap.INSTANCE.putBlock(MythicManiaBlocks.RINTH_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MythicManiaBlocks.HARVESTER_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MythicManiaBlocks.TRIBUS_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MythicManiaBlocks.LUMINESCENT_SAC, RenderLayer.getCutout());
    }
}
