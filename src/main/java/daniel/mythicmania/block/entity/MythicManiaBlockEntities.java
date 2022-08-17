package daniel.mythicmania.block.entity;


import daniel.mythicmania.MythicMania;
import daniel.mythicmania.block.MythicManiaBlocks;
import daniel.mythicmania.client.render.block.entity.AncientAltarBlockEntityRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public final class MythicManiaBlockEntities {

    public static final BlockEntityType<AncientAltarBlockEntity> ANCIENT_ALTAR = Registry.register(
            Registry.BLOCK_ENTITY_TYPE,
            new Identifier(MythicMania.MOD_ID, "ancient_altar"),
            FabricBlockEntityTypeBuilder.create(AncientAltarBlockEntity::new, MythicManiaBlocks.ANCIENT_ALTAR).build()
    );

    public static void registerBlockEntityRendering() {
        BlockEntityRendererRegistry.register(ANCIENT_ALTAR, AncientAltarBlockEntityRenderer::new);
    }
}
