package daniel.mythicmania.entity.projectile;

import daniel.mythicmania.entity.MythicManiaEntityTypes;
import daniel.mythicmania.item.MythicManiaItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;

public class WastedStaffChargeEntity extends ThrownItemEntity {
    public WastedStaffChargeEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public WastedStaffChargeEntity(World world, LivingEntity owner) {
        super(MythicManiaEntityTypes.WASTED_STAFF_CHARGE_ENTITY, owner, world);
    }

    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        World.ExplosionSourceType destructionType = this.getWorld().getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING) ? World.ExplosionSourceType.MOB : World.ExplosionSourceType.NONE;

        // TODO: Crosscheck this
        if (!this.getWorld().isClient) {
            this.getWorld().createExplosion(this, this.getX(), this.getY(), this.getZ(), 1, destructionType);
            this.kill();
        }
    }

    @Override
    public void tick() {
        final boolean isIdle = (this.getVelocity().x == 0 || this.getVelocity().y == 0 || this.getVelocity().z == 0) && this.age > 5;
        if (isIdle) this.kill();
        super.tick();
    }

    @Override
    protected Item getDefaultItem() {
        return MythicManiaItems.WASTED_STAFF_CHARGE;
    }

    @Override
    protected float getGravity() {
        return 0;
    }
}