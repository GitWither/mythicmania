package daniel.mythicmania;

import daniel.mythicmania.block.MythicManiaBlocks;
import daniel.mythicmania.block.entity.MythicManiaBlockEntities;
import daniel.mythicmania.client.render.entity.grub.MagicalGrubEntityRenderer;
import daniel.mythicmania.client.render.entity.grub.PoisonousGrubEntityRenderer;
import daniel.mythicmania.client.render.entity.model.MagicalGrubEntityModel;
import daniel.mythicmania.client.render.entity.model.PoisonousGrubEntityModel;
import daniel.mythicmania.entity.MythicManiaEntityTypes;
import daniel.mythicmania.particle.MythicManiaParticles;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.util.Identifier;

public class MythicManiaClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
            MythicManiaParticles.registerParticleSprites(registry);
        });

        MythicManiaBlocks.registerBlockRendering();
        MythicManiaBlockEntities.registerBlockEntityRendering();
        MythicManiaEntityTypes.registerEntityRendering();
        MythicManiaParticles.registerParticleFactories();
    }
}
