package daniel.mythicmania.mixin;

import daniel.mythicmania.item.MythicManiaItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class MixinLivingEntity extends Entity {
    @Shadow public abstract ItemStack getEquippedStack(EquipmentSlot slot);

    protected MixinLivingEntity(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(at = @At("HEAD"), method = "tick()V")
    private void injectIntoxicatedChestplateEffects(CallbackInfo ci, Entity entity) {
        ItemStack chestSlotItem = this.getEquippedStack(EquipmentSlot.CHEST);

        if (!(entity instanceof PlayerEntity)) {
            if (chestSlotItem.isOf(MythicManiaItems.INTOXICATED_CHESTPLATE)) {
            }
        }
    }
}