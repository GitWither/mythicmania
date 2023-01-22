package daniel.mythicmania.client.render.entity.model;

import daniel.mythicmania.entity.DemonGuardianEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.CrossbowPosing;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class DemonGuardianEntityModel extends PlayerEntityModel<DemonGuardianEntity> {
    public DemonGuardianEntityModel(ModelPart root, boolean thinArms) {
        super(root, thinArms);
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData head = modelPartData.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -2.25F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 4.25F, 0.0F));

        ModelPartData hat = modelPartData.addChild("hat", ModelPartBuilder.create().uv(1, 95).cuboid(-4.0F, -2.75F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.5F)), ModelTransform.pivot(0.0F, 5.0F, 0.0F));

        ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create().uv(0, 16).cuboid(-4.0F, 6.0F, -3.0F, 8.0F, 9.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 3.25F, 0.0F));

        ModelPartData right_arm = modelPartData.addChild("right_arm", ModelPartBuilder.create().uv(28, 12).cuboid(-2.5F, 2.5F, -1.7F, 4.0F, 11.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(7.0F, 7.0F, 0.0F));

        ModelPartData left_leg = modelPartData.addChild("left_leg", ModelPartBuilder.create().uv(36, 38).cuboid(-2.0F, 3.0F, -2.0F, 4.0F, 9.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, 15.0F, 0.0F));

        ModelPartData ear = modelPartData.addChild("ear", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData right_sleeve = modelPartData.addChild("right_sleeve", ModelPartBuilder.create().uv(1, 49).mirrored().cuboid(-2.5F, 2.5F, -1.7F, 4.0F, 11.0F, 4.0F, new Dilation(0.5F)).mirrored(false), ModelTransform.pivot(7.0F, 7.0F, 0.0F));

        ModelPartData jacket = modelPartData.addChild("jacket", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData left_pants = modelPartData.addChild("left_pants", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData right_pants = modelPartData.addChild("right_pants", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData cloak = modelPartData.addChild("cloak", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -4.0F, 2.0F));

        ModelPartData left_arm = modelPartData.addChild("left_arm", ModelPartBuilder.create().uv(28, 12).mirrored().cuboid(-1.5F, 2.5F, -1.7F, 4.0F, 11.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-7.0F, 7.0F, 0.0F));

        ModelPartData right_leg = modelPartData.addChild("right_leg", ModelPartBuilder.create().uv(36, 38).mirrored().cuboid(-2.0F, 3.0F, -2.0F, 4.0F, 9.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(2.0F, 15.0F, 0.0F));

        ModelPartData left_sleeve = modelPartData.addChild("left_sleeve", ModelPartBuilder.create().uv(1, 49).cuboid(-1.5F, 2.5F, -1.7F, 4.0F, 11.0F, 4.0F, new Dilation(0.5F)), ModelTransform.pivot(-7.0F, 7.0F, 0.0F));
        return TexturedModelData.of(modelData, 128, 128);
    }

    @Override
    public void setAngles(DemonGuardianEntity entity, float f, float g, float h, float i, float j) {
        super.setAngles(entity, f, g, h, i, j);
    }

    @Override
    protected void animateArms(DemonGuardianEntity entity, float animationProgress) {
        if (this.handSwingProgress > 0.0f) {
            CrossbowPosing.meleeAttack(this.rightArm, this.leftArm, entity, this.handSwingProgress, animationProgress);
            return;
        }
        super.animateArms(entity, animationProgress);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        super.render(matrices, vertices, light, overlay, red, green, blue, alpha);
    }
}
