package daniel.mythicmania.entity.mob;

import daniel.mythicmania.entity.abstract_entity.AbstractOrbiterEntity;
import daniel.mythicmania.entity.goals.OrbiterShootCoreGoal;
import daniel.mythicmania.entity.projectile.OrbiterProjectileEntity;
import daniel.mythicmania.item.MythicManiaItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class OrbiterEntity extends AbstractOrbiterEntity {
	public OrbiterEntity(EntityType<? extends HostileEntity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	protected void initGoals() {
		super.initGoals();
		this.goalSelector.add(0, new OrbiterShootCoreGoal(this, new ItemStack(MythicManiaItems.ORBITER_PROJECTILE), new OrbiterProjectileEntity(world, this)));
	}

	@Override
	public boolean tryAttack(Entity target) {
		if (super.tryAttack(target) && target instanceof LivingEntity livingEntity) {
			livingEntity.setOnFireFor(3);
			return true;
		}

		return false;
	}
}
