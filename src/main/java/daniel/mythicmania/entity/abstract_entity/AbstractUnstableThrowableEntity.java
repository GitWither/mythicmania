package daniel.mythicmania.entity.abstract_entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public abstract class AbstractUnstableThrowableEntity extends ThrownItemEntity {
	public static float GRAVITY = 0.07f;

	public AbstractUnstableThrowableEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
		super(entityType, world);
	}

	public AbstractUnstableThrowableEntity(EntityType<? extends ThrownItemEntity> entityType, World world, LivingEntity owner) {
		super(entityType, owner, world);
	}

	// Override this in other classes
	@Override
	protected Item getDefaultItem() {
		return null;
	}

	@Override
	protected void tickInVoid() {
		this.kill();
	}

	@Override
	protected float getGravity() {
		return GRAVITY;
	}

	@Override
	protected void onCollision(HitResult hitResult) {
		this.kill();
	}
}