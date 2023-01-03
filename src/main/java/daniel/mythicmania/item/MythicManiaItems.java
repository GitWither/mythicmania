package daniel.mythicmania.item;

import daniel.mythicmania.MythicMania;
import daniel.mythicmania.block.MythicManiaBlocks;
import daniel.mythicmania.entity.MythicManiaEntityTypes;
import daniel.mythicmania.item.combat.*;
import daniel.mythicmania.item.material.armor.DemonVestMaterial;
import daniel.mythicmania.item.material.armor.NuclearArmorMaterial;
import daniel.mythicmania.item.material.tool.MythicManiaToolMaterials;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public final class MythicManiaItems {

    // Block Items
    public static Item PULSATING_BLACKSTONE;
    public static Item RINTH;
    public static Item TOXIC_ORE;
    public static Item ANCIENT_ALTAR;
    public static Item LUMINESCENT_SAC;

    // Food Tab Items
    public static Item POISONOUS_BERRY;
    public static Item HEALING_BERRY;
    public static Item TRIBUS_FRUIT;
    public static Item ENCHANTED_TRIBUS_FRUIT;

    // Misc Items
    public static Item EMPTY_ORB;
    public static Item CHARGED_NUCLEAR_ORB;
    public static Item CHARGED_LOCH_ORB;
    public static Item CHARGED_RUINED_ORB;
    public static Item POISON_SPIKE;
    public static Item GRUB_ESSENCE;
    public static Item TOXIC_PEBBLE;
    public static Item WASTED_ESSENCE;
    public static Item IRRADIATED_CRYSTAL;
    public static Item WATER_PARCEL;

    // Combat items
    public static Item NUCLEAR_DAGGER;
    public static Item NUCLEAR_BLADE;
    public static Item NUCLEAR_SWORD;
    public static Item NUCLEAR_HELMET;
    public static Item NUCLEAR_CHESTPLATE;
    public static Item NUCLEAR_LEGGINGS;
    public static Item NUCLEAR_BOOTS;
    public static Item WASTED_STAFF;
    public static Item DEMON_VEST;
    public static Item SHOCK_BOLT_STAFF;

    // Tool items
    public static Item NUCLEAR_PICKAXE;
    public static Item NUCLEAR_AXE;
    public static Item NUCLEAR_HOE;
    public static Item NUCLEAR_SHOVEL;

    // Non-tab items
    public static Item WASTED_STAFF_CHARGE;
    public static Item SHOCK_BOLT;

    public static void registerFoodTab() {
        POISONOUS_BERRY = Registry.register(
                Registry.ITEM,
                new Identifier(MythicMania.MOD_ID, "poisonous_berry"),
                new AliasedBlockItem(MythicManiaBlocks.HARVESTER_BLOCK, new Item.Settings().food(FoodComponents.POISONOUS_BERRY).group(MythicMania.MYTHICMANIA_FOOD_ITEM_GROUP))
        );

        HEALING_BERRY = Registry.register(
                Registry.ITEM,
                new Identifier(MythicMania.MOD_ID, "healing_berry"),
                new HealingBerryItem()
        );

        TRIBUS_FRUIT = Registry.register(
                Registry.ITEM,
                new Identifier(MythicMania.MOD_ID, "tribus_fruit"),
                new AliasedBlockItem(MythicManiaBlocks.TRIBUS_BLOCK, new Item.Settings().food(FoodComponents.TRIBUS_FRUIT).group(MythicMania.MYTHICMANIA_FOOD_ITEM_GROUP))
        );

        ENCHANTED_TRIBUS_FRUIT = Registry.register(
                Registry.ITEM,
                new Identifier(MythicMania.MOD_ID, "enchanted_tribus_fruit"),
                new Item(new Item.Settings().food(FoodComponents.ENCHANTED_TRIBUS_FRUIT).group(MythicMania.MYTHICMANIA_FOOD_ITEM_GROUP).rarity(Rarity.RARE))
        );
    }

    public static void registerItemTab() {
        EMPTY_ORB = Registry.register(
                Registry.ITEM,
                new Identifier(MythicMania.MOD_ID, "empty_orb"),
                new Item(new Item.Settings().group(MythicMania.MYTHICMANIA_ITEMS_ITEM_GROUP))
        );

        CHARGED_NUCLEAR_ORB = Registry.register(
                Registry.ITEM,
                new Identifier(MythicMania.MOD_ID, "charged_nuclear_orb"),
                new Item(new Item.Settings().group(MythicMania.MYTHICMANIA_ITEMS_ITEM_GROUP).rarity(Rarity.UNCOMMON))
        );

        CHARGED_LOCH_ORB = Registry.register(
                Registry.ITEM,
                new Identifier(MythicMania.MOD_ID, "charged_loch_orb"),
                new Item(new Item.Settings().group(MythicMania.MYTHICMANIA_ITEMS_ITEM_GROUP).rarity(Rarity.UNCOMMON))
        );

        CHARGED_RUINED_ORB = Registry.register(
                Registry.ITEM,
                new Identifier(MythicMania.MOD_ID, "charged_ruined_orb"),
                new Item(new Item.Settings().group(MythicMania.MYTHICMANIA_ITEMS_ITEM_GROUP).rarity(Rarity.UNCOMMON))
        );

        POISON_SPIKE = Registry.register(
                Registry.ITEM,
                new Identifier(MythicMania.MOD_ID, "poison_spike"),
                new PoisonSpikeItem(new Item.Settings().group(MythicMania.MYTHICMANIA_ITEMS_ITEM_GROUP))
        );

        GRUB_ESSENCE = Registry.register(
                Registry.ITEM,
                new Identifier(MythicMania.MOD_ID, "grub_essence"),
                new Item(new Item.Settings().group(MythicMania.MYTHICMANIA_ITEMS_ITEM_GROUP))
        );

        TOXIC_PEBBLE = Registry.register(
                Registry.ITEM,
                new Identifier(MythicMania.MOD_ID, "toxic_pebble"),
                new Item(new Item.Settings().group(MythicMania.MYTHICMANIA_ITEMS_ITEM_GROUP))
        );

        WASTED_ESSENCE = Registry.register(
                Registry.ITEM,
                new Identifier(MythicMania.MOD_ID, "wasted_essence"),
                new Item(new Item.Settings().group(MythicMania.MYTHICMANIA_ITEMS_ITEM_GROUP))
        );

        IRRADIATED_CRYSTAL = Registry.register(
                Registry.ITEM,
                new Identifier(MythicMania.MOD_ID, "irradiated_crystal"),
                new Item(new Item.Settings().group(MythicMania.MYTHICMANIA_ITEMS_ITEM_GROUP))
        );

        WATER_PARCEL = Registry.register(
                Registry.ITEM,
                new Identifier(MythicMania.MOD_ID, "water_parcel"),
                new WaterParcelItem(new Item.Settings().group(MythicMania.MYTHICMANIA_ITEMS_ITEM_GROUP).maxCount(32))
        );

        WASTED_STAFF_CHARGE = Registry.register(
                Registry.ITEM,
                new Identifier(MythicMania.MOD_ID, "wasted_staff_charge"),
                new WastedStaffChargeItem(new Item.Settings().group(MythicMania.MYTHICMANIA_ITEMS_ITEM_GROUP))
        );

        // Register spawn eggs
        registerSpawnEggs();
    }

    public static void registerCombatTab() {
        NUCLEAR_DAGGER = Registry.register(
                Registry.ITEM,
                new Identifier(MythicMania.MOD_ID, "nuclear_dagger"),
                new NuclearDaggerItem(MythicManiaToolMaterials.NUCLEAR, 5, 1.2f, new Item.Settings().group(MythicMania.MYTHICMANIA_COMBAT_ITEM_GROUP))
        );

        NUCLEAR_BLADE = Registry.register(
                Registry.ITEM,
                new Identifier(MythicMania.MOD_ID, "nuclear_blade"),
                new NuclearBladeItem(MythicManiaToolMaterials.NUCLEAR, 6, 1.2f, new Item.Settings().group(MythicMania.MYTHICMANIA_COMBAT_ITEM_GROUP))
        );

        NUCLEAR_SWORD = Registry.register(
                Registry.ITEM,
                new Identifier(MythicMania.MOD_ID, "nuclear_sword"),
                new NuclearSwordItem(MythicManiaToolMaterials.NUCLEAR, 7, 1.2f, new Item.Settings().group(MythicMania.MYTHICMANIA_COMBAT_ITEM_GROUP))
        );

        NUCLEAR_HELMET = Registry.register(
                Registry.ITEM,
                new Identifier(MythicMania.MOD_ID, "nuclear_helmet"),
                new ArmorItem(NuclearArmorMaterial.INSTANCE, EquipmentSlot.HEAD, new Item.Settings().group(MythicMania.MYTHICMANIA_COMBAT_ITEM_GROUP))
        );

        NUCLEAR_CHESTPLATE = Registry.register(
                Registry.ITEM,
                new Identifier(MythicMania.MOD_ID, "nuclear_chestplate"),
                new ArmorItem(NuclearArmorMaterial.INSTANCE, EquipmentSlot.CHEST, new Item.Settings().group(MythicMania.MYTHICMANIA_COMBAT_ITEM_GROUP))
        );

        NUCLEAR_LEGGINGS = Registry.register(
                Registry.ITEM,
                new Identifier(MythicMania.MOD_ID, "nuclear_leggings"),
                new ArmorItem(NuclearArmorMaterial.INSTANCE, EquipmentSlot.LEGS, new Item.Settings().group(MythicMania.MYTHICMANIA_COMBAT_ITEM_GROUP))
        );

        NUCLEAR_BOOTS = Registry.register(
                Registry.ITEM,
                new Identifier(MythicMania.MOD_ID, "nuclear_boots"),
                new ArmorItem(NuclearArmorMaterial.INSTANCE, EquipmentSlot.FEET, new Item.Settings().group(MythicMania.MYTHICMANIA_COMBAT_ITEM_GROUP))
        );

        WASTED_STAFF = Registry.register(
                Registry.ITEM,
                new Identifier(MythicMania.MOD_ID, "wasted_staff"),
                new WastedStaffItem(MythicManiaToolMaterials.WASTED_STAFF,2,0.8f, new Item.Settings().group(MythicMania.MYTHICMANIA_COMBAT_ITEM_GROUP).maxCount(1))
        );

        DEMON_VEST = Registry.register(
                Registry.ITEM,
                new Identifier(MythicMania.MOD_ID, "demon_vest"),
                new ArmorItem(DemonVestMaterial.INSTANCE, EquipmentSlot.CHEST, new Item.Settings().group(MythicMania.MYTHICMANIA_COMBAT_ITEM_GROUP))
        );

        SHOCK_BOLT_STAFF = Registry.register(
                Registry.ITEM,
                new Identifier(MythicMania.MOD_ID, "shock_bolt_staff"),
                new ShockBoltStaffItem(MythicManiaToolMaterials.SHOCK_BOLT_STAFF,1,0.8f, new Item.Settings().group(MythicMania.MYTHICMANIA_COMBAT_ITEM_GROUP).maxCount(1))
        );
    }

    public static void registerToolTab() {
        NUCLEAR_PICKAXE = Registry.register(
                Registry.ITEM,
                new Identifier(MythicMania.MOD_ID, "nuclear_pickaxe"),
                new CustomPickaxeItem(MythicManiaToolMaterials.NUCLEAR, 4, 2, new Item.Settings().group(MythicMania.MYTHICMANIA_TOOLS_ITEM_GROUP))
        );

        NUCLEAR_AXE = Registry.register(
                Registry.ITEM,
                new Identifier(MythicMania.MOD_ID, "nuclear_axe"),
                new CustomAxeItem(MythicManiaToolMaterials.NUCLEAR, 5, 2, new Item.Settings().group(MythicMania.MYTHICMANIA_TOOLS_ITEM_GROUP))
        );

        NUCLEAR_HOE = Registry.register(
                Registry.ITEM,
                new Identifier(MythicMania.MOD_ID, "nuclear_hoe"),
                new CustomHoeItem(MythicManiaToolMaterials.NUCLEAR, 1, 2, new Item.Settings().group(MythicMania.MYTHICMANIA_TOOLS_ITEM_GROUP))
        );

        NUCLEAR_SHOVEL = Registry.register(
                Registry.ITEM,
                new Identifier(MythicMania.MOD_ID, "nuclear_shovel"),
                new ShovelItem(MythicManiaToolMaterials.NUCLEAR, 1, 2, new Item.Settings().group(MythicMania.MYTHICMANIA_TOOLS_ITEM_GROUP))
        );
    }

    public static void registerNonTabItems() {
        SHOCK_BOLT = Registry.register(
                Registry.ITEM,
                new Identifier(MythicMania.MOD_ID, "shock_bolt"),
                new ShockBoltItem(new Item.Settings())
        );
    }

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

    public static void registerItems() {
        registerFoodTab();
        registerItemTab();
        registerCombatTab();
        registerToolTab();
        registerNonTabItems();
    }

    public static void registerSpawnEggs() {
        Registry.register(Registry.ITEM, new Identifier(MythicMania.MOD_ID, "magical_grub_spawn_egg"),
                new SpawnEggItem(
                        MythicManiaEntityTypes.MAGICAL_GRUB_ENTITY, 0x7ff8eb, 0x7EBADA,
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
                        MythicManiaEntityTypes.ZAPPING_BEETLE_ENTITY, 0x3991d0, 0xF0D538,
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
