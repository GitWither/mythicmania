package daniel.mythicmania.client.render.entity.model;

import daniel.mythicmania.entity.mob.PoisonousGrubEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class PoisonousGrubEntityModel extends EntityModel<PoisonousGrubEntity> {
    private final ModelPart root;
    private final ModelPart body;
    private final ModelPart segment1;
    private final ModelPart segment2;
    private final ModelPart segment3;
    private final ModelPart segment4;
    private final ModelPart segment5;

    public PoisonousGrubEntityModel(ModelPart part) {
        root = part;
        body = root.getChild("grub_poison");
        segment1 = body.getChild("bodyseg2");
        segment2 = segment1.getChild("bodyseg3");
        segment3 = segment2.getChild("tail");
        segment4 = body.getChild("bodyseg1");
        segment5 = segment4.getChild("head");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData grub_poison = modelPartData.addChild("grub_poison", ModelPartBuilder.create(), ModelTransform.pivot(-0.0042F, 24.0F, -0.6275F));

        ModelPartData bodyseg2 = grub_poison.addChild("bodyseg2", ModelPartBuilder.create().uv(0, 16).cuboid(-1.36F, -2.0F, -1.5F, 2.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 1.5F));

        ModelPartData bodyseg3 = bodyseg2.addChild("bodyseg3", ModelPartBuilder.create().uv(0, 9).cuboid(-2.2724F, 0.1031F, -2.309F, 4.0F, 3.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-0.0176F, -3.1031F, 3.659F));

        ModelPartData cube_r1 = bodyseg3.addChild("cube_r1", ModelPartBuilder.create().uv(2, 3).cuboid(0.0F, -0.9875F, -0.0125F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 2).cuboid(0.0F, -1.9875F, -1.0125F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.9424F, 0.2406F, 0.4035F, 0.0F, 0.0F, -0.1004F));

        ModelPartData cube_r2 = bodyseg3.addChild("cube_r2", ModelPartBuilder.create().uv(2, 2).cuboid(0.0F, -1.0375F, -0.0125F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(0.0F, -2.0375F, -1.0125F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.8076F, 0.2906F, -0.8465F, 0.0F, 0.0F, 0.2705F));

        ModelPartData tail = bodyseg3.addChild("tail", ModelPartBuilder.create().uv(14, 0).cuboid(-1.31F, -0.86F, -1.64F, 2.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0176F, 1.9631F, 3.321F));

        ModelPartData bodyseg1 = grub_poison.addChild("bodyseg1", ModelPartBuilder.create().uv(0, 0).cuboid(-2.33F, 0.5375F, -2.9125F, 4.0F, 3.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.04F, -3.5375F, -3.0375F));

        ModelPartData cube_r3 = bodyseg1.addChild("cube_r3", ModelPartBuilder.create().uv(0, 4).cuboid(0.0F, -0.3125F, -0.3125F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(2, 0).cuboid(0.0F, -1.3125F, -1.3125F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, -0.85F, 0.0F, 0.0F, 0.1222F));

        ModelPartData head = bodyseg1.addChild("head", ModelPartBuilder.create().uv(12, 12).cuboid(-1.86F, -0.86F, -1.46F, 3.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-0.04F, 2.3975F, -4.5875F));
        return TexturedModelData.of(modelData, 32, 32);
    }

    @Override
    public void setAngles(PoisonousGrubEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        segment1.yaw = MathHelper.cos(animationProgress * 0.8f) * 0.1f;
        segment2.yaw = MathHelper.sin(animationProgress * 0.8f) * 0.04f;
        segment3.yaw = MathHelper.cos(animationProgress * 0.9f) * 0.03f;
        segment4.yaw = MathHelper.sin(animationProgress * 0.8f) * 0.04f;
        segment5.yaw = MathHelper.cos(animationProgress * 0.8f) * 0.08f;
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        matrices.push();
        matrices.translate(0, -0.75, 0);
        matrices.scale(1.5f, 1.5f, 1.5f);
        root.render(matrices, vertices, light, overlay, red, green, blue, alpha);
        matrices.pop();
    }
}
