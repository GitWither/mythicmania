package daniel.mythicmania.item;

import daniel.mythicmania.MythicMania;
import daniel.mythicmania.block.MythicManiaBlocks;
import daniel.mythicmania.entity.MythicManiaEntityTypes;
import daniel.mythicmania.item.combat.*;
import daniel.mythicmania.item.material.armor.DemonVestMaterial;
import daniel.mythicmania.item.material.armor.NuclearArmorMaterial;
import daniel.mythicmania.item.material.armor.RuinousArmorMaterial;
import daniel.mythicmania.item.material.tool.MythicManiaToolMaterials;
import daniel.mythicmania.item.projectile.*;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public final class MythicManiaItems {

    // Block Items
    public static Item PULSATING_BLACKSTONE;
    public static Item RINTH;
    public static Item TOXIC_ORE;
    public static Item RUINED_ORE;
    public static Item BLACKSTONE_RUINED_ORE;
    public static Item ANCIENT_ALTAR;
    public static Item LUMINESCENT_SAC;
    public static Item ORBITER_PROJECTILE;
    public static Item TOXIC_ORBITER_PROJECTILE;

    // Food Tab Items
    public static Item RINTH_BERRY;
    public static Item POISONOUS_BERRY;
    public static Item HEALING_BERRY;
    public static Item TRIBUS_FRUIT;
    public static Item ENCHANTED_TRIBUS_FRUIT;

    // Misc Items
    public static Item EMPTY_ORB;
    public static Item CHARGED_NUCLEAR_ORB;
    public static Item CHARGED_RUINED_ORB;
    public static Item ORBITER_CORE;
    public static Item TOXIC_ORBITER_CORE;
    public static Item UNSTABLE_TOXIC_THROWABLE;
    public static Item UNSTABLE_RUINOUS_THROWABLE;
    public static Item WASTED_STAFF_CHARGE;
    public static Item POISON_SPIKE;
    public static Item SHOCK_BOLT;
    public static Item GRUB_ESSENCE;
    public static Item RINTH_SEED;
    public static Item TOXIC_PEBBLE;
    public static Item WASTED_ESSENCE;
    public static Item IRRADIATED_CRYSTAL;
    public static Item WATER_PARCEL;
    public static Item CHARGE;
    public static Item GLIDER_WING;

    // Spawn eggs
    public static Item MAGICAL_GRUB_SPAWN_EGG;
    public static Item POISONOUS_GRUB_SPAWN_EGG;
    public static Item ZAPPING_BEETLE_SPAWN_EGG;
    public static Item WASTED_DEMON_SPAWN_EGG;
    public static Item DEMON_GUARDIAN_SPAWN_EGG;
    public static Item ORBITER_SPAWN_EGG;
    public static Item NOXIOUS_SPIRIT_SPAWN_EGG;
    public static Item TOXIC_ORBITER_SPAWN_EGG;
    public static Item WASTREL_GLIDER_SPAWN_EGG;

    // Combat items
    public static Item NUCLEAR_DAGGER;
    public static Item NUCLEAR_BLADE;
    public static Item NUCLEAR_SWORD;
    public static Item NUCLEAR_HELMET;
    public static Item NUCLEAR_CHESTPLATE;
    public static Item NUCLEAR_LEGGINGS;
    public static Item NUCLEAR_BOOTS;
    public static Item RUINOUS_HELMET;
    public static Item RUINOUS_CHESTPLATE;
    public static Item RUINOUS_LEGGINGS;
    public static Item RUINOUS_BOOTS;
    public static Item RUINOUS_SWORD;
    public static Item WASTED_STAFF;
    public static Item DEMON_VEST;
    public static Item SHOCK_STAFF;
    public static Item SHOCK_BOLT_STAFF;

    // Tool items
    public static Item NUCLEAR_PICKAXE;
    public static Item NUCLEAR_AXE;
    public static Item NUCLEAR_HOE;
    public static Item NUCLEAR_SHOVEL;
    public static Item RUINOUS_AXE;
    public static Item RUINOUS_SHOVEL;
    public static Item RUINOUS_PICKAXE;
    public static Item RUINOUS_HOE;

    public static void registerFoodTab() {
        RINTH_BERRY = Registry.register(
                Registries.ITEM,
                new Identifier(MythicMania.MOD_ID, "rinth_berry"),
                new Item(new Item.Settings().food(MythicManiaFoodComponents.RINTH_BERRY))
        );

        POISONOUS_BERRY = Registry.register(
                Registries.ITEM,
                new Identifier(MythicMania.MOD_ID, "poisonous_berry"),
                new AliasedBlockItem(MythicManiaBlocks.HARVESTER_BLOCK, new Item.Settings().food(MythicManiaFoodComponents.POISONOUS_BERRY))
        );

        HEALING_BERRY = Registry.register(
                Registries.ITEM,
                new Identifier(MythicMania.MOD_ID, "healing_berry"),
                new HealingBerryItem()
        );

        TRIBUS_FRUIT = Registry.register(
                Registries.ITEM,
                new Identifier(MythicMania.MOD_ID, "tribus_fruit"),
                new AliasedBlockItem(MythicManiaBlocks.TRIBUS_BLOCK, new Item.Settings().food(MythicManiaFoodComponents.TRIBUS_FRUIT))
        );

        ENCHANTED_TRIBUS_FRUIT = Registry.register(
                Registries.ITEM,
                new Identifier(MythicMania.MOD_ID, "enchanted_tribus_fruit"),
                new Item(new Item.Settings().food(MythicManiaFoodComponents.ENCHANTED_TRIBUS_FRUIT).rarity(Rarity.RARE))
        );
    }

    public static void registerItemTab() {
        EMPTY_ORB = Registry.register(
                Registries.ITEM,
                new Identifier(MythicMania.MOD_ID, "empty_orb"),
                new Item(new Item.Settings())
        );

        CHARGED_NUCLEAR_ORB = Registry.register(
                Registries.ITEM,

                new Identifier(MythicMania.MOD_ID, "charged_nuclear_orb"),
                new Item(new Item.Settings().rarity(Rarity.UNCOMMON))
        );

        CHARGED_RUINED_ORB = Registry.register(
                Registries.ITEM,
                new Identifier(MythicMania.MOD_ID, "charged_ruined_orb"),
                new Item(new Item.Settings().rarity(Rarity.UNCOMMON))
        );

        ORBITER_CORE = Registry.register(
                Registries.ITEM,
                new Identifier(MythicMania.MOD_ID, "orbiter_core"),
                new Item(new Item.Settings())
        );

        TOXIC_ORBITER_CORE = Registry.register(
                Registries.ITEM,
                new Identifier(MythicMania.MOD_ID, "toxic_orbiter_core"),
                new Item(new Item.Settings())
        );

        UNSTABLE_RUINOUS_THROWABLE = Registry.register(
                Registries.ITEM,
                new Identifier(MythicMania.MOD_ID, "unstable_ruinous_throwable"),
                new UnstableRuinousThrowableItem(new Item.Settings().maxCount(16))
        );

        UNSTABLE_TOXIC_THROWABLE = Registry.register(
                Registries.ITEM,
                new Identifier(MythicMania.MOD_ID, "unstable_toxic_throwable"),
                new UnstableToxicThrowableItem(new Item.Settings().maxCount(16))
        );

        POISON_SPIKE = Registry.register(
                Registries.ITEM,
                new Identifier(MythicMania.MOD_ID, "poison_spike"),
                new PoisonSpikeItem(new Item.Settings())
        );

        GRUB_ESSENCE = Registry.register(
                Registries.ITEM,
                new Identifier(MythicMania.MOD_ID, "grub_essence"),
                new Item(new Item.Settings())
        );

        RINTH_SEED = Registry.register(
                Registries.ITEM,
                new Identifier(MythicMania.MOD_ID, "rinth_seed"),
                new AliasedBlockItem(MythicManiaBlocks.RINTH_BLOCK, new Item.Settings())
        );

        TOXIC_PEBBLE = Registry.register(
                Registries.ITEM,
                new Identifier(MythicMania.MOD_ID, "toxic_pebble"),
                new Item(new Item.Settings())
        );

        WASTED_ESSENCE = Registry.register(
                Registries.ITEM,
                new Identifier(MythicMania.MOD_ID, "wasted_essence"),
                new Item(new Item.Settings())
        );

        IRRADIATED_CRYSTAL = Registry.register(
                Registries.ITEM,
                new Identifier(MythicMania.MOD_ID, "irradiated_crystal"),
                new Item(new Item.Settings())
        );

        WATER_PARCEL = Registry.register(
                Registries.ITEM,
                new Identifier(MythicMania.MOD_ID, "water_parcel"),
                new WaterParcelItem(new Item.Settings().maxCount(32))
        );

        CHARGE = Registry.register(
                Registries.ITEM,
                new Identifier(MythicMania.MOD_ID, "charge"),
                new Item(new Item.Settings())
        );

        GLIDER_WING = Registry.register(
                Registries.ITEM,
                new Identifier(MythicMania.MOD_ID, "glider_wing"),
                new Item(new Item.Settings())
        );

        WASTED_STAFF_CHARGE = Registry.register(
                Registries.ITEM,
                new Identifier(MythicMania.MOD_ID, "wasted_staff_charge"),
                new WastedStaffChargeItem(new Item.Settings().maxCount(32))
        );

        SHOCK_BOLT = Registry.register(
                Registries.ITEM,
                new Identifier(MythicMania.MOD_ID, "shock_bolt"),
                new ShockBoltItem(new Item.Settings().maxCount(32))
        );

        // Register spawn eggs
        registerSpawnEggs();
    }

    public static void registerCombatTab() {
        NUCLEAR_DAGGER = Registry.register(
                Registries.ITEM,
                new Identifier(MythicMania.MOD_ID, "nuclear_dagger"),
                new NuclearDaggerItem(MythicManiaToolMaterials.NUCLEAR, 5, 1.2f, new Item.Settings())
        );

        NUCLEAR_BLADE = Registry.register(
                Registries.ITEM,
                new Identifier(MythicMania.MOD_ID, "nuclear_blade"),
                new NuclearSwordItem(MythicManiaToolMaterials.NUCLEAR, 6, 1.2f, new Item.Settings(), 6*20, 1, 9*20, 1, 2)
        );

        NUCLEAR_SWORD = Registry.register(
                Registries.ITEM,
                new Identifier(MythicMania.MOD_ID, "nuclear_sword"),
                new NuclearSwordItem(MythicManiaToolMaterials.NUCLEAR, 7, 1.2f, new Item.Settings(), 8*20, 1, 12*20, 2, 4)
        );

        RUINOUS_SWORD = Registry.register(
                Registries.ITEM,
                new Identifier(MythicMania.MOD_ID, "ruinous_sword"),
                new RuinousSwordItem(MythicManiaToolMaterials.RUINOUS, 8, 1.2f, new Item.Settings())
        );

        NUCLEAR_HELMET = Registry.register(
                Registries.ITEM,
                new Identifier(MythicMania.MOD_ID, "nuclear_helmet"),
                new ArmorItem(NuclearArmorMaterial.INSTANCE, ArmorItem.Type.HELMET, new Item.Settings())
        );

        NUCLEAR_CHESTPLATE = Registry.register(
                Registries.ITEM,
                new Identifier(MythicMania.MOD_ID, "nuclear_chestplate"),
                new ArmorItem(NuclearArmorMaterial.INSTANCE, ArmorItem.Type.CHESTPLATE, new Item.Settings())
        );

        NUCLEAR_LEGGINGS = Registry.register(
                Registries.ITEM,
                new Identifier(MythicMania.MOD_ID, "nuclear_leggings"),
                new ArmorItem(NuclearArmorMaterial.INSTANCE, ArmorItem.Type.LEGGINGS, new Item.Settings())
        );

        NUCLEAR_BOOTS = Registry.register(
                Registries.ITEM,
                new Identifier(MythicMania.MOD_ID, "nuclear_boots"),
                new ArmorItem(NuclearArmorMaterial.INSTANCE, ArmorItem.Type.BOOTS, new Item.Settings())
        );

        RUINOUS_HELMET = Registry.register(
                Registries.ITEM,
                new Identifier(MythicMania.MOD_ID, "ruinous_helmet"),
                new ArmorItem(RuinousArmorMaterial.INSTANCE, ArmorItem.Type.HELMET, new Item.Settings())
        );

        RUINOUS_CHESTPLATE = Registry.register(
                Registries.ITEM,
                new Identifier(MythicMania.MOD_ID, "ruinous_chestplate"),
                new ArmorItem(RuinousArmorMaterial.INSTANCE, ArmorItem.Type.CHESTPLATE, new Item.Settings())
        );

        RUINOUS_LEGGINGS = Registry.register(
                Registries.ITEM,
                new Identifier(MythicMania.MOD_ID, "ruinous_pants"),
                new ArmorItem(RuinousArmorMaterial.INSTANCE, ArmorItem.Type.LEGGINGS, new Item.Settings())
        );

        RUINOUS_BOOTS = Registry.register(
                Registries.ITEM,
                new Identifier(MythicMania.MOD_ID, "ruinous_boots"),
                new ArmorItem(RuinousArmorMaterial.INSTANCE, ArmorItem.Type.BOOTS, new Item.Settings())
        );

        DEMON_VEST = Registry.register(
                Registries.ITEM,
                new Identifier(MythicMania.MOD_ID, "demon_vest"),
                new ArmorItem(DemonVestMaterial.INSTANCE, ArmorItem.Type.CHESTPLATE, new Item.Settings())
        );

        WASTED_STAFF = Registry.register(
                Registries.ITEM,
                new Identifier(MythicMania.MOD_ID, "wasted_staff"),
                new WastedStaffItem(MythicManiaToolMaterials.WASTED_STAFF,2,0.8f, new Item.Settings().maxCount(1))
        );

        SHOCK_STAFF = Registry.register(
                Registries.ITEM,
                new Identifier(MythicMania.MOD_ID, "shock_staff"),
                new ShockStaffItem(MythicManiaToolMaterials.SHOCK_BOLT_STAFF,1,0.8f, new Item.Settings().maxCount(1), 10, 1, false)
        );

        SHOCK_BOLT_STAFF = Registry.register(
                Registries.ITEM,
                new Identifier(MythicMania.MOD_ID, "shock_bolt_staff"),
                new ShockStaffItem(MythicManiaToolMaterials.SHOCK_BOLT_STAFF,1,0.8f, new Item.Settings().maxCount(1), 20, 3, true)
        );
    }

    public static void registerToolTab() {
        NUCLEAR_PICKAXE = Registry.register(
                Registries.ITEM,
                new Identifier(MythicMania.MOD_ID, "nuclear_pickaxe"),
                new CustomPickaxeItem(MythicManiaToolMaterials.NUCLEAR, 4, 2, new Item.Settings())
        );

        NUCLEAR_AXE = Registry.register(
                Registries.ITEM,
                new Identifier(MythicMania.MOD_ID, "nuclear_axe"),
                new CustomAxeItem(MythicManiaToolMaterials.NUCLEAR, 5, 2, new Item.Settings())
        );

        NUCLEAR_HOE = Registry.register(
                Registries.ITEM,
                new Identifier(MythicMania.MOD_ID, "nuclear_hoe"),
                new CustomHoeItem(MythicManiaToolMaterials.NUCLEAR, 1, 2, new Item.Settings())
        );

        NUCLEAR_SHOVEL = Registry.register(
                Registries.ITEM,
                new Identifier(MythicMania.MOD_ID, "nuclear_shovel"),
                new ShovelItem(MythicManiaToolMaterials.NUCLEAR, 1, 2, new Item.Settings())
        );

        RUINOUS_AXE = Registry.register(
                Registries.ITEM,
                new Identifier(MythicMania.MOD_ID, "ruinous_axe"),
                new CustomAxeItem(MythicManiaToolMaterials.RUINOUS, 5, 2, new Item.Settings())
        );

        RUINOUS_SHOVEL = Registry.register(
                Registries.ITEM,
                new Identifier(MythicMania.MOD_ID, "ruinous_shovel"),
                new ShovelItem(MythicManiaToolMaterials.RUINOUS, 3, 2, new Item.Settings())
        );

        RUINOUS_PICKAXE = Registry.register(
                Registries.ITEM,
                new Identifier(MythicMania.MOD_ID, "ruinous_pickaxe"),
                new CustomPickaxeItem(MythicManiaToolMaterials.RUINOUS, 2, 2, new Item.Settings())
        );

        RUINOUS_HOE = Registry.register(
                Registries.ITEM,
                new Identifier(MythicMania.MOD_ID, "ruinous_hoe"),
                new CustomHoeItem(MythicManiaToolMaterials.RUINOUS, 1, 2, new Item.Settings())
        );
    }

    public static void registerBlockItems() {
        RINTH = Registry.register(
                Registries.ITEM,
                new Identifier(MythicMania.MOD_ID, "rinth"),
                new BlockItem(MythicManiaBlocks.RINTH_BLOCK, new Item.Settings())
        );

        ANCIENT_ALTAR = Registry.register(
                Registries.ITEM,
                new Identifier(MythicMania.MOD_ID, "ancient_altar"),
                new BlockItem(MythicManiaBlocks.ANCIENT_ALTAR, new Item.Settings())
        );

        TOXIC_ORE = Registry.register(
                Registries.ITEM,
                new Identifier(MythicMania.MOD_ID, "toxic_ore"),
                new BlockItem(MythicManiaBlocks.TOXIC_ORE, new Item.Settings())
        );

        RUINED_ORE = Registry.register(
                Registries.ITEM,
                new Identifier(MythicMania.MOD_ID, "ruined_ore"),
                new BlockItem(MythicManiaBlocks.RUINED_ORE, new Item.Settings())
        );

        BLACKSTONE_RUINED_ORE = Registry.register(
                Registries.ITEM,
                new Identifier(MythicMania.MOD_ID, "blackstone_ruined_ore"),
                new BlockItem(MythicManiaBlocks.BLACKSTONE_RUINED_ORE, new Item.Settings())
        );

        PULSATING_BLACKSTONE = Registry.register(
                Registries.ITEM,
                new Identifier(MythicMania.MOD_ID, "pulsating_blackstone"),
                new BlockItem(MythicManiaBlocks.PULSATING_BLACKSTONE, new Item.Settings())
        );

        LUMINESCENT_SAC = Registry.register(
                Registries.ITEM,
                new Identifier(MythicMania.MOD_ID, "luminescent_sac"),
                new BlockItem(MythicManiaBlocks.LUMINESCENT_SAC, new Item.Settings())
        );

        ORBITER_PROJECTILE = Registry.register(
                Registries.ITEM,
                new Identifier(MythicMania.MOD_ID, "orbiter_projectile"),
                new BlockItem(MythicManiaBlocks.ORBITER_PROJECTILE, new Item.Settings())
        );

        TOXIC_ORBITER_PROJECTILE = Registry.register(
                Registries.ITEM,
                new Identifier(MythicMania.MOD_ID, "toxic_orbiter_projectile"),
                new BlockItem(MythicManiaBlocks.TOXIC_ORBITER_PROJECTILE, new Item.Settings())
        );
    }

    public static void registerSpawnEggs() {
        MAGICAL_GRUB_SPAWN_EGG = Registry.register(Registries.ITEM, new Identifier(MythicMania.MOD_ID, "magical_grub_spawn_egg"),
            new SpawnEggItem(
                MythicManiaEntityTypes.MAGICAL_GRUB_ENTITY, 0x7ff8eb, 0x7EBADA,
                new Item.Settings()
            )
        );

        POISONOUS_GRUB_SPAWN_EGG = Registry.register(Registries.ITEM, new Identifier(MythicMania.MOD_ID, "poisonous_grub_spawn_egg"),
            new SpawnEggItem(
                MythicManiaEntityTypes.POISONOUS_GRUB_ENTITY, 0x48906D, 0x99FF9E,
                new Item.Settings()
            )
        );

        ZAPPING_BEETLE_SPAWN_EGG = Registry.register(Registries.ITEM, new Identifier(MythicMania.MOD_ID, "zapping_beetle_spawn_egg"),
            new SpawnEggItem(
                MythicManiaEntityTypes.ZAPPING_BEETLE_ENTITY, 0x3991d0, 0xF0D538,
                new Item.Settings()
            )
        );

        WASTED_DEMON_SPAWN_EGG = Registry.register(Registries.ITEM, new Identifier(MythicMania.MOD_ID, "wasted_demon_spawn_egg"),
            new SpawnEggItem(
                MythicManiaEntityTypes.WASTED_DEMON_ENTITY, 0x2a2a2a, 0x951010,
                new Item.Settings()
            )
        );

        NOXIOUS_SPIRIT_SPAWN_EGG = Registry.register(Registries.ITEM, new Identifier(MythicMania.MOD_ID, "noxious_spirit_spawn_egg"),
            new SpawnEggItem(
                    MythicManiaEntityTypes.NOXIOUS_SPIRIT_ENTITY, 0x35323e, 0x598f2f,
                    new Item.Settings()
            )
        );


        DEMON_GUARDIAN_SPAWN_EGG = Registry.register(Registries.ITEM, new Identifier(MythicMania.MOD_ID, "demon_guardian_spawn_egg"),
            new SpawnEggItem(
                MythicManiaEntityTypes.DEMON_GUARDIAN_ENTITY, 0x493C3A, 0xE7561B,
                new Item.Settings()
            )
        );

        ORBITER_SPAWN_EGG = Registry.register(Registries.ITEM, new Identifier(MythicMania.MOD_ID, "orbiter_spawn_egg"),
            new SpawnEggItem(
                MythicManiaEntityTypes.ORBITER_ENTITY, 0x494343, 0xdd693d,
                new Item.Settings()
            )
        );

        TOXIC_ORBITER_SPAWN_EGG = Registry.register(Registries.ITEM, new Identifier(MythicMania.MOD_ID, "toxic_orbiter_spawn_egg"),
            new SpawnEggItem(
                MythicManiaEntityTypes.TOXIC_ORBITER_ENTITY, 0x598f2f, 0x35323e,
                new Item.Settings()
            )
        );

        WASTREL_GLIDER_SPAWN_EGG = Registry.register(Registries.ITEM, new Identifier(MythicMania.MOD_ID, "wastrel_glider_spawn_egg"),
            new SpawnEggItem(
                MythicManiaEntityTypes.WASTREL_GLIDER_ENTITY, 0xa92b2b, 0x343337,
                new Item.Settings()
            )
        );
    }

    public static void registerItems() {
        registerFoodTab();
        registerItemTab();
        registerCombatTab();
        registerToolTab();
    }
}
