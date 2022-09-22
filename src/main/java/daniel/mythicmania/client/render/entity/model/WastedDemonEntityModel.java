package daniel.mythicmania.client.render.entity.model;

import daniel.mythicmania.entity.WastedDemonEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.CrossbowPosing;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

public class WastedDemonEntityModel<T extends Entity> extends PlayerEntityModel<WastedDemonEntity> {


    public WastedDemonEntityModel(ModelPart part) {
       super(part, false);
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData head = modelPartData.addChild("head", ModelPartBuilder.create().uv(0, 20).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -2.75F, 0.0F));

        ModelPartData horns = head.addChild("horns", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 26.75F, 0.0F));

        ModelPartData horn1 = horns.addChild("horn1", ModelPartBuilder.create().uv(42, 38).mirrored().cuboid(-2.5F, -10.75F, 0.0F, 5.0F, 11.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(2.5F, -35.0F, 0.0F));

        ModelPartData horn2 = horns.addChild("horn2", ModelPartBuilder.create().uv(42, 38).cuboid(-3.0F, -10.5F, 0.0F, 5.0F, 11.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, -35.25F, 0.0F));

        ModelPartData hat = modelPartData.addChild("hat", ModelPartBuilder.create().uv(63, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.5F)), ModelTransform.pivot(0.0F, -2.75F, 0.0F));

        ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -0.25F, -3.0F, 8.0F, 14.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -2.75F, 0.0F));

        ModelPartData right_arm = modelPartData.addChild("right_arm", ModelPartBuilder.create().uv(32, 19).mirrored().cuboid(-3.0F, -1.5F, -1.7F, 4.0F, 15.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(7.0F, -1.0F, 0.0F));

        ModelPartData left_arm = modelPartData.addChild("left_arm", ModelPartBuilder.create().uv(32, 19).cuboid(-1.0F, -1.5F, -1.7F, 4.0F, 15.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-7.0F, -1.0F, 0.0F));

        ModelPartData right_leg = modelPartData.addChild("right_leg", ModelPartBuilder.create().uv(16, 36).mirrored().cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 13.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(2.0F, 11.0F, 0.0F));

        ModelPartData left_leg = modelPartData.addChild("left_leg", ModelPartBuilder.create().uv(16, 36).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 13.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, 11.0F, 0.0F));

        ModelPartData ear = modelPartData.addChild("ear", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData right_sleeve = modelPartData.addChild("right_sleeve", ModelPartBuilder.create().uv(0, 64).cuboid(-3.0F, -1.5F, -1.7F, 4.0F, 15.0F, 4.0F, new Dilation(0.5F)), ModelTransform.pivot(7.0F, -1.0F, 0.0F));

        ModelPartData left_sleeve = modelPartData.addChild("left_sleeve", ModelPartBuilder.create().uv(0, 64).mirrored().cuboid(-1.0F, -1.5F, -1.7F, 4.0F, 15.0F, 4.0F, new Dilation(0.5F)).mirrored(false), ModelTransform.pivot(-7.0F, -1.0F, 0.0F));

        ModelPartData jacket = modelPartData.addChild("jacket", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData left_pants = modelPartData.addChild("left_pants", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData right_pants = modelPartData.addChild("right_pants", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData cloak = modelPartData.addChild("cloak", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -2.0F, 2.0F));
        return TexturedModelData.of(modelData, 128, 128);
    }
    @Override
    public void setAngles(WastedDemonEntity entity, float f, float g, float h, float i, float j) {
        super.setAngles(entity, f, g, h, i, j);
    }

    @Override
    protected void animateArms(WastedDemonEntity entity, float animationProgress) {
        if (this.handSwingProgress > 0.0f) {
            CrossbowPosing.meleeAttack(this.rightArm, this.leftArm, entity, this.handSwingProgress, animationProgress);
            return;
        }
        super.animateArms(entity, animationProgress);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        super.render(matrices, vertices, light, overlay, red, green, blue, alpha);
        //this.renderCape(matrices, vertices, light, overlay);
    }
}
