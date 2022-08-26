package daniel.mythicmania.entity;

import daniel.mythicmania.MythicMania;
import daniel.mythicmania.client.render.entity.grub.MagicalGrubEntityRenderer;
import daniel.mythicmania.client.render.entity.grub.PoisonousGrubEntityRenderer;
import daniel.mythicmania.client.render.entity.WastedDemonEntityRenderer;
import daniel.mythicmania.client.render.entity.ZappingBeetleEntityRenderer;
import daniel.mythicmania.client.render.entity.model.MagicalGrubEntityModel;
import daniel.mythicmania.client.render.entity.model.PoisonousGrubEntityModel;
import daniel.mythicmania.client.render.entity.model.WastedDemonEntityModel;
import daniel.mythicmania.client.render.entity.model.ZappingBeetleEntityModel;
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

    public static final EntityModelLayer ZAPPING_BEETLE_LAYER = new EntityModelLayer(new Identifier(MythicMania.MOD_ID, "zapping_beetle"), "root");
    public static final EntityType<ZappingBeetleEntity> ZAPPING_BEETLE_ENTITY = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier(MythicMania.MOD_ID, "zapping_beetle"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, ZappingBeetleEntity::new).dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build()
    );

    public static final EntityModelLayer WASTED_DEMON_LAYER = new EntityModelLayer(new Identifier(MythicMania.MOD_ID, "wasted_demon"), "root");
    public static final EntityType<WastedDemonEntity> WASTED_DEMON_ENTITY = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier(MythicMania.MOD_ID),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, WastedDemonEntity::new).dimensions(EntityDimensions.fixed(1.25f, 1.25f)).build()
    );

    public static void registerEntityAttributes() {
        FabricDefaultAttributeRegistry.register(MythicManiaEntityTypes.MAGICAL_GRUB_ENTITY, MagicalGrubEntity.createMagicalGrubAttributes());
        FabricDefaultAttributeRegistry.register(MythicManiaEntityTypes.POISONOUS_GRUB_ENTITY, PoisonousGrubEntity.createPoisonousGrubAttributes());
        FabricDefaultAttributeRegistry.register(MythicManiaEntityTypes.ZAPPING_BEETLE_ENTITY, ZappingBeetleEntity.createZappingBeetleAttributes());
        FabricDefaultAttributeRegistry.register(MythicManiaEntityTypes.WASTED_DEMON_ENTITY, WastedDemonEntity.createWastedDemonAttributes());
    }

    public static void registerEntityRendering() {
        // magical grub
        EntityRendererRegistry.register(MythicManiaEntityTypes.MAGICAL_GRUB_ENTITY, MagicalGrubEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MAGICAL_GRUB_LAYER, MagicalGrubEntityModel::getTexturedModelData);

        // poison grub
        EntityRendererRegistry.register(MythicManiaEntityTypes.POISONOUS_GRUB_ENTITY, PoisonousGrubEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(POISONOUS_GRUB_LAYER, PoisonousGrubEntityModel::getTexturedModelData);

        // zapping beetle
        EntityRendererRegistry.register(MythicManiaEntityTypes.ZAPPING_BEETLE_ENTITY, ZappingBeetleEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ZAPPING_BEETLE_LAYER, ZappingBeetleEntityModel::getTexturedModelData);

        // wasted demon
        EntityRendererRegistry.register(MythicManiaEntityTypes.WASTED_DEMON_ENTITY, WastedDemonEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(WASTED_DEMON_LAYER, WastedDemonEntityModel::getTexturedModelData);
    }
}
