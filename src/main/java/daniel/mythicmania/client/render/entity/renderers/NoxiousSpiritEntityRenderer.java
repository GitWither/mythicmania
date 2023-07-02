package daniel.mythicmania.client.render.entity.renderers;

import daniel.mythicmania.MythicMania;
import daniel.mythicmania.client.render.entity.feature.NoxiousSpiritEmissiveRenderer;
import daniel.mythicmania.client.render.entity.model.NoxiousSpiritEntityModel;
import daniel.mythicmania.entity.MythicManiaEntityTypes;
import daniel.mythicmania.entity.mob.NoxiousSpiritEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class NoxiousSpiritEntityRenderer extends MobEntityRenderer<NoxiousSpiritEntity, NoxiousSpiritEntityModel> {
    protected static final Identifier TEXTURE = new Identifier(MythicMania.MOD_ID, "textures/entity/noxious_spirit/noxious_spirit.png");

    public NoxiousSpiritEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new NoxiousSpiritEntityModel(context.getPart(MythicManiaEntityTypes.NOXIOUS_SPIRIT_LAYER)), 0.5f);
        this.addFeature(new NoxiousSpiritEmissiveRenderer<>(this));
    }

    @Override
    public Identifier getTexture(NoxiousSpiritEntity entity) {
        return TEXTURE;
    }
}