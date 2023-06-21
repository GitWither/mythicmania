package daniel.mythicmania.entity.goals;

import daniel.mythicmania.entity.OrbiterEntity;
import daniel.mythicmania.entity.OrbiterProjectileEntity;
import daniel.mythicmania.item.MythicManiaItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ShootCoreGoal extends Goal {
	private final OrbiterEntity orbiter;
	public int cooldown;

	public ShootCoreGoal(OrbiterEntity orbiter) {
		this.orbiter = orbiter;
	}

	@Override
	public boolean canStart() {
		return this.orbiter.getTarget() != null;
	}

	@Override
	public void start() {
		this.cooldown = 0;
	}

	@Override
	public void tick() {
		World world = orbiter.getWorld();
		LivingEntity attackTarget = this.orbiter.getTarget();

		ItemStack charge = new ItemStack(MythicManiaItems.ORBITER_PROJECTILE);
		OrbiterProjectileEntity projectile = new OrbiterProjectileEntity(world, this.orbiter);
		projectile.setItem(charge);
		projectile.setVelocity(this.orbiter, this.orbiter.getPitch(), this.orbiter.getYaw(), 0.0F, 0.72F, 0F);

		if (attackTarget == null) return;

		// TODO: Awkward. Rewrite
		if (attackTarget.squaredDistanceTo(this.orbiter) < 81 && this.orbiter.canSee(attackTarget)) {
			++this.cooldown;

			if (this.cooldown == 15) {
				world.spawnEntity(projectile);
				this.cooldown = 0;
			}
		} else if (this.cooldown > 0) {
			--this.cooldown;
		}
	}
}
