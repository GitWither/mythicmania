package daniel.mythicmania.item.combat;

import daniel.mythicmania.particle.MythicManiaParticles;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.server.world.ServerWorld;

import java.util.List;

public class NuclearSwordItem extends SwordItem {
    private final int poisonOtherEntitiesDuration;
    private final int poisonOtherEntitiesAmplifier;
    private final int poisonDirectTargetDuration;
    private final int poisonDirectTargetAmplifier;
    private final int targetBox;

    public NuclearSwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings, int poisonOtherEntitiesDuration, int poisonOtherEntitiesAmplifier, int poisonDirectTargetDuration, int poisonDirectTargetAmplifier, int targetBox) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
        this.poisonOtherEntitiesDuration = poisonOtherEntitiesDuration;
        this.poisonOtherEntitiesAmplifier = poisonOtherEntitiesAmplifier;
        this.poisonDirectTargetDuration = poisonDirectTargetDuration;
        this.poisonDirectTargetAmplifier = poisonDirectTargetAmplifier;
        this.targetBox = targetBox;
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        StatusEffectInstance otherEntitiesPoison = new StatusEffectInstance(StatusEffects.POISON, poisonOtherEntitiesDuration, poisonOtherEntitiesAmplifier);
        StatusEffectInstance directTargetPoison = new StatusEffectInstance(StatusEffects.POISON, poisonDirectTargetDuration, poisonDirectTargetAmplifier);

        ServerWorld world = (ServerWorld) target.getWorld();
        world.spawnParticles(MythicManiaParticles.POISON_CLOUD, target.getX(), target.getY() + target.getEyeHeight(target.getPose()), target.getZ(), 10, 0.5, 0.2, 0.5, 0.01);
        List<Entity> entities = world.getOtherEntities(target, target.getBoundingBox().expand(targetBox), EntityPredicates.VALID_LIVING_ENTITY);

        for (Entity entity : entities) {
            if (entity == attacker || entity instanceof PlayerEntity || entity instanceof PassiveEntity) continue;
            ((LivingEntity)entity).addStatusEffect(otherEntitiesPoison);
        }

        target.addStatusEffect(directTargetPoison);

        return super.postHit(stack, target, attacker);
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }
}
