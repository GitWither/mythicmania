package daniel.mythicmania;

import daniel.mythicmania.client.render.entity.grub.MagicalGrubEntityRenderer;
import daniel.mythicmania.client.render.entity.grub.PoisonousGrubEntityRenderer;
import daniel.mythicmania.client.render.entity.model.GrubEntityModel;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class MythicManiaClient implements ClientModInitializer {

    public static final EntityModelLayer MAGICAL_GRUB_LAYER = new EntityModelLayer(new Identifier(MythicMania.MOD_ID, "magical_grub"), "root");
    public static final EntityModelLayer POISONOUS_GRUB_LAYER = new EntityModelLayer(new Identifier(MythicMania.MOD_ID, "poisonous_grub"), "root");

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(MythicMania.RINTH_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MythicMania.HARVESTER_BLOCK, RenderLayer.getCutout());

        EntityRendererRegistry.register(MythicMania.POISONOUS_GRUB_ENTITY, PoisonousGrubEntityRenderer::new);
        EntityRendererRegistry.register(MythicMania.MAGICAL_GRUB_ENTITY, MagicalGrubEntityRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(MAGICAL_GRUB_LAYER, GrubEntityModel::getMagicalGrubTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(POISONOUS_GRUB_LAYER, GrubEntityModel::getPoisonousGrubTexturedModelData);
    }
}
