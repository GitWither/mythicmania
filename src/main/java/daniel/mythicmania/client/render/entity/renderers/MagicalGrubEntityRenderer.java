package daniel.mythicmania.client.render.entity.renderers;

import daniel.mythicmania.MythicMania;
import daniel.mythicmania.client.render.entity.model.MagicalGrubEntityModel;
import daniel.mythicmania.entity.MagicalGrubEntity;
import daniel.mythicmania.entity.MythicManiaEntityTypes;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class MagicalGrubEntityRenderer extends MobEntityRenderer<MagicalGrubEntity, MagicalGrubEntityModel> {
    public MagicalGrubEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new MagicalGrubEntityModel(context.getPart(MythicManiaEntityTypes.MAGICAL_GRUB_LAYER)), 0.5f);
    }

    @Override
    public Identifier getTexture(MagicalGrubEntity entity) {
        return new Identifier(MythicMania.MOD_ID, "textures/entity/grubs/magical.png");
    }
}