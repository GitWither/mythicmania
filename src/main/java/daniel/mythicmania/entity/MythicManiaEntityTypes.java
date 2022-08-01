package daniel.mythicmania.entity;

import daniel.mythicmania.MythicMania;
import daniel.mythicmania.client.render.entity.grub.MagicalGrubEntityRenderer;
import daniel.mythicmania.client.render.entity.grub.PoisonousGrubEntityRenderer;
import daniel.mythicmania.client.render.entity.model.MagicalGrubEntityModel;
import daniel.mythicmania.client.render.entity.model.PoisonousGrubEntityModel;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public final class MythicManiaEntityTypes {

    public static final EntityModelLayer MAGICAL_GRUB_LAYER = new EntityModelLayer(new Identifier(MythicMania.MOD_ID, "magical_grub"), "root");
    public static final EntityType<MagicalGrubEntity> MAGICAL_GRUB_ENTITY = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier(MythicMania.MOD_ID, "magical_grub"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MagicalGrubEntity::new).dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build()
    );

    public static final EntityModelLayer POISONOUS_GRUB_LAYER = new EntityModelLayer(new Identifier(MythicMania.MOD_ID, "poisonous_grub"), "root");
    public static final EntityType<PoisonousGrubEntity> POISONOUS_GRUB_ENTITY = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier(MythicMania.MOD_ID, "poisonous_grub"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, PoisonousGrubEntity::new).dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build()
    );

    public static void registerEntityAttributes() {
        FabricDefaultAttributeRegistry.register(MythicManiaEntityTypes.MAGICAL_GRUB_ENTITY, MagicalGrubEntity.createMagicalGrubAttributes());
        FabricDefaultAttributeRegistry.register(MythicManiaEntityTypes.POISONOUS_GRUB_ENTITY, PoisonousGrubEntity.createPoisonousGrubAttributes());
    }

    public static void registerEntityRendering() {
        EntityRendererRegistry.register(MythicManiaEntityTypes.MAGICAL_GRUB_ENTITY, MagicalGrubEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MAGICAL_GRUB_LAYER, MagicalGrubEntityModel::getTexturedModelData);

        EntityRendererRegistry.register(MythicManiaEntityTypes.POISONOUS_GRUB_ENTITY, PoisonousGrubEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(POISONOUS_GRUB_LAYER, PoisonousGrubEntityModel::getTexturedModelData);
    }
}