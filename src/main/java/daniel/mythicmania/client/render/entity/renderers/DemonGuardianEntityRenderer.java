package daniel.mythicmania.client.render.entity.renderers;

import daniel.mythicmania.MythicMania;
import daniel.mythicmania.client.render.entity.model.DemonGuardianEntityModel;
import daniel.mythicmania.entity.mob.DemonGuardianEntity;
import daniel.mythicmania.entity.MythicManiaEntityTypes;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;

public class DemonGuardianEntityRenderer extends BipedEntityRenderer<DemonGuardianEntity, DemonGuardianEntityModel> {
    public DemonGuardianEntityRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new DemonGuardianEntityModel(ctx.getPart(MythicManiaEntityTypes.DEMON_GUARDIAN_LAYER), false), 0.5f);
    }

    @Override
    public Identifier getTexture(DemonGuardianEntity entity) {
        return new Identifier(MythicMania.MOD_ID, "textures/entity/demon_guardian/demon_guardian.png");
    }
}
