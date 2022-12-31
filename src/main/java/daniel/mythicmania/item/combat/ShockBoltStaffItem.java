package daniel.mythicmania.item.combat;

import daniel.mythicmania.client.sound.MythicManiaSoundEvents;
import daniel.mythicmania.entity.ShockBoltEntity;
import daniel.mythicmania.item.MythicManiaItems;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class ShockBoltStaffItem extends SwordItem {
    public ShockBoltStaffItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
//        if (world.isClient) return super.use(world, user, hand);

        final ItemStack shockBoltItem = new ItemStack(MythicManiaItems.SHOCK_BOLT);

        if (!user.getAbilities().creativeMode) {
            //User is not in creative, consume item
            int slotWithShockBolt = user.getInventory().getSlotWithStack(shockBoltItem);
            if (slotWithShockBolt < 0) return TypedActionResult.pass(user.getStackInHand(hand)); //return a pass, no ammunition is available, should try to use offhand item instead
            //(don't return super for SwordItem, those might get blocking again in the future, which will result in unexpect behavior)

            //You can store the ItemStacks in fields here, but it's not necessary, the compiler will optimize it anyways, so choose what's easier for you to read
            user.getInventory().getStack(slotWithShockBolt).decrement(1);
            user.getStackInHand(hand).damage(1, user, (p) -> p.sendToolBreakStatus(user.getActiveHand())); //use hand passed into method, or you may damage the wrong item
        }

        //If this code runs, all checks have been made, the user can shoot

        //Create new Projectiles and store in array
        ShockBoltEntity[] projectiles = {
                new ShockBoltEntity(world, user),
                new ShockBoltEntity(world, user),
                new ShockBoltEntity(world, user)
        };

        for (ShockBoltEntity projectile : projectiles) {
            projectile.setItem(shockBoltItem);
            projectile.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 1, world.random.nextInt(4));
            world.spawnEntity(projectile);
        }

        if (!user.getAbilities().creativeMode) user.getItemCooldownManager().set(this, 8); //people don't like cooldowns in creative, just a suggestion
        world.playSound(null, user.getX(), user.getY(), user.getZ(), MythicManiaSoundEvents.SHOCK_BOLT_STAFF_FIRE, SoundCategory.NEUTRAL, 0.7F, 2.5F);

        return super.use(world, user, hand);
    }
}
