package daniel.mythicmania.client.render.entity.renderers;

import daniel.mythicmania.MythicMania;
import daniel.mythicmania.client.render.entity.model.OrbiterEntityModel;
import daniel.mythicmania.client.render.entity.model.ToxicOrbiterEntityModel;
import daniel.mythicmania.entity.MythicManiaEntityTypes;
import daniel.mythicmania.entity.mob.OrbiterEntity;
import daniel.mythicmania.entity.mob.ToxicOrbiterEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;

public class ToxicOrbiterEntityRenderer extends MobEntityRenderer<ToxicOrbiterEntity, ToxicOrbiterEntityModel<Entity>> {
	public ToxicOrbiterEntityRenderer(EntityRendererFactory.Context context) {
		super(context, new ToxicOrbiterEntityModel<>(context.getPart(MythicManiaEntityTypes.TOXIC_ORBITER_LAYER)), 0.5f);
	}

	@Override
	public Identifier getTexture(ToxicOrbiterEntity entity) {
		return new Identifier(MythicMania.MOD_ID, "textures/entity/orbiter/orbiter_toxic.png");
	}
}
