package daniel.mythicmania;

import daniel.mythicmania.block.HarvesterBlock;
import daniel.mythicmania.block.RinthBlock;
import daniel.mythicmania.entity.AbstractGrubEntity;
import daniel.mythicmania.entity.MagicalGrubEntity;
import daniel.mythicmania.entity.PoisonousGrubEntity;
import daniel.mythicmania.item.FoodComponents;
import daniel.mythicmania.item.SweetenedBerryItem;
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
