package daniel.mythicmania.client.render.entity.feature;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.feature.EyesFeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class ToxicOrbiterCoreRenderer<T extends Entity, M extends EntityModel<T>> extends EyesFeatureRenderer<T, M> {
	private static final RenderLayer EYES = RenderLayer.getEyes(new Identifier("mythicmania:textures/entity/orbiter/toxic_orbiter_e.png"));

	public ToxicOrbiterCoreRenderer(FeatureRendererContext<T, M> featureRendererContext) {
		super(featureRendererContext);
	}

	public RenderLayer getEyesTexture() {
		return EYES;
	}
}