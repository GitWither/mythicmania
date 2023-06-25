package daniel.mythicmania.client.render.entity.renderers;

import daniel.mythicmania.MythicMania;
import daniel.mythicmania.client.render.entity.model.ZappingBeetleEntityModel;
import daniel.mythicmania.entity.MythicManiaEntityTypes;
import daniel.mythicmania.entity.mob.ZappingBeetleEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class ZappingBeetleEntityRenderer extends MobEntityRenderer<ZappingBeetleEntity, ZappingBeetleEntityModel> {
    public ZappingBeetleEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new ZappingBeetleEntityModel(context.getPart(MythicManiaEntityTypes.ZAPPING_BEETLE_LAYER)), 0.5f);
    }

    @Override
    public Identifier getTexture(ZappingBeetleEntity entity) {
        return new Identifier(MythicMania.MOD_ID, "textures/entity/beetle/zapping_beetle.png");
    }
}
