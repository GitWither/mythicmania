package daniel.mythicmania.item;

import daniel.mythicmania.MythicMania;
import daniel.mythicmania.block.MythicManiaBlocks;
import daniel.mythicmania.entity.MythicManiaEntityTypes;
import daniel.mythicmania.item.material.armor.IntoxicatedArmorMaterial;
import daniel.mythicmania.item.material.tool.IntoxicatedToolMaterial;
import daniel.mythicmania.util.wrapper.CustomAxeItem;
import daniel.mythicmania.util.wrapper.CustomHoeItem;
import daniel.mythicmania.util.wrapper.CustomPickaxeItem;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public final class MythicManiaItems {
    public static final Item POISONOUS_BERRY = Registry.register(
            Registry.ITEM,
            new Identifier(MythicMania.MOD_ID, "poisonous_berry"),
            new AliasedBlockItem(MythicManiaBlocks.HARVESTER_BLOCK, new Item.Settings().food(FoodComponents.POISONOUS_BERRY).group(MythicMania.MYTHICMANIA_ITEM_GROUP))
    );

    public static final Item TRIBUS_FRUIT = Registry.register(
            Registry.ITEM,
            new Identifier(MythicMania.MOD_ID, "tribus_fruit"),
            new AliasedBlockItem(MythicManiaBlocks.TRIBUS_BLOCK, new Item.Settings().food(FoodComponents.TRIBUS_FRUIT).group(MythicMania.MYTHICMANIA_ITEM_GROUP))
    );

    public static final Item SWEETENED_BERRY = Registry.register(
            Registry.ITEM,
            new Identifier(MythicMania.MOD_ID, "sweetened_berry"),
            new SweetenedBerryItem()
    );

    public static final Item EMPTY_ORB = Registry.register(
            Registry.ITEM,
            new Identifier(MythicMania.MOD_ID, "empty_orb"),
            new OrbItem(false)
    );

    public static final Item CHARGED_INTOXICATED_ORB = Registry.register(
            Registry.ITEM,
            new Identifier(MythicMania.MOD_ID, "charged_intoxicated_orb"),
            new OrbItem(true)
    );

    public static final Item CHARGED_LOCH_ORB = Registry.register(
            Registry.ITEM,
            new Identifier(MythicMania.MOD_ID, "charged_loch_orb"),
            new OrbItem(true)
    );

    public static final Item CHARGED_RUINOUS_ORB = Registry.register(
            Registry.ITEM,
            new Identifier(MythicMania.MOD_ID, "charged_ruinous_orb"),
            new OrbItem(true)
    );

    public static final Item POISON_SPIKE = Registry.register(
            Registry.ITEM,
            new Identifier(MythicMania.MOD_ID, "poison_spike"),
            new PoisonSpikeItem()
    );
    
    public static final Item GRUB_ESSENCE = Registry.register(
            Registry.ITEM,
            new Identifier(MythicMania.MOD_ID, "grub_essence"),
            new GrubEssenceItem()
    );

    public static final Item INTOXICATED_SWORD = Registry.register(
            Registry.ITEM,
            new Identifier(MythicMania.MOD_ID, "intoxicated_sword"),
            new IntoxicatedSwordItem(IntoxicatedToolMaterial.INSTANCE, 8, -2.4f, new Item.Settings().group(MythicMania.MYTHICMANIA_ITEM_GROUP))
    );

    public static final Item INTOXICATED_PICKAXE = Registry.register(
            Registry.ITEM,
            new Identifier(MythicMania.MOD_ID, "intoxicated_pickaxe"),
            new CustomPickaxeItem(IntoxicatedToolMaterial.INSTANCE, 5, 2, new Item.Settings().group(MythicMania.MYTHICMANIA_ITEM_GROUP))
    );

    public static final Item INTOXICATED_AXE = Registry.register(
            Registry.ITEM,
            new Identifier(MythicMania.MOD_ID, "intoxicated_axe"),
            new CustomAxeItem(IntoxicatedToolMaterial.INSTANCE, 5, 2, new Item.Settings().group(MythicMania.MYTHICMANIA_ITEM_GROUP))
    );

    public static final Item INTOXICATED_HOE = Registry.register(
            Registry.ITEM,
            new Identifier(MythicMania.MOD_ID, "intoxicated_hoe"),
            new CustomHoeItem(IntoxicatedToolMaterial.INSTANCE, 5, 2, new Item.Settings().group(MythicMania.MYTHICMANIA_ITEM_GROUP))
    );

    public static final Item INTOXICATED_SHOVEL = Registry.register(
            Registry.ITEM,
            new Identifier(MythicMania.MOD_ID, "intoxicated_shovel"),
            new ShovelItem(IntoxicatedToolMaterial.INSTANCE, 5, 2, new Item.Settings().group(MythicMania.MYTHICMANIA_ITEM_GROUP))
    );

    // ==== INTOXICATED GEAR ====

    public static final Item INTOXICATED_HELMET = Registry.register(
            Registry.ITEM,
            new Identifier(MythicMania.MOD_ID, "intoxicated_helmet"),
            new ArmorItem(IntoxicatedArmorMaterial.INSTANCE, EquipmentSlot.HEAD, new Item.Settings().group(MythicMania.MYTHICMANIA_ITEM_GROUP))
    );

    public static final Item INTOXICATED_CHESTPLATE = Registry.register(
            Registry.ITEM,
            new Identifier(MythicMania.MOD_ID, "intoxicated_chestplate"),
            new ArmorItem(IntoxicatedArmorMaterial.INSTANCE, EquipmentSlot.CHEST, new Item.Settings().group(MythicMania.MYTHICMANIA_ITEM_GROUP))
    );

    public static final Item INTOXICATED_LEGGINGS = Registry.register(
            Registry.ITEM,
            new Identifier(MythicMania.MOD_ID, "intoxicated_leggings"),
            new ArmorItem(IntoxicatedArmorMaterial.INSTANCE, EquipmentSlot.LEGS, new Item.Settings().group(MythicMania.MYTHICMANIA_ITEM_GROUP))
    );

    public static final Item INTOXICATED_BOOTS = Registry.register(
            Registry.ITEM,
            new Identifier(MythicMania.MOD_ID, "intoxicated_boots"),
            new ArmorItem(IntoxicatedArmorMaterial.INSTANCE, EquipmentSlot.FEET, new Item.Settings().group(MythicMania.MYTHICMANIA_ITEM_GROUP))
    );

    // ==== BLOCKS ====

    public static void registerBlockItems() {
        Registry.register(Registry.ITEM, new Identifier(MythicMania.MOD_ID, "rinth"),
                new BlockItem(MythicManiaBlocks.RINTH_BLOCK, new Item.Settings().group(MythicMania.MYTHICMANIA_ITEM_GROUP)
                ));
    }

    public static void registerSpawnEggs() {
        Registry.register(Registry.ITEM, new Identifier(MythicMania.MOD_ID, "magical_grub_spawn_egg"),
                new SpawnEggItem(MythicManiaEntityTypes.MAGICAL_GRUB_ENTITY, 0x7ff8eb, 0x5da1c5, new Item.Settings().group(MythicMania.MYTHICMANIA_ITEM_GROUP)
                ));

        Registry.register(Registry.ITEM, new Identifier(MythicMania.MOD_ID, "poisonous_grub_spawn_egg"),
                new SpawnEggItem(MythicManiaEntityTypes.POISONOUS_GRUB_ENTITY, 0x4e9e78, 0x9cf590, new Item.Settings().group(MythicMania.MYTHICMANIA_ITEM_GROUP)
                ));
    }
}
