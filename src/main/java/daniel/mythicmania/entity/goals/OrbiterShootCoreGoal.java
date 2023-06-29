package daniel.mythicmania.entity.goals;

import daniel.mythicmania.entity.projectile.OrbiterProjectileEntity;
import daniel.mythicmania.item.MythicManiaItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class OrbiterShootCoreGoal extends Goal {
	private final PathAwareEntity orbiter;
	public int cooldown;
	public final boolean isToxicGoal;

	public OrbiterShootCoreGoal(PathAwareEntity orbiter, boolean isToxicGoal) {
		this.orbiter = orbiter;
		this.isToxicGoal = isToxicGoal;
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
		ItemStack charge = new ItemStack(isToxicGoal ? MythicManiaItems.TOXIC_ORBITER_PROJECTILE : MythicManiaItems.ORBITER_PROJECTILE);

		OrbiterProjectileEntity projectile = new OrbiterProjectileEntity(world, this.orbiter); // come back to
		projectile.setItem(charge);
		projectile.setVelocity(this.orbiter, this.orbiter.getPitch(), this.orbiter.getYaw(), 0.0F, 0.72F, 0F);

		// TODO: Is this logic okay?
		if (attackTarget == null || !canAttack(attackTarget)) return;
		++this.cooldown;

		if (this.cooldown == 15) {
			world.spawnEntity(projectile);
			this.cooldown = 0;
		}
	}

	private boolean canAttack(LivingEntity target) {
		return target.squaredDistanceTo(this.orbiter) < 81 && this.orbiter.canSee(target);
	}
}
