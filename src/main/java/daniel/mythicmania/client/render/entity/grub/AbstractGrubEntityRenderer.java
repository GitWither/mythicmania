package daniel.mythicmania.client.render.entity.grub;

import daniel.mythicmania.client.render.entity.model.GrubEntityModel;
import daniel.mythicmania.entity.AbstractGrubEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractGrubEntityRenderer extends MobEntityRenderer<AbstractGrubEntity, GrubEntityModel> {
    public AbstractGrubEntityRenderer(EntityRendererFactory.Context context, GrubEntityModel entityModel, float f) {
        super(context, entityModel, f);
    }

    @Nullable
    @Override
    protected RenderLayer getRenderLayer(AbstractGrubEntity entity, boolean showBody, boolean translucent, boolean showOutline) {
        return RenderLayer.getEntityTranslucent(this.getTexture(entity));
    }
}
