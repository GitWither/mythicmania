package daniel.mythicmania.entity.goals;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;

public class SummonMinionGoal extends Goal {
    private final HostileEntity mob;
    private final EntityType<? extends LivingEntity> minion;
    private final int numberOfMinions;
    private int cooldown = 0;

    public SummonMinionGoal(HostileEntity mob, EntityType<? extends LivingEntity> minion, int numberOfMinions) {
        this.mob = mob;
        this.minion = minion;
        this.numberOfMinions = numberOfMinions;
    }

    @Override
    public boolean canStart() {
        return mob != null && mob.getHealth() < mob.getMaxHealth();
    }

    @Override
    public void tick() {
        cooldown++;
        World world = mob.getWorld();

        if (canSpawnMinions(world)) {
            for (int i = 0; i < numberOfMinions + world.random.nextInt(3); i++) {
                Entity minionEntity = minion.create(world);
                if (minionEntity == null) return;
                minionEntity.refreshPositionAndAngles(mob.getX(), mob.getY(), mob.getZ(), mob.getYaw(), 0.0F);
                world.spawnEntity(minionEntity);
            }

            cooldown = 0;
        }
    }

    public boolean canSpawnMinions(World world) {
        return !world.isClient && cooldown % 40 == 0 && world.random.nextInt(6) == 0;
    }
}