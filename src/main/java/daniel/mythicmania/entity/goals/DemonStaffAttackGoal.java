package daniel.mythicmania.entity.goals;

import daniel.mythicmania.entity.mob.WastedDemonEntity;
import daniel.mythicmania.entity.projectile.WastedStaffChargeEntity;
import daniel.mythicmania.item.MythicManiaItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

// TODO: reference ghast to make more accurate
public class DemonStaffAttackGoal extends Goal {
    private final WastedDemonEntity demon;
    private int cooldown = 0;

    public DemonStaffAttackGoal(WastedDemonEntity demon) {
        this.demon = demon;
    }

    @Override
    public boolean canStart() {
        return demon != null && demon.getTarget() != null;
    }

    @Override
    public void tick() {
        cooldown++;
        World world = demon.getWorld();
        ItemStack itemStack = new ItemStack(MythicManiaItems.WASTED_STAFF_CHARGE);
        WastedStaffChargeEntity projectile = new WastedStaffChargeEntity(world, demon);

        if (world.random.nextInt(4) == 0 && cooldown % 15 == 0) {
            handleAndShootProjectile(projectile, itemStack, demon, world);
            cooldown = 0;
        }
    }

    public void handleAndShootProjectile(WastedStaffChargeEntity projectile, ItemStack itemStack, WastedDemonEntity user, World world) {
        LivingEntity target = demon.getTarget();

        double xPos = target.getX() - demon.getX();
        double yPos = target.getBodyY(0.3) - projectile.getY();
        double zPos = target.getZ() - demon.getZ();
        double calc = Math.sqrt(xPos * xPos + zPos * zPos);

        projectile.setItem(itemStack);
        projectile.setVelocity(xPos, (yPos + calc * 0.2) - 2, zPos, 1.6F, (float)(14 - demon.getWorld().getDifficulty().getId() * 4));
        world.spawnEntity(projectile);
    }
}