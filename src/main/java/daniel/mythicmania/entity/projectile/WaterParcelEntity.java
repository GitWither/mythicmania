package daniel.mythicmania.entity.projectile;

import daniel.mythicmania.entity.MythicManiaEntityTypes;
import daniel.mythicmania.item.MythicManiaItems;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class WaterParcelEntity extends ThrownItemEntity {

    public WaterParcelEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public WaterParcelEntity(World world, LivingEntity owner) {
        super(MythicManiaEntityTypes.WATER_PARCEL_ENTITY, owner, world);
    }

    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (!world.isClient) {
            // TODO: Check the number for flags
            world.setBlockState(getBlockPos(), Blocks.WATER.getDefaultState(), 11);
            this.kill();
        }
    }

    @Override
    protected Item getDefaultItem() {
        return MythicManiaItems.WATER_PARCEL;
    }

    @Override
    protected float getGravity() {
        return 0.04f;
    }
}