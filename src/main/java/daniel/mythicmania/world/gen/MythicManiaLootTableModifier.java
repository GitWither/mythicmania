package daniel.mythicmania.world.gen;

import daniel.mythicmania.item.MythicManiaItems;
import net.fabricmc.fabric.api.loot.v2.FabricLootTableBuilder;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.item.Item;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

public class MythicManiaLootTableModifier {
	public static void registerLootTableModifiers() {
		LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
//			appendItemToLootTable(LootTables.VILLAGE_DESERT_HOUSE_CHEST, MythicManiaItems.WASTED_ESSENCE, 0.4f, id, tableBuilder);
//			appendItemToLootTable(LootTables.ABANDONED_MINESHAFT_CHEST, MythicManiaItems.WASTED_ESSENCE, 0.4f, id, tableBuilder);
//			appendItemToLootTable(LootTables.VILLAGE_WEAPONSMITH_CHEST, MythicManiaItems.WASTED_ESSENCE, 0.6f, id, tableBuilder);
//			appendItemToLootTable(LootTables.VILLAGE_TOOLSMITH_CHEST, MythicManiaItems.WASTED_ESSENCE, 0.6f, id, tableBuilder);
//
//			appendItemToLootTable(LootTables.ANCIENT_CITY_CHEST, MythicManiaItems.CHARGED_RUINED_ORB, 0.5f, id, tableBuilder);
//			appendItemToLootTable(LootTables.ANCIENT_CITY_CHEST, MythicManiaItems.CHARGED_NUCLEAR_ORB, 0.5f, id, tableBuilder);
		});
	}

	// TODO: Refactor this system.
	public static void appendItemToLootTable(Identifier target, Item item, float chance, Identifier id, FabricLootTableBuilder tableBuilder) {
		if (!target.equals(id)) return;

		LootPool.Builder poolBuilder = LootPool.builder()
			.rolls(ConstantLootNumberProvider.create(1))
			.conditionally(RandomChanceLootCondition.builder(chance))
			.with(ItemEntry.builder(item))
			.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

		tableBuilder.pool(poolBuilder.build());
	}
}
