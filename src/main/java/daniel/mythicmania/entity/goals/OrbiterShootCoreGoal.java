package daniel.mythicmania.entity.goals;

import daniel.mythicmania.entity.mob.OrbiterEntity;
import daniel.mythicmania.entity.projectile.OrbiterProjectileEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class OrbiterShootCoreGoal extends Goal {
	private final OrbiterEntity orbiter;
	public int cooldown;
	private final ItemStack core;
	private final OrbiterProjectileEntity projectile;

	public OrbiterShootCoreGoal(OrbiterEntity orbiter, ItemStack core, OrbiterProjectileEntity projectile) {
		this.orbiter = orbiter;
		this.core = core;
		this.projectile = projectile;
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

		projectile.setItem(core);
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
