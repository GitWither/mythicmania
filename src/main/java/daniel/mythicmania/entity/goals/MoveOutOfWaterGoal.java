package daniel.mythicmania.entity.goals;

import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;

public class MoveOutOfWaterGoal extends Goal {
	private final PathAwareEntity mob;

	public MoveOutOfWaterGoal(PathAwareEntity mob) {
		this.mob = mob;
	}

	public boolean canStart() {
		return this.mob.isOnGround() && this.mob.world.getFluidState(this.mob.getBlockPos()).isIn(FluidTags.WATER);
	}

	public void start() {
		BlockPos blockPos = null;
		int startX = MathHelper.floor(this.mob.getX() - 2.0);
		int startY = MathHelper.floor(this.mob.getY() - 2.0);
		int startZ = MathHelper.floor(this.mob.getZ() - 2.0);
		int endX = MathHelper.floor(this.mob.getX() + 2.0);
		int endY = this.mob.getBlockY();
		int endZ = MathHelper.floor(this.mob.getZ() + 2.0);

		Iterable<BlockPos> blockReplaceList = BlockPos.iterate(startX, startY, startZ, endX, endY, endZ);

		// TODO: Review this for loop to see if it's ok
		for (BlockPos pos : blockReplaceList) {
			if (!this.mob.world.getFluidState(pos).isIn(FluidTags.WATER)) {
				blockPos = pos;
				break;
			}
		}

		if (blockPos != null) {
			this.mob.getMoveControl().moveTo(blockPos.getX(), blockPos.getY(), blockPos.getZ(), 1.4);
		}
	}
}