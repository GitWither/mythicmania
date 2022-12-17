package daniel.mythicmania.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.world.World;

public abstract class AbstractGrubEntity extends PathAwareEntity {
    protected AbstractGrubEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder createGrubAttributes() {
        return HostileEntity
                .createHostileAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 6)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 35.0D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.23D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 3.0D);
    }

}
