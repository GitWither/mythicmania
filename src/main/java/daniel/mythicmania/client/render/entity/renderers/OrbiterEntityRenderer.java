package daniel.mythicmania.client.render.entity.renderers;

import daniel.mythicmania.MythicMania;
import daniel.mythicmania.client.render.entity.feature.OrbiterCoreRenderer;
import daniel.mythicmania.client.render.entity.model.OrbiterEntityModel;
import daniel.mythicmania.entity.*;
import daniel.mythicmania.entity.mob.OrbiterEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
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

    @Override
    protected void scale(OrbiterEntity entity, MatrixStack matrices, float amount) {
        matrices.scale(1.2f, 1.2f, 1.2f);
    }
}