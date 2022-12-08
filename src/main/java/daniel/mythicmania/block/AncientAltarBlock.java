package daniel.mythicmania.block;

import daniel.mythicmania.block.entity.AncientAltarBlockEntity;
import daniel.mythicmania.item.MythicManiaItems;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class AncientAltarBlock extends HorizontalFacingBlock implements BlockEntityProvider {
    public AncientAltarBlock() {
        super(FabricBlockSettings.of(Material.STONE, MapColor.GRAY).nonOpaque().requiresTool().strength(3.0f, 3.0f).sounds(BlockSoundGroup.LODESTONE));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(HorizontalFacingBlock.FACING);
    }

    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        double d = (double)pos.getX() + random.nextDouble();
        double e = (double)pos.getY() + 0.8;
        double f = (double)pos.getZ() + random.nextDouble();
        world.addParticle(ParticleTypes.ENCHANT, d, e, f, 0.0, 1.0, 0.0);
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerFacing());
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack stack = player.getStackInHand(hand);

        if (stack.getItem() == MythicManiaItems.CHARGED_INTOXICATED_ORB || stack.getItem() == MythicManiaItems.CHARGED_LOCH_ORB || stack.getItem() == MythicManiaItems.CHARGED_RUINED_ORB) {
            if (!world.isClient) {
                BlockEntity blockEntity = world.getBlockEntity(pos);

                if (blockEntity instanceof AncientAltarBlockEntity altarBlockEntity) {
                    if (!altarBlockEntity.getOrb().isOf(stack.getItem())) {
                        altarBlockEntity.setOrb(player.getStackInHand(hand).copy(), player);
                        world.playSound(null, pos, SoundEvents.BLOCK_END_PORTAL_FRAME_FILL, SoundCategory.BLOCKS, 1, 1);
                    }
                }
            }

            return ActionResult.success(world.isClient);
        }

        return super.onUse(state, world, pos, player, hand, hit);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new AncientAltarBlockEntity(pos, state);
    }
}
