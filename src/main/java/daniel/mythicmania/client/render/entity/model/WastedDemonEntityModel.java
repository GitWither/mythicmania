package daniel.mythicmania.client.render.entity.model;

import daniel.mythicmania.entity.WastedDemonEntity;
import daniel.mythicmania.entity.ZappingBeetleEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class WastedDemonEntityModel extends EntityModel<WastedDemonEntity> {
    private final ModelPart root;
    public WastedDemonEntityModel(ModelPart part) {
       root = part;
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData demon = modelPartData.addChild("demon", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -27.0F, -3.0F, 8.0F, 14.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData bone = demon.addChild("bone", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -3.0F, 0.0F));

        ModelPartData head = demon.addChild("head", ModelPartBuilder.create().uv(0, 20).cuboid(-4.0F, -35.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData head_inflated = head.addChild("head_inflated", ModelPartBuilder.create().uv(63, 0).cuboid(-4.0F, -35.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.5F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData horns = head.addChild("horns", ModelPartBuilder.create().uv(42, 38).mirrored().cuboid(0.0F, -46.0F, 0.0F, 5.0F, 11.0F, 0.0F, new Dilation(0.0F)).mirrored(false)
                .uv(42, 38).cuboid(-5.0F, -46.0F, 0.0F, 5.0F, 11.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData arm_r = demon.addChild("arm_r", ModelPartBuilder.create().uv(32, 19).mirrored().cuboid(4.0F, -26.5F, -1.7F, 4.0F, 15.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData arm_r_inflated = arm_r.addChild("arm_r_inflated", ModelPartBuilder.create().uv(0, 64).mirrored().cuboid(4.0F, -26.5F, -1.7F, 4.0F, 15.0F, 4.0F, new Dilation(0.5F)).mirrored(false), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData arm_l = demon.addChild("arm_l", ModelPartBuilder.create().uv(32, 19).cuboid(-8.0F, -26.5F, -1.7F, 4.0F, 15.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData arm_l_inflated = arm_l.addChild("arm_l_inflated", ModelPartBuilder.create().uv(0, 64).cuboid(-8.0F, -26.5F, -1.7F, 4.0F, 15.0F, 4.0F, new Dilation(0.5F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData leg_r = demon.addChild("leg_r", ModelPartBuilder.create().uv(16, 36).mirrored().cuboid(0.0F, -13.0F, -2.0F, 4.0F, 13.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData leg_l = demon.addChild("leg_l", ModelPartBuilder.create().uv(16, 36).cuboid(-4.0F, -13.0F, -2.0F, 4.0F, 13.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        return TexturedModelData.of(modelData, 128, 128);
    }

    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        matrices.push();
        root.render(matrices, vertices, light, overlay, red, green, blue, alpha);
        matrices.pop();
    }

    @Override
    public void setAngles(WastedDemonEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

    }
}
