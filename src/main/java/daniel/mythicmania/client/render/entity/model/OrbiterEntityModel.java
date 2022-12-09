package daniel.mythicmania.client.render.entity.model;

import daniel.mythicmania.entity.OrbiterEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class OrbiterEntityModel<T extends Entity> extends EntityModel<OrbiterEntity> {
    private final ModelPart root;
    private final ModelPart main;
    private final ModelPart core;
    private final ModelPart big_ring;
    private final ModelPart small_ring;
    private final ModelPart med_ring;

    public OrbiterEntityModel(ModelPart part) {
        root = part;
        main = root.getChild("orbiter");
        core = main.getChild("core");
        big_ring = main.getChild("big_ring");
        small_ring = main.getChild("small_ring");
        med_ring = main.getChild("med_ring");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();

        ModelPartData orbiter = modelPartData.addChild("orbiter", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData core = orbiter.addChild("core", ModelPartBuilder.create()
                .uv(0, 47).cuboid(-3.5F, -3.5F, -3.5F, 7.0F, 7.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(0.5F, -13.5F, -0.5F));

        ModelPartData small_ring = orbiter.addChild("small_ring", ModelPartBuilder.create().uv(48, 15).cuboid(-7.5F, -1.0F, -5.5F, 3.0F, 2.0F, 11.0F, new Dilation(0.0F))
                .uv(48, 28).cuboid(-7.5F, -1.0F, 5.5F, 15.0F, 2.0F, 3.0F, new Dilation(0.0F))
                .uv(17, 51).cuboid(4.5F, -1.0F, -5.5F, 3.0F, 2.0F, 11.0F, new Dilation(0.0F))
                .uv(34, 51).cuboid(-7.5F, -1.0F, -8.5F, 15.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.5F, -3.0F, -0.5F));

        ModelPartData big_ring = orbiter.addChild("big_ring", ModelPartBuilder.create().uv(0, 21).cuboid(-12.5F, -1.0F, -9.5F, 4.0F, 2.0F, 19.0F, new Dilation(0.0F))
                .uv(27, 0).cuboid(-12.5F, -1.0F, 9.5F, 25.0F, 2.0F, 3.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(8.5F, -1.0F, -9.5F, 4.0F, 2.0F, 19.0F, new Dilation(0.0F))
                .uv(27, 5).cuboid(-12.5F, -1.0F, -12.5F, 25.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.5F, -11.0F, -0.5F));

        ModelPartData med_ring = orbiter.addChild("med_ring", ModelPartBuilder.create().uv(27, 10).cuboid(-9.5F, -1.0F, 6.5F, 19.0F, 2.0F, 3.0F, new Dilation(0.0F))
                .uv(33, 36).cuboid(-9.5F, -1.0F, -6.5F, 4.0F, 2.0F, 13.0F, new Dilation(0.0F))
                .uv(0, 42).cuboid(-9.5F, -1.0F, -9.5F, 19.0F, 2.0F, 3.0F, new Dilation(0.0F))
                .uv(27, 21).cuboid(5.5F, -1.0F, -6.5F, 4.0F, 2.0F, 13.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, -7.0F, -0.5F, 0.0F, 0.7854F, 0.0F));

        return TexturedModelData.of(modelData, 128, 128);
    }

    @Override
    public void setAngles(OrbiterEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        big_ring.yaw = animationProgress * 5;
        med_ring.yaw = -(animationProgress * 5);
        small_ring.yaw = animationProgress * 5;
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        root.render(matrices, vertices, light, overlay, red, green, blue, alpha);
        matrices.translate(0, 13, 0);
        matrices.push();
        matrices.pop();
    }
}
