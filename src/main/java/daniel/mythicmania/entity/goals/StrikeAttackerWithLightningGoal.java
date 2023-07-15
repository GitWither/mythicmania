package daniel.mythicmania.entity.goals;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class StrikeAttackerWithLightningGoal extends Goal {
    private final PathAwareEntity mob;
    private int cooldown = 0;

    public StrikeAttackerWithLightningGoal(PathAwareEntity mob) {
        this.mob = mob;
    }

    @Override
    public boolean canStart() {
        return mob != null && mob.getTarget() != null;
    }

    @Override
    public void tick() {
        cooldown++;

        LivingEntity target = mob.getTarget();
        World world = mob.getWorld();

        // TODO: Fix isCloseToTarget() method and use here
        if (world.random.nextInt(8) == 0 && cooldown % 35 == 0) {
            LightningEntity lightningEntity = EntityType.LIGHTNING_BOLT.create(mob.getWorld());
            BlockPos blockPos = target.getBlockPos();

            if (lightningEntity == null) return;

            lightningEntity.refreshPositionAfterTeleport(Vec3d.ofBottomCenter(blockPos.up()));
            lightningEntity.setChanneler(target instanceof ServerPlayerEntity ? (ServerPlayerEntity) target : null);

            if (!mob.getWorld().isClient) mob.getWorld().spawnEntity(lightningEntity);

            cooldown = 0;
        }
    }
}