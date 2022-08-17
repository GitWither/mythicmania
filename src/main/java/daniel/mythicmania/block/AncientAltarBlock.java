package daniel.mythicmania.block;

import daniel.mythicmania.block.entity.AncientAltarBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class AncientAltarBlock extends Block implements BlockEntityProvider {
    public AncientAltarBlock() {
        super(FabricBlockSettings.of(Material.STONE, MapColor.GRAY).nonOpaque().sounds(BlockSoundGroup.LODESTONE));
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new AncientAltarBlockEntity(pos, state);
    }
}
