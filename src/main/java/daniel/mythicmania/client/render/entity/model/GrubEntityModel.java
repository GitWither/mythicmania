package daniel.mythicmania.client.render.entity.model;

import daniel.mythicmania.entity.AbstractGrubEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class GrubEntityModel extends EntityModel<AbstractGrubEntity> {

    private final ModelPart root;

    public GrubEntityModel(ModelPart part) {
        root = part;
    }

    public static TexturedModelData getMagicalGrubTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData grub = modelPartData.addChild("grub", ModelPartBuilder.create(), ModelTransform.pivot(0.5707F, 23.75F, -0.55F));

        ModelPartData bone = grub.addChild("bone", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0778F, -2.6352F, -1.8444F, 3.0F, 3.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -0.0574F, 0.0F));

        ModelPartData bone2 = grub.addChild("bone2", ModelPartBuilder.create().uv(0, 8).cuboid(-1.5442F, -1.6776F, -5.0632F, 2.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -0.015F, 0.0F));

        ModelPartData bone3 = grub.addChild("bone3", ModelPartBuilder.create().uv(8, 8).cuboid(-1.5972F, -1.6776F, 3.1632F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -0.015F, 0.0F));
        return TexturedModelData.of(modelData, 16, 16);
    }

    public static TexturedModelData getPoisonousGrubTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData grub_poison = modelPartData.addChild("grub_poison", ModelPartBuilder.create(), ModelTransform.pivot(-0.0042F, 24.0F, -0.6275F));

        ModelPartData bodyseg2 = grub_poison.addChild("bodyseg2", ModelPartBuilder.create().uv(0, 16).cuboid(-1.36F, -2.0F, 0.0F, 2.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData bodyseg3 = bodyseg2.addChild("bodyseg3", ModelPartBuilder.create().uv(0, 9).cuboid(-2.2724F, 0.1031F, -0.059F, 4.0F, 3.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-0.0176F, -3.1031F, 2.909F));

        ModelPartData cube_r1 = bodyseg3.addChild("cube_r1", ModelPartBuilder.create().uv(2, 3).cuboid(0.0F, -0.9875F, -0.0125F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 2).cuboid(0.0F, -1.9875F, -1.0125F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.9424F, 0.2406F, 2.6535F, 0.0F, 0.0F, -0.1004F));

        ModelPartData cube_r2 = bodyseg3.addChild("cube_r2", ModelPartBuilder.create().uv(2, 2).cuboid(0.0F, -1.0375F, -0.0125F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(0.0F, -2.0375F, -1.0125F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.8076F, 0.2906F, 1.4035F, 0.0F, 0.0F, 0.2705F));

        ModelPartData tail = bodyseg3.addChild("tail", ModelPartBuilder.create().uv(14, 0).cuboid(-1.31F, -0.86F, 0.11F, 2.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0176F, 1.9631F, 3.821F));

        ModelPartData bodyseg1 = grub_poison.addChild("bodyseg1", ModelPartBuilder.create().uv(0, 0).cuboid(-2.33F, 0.5375F, -1.4375F, 4.0F, 3.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.04F, -3.5375F, -4.5125F));

        ModelPartData cube_r3 = bodyseg1.addChild("cube_r3", ModelPartBuilder.create().uv(0, 4).cuboid(0.0F, -0.3125F, -0.3125F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(2, 0).cuboid(0.0F, -1.3125F, -1.3125F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.625F, 0.0F, 0.0F, 0.1222F));

        ModelPartData head = bodyseg1.addChild("head", ModelPartBuilder.create().uv(12, 12).cuboid(-1.86F, -0.86F, -3.46F, 3.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-0.04F, 2.3975F, -1.1125F));
        return TexturedModelData.of(modelData, 32, 32);
    }


    @Override
    public void setAngles(AbstractGrubEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

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
