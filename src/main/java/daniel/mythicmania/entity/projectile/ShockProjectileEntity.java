package daniel.mythicmania.entity.projectile;

import daniel.mythicmania.entity.MythicManiaEntityTypes;
import daniel.mythicmania.item.MythicManiaItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ShockProjectileEntity extends ThrownItemEntity {
    private boolean isShockBoltEntity;

    public ShockProjectileEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public ShockProjectileEntity(World world, LivingEntity owner, boolean isShockBoltEntity) {
        super(MythicManiaEntityTypes.SHOCK_BOLT_ENTITY, owner, world);
        this.isShockBoltEntity = isShockBoltEntity;
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        StatusEffectInstance stunEffect = new StatusEffectInstance(StatusEffects.SLOWNESS, 20 * 15, 4, false, false, true);
        Entity target = entityHitResult.getEntity();

        if (isShockBoltEntity) {
            LightningEntity lightningEntity = EntityType.LIGHTNING_BOLT.create(world);
            BlockPos blockPos = target.getBlockPos();

            if (lightningEntity == null) return;

            lightningEntity.refreshPositionAfterTeleport(Vec3d.ofBottomCenter(blockPos.up()));
            lightningEntity.setChanneler(target instanceof ServerPlayerEntity ? (ServerPlayerEntity)target : null);

            if (!world.isClient) world.spawnEntity(lightningEntity);
        }

        if (!world.isClient) ((LivingEntity) target).addStatusEffect(stunEffect);

        this.kill();
        super.onEntityHit(entityHitResult);
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        this.kill();
        super.onCollision(hitResult);
    }

    @Override
    protected Item getDefaultItem() {
        return MythicManiaItems.SHOCK_BOLT;
    }

    @Override
    public void tick() {
        final boolean isIdle = (this.getVelocity().x == 0 || this.getVelocity().y == 0 || this.getVelocity().y == 0) && this.age > 5;
        if (isIdle) this.kill();
        super.tick();
    }

    @Override
    protected float getGravity() {
        return 0;
    }
}
