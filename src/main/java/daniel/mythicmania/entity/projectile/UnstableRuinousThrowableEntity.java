package daniel.mythicmania.entity.projectile;

import daniel.mythicmania.entity.MythicManiaEntityTypes;
import daniel.mythicmania.entity.abstract_entity.AbstractUnstableThrowableEntity;
import daniel.mythicmania.item.MythicManiaItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class UnstableRuinousThrowableEntity extends AbstractUnstableThrowableEntity {
	public UnstableRuinousThrowableEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
		super(entityType, world);
	}

	public UnstableRuinousThrowableEntity(World world, PlayerEntity player) {
		super(MythicManiaEntityTypes.UNSTABLE_RUINOUS_THROWABLE_ENTITY, world, player);
	}

	@Override
	protected Item getDefaultItem() {
		return MythicManiaItems.UNSTABLE_RUINOUS_THROWABLE;
	}
}