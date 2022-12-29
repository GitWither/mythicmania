package daniel.mythicmania.entity;

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

public class ShockBoltEntity extends ThrownItemEntity {
    public ShockBoltEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public ShockBoltEntity(World world, LivingEntity owner) {
        super(MythicManiaEntityTypes.SHOCK_BOLT_ENTITY, owner, world);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        StatusEffectInstance stunEffect = new StatusEffectInstance(StatusEffects.SLOWNESS, 20 * 15, 4, false, false, true);
        Entity entity = entityHitResult.getEntity();

        if (!world.isClient) {
            ((LivingEntity) entity).addStatusEffect(stunEffect);
        }

        this.kill();
        super.onEntityHit(entityHitResult);
    }

    @Override
    protected Item getDefaultItem() {
        return MythicManiaItems.SHOCK_BOLT;
    }

    @Override
    protected float getGravity() {
        return 0;
    }
}
