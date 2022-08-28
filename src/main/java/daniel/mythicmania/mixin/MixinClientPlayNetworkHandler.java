package daniel.mythicmania.mixin;

import daniel.mythicmania.client.sound.BeetleSoundInstance;
import daniel.mythicmania.entity.AbstractBeetleEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.entity.Entity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayNetworkHandler.class)
public class MixinClientPlayNetworkHandler {
    @Shadow @Final private MinecraftClient client;

    @Inject(method = "playSpawnSound", at = @At("TAIL"))
    private void mythicmania$injectBeetleLoopSound(Entity entity, CallbackInfo ci) {
        if (entity instanceof AbstractBeetleEntity beetle) {
            this.client.getSoundManager().playNextTick(new BeetleSoundInstance(beetle, SoundEvents.ENTITY_BEE_LOOP, SoundCategory.NEUTRAL));
        }
    }
}
