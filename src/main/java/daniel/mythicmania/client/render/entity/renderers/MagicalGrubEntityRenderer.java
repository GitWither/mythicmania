package daniel.mythicmania.client.render.entity.renderers;

import daniel.mythicmania.MythicMania;
import daniel.mythicmania.client.render.entity.feature.MythicManiaEmissiveFeatureRenderer;
import daniel.mythicmania.client.render.entity.model.MagicalGrubEntityModel;
import daniel.mythicmania.entity.mob.MagicalGrubEntity;
import daniel.mythicmania.entity.MythicManiaEntityTypes;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

public class MagicalGrubEntityRenderer extends MobEntityRenderer<MagicalGrubEntity, MagicalGrubEntityModel> {
    private static final Identifier TEXTURE = new Identifier(MythicMania.MOD_ID, "textures/entity/grubs/magical.png");
    private static final Identifier EMISSIVE = new Identifier(MythicMania.MOD_ID, "textures/entity/grubs/magical_e.png");

    public MagicalGrubEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new MagicalGrubEntityModel(context.getPart(MythicManiaEntityTypes.MAGICAL_GRUB_LAYER)), 0.5f);
        this.addFeature(new MythicManiaEmissiveFeatureRenderer<>(this, EMISSIVE));
    }

    @Override
    public Identifier getTexture(MagicalGrubEntity entity) {
        return TEXTURE;
    }

    @Nullable
    @Override
    protected RenderLayer getRenderLayer(MagicalGrubEntity entity, boolean showBody, boolean translucent, boolean showOutline) {
        return super.getRenderLayer(entity, showBody, true, showOutline);
    }
}