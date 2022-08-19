package daniel.mythicmania.block;

import daniel.mythicmania.block.entity.AncientAltarBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class AncientAltarBlock extends HorizontalFacingBlock implements BlockEntityProvider {
    public AncientAltarBlock() {
        super(FabricBlockSettings.of(Material.STONE, MapColor.GRAY).nonOpaque().sounds(BlockSoundGroup.LODESTONE));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(HorizontalFacingBlock.FACING);
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerFacing());
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new AncientAltarBlockEntity(pos, state);
    }
}
