package daniel.mythicmania.client.render.entity.renderers;

import daniel.mythicmania.MythicMania;
import daniel.mythicmania.client.render.entity.feature.MythicManiaEmissiveFeatureRenderer;
import daniel.mythicmania.client.render.entity.model.NoxiousSpiritEntityModel;
import daniel.mythicmania.entity.MythicManiaEntityTypes;
import daniel.mythicmania.entity.mob.NoxiousSpiritEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class NoxiousSpiritEntityRenderer extends MobEntityRenderer<NoxiousSpiritEntity, NoxiousSpiritEntityModel> {
    private static final Identifier TEXTURE = new Identifier(MythicMania.MOD_ID, "textures/entity/noxious_spirit/noxious_spirit.png");
    private static final Identifier EMISSIVE_TEXTURE = new Identifier("mythicmania:textures/entity/noxious_spirit/noxious_spirit_e.png");

    public NoxiousSpiritEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new NoxiousSpiritEntityModel(context.getPart(MythicManiaEntityTypes.NOXIOUS_SPIRIT_LAYER)), 0.5f);
        this.addFeature(new MythicManiaEmissiveFeatureRenderer<>(this, EMISSIVE_TEXTURE));
    }

    @Override
    public Identifier getTexture(NoxiousSpiritEntity entity) {
        return TEXTURE;
    }
}