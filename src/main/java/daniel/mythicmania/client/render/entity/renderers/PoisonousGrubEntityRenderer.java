package daniel.mythicmania.client.render.entity.renderers;

import daniel.mythicmania.MythicMania;
import daniel.mythicmania.client.render.entity.feature.MythicManiaEmissiveFeatureRenderer;
import daniel.mythicmania.client.render.entity.model.PoisonousGrubEntityModel;
import daniel.mythicmania.entity.MythicManiaEntityTypes;
import daniel.mythicmania.entity.mob.PoisonousGrubEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

public class PoisonousGrubEntityRenderer extends MobEntityRenderer<PoisonousGrubEntity, PoisonousGrubEntityModel> {
    private static final Identifier TEXTURE = new Identifier(MythicMania.MOD_ID, "textures/entity/grubs/poisonous.png");
    private static final Identifier EMISSIVE = new Identifier(MythicMania.MOD_ID, "textures/entity/grubs/poisonous_e.png");

    public PoisonousGrubEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new PoisonousGrubEntityModel(context.getPart(MythicManiaEntityTypes.POISONOUS_GRUB_LAYER)), 0.5f);
        this.addFeature(new MythicManiaEmissiveFeatureRenderer<>(this, EMISSIVE));
    }

    @Override
    public Identifier getTexture(PoisonousGrubEntity entity) {
        return TEXTURE;
    }

    @Nullable
    @Override
    protected RenderLayer getRenderLayer(PoisonousGrubEntity entity, boolean showBody, boolean translucent, boolean showOutline) {
        return super.getRenderLayer(entity, showBody, true, showOutline);
    }
}
