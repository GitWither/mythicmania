package daniel.mythicmania.entity.projectile;

import daniel.mythicmania.entity.MythicManiaEntityTypes;
import daniel.mythicmania.item.MythicManiaItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

public class ToxicOrbiterProjectileEntity extends ThrownItemEntity {
    public ToxicOrbiterProjectileEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public ToxicOrbiterProjectileEntity(World world, LivingEntity owner) {
        super(MythicManiaEntityTypes.TOXIC_ORBITER_PROJECTILE_ENTITY, owner, world);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        // TODO: This is a bit weird
        Entity entity = entityHitResult.getEntity();
        entity.damage(this.getDamageSources().magic(), 2);
        ((LivingEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 20 * 3, 0));

        super.onEntityHit(entityHitResult);
    }

    @Override
    protected Item getDefaultItem() {
        return MythicManiaItems.TOXIC_ORBITER_PROJECTILE;
    }

    @Override
    protected float getGravity() {
        return 0.04f;
    }
}