package daniel.mythicmania.mixin;

import daniel.mythicmania.MythicMania;
import daniel.mythicmania.item.MythicManiaItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class MixinPlayerEntity extends LivingEntity {
    protected MixinPlayerEntity(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Shadow public abstract ItemStack getEquippedStack(EquipmentSlot slot);

    @Inject(method = "tick", at = @At(value = "INVOKE", target = "net/minecraft/entity/player/PlayerEntity.updateTurtleHelmet()V"))
    private void mythicmania$injectDemonVestEffects(CallbackInfo ci) {
        // TODO: Write more flexible system to avoid polluting this inject, and clean up some of the code (like particle handling)
        ItemStack headSlotItem = this.getEquippedStack(EquipmentSlot.HEAD);
        ItemStack chestSlotItem = this.getEquippedStack(EquipmentSlot.CHEST);
        ItemStack legsSlotItem = this.getEquippedStack(EquipmentSlot.LEGS);
        ItemStack bootSlotItem = this.getEquippedStack(EquipmentSlot.FEET);

        final StatusEffectInstance speed = new StatusEffectInstance(StatusEffects.SPEED, 40, 0, false, false, true);
        final StatusEffectInstance fireResistance = new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 40, 0, false, false, true);
        final StatusEffectInstance regeneration = new StatusEffectInstance(StatusEffects.REGENERATION, 40, 0, false, false, true);

        // Handle player when wearing demon vest
        if (chestSlotItem.isOf(MythicManiaItems.DEMON_VEST)) {
            this.addStatusEffect(speed);
            this.addStatusEffect(fireResistance);
        }

        // Handle player when wearing nuclear set
        if (
            headSlotItem.isOf(MythicManiaItems.NUCLEAR_HELMET) &&
            chestSlotItem.isOf(MythicManiaItems.NUCLEAR_CHESTPLATE) &&
            legsSlotItem.isOf(MythicManiaItems.NUCLEAR_LEGGINGS) &&
            bootSlotItem.isOf(MythicManiaItems.NUCLEAR_BOOTS)
        ) {
            this.addStatusEffect(regeneration);

            if (this.hasStatusEffect(StatusEffects.POISON)) {
                this.removeStatusEffect(StatusEffects.POISON);

                if (world.isClient) {
                    World world = this.getWorld();
                    BlockPos pos = this.getBlockPos();
                    final double xPos = pos.getX() + random.nextDouble();
                    final double yPos = pos.getY() + 0.6;
                    final double zPos = pos.getZ() + random.nextDouble();

                    world.addParticle(ParticleTypes.HEART, xPos, yPos, zPos, 0.0, -1, 0.0);
                    world.addParticle(ParticleTypes.HEART, xPos, yPos, zPos, 0.0, -1, 0.0);
                }
            }
        }

        // Handle player when wearing ruinous set
        if (
            headSlotItem.isOf(MythicManiaItems.RUINOUS_HELMET) ||
            chestSlotItem.isOf(MythicManiaItems.RUINOUS_CHESTPLATE) ||
            legsSlotItem.isOf(MythicManiaItems.RUINOUS_LEGGINGS) ||
            bootSlotItem.isOf(MythicManiaItems.RUINOUS_BOOTS)
        ) {
            this.addStatusEffect(fireResistance);
        }
    }
}
