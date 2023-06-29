package daniel.mythicmania.client.render.entity.model;

import daniel.mythicmania.entity.mob.OrbiterEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

public class OrbiterEntityModel<T extends Entity> extends EntityModel<OrbiterEntity> {
    private final ModelPart root;
    private final ModelPart main;
    private final ModelPart segment1;
    private final ModelPart segment2;
    private final ModelPart head;

    public OrbiterEntityModel(ModelPart part) {
        root = part;
        main = root.getChild("orbiter");
        head = main.getChild("head");
        segment1 = main.getChild("segment1");
        segment2 = main.getChild("segment2");
    }

    // Defines the geometry
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData orbiter = modelPartData.addChild("orbiter", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 19.0F, 0.0F));

        ModelPartData head = orbiter.addChild("head", ModelPartBuilder.create().uv(0, 14).cuboid(-3.54F, -16.52F, -3.54F, 7.0F, 7.0F, 7.0F, new Dilation(0.0F))
                .uv(0, 30).cuboid(-3.96F, -16.94F, -3.96F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData segment1 = orbiter.addChild("segment1", ModelPartBuilder.create().uv(24, 10).cuboid(-2.36F, -3.54F, -2.36F, 4.0F, 7.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -3.54F, 0.0F));

        ModelPartData segment2 = orbiter.addChild("segment2", ModelPartBuilder.create().uv(21, 0).cuboid(-1.18F, -1.18F, -1.18F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 3.54F, 0.0F));

        return TexturedModelData.of(modelData, 64, 64);
    }

    @Override
    public void setAngles(OrbiterEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        segment1.yaw = animationProgress * 0.4f;
        segment2.yaw = -(animationProgress * 0.4f);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        matrices.push();
        root.render(matrices, vertices, light, overlay, red, green, blue, alpha);
        matrices.pop();
    }
}
