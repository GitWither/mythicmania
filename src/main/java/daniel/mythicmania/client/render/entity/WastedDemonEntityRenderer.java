package daniel.mythicmania.client.render.entity;

import daniel.mythicmania.MythicMania;
import daniel.mythicmania.MythicManiaClient;
import daniel.mythicmania.client.render.entity.feature.EntityCapeFeatureRenderer;
import daniel.mythicmania.client.render.entity.model.PoisonousGrubEntityModel;
import daniel.mythicmania.client.render.entity.model.WastedDemonEntityModel;
import daniel.mythicmania.client.render.entity.model.ZappingBeetleEntityModel;
import daniel.mythicmania.entity.*;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class WastedDemonEntityRenderer extends BipedEntityRenderer<WastedDemonEntity, WastedDemonEntityModel> {
    public WastedDemonEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new WastedDemonEntityModel(context.getPart(MythicManiaEntityTypes.WASTED_DEMON_LAYER)), 0.5f);
        this.addFeature(new EntityCapeFeatureRenderer(this));
    }

    @Override
    public Identifier getTexture(WastedDemonEntity entity) {
        return new Identifier(MythicMania.MOD_ID, "textures/entity/wasted_demon/wasted_demon.png");
    }
}
