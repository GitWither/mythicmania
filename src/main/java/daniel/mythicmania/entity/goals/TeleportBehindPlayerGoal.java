package daniel.mythicmania.entity.goals;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

// TODO: Sometimes teleports in blocks if behind player is incline
public class TeleportBehindPlayerGoal extends Goal {
    private final PathAwareEntity mob;

    public TeleportBehindPlayerGoal(PathAwareEntity mob) {
        this.mob = mob;
    }

    @Override
    public boolean canStart() {
        return mob != null && mob.getAttacker() != null && mob.getPos() != null;
    }

    @Override
    public void tick() {
        LivingEntity attacker = mob.getAttacker();
        Vec3d pos = attacker.getPos();
        World world = mob.getWorld();

        int rand = world.random.nextInt(18);
        if (rand != 0) return;

        switch(attacker.getHorizontalFacing()) {
            case SOUTH -> mob.teleport(pos.x, pos.y, pos.z - (rand + 3));
            case NORTH -> mob.teleport(pos.x, pos.y, pos.z + (rand + 3));
            case EAST -> mob.teleport(pos.x - (rand + 3), pos.y, pos.z);
            case WEST -> mob.teleport(pos.x + (rand + 3), pos.y, pos.z);
        }
    }
}