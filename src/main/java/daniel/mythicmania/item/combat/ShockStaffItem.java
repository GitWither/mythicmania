package daniel.mythicmania.item.combat;

import daniel.mythicmania.client.sound.MythicManiaSoundEvents;
import daniel.mythicmania.entity.projectile.ShockProjectileEntity;
import daniel.mythicmania.item.MythicManiaItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class ShockStaffItem extends SwordItem {
    private final int cooldown;
    private final int projectileCount;
    private final boolean isShockBoltStaff;

    public ShockStaffItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings, int cooldown, int projectileCount, boolean isShockBoltStaff) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
        this.cooldown = cooldown;
        this.projectileCount = projectileCount;
        this.isShockBoltStaff = isShockBoltStaff;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        final ItemStack shockBoltItem = new ItemStack(MythicManiaItems.SHOCK_BOLT);

        if (!user.getAbilities().creativeMode) {
            int slotWithShockBolt = user.getInventory().getSlotWithStack(shockBoltItem);
            if (slotWithShockBolt < 0) return TypedActionResult.pass(user.getStackInHand(hand));

            user.getInventory().getStack(slotWithShockBolt).decrement(1);
            user.getStackInHand(hand).damage(1, user, (p) -> p.sendToolBreakStatus(user.getActiveHand()));
            user.getItemCooldownManager().set(this, cooldown);
        }

        for (int i = 0; i < projectileCount; i++) {
            ShockProjectileEntity projectile = new ShockProjectileEntity(world, user, isShockBoltStaff);
            projectile.setItem(shockBoltItem);
            projectile.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 1, world.random.nextInt(4));
            world.spawnEntity(projectile);
        }

        world.playSound(null, user.getX(), user.getY(), user.getZ(), MythicManiaSoundEvents.SHOCK_BOLT_STAFF_FIRE, SoundCategory.NEUTRAL, 0.7F, 2.5F);

        // TODO: Are we sure about client/server safety?
        return super.use(world, user, hand);
    }
}
