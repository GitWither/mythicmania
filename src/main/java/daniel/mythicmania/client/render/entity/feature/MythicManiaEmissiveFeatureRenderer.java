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
public class MythicManiaEmissiveFeatureRenderer<T extends Entity, M extends EntityModel<T>> extends EyesFeatureRenderer<T, M> {
    private final Identifier emissiveTexture;

    public MythicManiaEmissiveFeatureRenderer(FeatureRendererContext<T, M> featureRendererContext, Identifier emissiveTexture) {
        super(featureRendererContext);
        this.emissiveTexture = emissiveTexture;
    }

    public RenderLayer getEyesTexture() {
        return RenderLayer.getEyes(emissiveTexture);
    }
}