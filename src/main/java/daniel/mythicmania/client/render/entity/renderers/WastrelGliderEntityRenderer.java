package daniel.mythicmania.client.render.entity.renderers;

import daniel.mythicmania.MythicMania;
import daniel.mythicmania.client.render.entity.model.WastedDemonEntityModel;
import daniel.mythicmania.client.render.entity.model.WastrelGliderEntityModel;
import daniel.mythicmania.entity.MythicManiaEntityTypes;
import daniel.mythicmania.entity.WastrelGliderEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;

public class WastrelGliderEntityRenderer extends MobEntityRenderer<WastrelGliderEntity, WastrelGliderEntityModel> {
	public WastrelGliderEntityRenderer(EntityRendererFactory.Context context) {
		super(context, new WastrelGliderEntityModel(context.getPart(MythicManiaEntityTypes.WASTREL_GLIDER_LAYER)), 0.5f);
	}

	@Override
	public Identifier getTexture(WastrelGliderEntity entity) {
		return new Identifier(MythicMania.MOD_ID, "textures/entity/wastrel_glider/wastrel_glider.png");
	}
}