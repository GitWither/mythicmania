package daniel.mythicmania.entity;

import daniel.mythicmania.MythicMania;
import daniel.mythicmania.client.render.entity.renderers.*;
import daniel.mythicmania.client.render.entity.model.*;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
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
            new Identifier(MythicMania.MOD_ID, "wasted_demon"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, WastedDemonEntity::new).fireImmune().dimensions(EntityDimensions.fixed(1.25f, 2f)).build()
    );

    public static final EntityModelLayer DEMON_GUARDIAN_LAYER = new EntityModelLayer(new Identifier(MythicMania.MOD_ID, "demon_guardian"), "root");
    public static final EntityType<DemonGuardianEntity> DEMON_GUARDIAN_ENTITY = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier(MythicMania.MOD_ID, "demon_guardian"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, DemonGuardianEntity::new).fireImmune().dimensions(EntityDimensions.fixed(1.25f, 2f)).build()
    );

    public static final EntityType<WaterParcelEntity> WATER_PARCEL_ENTITY = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier(MythicMania.MOD_ID, "water_parcel"),
            FabricEntityTypeBuilder.<WaterParcelEntity>create(SpawnGroup.MISC, WaterParcelEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(8).trackedUpdateRate(10)
                    .build()
    );

    public static final EntityType<WastedStaffChargeEntity> WASTED_STAFF_CHARGE_ENTITY = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier(MythicMania.MOD_ID, "wasted_staff_charge"),
            FabricEntityTypeBuilder.<WastedStaffChargeEntity>create(SpawnGroup.MISC, WastedStaffChargeEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(30).trackedUpdateRate(30)
                    .build());
                    
                 
    public static final EntityModelLayer ORBITER_LAYER = new EntityModelLayer(new Identifier(MythicMania.MOD_ID, "orbiter"), "root");
    public static final EntityType<OrbiterEntity> ORBITER_ENTITY = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier(MythicMania.MOD_ID, "orbiter"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, OrbiterEntity::new).fireImmune().dimensions(EntityDimensions.fixed(1.25f, 2f)).build()
    );

    public static void registerEntityAttributes() {
        FabricDefaultAttributeRegistry.register(MythicManiaEntityTypes.MAGICAL_GRUB_ENTITY, MagicalGrubEntity.createMagicalGrubAttributes());
        FabricDefaultAttributeRegistry.register(MythicManiaEntityTypes.POISONOUS_GRUB_ENTITY, PoisonousGrubEntity.createPoisonousGrubAttributes());
        FabricDefaultAttributeRegistry.register(MythicManiaEntityTypes.ZAPPING_BEETLE_ENTITY, ZappingBeetleEntity.createZappingBeetleAttributes());
        FabricDefaultAttributeRegistry.register(MythicManiaEntityTypes.WASTED_DEMON_ENTITY, WastedDemonEntity.createWastedDemonAttributes());
        FabricDefaultAttributeRegistry.register(MythicManiaEntityTypes.DEMON_GUARDIAN_ENTITY, DemonGuardianEntity.createDemonGuardianAttributes());
        FabricDefaultAttributeRegistry.register(MythicManiaEntityTypes.ORBITER_ENTITY, OrbiterEntity.createOrbiterAttributes());
    }

    public static void registerEntityRendering() {
        // Register entity type rendering
        EntityRendererRegistry.register(MythicManiaEntityTypes.MAGICAL_GRUB_ENTITY, MagicalGrubEntityRenderer::new);
        EntityRendererRegistry.register(MythicManiaEntityTypes.POISONOUS_GRUB_ENTITY, PoisonousGrubEntityRenderer::new);
        EntityRendererRegistry.register(MythicManiaEntityTypes.ZAPPING_BEETLE_ENTITY, ZappingBeetleEntityRenderer::new);
        EntityRendererRegistry.register(MythicManiaEntityTypes.WASTED_DEMON_ENTITY, WastedDemonEntityRenderer::new);
        EntityRendererRegistry.register(MythicManiaEntityTypes.DEMON_GUARDIAN_ENTITY, DemonGuardianEntityRenderer::new);
        EntityRendererRegistry.register(MythicManiaEntityTypes.WATER_PARCEL_ENTITY, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(MythicManiaEntityTypes.WASTED_STAFF_CHARGE_ENTITY, FlyingItemEntityRenderer::new);

        // Register layers
        EntityModelLayerRegistry.registerModelLayer(MAGICAL_GRUB_LAYER, MagicalGrubEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(POISONOUS_GRUB_LAYER, PoisonousGrubEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ZAPPING_BEETLE_LAYER, ZappingBeetleEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(WASTED_DEMON_LAYER, WastedDemonEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(DEMON_GUARDIAN_LAYER, DemonGuardianEntityModel::getTexturedModelData);

        // Orbiter
        EntityRendererRegistry.register(MythicManiaEntityTypes.ORBITER_ENTITY, OrbiterEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ORBITER_LAYER, OrbiterEntityModel::getTexturedModelData);
    }
}
