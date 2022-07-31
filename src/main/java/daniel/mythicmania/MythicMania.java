package daniel.mythicmania;

import daniel.mythicmania.block.HarvesterBlock;
import daniel.mythicmania.block.RinthBlock;
import daniel.mythicmania.entity.AbstractGrubEntity;
import daniel.mythicmania.entity.MagicalGrubEntity;
import daniel.mythicmania.entity.PoisonousGrubEntity;
import daniel.mythicmania.item.FoodComponents;
import daniel.mythicmania.item.OrbItem;
import daniel.mythicmania.item.PoisonSpikeItem;
import daniel.mythicmania.item.SweetenedBerryItem;
import daniel.mythicmania.item.material.IntoxicatedToolMaterial;
import daniel.mythicmania.util.wrapper.CustomAxeItem;
import daniel.mythicmania.util.wrapper.CustomHoeItem;
import daniel.mythicmania.util.wrapper.CustomPickaxeItem;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MythicMania implements ModInitializer {

    public static final String MOD_ID = "mythicmania";

    public static final ItemGroup MYTHICMANIA_ITEM_GROUP = FabricItemGroupBuilder.build(new Identifier(MOD_ID, MOD_ID), () -> new ItemStack(Items.BEDROCK));

    //=============== ENTITIES ===============
    public static final EntityType<MagicalGrubEntity> MAGICAL_GRUB_ENTITY = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier(MOD_ID, "magical_grub"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MagicalGrubEntity::new).dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build()
    );

    public static final EntityType<PoisonousGrubEntity> POISONOUS_GRUB_ENTITY = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier(MOD_ID, "poisonous_grub"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, PoisonousGrubEntity::new).dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build()
    );

    //=============== BLOCKS ===============
    public static final Block RINTH_BLOCK = Registry.register(
            Registry.BLOCK,
            new Identifier(MOD_ID, "rinth"),
            new RinthBlock()
    );

    public static final Block HARVESTER_BLOCK = Registry.register(
            Registry.BLOCK,
            new Identifier(MOD_ID, "harvester"),
            new HarvesterBlock()
    );

    //=============== ITEMS ===============
    public static final Item POISONOUS_BERRY = Registry.register(
            Registry.ITEM,
            new Identifier(MOD_ID, "poisonous_berry"),
            new AliasedBlockItem(HARVESTER_BLOCK, new Item.Settings().food(FoodComponents.POISONOUS_BERRY).group(MYTHICMANIA_ITEM_GROUP))
    );

    public static final Item SWEETENED_BERRY = Registry.register(
            Registry.ITEM,
            new Identifier(MOD_ID, "sweetened_berry"),
            new SweetenedBerryItem()
    );

    public static final Item EMPTY_ORB = Registry.register(
            Registry.ITEM,
            new Identifier(MOD_ID, "empty_orb"),
            new OrbItem(false)
    );

    public static final Item CHARGED_INTOXICATED_ORB = Registry.register(
            Registry.ITEM,
            new Identifier(MOD_ID, "charged_intoxicated_orb"),
            new OrbItem(true)
    );

    public static final Item CHARGED_LOCH_ORB = Registry.register(
            Registry.ITEM,
            new Identifier(MOD_ID, "charged_loch_orb"),
            new OrbItem(true)
    );

    public static final Item CHARGED_RUINOUS_ORB = Registry.register(
            Registry.ITEM,
            new Identifier(MOD_ID, "charged_ruinous_orb"),
            new OrbItem(true)
    );
    
    public static final Item POISON_SPIKE = Registry.register(
            Registry.ITEM,
            new Identifier(MOD_ID, "poison_spike"),
            new PoisonSpikeItem()
    );

    public static final Item INTOXICATED_SWORD = Registry.register(
            Registry.ITEM,
            new Identifier(MOD_ID, "intoxicated_sword"),
            new SwordItem(IntoxicatedToolMaterial.INSTANCE, 8, -2.4f, new Item.Settings().group(MYTHICMANIA_ITEM_GROUP))
    );

    public static final Item INTOXICATED_PICKAXE = Registry.register(
            Registry.ITEM,
            new Identifier(MOD_ID, "intoxicated_pickaxe"),
            new CustomPickaxeItem(IntoxicatedToolMaterial.INSTANCE, 5, 2, new Item.Settings().group(MYTHICMANIA_ITEM_GROUP))
    );

    public static final Item INTOXICATED_AXE = Registry.register(
            Registry.ITEM,
            new Identifier(MOD_ID, "intoxicated_axe"),
            new CustomAxeItem(IntoxicatedToolMaterial.INSTANCE, 5, 2, new Item.Settings().group(MYTHICMANIA_ITEM_GROUP))
    );

    public static final Item INTOXICATED_HOE = Registry.register(
            Registry.ITEM,
            new Identifier(MOD_ID, "intoxicated_hoe"),
            new CustomHoeItem(IntoxicatedToolMaterial.INSTANCE, 5, 2, new Item.Settings().group(MYTHICMANIA_ITEM_GROUP))
    );

    public static final Item INTOXICATED_SHOVEL = Registry.register(
            Registry.ITEM,
            new Identifier(MOD_ID, "intoxicated_shovel"),
            new ShovelItem(IntoxicatedToolMaterial.INSTANCE, 5, 2, new Item.Settings().group(MYTHICMANIA_ITEM_GROUP))
    );

    @Override
    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "rinth"),
                new BlockItem(RINTH_BLOCK, new Item.Settings().group(MYTHICMANIA_ITEM_GROUP)
        ));

        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "magical_grub_spawn_egg"),
                new SpawnEggItem(MAGICAL_GRUB_ENTITY, 0x7ff8eb, 0x5da1c5, new Item.Settings().group(MYTHICMANIA_ITEM_GROUP)
        ));

        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "poisonous_grub_spawn_egg"),
                new SpawnEggItem(POISONOUS_GRUB_ENTITY, 0x4e9e78, 0x9cf590, new Item.Settings().group(MYTHICMANIA_ITEM_GROUP)
        ));


        FabricDefaultAttributeRegistry.register(MAGICAL_GRUB_ENTITY, MagicalGrubEntity.createMagicalGrubAttributes());
        FabricDefaultAttributeRegistry.register(POISONOUS_GRUB_ENTITY, PoisonousGrubEntity.createPoisonousGrubAttributes());
    }
}
