package daniel.mythicmania.client.render.entity.model;

import daniel.mythicmania.entity.mob.DemonGuardianEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.CrossbowPosing;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class DemonGuardianEntityModel extends PlayerEntityModel<DemonGuardianEntity> {
    private final ModelPart root;
    private final ModelPart body;
    private final ModelPart bodyRemains;

    public DemonGuardianEntityModel(ModelPart part, boolean thinArms) {
        super(part, thinArms);
        root = part;
        body = root.getChild("body");
        bodyRemains = body.getChild("body_remains");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData head = modelPartData.addChild("head", ModelPartBuilder.create().uv(25, 12).cuboid(-3.5F, -8.0F, -4.0F, 7.0F, 7.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 5.0F, -2.0F));

        ModelPartData hat = modelPartData.addChild("hat", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 5.0F, -2.0F));

        ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create().uv(0, 19).cuboid(-4.0F, -1.0F, -5.0F, 8.0F, 11.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 6.0F, 0.0F));

        ModelPartData body_remains = body.addChild("body_remains", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 10.525F, -2.5F));

        ModelPartData cube_r1 = body_remains.addChild("cube_r1", ModelPartBuilder.create().uv(26, 32).cuboid(-3.0F, -1.5F, -1.0F, 6.0F, 8.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.48F, 0.0F, 0.0F));

        ModelPartData right_arm = modelPartData.addChild("right_arm", ModelPartBuilder.create(), ModelTransform.pivot(-4.0F, 8.0F, 0.0F));

        ModelPartData cube_r2 = right_arm.addChild("cube_r2", ModelPartBuilder.create().uv(48, 0).mirrored().cuboid(0.0F, -7.0F, 1.0F, 4.0F, 10.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-4.0F, 3.25F, -4.5F, 0.0F, 0.0F, 0.1309F));

        ModelPartData left_leg = modelPartData.addChild("left_leg", ModelPartBuilder.create(), ModelTransform.pivot(-2.0F, 18.0F, 0.0F));

        ModelPartData right_leg = modelPartData.addChild("right_leg", ModelPartBuilder.create(), ModelTransform.pivot(2.0F, 18.0F, 0.0F));

        ModelPartData ear = modelPartData.addChild("ear", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData right_sleeve = modelPartData.addChild("right_sleeve", ModelPartBuilder.create(), ModelTransform.pivot(-4.0F, 8.0F, 0.0F));

        ModelPartData arm_r_inflated_r1 = right_sleeve.addChild("arm_r_inflated_r1", ModelPartBuilder.create().uv(16, 46).mirrored().cuboid(0.0F, -7.0F, 1.0F, 4.0F, 10.0F, 4.0F, new Dilation(0.2F)).mirrored(false), ModelTransform.of(-4.0F, 3.25F, -4.5F, 0.0F, 0.0F, 0.1309F));

        ModelPartData jacket = modelPartData.addChild("jacket", ModelPartBuilder.create().uv(1, 1).cuboid(-4.0F, -1.0F, -5.0F, 8.0F, 11.0F, 7.0F, new Dilation(0.2F)), ModelTransform.pivot(0.0F, 6.0F, 0.0F));

        ModelPartData left_pants = modelPartData.addChild("left_pants", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData right_pants = modelPartData.addChild("right_pants", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData cloak = modelPartData.addChild("cloak", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData left_arm = modelPartData.addChild("left_arm", ModelPartBuilder.create(), ModelTransform.pivot(4.0F, 8.0F, 0.0F));

        ModelPartData cube_r3 = left_arm.addChild("cube_r3", ModelPartBuilder.create().uv(48, 0).cuboid(-4.0F, -7.0F, 1.0F, 4.0F, 10.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, 3.25F, -4.5F, 0.0F, 0.0F, -0.1309F));

        ModelPartData left_sleeve = modelPartData.addChild("left_sleeve", ModelPartBuilder.create(), ModelTransform.pivot(4.0F, 8.0F, 0.0F));

        ModelPartData arm_l_inflated_r1 = left_sleeve.addChild("arm_l_inflated_r1", ModelPartBuilder.create().uv(16, 46).cuboid(-4.0F, -7.0F, 1.0F, 4.0F, 10.0F, 4.0F, new Dilation(0.2F)), ModelTransform.of(4.0F, 3.25F, -4.5F, 0.0F, 0.0F, -0.1309F));
        return TexturedModelData.of(modelData, 64, 64);
    }

    @Override
    protected void animateArms(DemonGuardianEntity entity, float animationProgress) {
        if (this.handSwingProgress > 0.0f) {
            CrossbowPosing.meleeAttack(this.rightArm, this.leftArm, entity, this.handSwingProgress, animationProgress);
            return;
        }

        super.animateArms(entity, animationProgress);
    }

    // TODO: Animate the body-remains segment
    @Override
    public void setAngles(DemonGuardianEntity livingEntity, float f, float g, float h, float i, float j) {
        super.setAngles(livingEntity, f, g, h, i, j);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        matrices.push();
        root.render(matrices, vertices, light, overlay, red, green, blue, alpha);
        matrices.pop();
    }
}
