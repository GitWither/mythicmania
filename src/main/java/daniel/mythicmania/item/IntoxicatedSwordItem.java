package daniel.mythicmania.item;

import daniel.mythicmania.particle.MythicManiaParticles;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.server.world.ServerWorld;

import java.util.List;

public class IntoxicatedSwordItem extends SwordItem {
    public IntoxicatedSwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        ServerWorld world = (ServerWorld) target.getWorld();
        world.spawnParticles(MythicManiaParticles.POISON_CLOUD, target.getX(), target.getY() + target.getEyeHeight(target.getPose()), target.getZ(), 10, 0.5, 0.2, 0.5, 0.01);
        List<Entity> entities = world.getOtherEntities(target, target.getBoundingBox().expand(2), EntityPredicates.VALID_LIVING_ENTITY);
        for (Entity entity : entities) {
            if (entity == attacker) continue;
            StatusEffectInstance poison = new StatusEffectInstance(StatusEffects.POISON, 7 * 20, 1);
            ((LivingEntity)entity).addStatusEffect(poison);
        }

        return super.postHit(stack, target, attacker);
    }
}
