package daniel.mythicmania.entity.goals;

import daniel.mythicmania.entity.AbstractFlyingEntity;
import net.minecraft.entity.ai.NoPenaltySolidTargeting;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;

public class FlyingEntityWanderAroundGoal extends Goal {
	AbstractFlyingEntity beetle;

	public FlyingEntityWanderAroundGoal(PassiveEntity beetle) {
		this.setControls(EnumSet.of(Goal.Control.MOVE));
		this.beetle = (AbstractFlyingEntity) beetle;
	}

	@Override
	public boolean canStart() {
		World world = beetle.getWorld();
		return beetle.getNavigation().isIdle() && world.random.nextInt(10) == 0;
	}

	@Override
	public boolean shouldContinue() {
		return beetle.getNavigation().isFollowingPath();
	}

	@Override
	public void start() {
		Vec3d vec3d = this.getRandomLocation();
		if (vec3d == null) return;

		// TODO: Look over and change if necessary
		beetle.getNavigation().startMovingAlong(beetle.getNavigation().findPathTo(new BlockPos((int) vec3d.x, (int) vec3d.y, (int) vec3d.z), 1), 1.0);
	}

	@Nullable
	private Vec3d getRandomLocation() {
		Vec3d direction = beetle.getRotationVec(0.0f);
		return NoPenaltySolidTargeting.find(beetle, 8, 8, -2, direction.x, direction.z, 1.5707963705062866);
	}
}