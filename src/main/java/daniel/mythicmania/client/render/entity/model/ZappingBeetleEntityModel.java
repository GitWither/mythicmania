package daniel.mythicmania.client.render.entity.model;

import daniel.mythicmania.entity.mob.ZappingBeetleEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class ZappingBeetleEntityModel extends EntityModel<ZappingBeetleEntity> {
    private final ModelPart root;
    private final ModelPart body;
    private final ModelPart segment1;
    private final ModelPart wing3;
    private final ModelPart wing2;

    public ZappingBeetleEntityModel(ModelPart part) {
        root = part;
        body = root.getChild("bone");
        segment1 = body.getChild("wings");
        wing3 = segment1.getChild("wing3");
        wing2 = segment1.getChild("wing2");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData bone = modelPartData.addChild("bone", ModelPartBuilder.create().uv(18, 0).cuboid(-1.4F, -4.25F, -5.0F, 3.0F, 3.0F, 3.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-2.0F, -5.0F, -2.0F, 4.0F, 4.0F, 6.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(0.0F, -3.75F, 4.0F, 0.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData cube_r1 = bone.addChild("cube_r1", ModelPartBuilder.create().uv(2, 9).cuboid(0.0F, 0.0F, -0.5F, 0.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, -2.0F, 2.5F, 0.4363F, 0.0F, 1.0472F));

        ModelPartData cube_r2 = bone.addChild("cube_r2", ModelPartBuilder.create().uv(0, 9).cuboid(0.0F, 0.0F, -0.5F, 0.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, -2.0F, 0.5F, 0.0F, 0.0F, 1.0472F));

        ModelPartData cube_r3 = bone.addChild("cube_r3", ModelPartBuilder.create().uv(4, 0).cuboid(0.0F, 0.0F, -0.5F, 0.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, -2.0F, -1.5F, -0.4363F, 0.0F, 1.0472F));

        ModelPartData cube_r4 = bone.addChild("cube_r4", ModelPartBuilder.create().uv(4, 9).cuboid(0.0F, 0.0F, -0.5F, 0.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, -2.0F, 0.5F, 0.0F, 0.0F, -1.0472F));

        ModelPartData cube_r5 = bone.addChild("cube_r5", ModelPartBuilder.create().uv(0, 19).cuboid(0.0F, 0.0F, -0.5F, 0.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, -2.0F, 2.5F, 0.4363F, 0.0F, -1.0472F));

        ModelPartData cube_r6 = bone.addChild("cube_r6", ModelPartBuilder.create().uv(2, 19).cuboid(0.0F, 0.0F, -0.5F, 0.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, -2.0F, -1.5F, -0.4363F, 0.0F, -1.0472F));

        ModelPartData wings = bone.addChild("wings", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData wing3 = wings.addChild("wing3", ModelPartBuilder.create().uv(0, 11).cuboid(2.0F, 0.0F, 0.0F, 0.0F, 3.0F, 6.0F, new Dilation(0.0F))
                .uv(8, 0).cuboid(0.0F, 0.0F, 0.0F, 2.0F, 0.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.025F, -5.025F, -2.0F));

        ModelPartData wing2 = wings.addChild("wing2", ModelPartBuilder.create().uv(0, 11).mirrored().cuboid(-2.0F, 0.0F, 0.0F, 0.0F, 3.0F, 6.0F, new Dilation(0.0F)).mirrored(false)
                .uv(8, 0).mirrored().cuboid(-2.0F, 0.0F, 0.0F, 2.0F, 0.0F, 6.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-0.025F, -5.025F, -2.0F));

        ModelPartData antenna1 = bone.addChild("antenna1", ModelPartBuilder.create(), ModelTransform.pivot(-0.375F, -3.75F, -3.675F));

        ModelPartData cube_r7 = antenna1.addChild("cube_r7", ModelPartBuilder.create().uv(2, 10).cuboid(-1.025F, 0.0F, -6.325F, 1.0F, 0.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, -0.25F, 0.0F, 0.0F, 0.1745F, 0.1309F));

        ModelPartData antenna2 = bone.addChild("antenna2", ModelPartBuilder.create(), ModelTransform.pivot(2.625F, -3.75F, -3.675F));

        ModelPartData cube_r8 = antenna2.addChild("cube_r8", ModelPartBuilder.create().uv(0, 10).cuboid(0.025F, 0.0F, -6.325F, 1.0F, 0.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, -0.25F, 0.0F, 0.0F, -0.1745F, -0.1309F));

        return TexturedModelData.of(modelData, 32, 32);
    }

    @Override
    public void setAngles(ZappingBeetleEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        float angle = MathHelper.clamp(MathHelper.sin(animationProgress * 1.6f) * 0.8f, 0, 45);

        wing3.pitch = angle;
        wing2.pitch = angle;

        wing3.yaw = angle;
        wing2.yaw = -angle;
    }

    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        root.render(matrices, vertices, light, overlay, red, green, blue, alpha);
    }
}
