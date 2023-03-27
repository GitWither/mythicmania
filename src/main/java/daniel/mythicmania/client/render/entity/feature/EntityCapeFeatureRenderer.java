package daniel.mythicmania.client.render.entity.feature;

import daniel.mythicmania.client.render.entity.model.WastedDemonEntityModel;
import daniel.mythicmania.entity.WastedDemonEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import org.joml.Vector3f;

public class EntityCapeFeatureRenderer extends FeatureRenderer<WastedDemonEntity, WastedDemonEntityModel<Entity>> {
    private final Identifier capeTexture;

    public EntityCapeFeatureRenderer(FeatureRendererContext<WastedDemonEntity, WastedDemonEntityModel<Entity>> context, Identifier capeTexture) {
        super(context);
        this.capeTexture = capeTexture;
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, WastedDemonEntity wastedDemon, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        matrices.push();
        matrices.translate(0.0, 0.0, 0.125);

        double capeDeltaX = MathHelper.lerp(tickDelta, wastedDemon.prevCapeX, wastedDemon.capeX) - MathHelper.lerp(tickDelta, wastedDemon.prevX, wastedDemon.getX());
        double capeDeltaY = MathHelper.lerp(tickDelta, wastedDemon.prevCapeY, wastedDemon.capeY) - MathHelper.lerp(tickDelta, wastedDemon.prevY, wastedDemon.getY());
        double capeDeltaZ = MathHelper.lerp(tickDelta, wastedDemon.prevCapeZ, wastedDemon.capeZ) - MathHelper.lerp(tickDelta, wastedDemon.prevZ, wastedDemon.getZ());

        float deltaYaw = wastedDemon.prevBodyYaw + (wastedDemon.bodyYaw - wastedDemon.prevBodyYaw);

        double unitCircleY = MathHelper.sin(deltaYaw * ((float)Math.PI / 180));
        double unitCircleX = -MathHelper.cos(deltaYaw * ((float)Math.PI / 180));

        float capeTilt = (float)capeDeltaY * 10.0f;

        capeTilt = MathHelper.clamp(capeTilt, -6.0f, 32.0f);

        float capeX = (float)(capeDeltaX * unitCircleY + capeDeltaZ * unitCircleX) * 100.0f;
        capeX = MathHelper.clamp(capeX, 0.0f, 150.0f);

        float capeZ = (float)(capeDeltaX * unitCircleX - capeDeltaZ * unitCircleY) * 100.0f;
        capeZ = MathHelper.clamp(capeZ, -20.0f, 20.0f);

        if (capeX < 0.0f) {
            capeX = 0.0f;
        }
        //float t = MathHelper.lerp(tickDelta, wastedDemon.prevStrideDistance, abstractClientPlayerEntity.strideDistance);
        capeTilt += MathHelper.sin(MathHelper.lerp(tickDelta, wastedDemon.prevHorizontalSpeed, wastedDemon.horizontalSpeed) * 6.0f) * 32.0f * 0.9f;

        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(6.0f + capeX / 2.0f + capeTilt));
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(capeZ / 2.0f));
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180.0f - capeZ / 2.0f));

        VertexConsumer vertexConsumer = vertexConsumers.getBuffer(RenderLayer.getEntitySolid(capeTexture));
        this.getContextModel().renderCape(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV);

        matrices.pop();
    }
}
