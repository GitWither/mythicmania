package daniel.mythicmania.item;

import daniel.mythicmania.MythicMania;
import daniel.mythicmania.block.MythicManiaBlocks;
import daniel.mythicmania.entity.MythicManiaEntityTypes;
import daniel.mythicmania.item.combat.*;
import daniel.mythicmania.item.material.armor.DemonVestMaterial;
import daniel.mythicmania.item.material.armor.IntoxicatedArmorMaterial;
import daniel.mythicmania.item.material.tool.MythicManiaToolMaterials;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public final class MythicManiaItems {
    public static Item PULSATING_BLACKSTONE;
    public static Item RINTH;
    public static Item TOXIC_ORE;
    public static Item ANCIENT_ALTAR;
    public static Item LUMINESCENT_SAC;

    public static final Item POISONOUS_BERRY = Registry.register(
            Registry.ITEM,
            new Identifier(MythicMania.MOD_ID, "poisonous_berry"),
            new AliasedBlockItem(MythicManiaBlocks.HARVESTER_BLOCK, new Item.Settings().food(FoodComponents.POISONOUS_BERRY).group(MythicMania.MYTHICMANIA_FOOD_ITEM_GROUP))
    );

    public static final Item HEALING_BERRY = Registry.register(
            Registry.ITEM,
            new Identifier(MythicMania.MOD_ID, "healing_berry"),
            new HealingBerryItem()
    );

    public static final Item TRIBUS_FRUIT = Registry.register(
            Registry.ITEM,
            new Identifier(MythicMania.MOD_ID, "tribus_fruit"),
            new AliasedBlockItem(MythicManiaBlocks.TRIBUS_BLOCK, new Item.Settings().food(FoodComponents.TRIBUS_FRUIT).group(MythicMania.MYTHICMANIA_FOOD_ITEM_GROUP))
    );

    public static final Item ENCHANTED_TRIBUS_FRUIT = Registry.register(
            Registry.ITEM,
            new Identifier(MythicMania.MOD_ID, "enchanted_tribus_fruit"),
            new EnchantedTribusFruitItem()
    );

    public static final Item EMPTY_ORB = Registry.register(
            Registry.ITEM,
            new Identifier(MythicMania.MOD_ID, "empty_orb"),
            new Item(new Item.Settings().group(MythicMania.MYTHICMANIA_ITEMS_ITEM_GROUP))
    );

    public static final Item CHARGED_INTOXICATED_ORB = Registry.register(
            Registry.ITEM,
            new Identifier(MythicMania.MOD_ID, "charged_intoxicated_orb"),
            new Item(new Item.Settings().group(MythicMania.MYTHICMANIA_ITEMS_ITEM_GROUP).rarity(Rarity.UNCOMMON))
    );

    public static final Item CHARGED_LOCH_ORB = Registry.register(
            Registry.ITEM,
            new Identifier(MythicMania.MOD_ID, "charged_loch_orb"),
            new Item(new Item.Settings().group(MythicMania.MYTHICMANIA_ITEMS_ITEM_GROUP).rarity(Rarity.UNCOMMON))
    );

    public static final Item CHARGED_RUINED_ORB = Registry.register(
            Registry.ITEM,
            new Identifier(MythicMania.MOD_ID, "charged_ruined_orb"),
            new Item(new Item.Settings().group(MythicMania.MYTHICMANIA_ITEMS_ITEM_GROUP).rarity(Rarity.UNCOMMON))
    );

    public static final Item POISON_SPIKE = Registry.register(
            Registry.ITEM,
            new Identifier(MythicMania.MOD_ID, "poison_spike"),
            new PoisonSpikeItem(new Item.Settings().group(MythicMania.MYTHICMANIA_ITEMS_ITEM_GROUP))
    );
    
    public static final Item GRUB_ESSENCE = Registry.register(
            Registry.ITEM,
            new Identifier(MythicMania.MOD_ID, "grub_essence"),
            new Item(new Item.Settings().group(MythicMania.MYTHICMANIA_ITEMS_ITEM_GROUP))
    );

    public static final Item TOXIC_PEBBLE = Registry.register(
            Registry.ITEM,
            new Identifier(MythicMania.MOD_ID, "toxic_pebble"),
            new Item(new Item.Settings().group(MythicMania.MYTHICMANIA_ITEMS_ITEM_GROUP))
    );

    public static final Item WASTED_ESSENCE = Registry.register(
            Registry.ITEM,
            new Identifier(MythicMania.MOD_ID, "wasted_essence"),
            new Item(new Item.Settings().group(MythicMania.MYTHICMANIA_ITEMS_ITEM_GROUP))
    );

    public static final Item WATER_PARCEL = Registry.register(
            Registry.ITEM,
            new Identifier(MythicMania.MOD_ID, "water_parcel"),
            new WaterParcelItem(new Item.Settings().group(MythicMania.MYTHICMANIA_ITEMS_ITEM_GROUP).maxCount(32))
    );

    public static final Item WASTED_STAFF_CHARGE = Registry.register(
            Registry.ITEM,
            new Identifier(MythicMania.MOD_ID, "wasted_staff_charge"),
            new WastedStaffChargeItem(new Item.Settings())
    );

    public static final Item WASTED_STAFF = Registry.register(
            Registry.ITEM,
            new Identifier(MythicMania.MOD_ID, "wasted_staff"),
            new WastedStaffItem(MythicManiaToolMaterials.WASTED_STAFF,2,0.8f, new Item.Settings().group(MythicMania.MYTHICMANIA_COMBAT_ITEM_GROUP).maxCount(1))
    );

    public static final Item INTOXICATED_SWORD = Registry.register(
            Registry.ITEM,
            new Identifier(MythicMania.MOD_ID, "intoxicated_sword"),
            new IntoxicatedSwordItem(MythicManiaToolMaterials.INTOXICATED, 7, 1.2f, new Item.Settings().group(MythicMania.MYTHICMANIA_COMBAT_ITEM_GROUP))
    );

    public static final Item INTOXICATED_PICKAXE = Registry.register(
            Registry.ITEM,
            new Identifier(MythicMania.MOD_ID, "intoxicated_pickaxe"),
            new CustomPickaxeItem(MythicManiaToolMaterials.INTOXICATED, 4, 2, new Item.Settings().group(MythicMania.MYTHICMANIA_TOOLS_ITEM_GROUP))
    );

    public static final Item INTOXICATED_AXE = Registry.register(
            Registry.ITEM,
            new Identifier(MythicMania.MOD_ID, "intoxicated_axe"),
            new CustomAxeItem(MythicManiaToolMaterials.INTOXICATED, 5, 2, new Item.Settings().group(MythicMania.MYTHICMANIA_TOOLS_ITEM_GROUP))
    );

    public static final Item INTOXICATED_HOE = Registry.register(
            Registry.ITEM,
            new Identifier(MythicMania.MOD_ID, "intoxicated_hoe"),
            new CustomHoeItem(MythicManiaToolMaterials.INTOXICATED, 1, 2, new Item.Settings().group(MythicMania.MYTHICMANIA_TOOLS_ITEM_GROUP))
    );

    public static final Item INTOXICATED_SHOVEL = Registry.register(
            Registry.ITEM,
            new Identifier(MythicMania.MOD_ID, "intoxicated_shovel"),
            new ShovelItem(MythicManiaToolMaterials.INTOXICATED, 1, 2, new Item.Settings().group(MythicMania.MYTHICMANIA_TOOLS_ITEM_GROUP))
    );

    // ==== GEAR ====

    public static final Item DEMON_VEST = Registry.register(
            Registry.ITEM,
            new Identifier(MythicMania.MOD_ID, "demon_vest"),
            new ArmorItem(DemonVestMaterial.INSTANCE, EquipmentSlot.CHEST, new Item.Settings().group(MythicMania.MYTHICMANIA_COMBAT_ITEM_GROUP))
    );

    public static final Item INTOXICATED_HELMET = Registry.register(
            Registry.ITEM,
            new Identifier(MythicMania.MOD_ID, "intoxicated_helmet"),
            new ArmorItem(IntoxicatedArmorMaterial.INSTANCE, EquipmentSlot.HEAD, new Item.Settings().group(MythicMania.MYTHICMANIA_COMBAT_ITEM_GROUP))
    );

    public static final Item INTOXICATED_CHESTPLATE = Registry.register(
            Registry.ITEM,
            new Identifier(MythicMania.MOD_ID, "intoxicated_chestplate"),
            new ArmorItem(IntoxicatedArmorMaterial.INSTANCE, EquipmentSlot.CHEST, new Item.Settings().group(MythicMania.MYTHICMANIA_COMBAT_ITEM_GROUP))
    );

    public static final Item INTOXICATED_LEGGINGS = Registry.register(
            Registry.ITEM,
            new Identifier(MythicMania.MOD_ID, "intoxicated_leggings"),
            new ArmorItem(IntoxicatedArmorMaterial.INSTANCE, EquipmentSlot.LEGS, new Item.Settings().group(MythicMania.MYTHICMANIA_COMBAT_ITEM_GROUP))
    );

    public static final Item INTOXICATED_BOOTS = Registry.register(
            Registry.ITEM,
            new Identifier(MythicMania.MOD_ID, "intoxicated_boots"),
            new ArmorItem(IntoxicatedArmorMaterial.INSTANCE, EquipmentSlot.FEET, new Item.Settings().group(MythicMania.MYTHICMANIA_COMBAT_ITEM_GROUP))
    );

    public static void registerBlockItems() {
        RINTH = Registry.register(
                Registry.ITEM,
                new Identifier(MythicMania.MOD_ID, "rinth"),
                new BlockItem(MythicManiaBlocks.RINTH_BLOCK, new Item.Settings().group(MythicMania.MYTHICMANIA_BLOCK_ITEM_GROUP)
                )
        );

        ANCIENT_ALTAR = Registry.register(
                Registry.ITEM,
                new Identifier(MythicMania.MOD_ID, "ancient_altar"),
                new BlockItem(MythicManiaBlocks.ANCIENT_ALTAR, new Item.Settings().group(MythicMania.MYTHICMANIA_BLOCK_ITEM_GROUP)
                )
        );

        TOXIC_ORE = Registry.register(
                Registry.ITEM,
                new Identifier(MythicMania.MOD_ID, "toxic_ore"),
                new BlockItem(MythicManiaBlocks.TOXIC_ORE, new Item.Settings().group(MythicMania.MYTHICMANIA_BLOCK_ITEM_GROUP)
                )
        );

        PULSATING_BLACKSTONE = Registry.register(
                Registry.ITEM,
                new Identifier(MythicMania.MOD_ID, "pulsating_blackstone"),
                new BlockItem(MythicManiaBlocks.PULSATING_BLACKSTONE, new Item.Settings().group(MythicMania.MYTHICMANIA_BLOCK_ITEM_GROUP)
                )
        );

        LUMINESCENT_SAC = Registry.register(
                Registry.ITEM,
                new Identifier(MythicMania.MOD_ID, "luminescent_sac"),
                new BlockItem(MythicManiaBlocks.LUMINESCENT_SAC, new Item.Settings().group(MythicMania.MYTHICMANIA_BLOCK_ITEM_GROUP)
                )
        );
    }

    public static void registerSpawnEggs() {
        Registry.register(Registry.ITEM, new Identifier(MythicMania.MOD_ID, "magical_grub_spawn_egg"),
                new SpawnEggItem(
                        MythicManiaEntityTypes.MAGICAL_GRUB_ENTITY, 0x7ff8eb, 0x5da1c5,
                        new Item.Settings().group(MythicMania.MYTHICMANIA_ITEMS_ITEM_GROUP)
                )
        );

        Registry.register(Registry.ITEM, new Identifier(MythicMania.MOD_ID, "poisonous_grub_spawn_egg"),
                new SpawnEggItem(
                        MythicManiaEntityTypes.POISONOUS_GRUB_ENTITY, 0x4e9e78, 0x9cf590,
                        new Item.Settings().group(MythicMania.MYTHICMANIA_ITEMS_ITEM_GROUP)
                )
        );

        Registry.register(Registry.ITEM, new Identifier(MythicMania.MOD_ID, "zapping_beetle_spawn_egg"),
                new SpawnEggItem(
                        MythicManiaEntityTypes.ZAPPING_BEETLE_ENTITY, 0x3991d0, 0xcab641,
                        new Item.Settings().group(MythicMania.MYTHICMANIA_ITEMS_ITEM_GROUP)
                )
        );

        Registry.register(Registry.ITEM, new Identifier(MythicMania.MOD_ID, "wasted_demon_spawn_egg"),
                new SpawnEggItem(
                        MythicManiaEntityTypes.WASTED_DEMON_ENTITY, 0x2a2a2a, 0x951010,
                        new Item.Settings().group(MythicMania.MYTHICMANIA_ITEMS_ITEM_GROUP)
                )
        );

        Registry.register(Registry.ITEM, new Identifier(MythicMania.MOD_ID, "demon_guardian_spawn_egg"),
                new SpawnEggItem(
                        MythicManiaEntityTypes.DEMON_GUARDIAN_ENTITY, 0x2a2a2a, 0x7c7c7c,
                        new Item.Settings().group(MythicMania.MYTHICMANIA_ITEMS_ITEM_GROUP)
                )
        );

        Registry.register(Registry.ITEM, new Identifier(MythicMania.MOD_ID, "orbiter_spawn_egg"),
                new SpawnEggItem(
                        MythicManiaEntityTypes.ORBITER_ENTITY, 0x494343, 0xdd693d,
                        new Item.Settings().group(MythicMania.MYTHICMANIA_ITEMS_ITEM_GROUP)
                )
        );
    }
}
