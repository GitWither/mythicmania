package daniel.mythicmania;

import daniel.mythicmania.block.HarvesterBlock;
import daniel.mythicmania.block.RinthBlock;
import daniel.mythicmania.entity.AbstractGrubEntity;
import daniel.mythicmania.entity.MagicalGrubEntity;
import daniel.mythicmania.entity.MythicManiaEntityTypes;
import daniel.mythicmania.entity.PoisonousGrubEntity;
import daniel.mythicmania.item.*;
import daniel.mythicmania.item.FoodComponents;
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

    @Override
    public void onInitialize() {
        MythicManiaItems.registerBlockItems();
        MythicManiaItems.registerSpawnEggs();

        MythicManiaEntityTypes.registerEntityAttributes();
    }
}
