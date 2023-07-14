package daniel.mythicmania.item.combat;

import daniel.mythicmania.client.sound.MythicManiaSoundEvents;
import daniel.mythicmania.entity.projectile.WastedStaffChargeEntity;
import daniel.mythicmania.item.MythicManiaItems;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

// TODO: Make texture and add to game
public class RuinousDoubleswordItem extends RuinousSwordItem {
    protected static final StatusEffectInstance REGENERATION = new StatusEffectInstance(StatusEffects.REGENERATION, 20*2, 1);

    public RuinousDoubleswordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public StatusEffectInstance getRegenerationEffect() {
        return REGENERATION;
    }

    @Override
    public int getFireTime() {
        return 5;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!canShootProjectile(world, user))
            return TypedActionResult.pass(user.getStackInHand(hand));

        ItemStack itemStack = new ItemStack(MythicManiaItems.WASTED_STAFF_CHARGE);
        WastedStaffChargeEntity projectile = new WastedStaffChargeEntity(world, user);

        if (!user.getAbilities().creativeMode) {
            user.getItemCooldownManager().set(this, 40);
            user.getStackInHand(hand).damage(17, user, (p) -> p.sendToolBreakStatus(user.getActiveHand()));
        }

        WastedStaffItem.handleAndShootProjectile(projectile, itemStack, user, world);
        world.playSound(null, user.getX(), user.getY(), user.getZ(), MythicManiaSoundEvents.WASTED_STAFF_FIRE, SoundCategory.NEUTRAL, 0.7F, 1F);

        return TypedActionResult.success(user.getStackInHand(hand));
    }

    public static boolean canShootProjectile(World world, PlayerEntity user) {
        return !world.isClient && user.isSneaking();
    }
}
