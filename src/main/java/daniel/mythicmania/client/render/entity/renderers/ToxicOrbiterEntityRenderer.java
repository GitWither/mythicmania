package daniel.mythicmania.client.render.entity.renderers;

import daniel.mythicmania.MythicMania;
import daniel.mythicmania.client.render.entity.feature.MythicManiaEmissiveFeatureRenderer;
import daniel.mythicmania.client.render.entity.model.ToxicOrbiterEntityModel;
import daniel.mythicmania.entity.MythicManiaEntityTypes;
import daniel.mythicmania.entity.mob.ToxicOrbiterEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;

public class ToxicOrbiterEntityRenderer extends MobEntityRenderer<ToxicOrbiterEntity, ToxicOrbiterEntityModel<Entity>> {
	private static final Identifier EMISSIVE_TEXTURE = new Identifier("mythicmania:textures/entity/orbiter/toxic_orbiter_e.png");

	public ToxicOrbiterEntityRenderer(EntityRendererFactory.Context context) {
		super(context, new ToxicOrbiterEntityModel<>(context.getPart(MythicManiaEntityTypes.TOXIC_ORBITER_LAYER)), 0.5f);
		this.addFeature(new MythicManiaEmissiveFeatureRenderer<>(this, EMISSIVE_TEXTURE));
	}

	@Override
	public Identifier getTexture(ToxicOrbiterEntity entity) {
		return new Identifier(MythicMania.MOD_ID, "textures/entity/orbiter/orbiter_toxic.png");
	}

	@Override
	protected void scale(ToxicOrbiterEntity entity, MatrixStack matrices, float amount) {
		matrices.scale(1.2f, 1.2f, 1.2f);
	}
}
