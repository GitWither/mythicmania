package daniel.mythicmania.mixin;

import daniel.mythicmania.item.MythicManiaItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.tag.FluidTags;
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
        ItemStack chestSlotItem = this.getEquippedStack(EquipmentSlot.CHEST);

        if (chestSlotItem.isOf(MythicManiaItems.DEMON_VEST)) {
            this.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 40, 0, false, false, true));
            this.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 40, 0, false, false, true));
        }
    }
}
