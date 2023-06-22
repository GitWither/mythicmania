package daniel.mythicmania.entity.goals;

import daniel.mythicmania.entity.projectile.OrbiterProjectileEntity;
import daniel.mythicmania.item.MythicManiaItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

// TODO: Duplicate of OrbiterShootCoreGoal. Look into reusing that goal and solving error of identical UUID
public class ToxicOrbiterShootCoreGoal extends Goal {
	private final PathAwareEntity orbiter;
	public int cooldown;

	public ToxicOrbiterShootCoreGoal(PathAwareEntity orbiter) {
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
		ItemStack charge = new ItemStack(MythicManiaItems.CHARGED_NUCLEAR_ORB);
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

