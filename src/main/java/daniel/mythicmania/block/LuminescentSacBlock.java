package daniel.mythicmania.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

public class LuminescentSacBlock extends Block {
    public static final BooleanProperty isHanging = Properties.HANGING;

    public LuminescentSacBlock() {
        super(FabricBlockSettings.of(Material.PLANT, MapColor.BLUE).nonOpaque().sounds(BlockSoundGroup.SLIME));
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        if (ctx.getSide() == Direction.DOWN) return this.getDefaultState().with(isHanging, true);
        return this.getDefaultState().with(isHanging, true);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return !world.isAir(pos.up());
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(isHanging);
    }
}
