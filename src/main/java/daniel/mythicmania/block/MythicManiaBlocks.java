package daniel.mythicmania.block;

import daniel.mythicmania.MythicMania;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;
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

    public static void registerBlockRendering() {
        BlockRenderLayerMap.INSTANCE.putBlock(MythicManiaBlocks.RINTH_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MythicManiaBlocks.HARVESTER_BLOCK, RenderLayer.getCutout());
    }
}
