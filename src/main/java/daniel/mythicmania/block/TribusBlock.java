package daniel.mythicmania.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;

public class TribusBlock extends Block {
    public TribusBlock() {
        super(FabricBlockSettings.of(Material.PLANT, MapColor.GREEN).nonOpaque().sounds(BlockSoundGroup.AZALEA_LEAVES));
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
}