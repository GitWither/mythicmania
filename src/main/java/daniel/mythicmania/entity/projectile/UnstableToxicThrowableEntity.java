package daniel.mythicmania.entity.projectile;

import daniel.mythicmania.entity.MythicManiaEntityTypes;
import daniel.mythicmania.entity.abstract_entity.AbstractUnstableThrowableEntity;
import daniel.mythicmania.item.MythicManiaItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class UnstableToxicThrowableEntity extends AbstractUnstableThrowableEntity {
	public UnstableToxicThrowableEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
		super(entityType, world);
	}

	public UnstableToxicThrowableEntity(World world, PlayerEntity player) {
		super(MythicManiaEntityTypes.UNSTABLE_TOXIC_THROWABLE_ENTITY, world, player);
	}

	@Override
	protected Item getDefaultItem() {
		return MythicManiaItems.UNSTABLE_TOXIC_THROWABLE;
	}
}
