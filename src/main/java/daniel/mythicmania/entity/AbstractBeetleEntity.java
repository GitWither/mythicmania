package daniel.mythicmania.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.NoPenaltySolidTargeting;
import net.minecraft.entity.ai.control.FlightMoveControl;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.pathing.BirdNavigation;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;

public abstract class AbstractBeetleEntity extends AnimalEntity {
    protected AbstractBeetleEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
        this.moveControl = new FlightMoveControl(this, 20, true);
    }

    @Override
    protected EntityNavigation createNavigation(World world) {
        BirdNavigation birdNavigation = new BirdNavigation(this, world);
        birdNavigation.setCanPathThroughDoors(false);
        birdNavigation.setCanSwim(false);
        birdNavigation.setCanEnterOpenDoors(true);
        return birdNavigation;
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return null;
    }

    @Override
    public float getSoundPitch() {
        return 1.5f;
    }

    @Override
    public boolean handleFallDamage(float fallDistance, float damageMultiplier, DamageSource damageSource) {
        return false;
    }

    public static DefaultAttributeContainer.Builder createBeetleAttributes() {
        return HostileEntity
                .createHostileAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 8)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 50.0D)
                .add(EntityAttributes.GENERIC_FLYING_SPEED, 0.6f)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3f)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2);
    }

    // TODO: Move this into own class
    class BeetleWanderAroundGoal extends Goal {
        // TODO: Unused constant?
        private static final int MAX_DISTANCE = 22;

        BeetleWanderAroundGoal() {
            this.setControls(EnumSet.of(Goal.Control.MOVE));
        }

        @Override
        public boolean canStart() {
            return AbstractBeetleEntity.this.navigation.isIdle() && AbstractBeetleEntity.this.random.nextInt(10) == 0;
        }

        @Override
        public boolean shouldContinue() {
            return AbstractBeetleEntity.this.navigation.isFollowingPath();
        }

        @Override
        public void start() {
            Vec3d vec3d = this.getRandomLocation();
            // TODO: Change this
            if (vec3d != null) {
                AbstractBeetleEntity.this.navigation.startMovingAlong(AbstractBeetleEntity.this.navigation.findPathTo(new BlockPos((int) vec3d.x, (int) vec3d.y, (int) vec3d.z), 1), 1.0);
            }
        }

        @Nullable
        private Vec3d getRandomLocation() {
            Vec3d direction = AbstractBeetleEntity.this.getRotationVec(0.0f);
            return NoPenaltySolidTargeting.find(AbstractBeetleEntity.this, 8, 4, -2, direction.x, direction.z, 1.5707963705062866);
        }
    }
}
