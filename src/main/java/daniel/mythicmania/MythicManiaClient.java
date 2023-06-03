package daniel.mythicmania;

import daniel.mythicmania.block.MythicManiaBlocks;
import daniel.mythicmania.block.entity.MythicManiaBlockEntities;
import daniel.mythicmania.entity.MythicManiaEntityTypes;
import daniel.mythicmania.particle.MythicManiaParticles;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class MythicManiaClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        MythicManiaBlocks.registerBlockRendering();
        MythicManiaBlockEntities.registerBlockEntityRendering();
        MythicManiaEntityTypes.registerEntityRendering();
        MythicManiaParticles.registerParticleFactories();

        BlockRenderLayerMap.INSTANCE.putBlock(MythicManiaBlocks.ANCIENT_ALTAR, RenderLayer.getCutout());
    }
}