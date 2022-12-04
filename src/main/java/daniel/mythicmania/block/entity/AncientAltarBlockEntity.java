package daniel.mythicmania.block.entity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.util.Clearable;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class AncientAltarBlockEntity extends BlockEntity implements Clearable {
    ItemStack currentOrb = ItemStack.EMPTY;

    public AncientAltarBlockEntity(BlockPos pos, BlockState state) {
        super(MythicManiaBlockEntities.ANCIENT_ALTAR, pos, state);
    }

    public void setOrb(ItemStack orb, PlayerEntity player) {
        this.currentOrb = orb;
        this.markDirty();
        this.world.updateListeners(this.pos, this.getCachedState(), this.getCachedState(), Block.NOTIFY_ALL);
    }

    public ItemStack getOrb() {
        return this.currentOrb;
    }

    @Override
    public void clear() {
        this.setOrb(ItemStack.EMPTY, null);
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt() {
        return createNbt();
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);

        NbtCompound itemCompound = new NbtCompound();
        nbt.put("Orb", this.currentOrb.writeNbt(itemCompound));
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);

        this.currentOrb = ItemStack.fromNbt(nbt.getCompound("Orb"));
    }
}
