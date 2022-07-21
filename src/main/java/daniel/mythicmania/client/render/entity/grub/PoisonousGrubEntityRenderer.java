package daniel.mythicmania.client.render.entity.grub;

import daniel.mythicmania.MythicMania;
import daniel.mythicmania.MythicManiaClient;
import daniel.mythicmania.client.render.entity.model.PoisonousGrubEntityModel;
import daniel.mythicmania.entity.AbstractGrubEntity;
import daniel.mythicmania.entity.PoisonousGrubEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class PoisonousGrubEntityRenderer extends MobEntityRenderer<PoisonousGrubEntity, PoisonousGrubEntityModel> {
    public PoisonousGrubEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new PoisonousGrubEntityModel(context.getPart(MythicManiaClient.POISONOUS_GRUB_LAYER)), 0.5f);
    }

    @Override
    public Identifier getTexture(PoisonousGrubEntity entity) {
        return new Identifier(MythicMania.MOD_ID, "textures/entity/grubs/poisonous.png");
    }
}
