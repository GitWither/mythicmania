package daniel.mythicmania.client.render.entity.model;

import daniel.mythicmania.entity.mob.NoxiousSpiritEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class NoxiousSpiritEntityModel extends EntityModel<NoxiousSpiritEntity> {
    private final ModelPart root;
    private final ModelPart main;
    private final ModelPart leftWing;
    private final ModelPart leftWingSeg1;
    private final ModelPart leftWingSeg2;
    private final ModelPart rightWing;
    private final ModelPart rightWingSeg1;
    private final ModelPart rightWingSeg2;
    private final ModelPart particles;

    public NoxiousSpiritEntityModel(ModelPart part) {
        root = part;
        main = root.getChild("boss");

        leftWing = main.getChild("left_wing");
        leftWingSeg1 = leftWing.getChild("left_wing_1");
        leftWingSeg2 = leftWingSeg1.getChild("left_wing_2");

        rightWing = main.getChild("left_wing");
        rightWingSeg1 = rightWing.getChild("left_wing_1");
        rightWingSeg2 = rightWingSeg1.getChild("left_wing_2");

        particles = main.getChild("particles");
    }

    // Entity model
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData boss = modelPartData.addChild("boss", ModelPartBuilder.create().uv(0, 16).cuboid(-5.0F, 0.0F, -1.0F, 6.0F, 6.0F, 6.0F, new Dilation(0.3F))
                .uv(23, 0).cuboid(-5.0F, 0.0F, -1.0F, 6.0F, 6.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(2.5F, 1.0F, -2.5F));

        ModelPartData left_wing = boss.addChild("left_wing", ModelPartBuilder.create(), ModelTransform.of(3.8516F, 2.0128F, 0.6313F, -0.0873F, 0.0F, 0.0F));

        ModelPartData cube_r1 = left_wing.addChild("cube_r1", ModelPartBuilder.create().uv(0, 29).cuboid(-1.87F, -4.4877F, -1.5872F, 4.0F, 7.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, 0.9962F, 0.0872F, 0.0F, 0.0F, -0.1309F));

        ModelPartData left_wing_1 = left_wing.addChild("left_wing_1", ModelPartBuilder.create(), ModelTransform.pivot(0.9601F, -7.3707F, 0.4861F));

        ModelPartData cube_r2 = left_wing_1.addChild("cube_r2", ModelPartBuilder.create().uv(25, 13).cuboid(-10.12F, -6.5123F, 0.0872F, 10.0F, 15.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(11.1413F, 7.0941F, 0.0882F, 3.1416F, 0.0F, -0.1309F));

        ModelPartData left_wing_2 = left_wing_1.addChild("left_wing_2", ModelPartBuilder.create().uv(0, 0).cuboid(-0.0052F, -8.293F, 0.087F, 11.0F, 15.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(10.7913F, 5.3441F, 0.0882F, 3.1416F, -0.0436F, -0.1309F));

        ModelPartData right_wing = boss.addChild("right_wing", ModelPartBuilder.create(), ModelTransform.of(-8.3516F, 2.0128F, 0.6313F, -0.0873F, 0.0F, 0.0F));

        ModelPartData cube_r3 = right_wing.addChild("cube_r3", ModelPartBuilder.create().uv(0, 29).mirrored().cuboid(-2.13F, -4.4877F, -1.5872F, 4.0F, 7.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-2.0F, 0.9962F, 0.0872F, 0.0F, 0.0F, 0.1309F));

        ModelPartData right_wing_1 = right_wing.addChild("right_wing_1", ModelPartBuilder.create(), ModelTransform.pivot(-0.9601F, -7.3707F, 0.4861F));

        ModelPartData cube_r4 = right_wing_1.addChild("cube_r4", ModelPartBuilder.create().uv(25, 13).mirrored().cuboid(0.12F, -6.5123F, 0.0872F, 10.0F, 15.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-11.1413F, 7.0941F, 0.0882F, 3.1416F, 0.0F, 0.1309F));

        ModelPartData right_wing_2 = right_wing_1.addChild("right_wing_2", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-10.9948F, -8.293F, 0.087F, 11.0F, 15.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-10.7913F, 5.3441F, 0.0882F, 3.1416F, 0.0436F, 0.1309F));

        ModelPartData particles = boss.addChild("particles", ModelPartBuilder.create(), ModelTransform.pivot(-2.0625F, 9.908F, 2.0F));

        ModelPartData cube_r5 = particles.addChild("cube_r5", ModelPartBuilder.create().uv(32, 29).mirrored().cuboid(-1.5F, -1.0F, -1.5F, 5.0F, 2.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(3.8125F, 0.342F, 0.0F, 0.0F, 0.0F, -0.3491F));

        ModelPartData cube_r6 = particles.addChild("cube_r6", ModelPartBuilder.create().uv(32, 29).cuboid(-3.5F, -1.0F, -1.5F, 5.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-3.9375F, 0.342F, 0.0F, 0.0F, 0.0F, 0.3491F));

        ModelPartData cube_r7 = particles.addChild("cube_r7", ModelPartBuilder.create().uv(15, 29).cuboid(-1.5F, -1.0F, -3.5F, 3.0F, 2.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0625F, 0.342F, 3.5F, -2.7925F, 0.0F, 0.0F));

        ModelPartData cube_r8 = particles.addChild("cube_r8", ModelPartBuilder.create().uv(15, 29).cuboid(-1.5F, -1.0F, -3.5F, 3.0F, 2.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0625F, 0.342F, -3.5F, -0.3491F, 0.0F, 0.0F));

        return TexturedModelData.of(modelData, 64, 64);
    }

    @Override
    public void setAngles(NoxiousSpiritEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        particles.yaw = -(animationProgress * 0.3f);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        matrices.push();
        matrices.translate(0, -1, 0);
        matrices.scale(2f, 2f, 2f);
        main.render(matrices, vertices, light, overlay, red, green, blue, alpha);
        matrices.pop();
    }
}
