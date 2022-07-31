package daniel.mythicmania;

import daniel.mythicmania.block.MythicManiaBlocks;
import daniel.mythicmania.client.render.entity.grub.MagicalGrubEntityRenderer;
import daniel.mythicmania.client.render.entity.grub.PoisonousGrubEntityRenderer;
import daniel.mythicmania.client.render.entity.model.MagicalGrubEntityModel;
import daniel.mythicmania.client.render.entity.model.PoisonousGrubEntityModel;
import daniel.mythicmania.entity.MythicManiaEntityTypes;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class MythicManiaClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        MythicManiaBlocks.registerBlockRendering();
        MythicManiaEntityTypes.registerEntityRendering();
    }
}
