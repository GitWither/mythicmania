package daniel.mythicmania.world.gen;

import daniel.mythicmania.item.MythicManiaItems;
import net.fabricmc.fabric.api.loot.v2.FabricLootTableBuilder;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.item.Item;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

public class MythicManiaLootTableModifier {
	public static void registerLootTableModifiers() {
		LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
			initLootTableModifier("chests/village/village_desert_house", MythicManiaItems.WASTED_ESSENCE, 0.4f, id, tableBuilder);
			initLootTableModifier("chests/abandoned_mineshaft", MythicManiaItems.WASTED_ESSENCE, 0.4f, id, tableBuilder);
			initLootTableModifier("chests/village/village_weaponsmith", MythicManiaItems.WASTED_ESSENCE, 0.6f, id, tableBuilder);
			initLootTableModifier("chests/village/village_toolsmith", MythicManiaItems.WASTED_ESSENCE, 0.6f, id, tableBuilder);

			initLootTableModifier("chests/ancient_city", MythicManiaItems.EMPTY_ORB, 1f, id, tableBuilder);
		});
	}

	// TODO: Refactor this system. Perhaps get rid of redundant parameters.
	public static void initLootTableModifier(String identifier,
									  Item item,
									  float chance,
									  Identifier id,
									  FabricLootTableBuilder tableBuilder) {
		final Identifier path = new Identifier(identifier);

		if (path.equals(id)) {
			LootPool.Builder poolBuilder = LootPool.builder()
				.rolls(ConstantLootNumberProvider.create(1))
				.conditionally(RandomChanceLootCondition.builder(chance))
				.with(ItemEntry.builder(item))
				.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

			tableBuilder.pool(poolBuilder.build());
		}
	}
}
