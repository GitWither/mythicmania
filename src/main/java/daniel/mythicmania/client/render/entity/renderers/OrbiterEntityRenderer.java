package daniel.mythicmania.client.render.entity.renderers;

import daniel.mythicmania.MythicMania;
import daniel.mythicmania.client.render.entity.feature.EntityCapeFeatureRenderer;
import daniel.mythicmania.client.render.entity.feature.OrbiterCoreRenderer;
import daniel.mythicmania.client.render.entity.model.OrbiterEntityModel;
import daniel.mythicmania.client.render.entity.model.WastedDemonEntityModel;
import daniel.mythicmania.client.render.entity.feature.DemonEyesRenderer;
import daniel.mythicmania.entity.*;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;

public class OrbiterEntityRenderer extends MobEntityRenderer<OrbiterEntity, OrbiterEntityModel<Entity>> {
    public OrbiterEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new OrbiterEntityModel<>(context.getPart(MythicManiaEntityTypes.ORBITER_LAYER)), 0.5f);
        this.addFeature(new OrbiterCoreRenderer<>(this));
    }

    @Override
    public Identifier getTexture(OrbiterEntity entity) {
        return new Identifier(MythicMania.MOD_ID, "textures/entity/orbiter/orbiter.png");
    }
}