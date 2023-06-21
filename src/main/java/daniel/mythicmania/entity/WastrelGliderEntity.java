package daniel.mythicmania.entity;

import daniel.mythicmania.entity.goals.FlyingEntityWanderAroundGoal;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.FleeEntityGoal;
import net.minecraft.entity.ai.goal.FlyGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.PhantomEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class WastrelGliderEntity extends AbstractFlyingEntity {
	protected WastrelGliderEntity(EntityType<? extends AbstractFlyingEntity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	protected void initGoals() {
		this.goalSelector.add(1, new FlyGoal(this, 2));
		this.goalSelector.add(2, new FleeEntityGoal<>(this, PhantomEntity.class, 6, 4,8));
		this.goalSelector.add(2, new FleeEntityGoal<>(this, PlayerEntity.class, 6, 4,8));
		this.goalSelector.add(0, new FlyingEntityWanderAroundGoal(this));
	}

	public static DefaultAttributeContainer.Builder createWastrelGliderAttributes() {
		return PassiveEntity
			.createLivingAttributes()
			.add(EntityAttributes.GENERIC_MAX_HEALTH, 4)
			.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.2D)
			.add(EntityAttributes.GENERIC_FOLLOW_RANGE, 8)
			.add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 2.0D)
			.add(EntityAttributes.GENERIC_FLYING_SPEED, 0.2D);
	}

	@Nullable
	@Override
	public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
		return null;
	}
}