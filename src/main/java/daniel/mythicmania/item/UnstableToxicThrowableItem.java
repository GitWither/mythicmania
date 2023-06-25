package daniel.mythicmania.item;

import daniel.mythicmania.entity.abstract_entity.AbstractUnstableThrowableEntity;
import daniel.mythicmania.entity.projectile.UnstableToxicThrowableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class UnstableToxicThrowableItem extends UnstableThrowableItem{
	public UnstableToxicThrowableItem(Settings settings) {
		super(settings);
	}

	@Override
	public ItemStack getItem() {
		return new ItemStack(MythicManiaItems.UNSTABLE_TOXIC_THROWABLE);
	}

	@Override
	public AbstractUnstableThrowableEntity getEntity(World world, PlayerEntity player) {
		return new UnstableToxicThrowableEntity(world, player);
	}
}
