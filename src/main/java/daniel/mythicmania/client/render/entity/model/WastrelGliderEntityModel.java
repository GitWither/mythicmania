package daniel.mythicmania.client.render.entity.model;

import daniel.mythicmania.entity.mob.WastrelGliderEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class WastrelGliderEntityModel extends EntityModel<WastrelGliderEntity> {
	private final ModelPart root;
	private final ModelPart main;
	private final ModelPart rightWing;
	private final ModelPart leftWing;

	public WastrelGliderEntityModel(ModelPart part) {
		root = part;
		main = root.getChild("root");
		rightWing = main.getChild("wing_r");
		leftWing = main.getChild("wing_l");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData root = modelPartData.addChild("root", ModelPartBuilder.create(), ModelTransform.pivot(-2.0F, 16.4F, 1.0F));

		ModelPartData wing_l = root.addChild("wing_l", ModelPartBuilder.create(), ModelTransform.pivot(3.0F, 0.0F, 0.0F));

		ModelPartData cube_r1 = wing_l.addChild("cube_r1", ModelPartBuilder.create().uv(0, 8).mirrored().cuboid(0.0F, 0.0F, -4.0F, 6.0F, 0.0F, 8.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.6981F));

		ModelPartData body = root.addChild("body", ModelPartBuilder.create().uv(0, 16).cuboid(-1.5F, -1.25F, -2.0F, 3.0F, 2.5F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(1.5F, -0.15F, 0.0F));

		ModelPartData antenna_l = root.addChild("antenna_l", ModelPartBuilder.create(), ModelTransform.pivot(2.5F, -1.15F, -2.0F));

		ModelPartData cube_r2 = antenna_l.addChild("cube_r2", ModelPartBuilder.create().uv(0, 6).cuboid(-0.7284F, 0.1814F, -5.7255F, 1.0F, 0.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.2066F, -0.3871F, 0.065F));

		ModelPartData antenna_r = root.addChild("antenna_r", ModelPartBuilder.create(), ModelTransform.pivot(0.5F, -1.15F, -2.0F));

		ModelPartData cube_r3 = antenna_r.addChild("cube_r3", ModelPartBuilder.create().uv(0, 0).cuboid(-0.2716F, 0.1814F, -5.7255F, 1.0F, 0.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.2066F, 0.3871F, -0.065F));

		ModelPartData wing_r = root.addChild("wing_r", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r4 = wing_r.addChild("cube_r4", ModelPartBuilder.create().uv(0, 8).cuboid(-6.0F, 0.0F, -4.0F, 6.0F, 0.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.6981F));

		return TexturedModelData.of(modelData, 32, 32);
	}

	@Override
	public void setAngles(WastrelGliderEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		if (entity.getHealth() == 1) {
			rightWing.roll = MathHelper.sin(animationProgress * 0.5f);
			leftWing.roll = -MathHelper.sin(animationProgress * 0.5f);
		} else {
			rightWing.roll = MathHelper.sin(animationProgress);
			leftWing.roll = -MathHelper.sin(animationProgress);
		}
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
		matrices.push();
		root.render(matrices, vertices, light, overlay, red, green, blue, alpha);
		matrices.pop();
	}
}
