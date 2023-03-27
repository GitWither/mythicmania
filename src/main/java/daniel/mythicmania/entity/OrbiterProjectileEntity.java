package daniel.mythicmania.entity;

import daniel.mythicmania.item.MythicManiaItems;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageEffects;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.server.command.DamageCommand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class OrbiterProjectileEntity extends ThrownItemEntity {
    public OrbiterProjectileEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public OrbiterProjectileEntity(World world, LivingEntity owner) {
        super(MythicManiaEntityTypes.ORBITER_PROJECTILE_ENTITY, owner, world);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        Entity entity = entityHitResult.getEntity();
        entity.damage(this.getDamageSources().magic(), 2);
        entity.setOnFireFor(2);
        super.onEntityHit(entityHitResult);
    }

    @Override
    protected Item getDefaultItem() {
        return MythicManiaItems.ORBITER_PROJECTILE;
    }

    @Override
    protected float getGravity() {
        return 0.04f;
    }
}