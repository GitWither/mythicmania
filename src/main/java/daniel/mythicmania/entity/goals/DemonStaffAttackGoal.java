package daniel.mythicmania.entity.goals;

import daniel.mythicmania.entity.mob.WastedDemonEntity;
import daniel.mythicmania.entity.projectile.WastedStaffChargeEntity;
import daniel.mythicmania.item.MythicManiaItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3d;
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
        LivingEntity target = user.getTarget();
        Vec3d vec3d = user.getRotationVec(1.0F);

        double f = target.getX() - (user.getX() + vec3d.x * 4.0);
        double g = target.getBodyY(0.5) - (0.5 + user.getBodyY(0.5));
        double h = target.getZ() - (user.getZ() + vec3d.z * 4.0);

        projectile.setItem(itemStack);
        projectile.setVelocity(f, g + 1, h, 1.6F, (float)(14 - demon.getWorld().getDifficulty().getId() * 4));
        projectile.setPosition(user.getX() + vec3d.x * 4.0, user.getBodyY(0.5) + 0.5, projectile.getZ() + vec3d.z * 4.0);
        world.spawnEntity(projectile);
    }
}