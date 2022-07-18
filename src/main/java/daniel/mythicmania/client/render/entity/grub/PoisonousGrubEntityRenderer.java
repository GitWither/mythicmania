package daniel.mythicmania.client.render.entity.grub;

import daniel.mythicmania.MythicMania;
import daniel.mythicmania.MythicManiaClient;
import daniel.mythicmania.client.render.entity.grub.AbstractGrubEntityRenderer;
import daniel.mythicmania.client.render.entity.model.GrubEntityModel;
import daniel.mythicmania.entity.AbstractGrubEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;

public class PoisonousGrubEntityRenderer extends AbstractGrubEntityRenderer {
    public PoisonousGrubEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new GrubEntityModel(context.getPart(MythicManiaClient.POISONOUS_GRUB_LAYER)), 0.5f);
    }

    @Override
    public Identifier getTexture(AbstractGrubEntity entity) {
        return new Identifier(MythicMania.MOD_ID, "textures/entity/grubs/poisonous.png");
    }
}
