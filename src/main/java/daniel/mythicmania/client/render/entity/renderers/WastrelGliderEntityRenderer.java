package daniel.mythicmania.client.render.entity.renderers;

import daniel.mythicmania.MythicMania;
import daniel.mythicmania.client.render.entity.model.WastrelGliderEntityModel;
import daniel.mythicmania.entity.MythicManiaEntityTypes;
import daniel.mythicmania.entity.mob.WastrelGliderEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class WastrelGliderEntityRenderer extends MobEntityRenderer<WastrelGliderEntity, WastrelGliderEntityModel> {
	private static final Identifier FULL_HEALTH_TEXTURE = new Identifier(MythicMania.MOD_ID, "textures/entity/wastrel_glider/wastrel_glider.png");
	private static final Identifier THREE_HP_TEXTURE = new Identifier(MythicMania.MOD_ID, "textures/entity/wastrel_glider/wastrel_glider_2.png");
	private static final Identifier TWO_HP_TEXTURE = new Identifier(MythicMania.MOD_ID, "textures/entity/wastrel_glider/wastrel_glider_3.png");
	private static final Identifier ONE_HP_TEXTURE = new Identifier(MythicMania.MOD_ID, "textures/entity/wastrel_glider/wastrel_glider_4.png");

	public WastrelGliderEntityRenderer(EntityRendererFactory.Context context) {
		super(context, new WastrelGliderEntityModel(context.getPart(MythicManiaEntityTypes.WASTREL_GLIDER_LAYER)), 0.5f);
	}

	@Override
	public Identifier getTexture(WastrelGliderEntity entity) {
		return switch((int) entity.getHealth()) {
			case 3 -> THREE_HP_TEXTURE;
			case 2 -> TWO_HP_TEXTURE;
			case 1, 0 -> ONE_HP_TEXTURE;
			default -> FULL_HEALTH_TEXTURE;
		};
	}
}