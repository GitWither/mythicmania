package daniel.mythicmania;

import daniel.mythicmania.block.MythicManiaBlocks;
import daniel.mythicmania.block.entity.MythicManiaBlockEntities;
import daniel.mythicmania.entity.MythicManiaEntityTypes;
import daniel.mythicmania.particle.MythicManiaParticles;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.minecraft.screen.PlayerScreenHandler;

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
