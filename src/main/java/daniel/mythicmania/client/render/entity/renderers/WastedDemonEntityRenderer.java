package daniel.mythicmania.client.render.entity.renderers;

import daniel.mythicmania.MythicMania;
import daniel.mythicmania.client.render.entity.feature.EntityCapeFeatureRenderer;
import daniel.mythicmania.client.render.entity.model.WastedDemonEntityModel;
import daniel.mythicmania.client.render.entity.feature.DemonEyesRenderer;
import daniel.mythicmania.entity.*;
import daniel.mythicmania.entity.mob.WastedDemonEntity;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;

public class WastedDemonEntityRenderer extends BipedEntityRenderer<WastedDemonEntity, WastedDemonEntityModel<Entity>> {
    public WastedDemonEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new WastedDemonEntityModel<Entity>(context.getPart(MythicManiaEntityTypes.WASTED_DEMON_LAYER)), 0.5f);
        this.addFeature(new EntityCapeFeatureRenderer(this, this.getCapeTexture()));
        this.addFeature(new DemonEyesRenderer<>(this));
    }

    @Override
    public Identifier getTexture(WastedDemonEntity entity) {
        return new Identifier(MythicMania.MOD_ID, "textures/entity/wasted_demon/demon.png");
    }

    public Identifier getCapeTexture() {
        return new Identifier(MythicMania.MOD_ID, "textures/entity/wasted_demon/cape.png");
    }

    @Override
    protected void scale(WastedDemonEntity entity, MatrixStack matrices, float amount) {
        matrices.scale(1.3f, 1.3f, 1.3f);
    }
}
