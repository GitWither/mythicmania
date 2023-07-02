package daniel.mythicmania.client.render.entity.model;

import daniel.mythicmania.entity.mob.MagicalGrubEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class MagicalGrubEntityModel extends EntityModel<MagicalGrubEntity> {
    private final ModelPart root;
    private final ModelPart bodySegment1;
    private final ModelPart bodySegment2;
    private final ModelPart bodySegment3;

    public MagicalGrubEntityModel(ModelPart part) {
        root = part;

        bodySegment1 = root.getChild("grub").getChild("bone");
        bodySegment2 = root.getChild("grub").getChild("bone2");
        bodySegment3 = root.getChild("grub").getChild("bone3");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData grub = modelPartData.addChild("grub", ModelPartBuilder.create(), ModelTransform.pivot(0.5707F, 23.75F, -0.55F));

        ModelPartData bone = grub.addChild("bone", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0778F, -2.6352F, -1.8444F, 3.0F, 3.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -0.0574F, 0.0F));

        ModelPartData bone2 = grub.addChild("bone2", ModelPartBuilder.create().uv(0, 8).cuboid(-1.5442F, -1.6776F, -5.0632F, 2.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -0.015F, 0.0F));

        ModelPartData bone3 = grub.addChild("bone3", ModelPartBuilder.create().uv(8, 8).cuboid(-1.5972F, -1.6776F, 3.1632F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -0.015F, 0.0F));

        return TexturedModelData.of(modelData, 16, 16);
    }

    @Override
    public void setAngles(MagicalGrubEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        bodySegment1.yaw = MathHelper.cos(animationProgress * 0.8f) * 0.1f;
        bodySegment2.yaw = MathHelper.sin(animationProgress * 0.8f) * 0.04f;
        bodySegment3.yaw = MathHelper.sin(animationProgress * 0.8f) * 0.04f;
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
