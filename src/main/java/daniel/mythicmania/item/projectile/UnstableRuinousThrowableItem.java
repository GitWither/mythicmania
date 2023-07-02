package daniel.mythicmania.item.projectile;

import daniel.mythicmania.entity.abstract_entity.AbstractUnstableThrowableEntity;
import daniel.mythicmania.entity.projectile.UnstableRuinousThrowableEntity;
import daniel.mythicmania.item.MythicManiaItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class UnstableRuinousThrowableItem extends UnstableThrowableItem {
	public UnstableRuinousThrowableItem(Settings settings) {
		super(settings);
	}

	@Override
	public ItemStack getItem() {
		return new ItemStack(MythicManiaItems.UNSTABLE_RUINOUS_THROWABLE);
	}

	@Override
	public AbstractUnstableThrowableEntity getEntity(World world, PlayerEntity player) {
		return new UnstableRuinousThrowableEntity(world, player);
	}
}
