package daniel.mythicmania.item;

import daniel.mythicmania.MythicMania;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class MythicManiaItemGroups {
        public static ItemGroup MYTHICMANIA_BLOCK_ITEM_GROUP;
        public static ItemGroup MYTHICMANIA_ITEMS_ITEM_GROUP;
        public static ItemGroup MYTHICMANIA_COMBAT_ITEM_GROUP;
        public static ItemGroup MYTHICMANIA_TOOLS_ITEM_GROUP;
        public static ItemGroup MYTHICMANIA_FOOD_ITEM_GROUP;

        public static void registerItemGroups() {
                MYTHICMANIA_ITEMS_ITEM_GROUP = Registry.register(
                        Registries.ITEM_GROUP,
                        new Identifier(MythicMania.MOD_ID, "mythicmania_misc_item_group"),

                        FabricItemGroup.builder()
                                .displayName(Text.translatable("itemGroup.mythicmania.misc"))
                                .icon(() -> new ItemStack(MythicManiaItems.EMPTY_ORB))

                                .entries((displayContext, entries) -> {
                                        entries.add(MythicManiaItems.EMPTY_ORB);
                                        entries.add(MythicManiaItems.CHARGED_NUCLEAR_ORB);
                                        entries.add(MythicManiaItems.CHARGED_RUINED_ORB);
                                        entries.add(MythicManiaItems.ORBITER_CORE);
                                        entries.add(MythicManiaItems.TOXIC_ORBITER_CORE);
                                        entries.add(MythicManiaItems.UNSTABLE_RUINOUS_THROWABLE);
                                        entries.add(MythicManiaItems.UNSTABLE_TOXIC_THROWABLE);
                                        entries.add(MythicManiaItems.POISON_SPIKE);
                                        entries.add(MythicManiaItems.GRUB_ESSENCE);
                                        entries.add(MythicManiaItems.TOXIC_PEBBLE);
                                        entries.add(MythicManiaItems.WASTED_ESSENCE);
                                        entries.add(MythicManiaItems.IRRADIATED_CRYSTAL);
                                        entries.add(MythicManiaItems.GLIDER_WING);
                                        entries.add(MythicManiaItems.WATER_PARCEL);
                                        entries.add(MythicManiaItems.CHARGE);
                                        entries.add(MythicManiaItems.WASTED_STAFF_CHARGE);
                                        entries.add(MythicManiaItems.SHOCK_BOLT);

                                        // Spawn eggs
                                        entries.add(MythicManiaItems.MAGICAL_GRUB_SPAWN_EGG);
                                        entries.add(MythicManiaItems.POISONOUS_GRUB_SPAWN_EGG);
                                        entries.add(MythicManiaItems.ZAPPING_BEETLE_SPAWN_EGG);
                                        entries.add(MythicManiaItems.WASTED_DEMON_SPAWN_EGG);
                                        entries.add(MythicManiaItems.DEMON_GUARDIAN_SPAWN_EGG);
                                        entries.add(MythicManiaItems.ORBITER_SPAWN_EGG);
                                        entries.add(MythicManiaItems.TOXIC_ORBITER_SPAWN_EGG);
                                        entries.add(MythicManiaItems.WASTREL_GLIDER_SPAWN_EGG);
                                }).build()
                );

                MYTHICMANIA_COMBAT_ITEM_GROUP = Registry.register(
                        Registries.ITEM_GROUP,
                        new Identifier(MythicMania.MOD_ID, "mythicmania_combat_item_group"),

                        FabricItemGroup.builder()
                                .displayName(Text.translatable("itemGroup.mythicmania.combat"))
                                .icon(() -> new ItemStack(MythicManiaItems.RUINOUS_SWORD))

                                .entries((displayContext, entries) -> {
                                        entries.add(MythicManiaItems.NUCLEAR_DAGGER);
                                        entries.add(MythicManiaItems.NUCLEAR_BLADE);
                                        entries.add(MythicManiaItems.NUCLEAR_SWORD);
                                        entries.add(MythicManiaItems.RUINOUS_SWORD);
                                        entries.add(MythicManiaItems.NUCLEAR_HELMET);
                                        entries.add(MythicManiaItems.NUCLEAR_CHESTPLATE);
                                        entries.add(MythicManiaItems.NUCLEAR_LEGGINGS);
                                        entries.add(MythicManiaItems.NUCLEAR_BOOTS);
                                        entries.add(MythicManiaItems.RUINOUS_HELMET);
                                        entries.add(MythicManiaItems.RUINOUS_CHESTPLATE);
                                        entries.add(MythicManiaItems.RUINOUS_LEGGINGS);
                                        entries.add(MythicManiaItems.RUINOUS_BOOTS);
                                        entries.add(MythicManiaItems.DEMON_VEST);
                                        entries.add(MythicManiaItems.WASTED_STAFF);
                                        entries.add(MythicManiaItems.SHOCK_STAFF);
                                        entries.add(MythicManiaItems.SHOCK_BOLT_STAFF);
                                }).build()
                );

                MYTHICMANIA_TOOLS_ITEM_GROUP = Registry.register(
                        Registries.ITEM_GROUP,
                        new Identifier(MythicMania.MOD_ID, "mythicmania_tools_item_group"),

                        FabricItemGroup.builder()
                                .displayName(Text.translatable("itemGroup.mythicmania.tools"))
                                .icon(() -> new ItemStack(MythicManiaItems.NUCLEAR_AXE))

                                .entries((displayContext, entries) -> {
                                        entries.add(MythicManiaItems.NUCLEAR_PICKAXE);
                                        entries.add(MythicManiaItems.NUCLEAR_AXE);
                                        entries.add(MythicManiaItems.NUCLEAR_HOE);
                                        entries.add(MythicManiaItems.NUCLEAR_SHOVEL);
                                        entries.add(MythicManiaItems.RUINOUS_PICKAXE);
                                        entries.add(MythicManiaItems.RUINOUS_AXE);
                                        entries.add(MythicManiaItems.RUINOUS_HOE);
                                        entries.add(MythicManiaItems.RUINOUS_SHOVEL);
                                }).build()
                );

                MYTHICMANIA_FOOD_ITEM_GROUP = Registry.register(
                        Registries.ITEM_GROUP,
                        new Identifier(MythicMania.MOD_ID, "mythicmania_food_item_group"),

                        FabricItemGroup.builder()
                                .displayName(Text.translatable("itemGroup.mythicmania.food"))
                                .icon(() -> new ItemStack(MythicManiaItems.TRIBUS_FRUIT))

                                .entries((displayContext, entries) -> {
                                        entries.add(MythicManiaItems.POISONOUS_BERRY);
                                        entries.add(MythicManiaItems.HEALING_BERRY);
                                        entries.add(MythicManiaItems.TRIBUS_FRUIT);
                                        entries.add(MythicManiaItems.ENCHANTED_TRIBUS_FRUIT);
                                }).build()
                );

                MYTHICMANIA_BLOCK_ITEM_GROUP = Registry.register(
                        Registries.ITEM_GROUP,
                        new Identifier(MythicMania.MOD_ID, "mythicmania_blocks_item_group"),

                        FabricItemGroup.builder()
                                .displayName(Text.translatable("itemGroup.mythicmania.blocks"))
                                .icon(() -> new ItemStack(MythicManiaItems.PULSATING_BLACKSTONE))

                                .entries((displayContext, entries) -> {
                                        entries.add(MythicManiaItems.RINTH);
                                        entries.add(MythicManiaItems.ANCIENT_ALTAR);
                                        entries.add(MythicManiaItems.TOXIC_ORE);
                                        entries.add(MythicManiaItems.RUINED_ORE);
                                        entries.add(MythicManiaItems.BLACKSTONE_RUINED_ORE);
                                        entries.add(MythicManiaItems.PULSATING_BLACKSTONE);
                                        entries.add(MythicManiaItems.LUMINESCENT_SAC);
                                }).build()
                );
        }
}
