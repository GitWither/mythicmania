package daniel.mythicmania;

import daniel.mythicmania.block.MythicManiaBlocks;
import daniel.mythicmania.block.entity.MythicManiaBlockEntities;
import daniel.mythicmania.entity.MythicManiaEntityTypes;
import daniel.mythicmania.particle.MythicManiaParticles;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.render.model.SpriteAtlasManager;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.texture.SpriteLoader;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.util.Identifier;

public class MythicManiaClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        MythicManiaBlocks.registerBlockRendering();
        MythicManiaBlockEntities.registerBlockEntityRendering();
        MythicManiaEntityTypes.registerEntityRendering();
        MythicManiaParticles.registerParticleFactories();
    }
}
