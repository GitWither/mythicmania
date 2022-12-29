package daniel.mythicmania.item.combat;

import daniel.mythicmania.client.sound.MythicManiaSoundEvents;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class ShockBoltStaffItem extends SwordItem {
    public ShockBoltStaffItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient) {
            world.playSound(null, user.getX(), user.getY(), user.getZ(), MythicManiaSoundEvents.SHOCK_BOLT_STAFF_FIRE, SoundCategory.NEUTRAL, 0.7F, 2.5F);
            user.getItemCooldownManager().set(this, 8);

            for (int x = 1; x < 2; x++) {
                System.out.println("Staff has been fired!");
            }
        }

        return super.use(world, user, hand);
    }
}
