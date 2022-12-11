package daniel.mythicmania.entity;

import daniel.mythicmania.item.MythicManiaItems;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class WastedStaffChargeEntity extends ThrownItemEntity {
    public WastedStaffChargeEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public WastedStaffChargeEntity(World world, LivingEntity owner) {
        super(MythicManiaEntityTypes.WASTED_STAFF_CHARGE_ENTITY, owner, world);
    }

    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        Explosion.DestructionType destructionType = this.world.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING) ? Explosion.DestructionType.DESTROY : Explosion.DestructionType.NONE;

        if (!world.isClient) {
            this.world.createExplosion(this, this.getX(), this.getY(), this.getZ(), 2, destructionType);
            this.kill();
        }
    }

    @Override
    protected Item getDefaultItem() {
        return MythicManiaItems.WATER_PARCEL;
    }

    @Override
    protected float getGravity() {
        return 0;
    }
}