package daniel.mythicmania.client.render.entity.model;

import daniel.mythicmania.entity.mob.OrbiterEntity;
import daniel.mythicmania.entity.mob.ToxicOrbiterEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ToxicOrbiterEntityModel<T extends Entity> extends EntityModel<ToxicOrbiterEntity> {
	private final ModelPart root;
	private final ModelPart main;
	private final ModelPart core;
	private final ModelPart primaryFragments;
	private final ModelPart secondaryFragments;

	public ToxicOrbiterEntityModel(ModelPart part) {
		root = part;
		main = root.getChild("toxic_orbiter");
		core = main.getChild("core");
		primaryFragments = main.getChild("main_fragments");
		secondaryFragments = main.getChild("secondary_fragments");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData toxic_orbiter = modelPartData.addChild("toxic_orbiter", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData core = toxic_orbiter.addChild("core", ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F, new Dilation(0.1F))
			.uv(0, 12).cuboid(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -14.0F, 0.0F));

		ModelPartData main_fragments = toxic_orbiter.addChild("main_fragments", ModelPartBuilder.create().uv(22, 22).cuboid(6.0F, -2.5F, -1.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F))
			.uv(22, 22).mirrored().cuboid(-8.0F, -2.5F, -1.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
			.uv(22, 22).cuboid(-1.0F, -2.5F, -8.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F))
			.uv(22, 22).mirrored().cuboid(-1.0F, -2.5F, 6.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, -9.5F, 0.0F));

		ModelPartData secondary_fragments = toxic_orbiter.addChild("secondary_fragments", ModelPartBuilder.create().uv(22, 10).cuboid(-1.0F, -3.0F, -1.0F, 2.0F, 6.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -5.0F, 0.0F));
		return TexturedModelData.of(modelData, 32, 32);
	}

	@Override
	public void setAngles(ToxicOrbiterEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		primaryFragments.yaw = animationProgress * 0.4f;
		secondaryFragments.yaw = -(animationProgress * 0.4f);
		main.pivotY = MathHelper.sin(animationProgress * 0.1f) * 4;
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
		root.render(matrices, vertices, light, overlay, red, green, blue, alpha);
		matrices.push();
		matrices.pop();
	}
}
