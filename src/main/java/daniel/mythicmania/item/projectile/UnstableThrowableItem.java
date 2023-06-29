package daniel.mythicmania.item.projectile;

import daniel.mythicmania.entity.abstract_entity.AbstractUnstableThrowableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class UnstableThrowableItem extends Item {
	public UnstableThrowableItem(Settings settings) {
		super(settings);
	}

	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		ItemStack itemStack = user.getStackInHand(hand);

		if (!world.isClient) {
			ItemStack charge = getItem();
			AbstractUnstableThrowableEntity projectile = getEntity(world, user);
			projectile.setItem(charge);
			projectile.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 0.6F, 0F);
			world.spawnEntity(projectile);

			user.incrementStat(Stats.USED.getOrCreateStat(this));
			// TODO: This looks wrong
			if (!user.getAbilities().creativeMode) {
				itemStack.decrement(1);
				user.getItemCooldownManager().set(this, 4);
			}
		}

		return TypedActionResult.success(itemStack, !world.isClient());
	}

	public ItemStack getItem() {
		return null;
	}

	public AbstractUnstableThrowableEntity getEntity(World world, PlayerEntity player) {
		return null;
	}
}
