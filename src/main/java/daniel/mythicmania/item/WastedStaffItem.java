package daniel.mythicmania.item;

import daniel.mythicmania.entity.WastedStaffChargeEntity;
import daniel.mythicmania.entity.WaterParcelEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class WastedStaffItem extends SwordItem {
    public WastedStaffItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        int duration = 20 * 5;
        final StatusEffectInstance absorption = new StatusEffectInstance(StatusEffects.ABSORPTION, duration, 0);

        attacker.addStatusEffect(absorption);
        target.setOnFireFor(6);

        return super.postHit(stack, target, attacker);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient) {
            world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_WITHER_SHOOT, SoundCategory.NEUTRAL, 0.5F, 1F);

            user.getItemCooldownManager().set(this, 6);

            ItemStack itemStack = new ItemStack(MythicManiaItems.WASTED_STAFF_CHARGE);
            WastedStaffChargeEntity projectile = new WastedStaffChargeEntity(world, user);
            projectile.setItem(itemStack);
            projectile.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 0.6F, 0F);
            world.spawnEntity(projectile);
        }

        return super.use(world, user, hand);
    }
}