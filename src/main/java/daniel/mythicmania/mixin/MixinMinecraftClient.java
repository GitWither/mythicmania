package daniel.mythicmania.mixin;

import daniel.mythicmania.block.ToxicOreBlock;
import daniel.mythicmania.particle.MythicManiaParticles;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(MinecraftClient.class)
public class MixinMinecraftClient {

    @Shadow @Nullable public HitResult crosshairTarget;

    @Shadow @Nullable public ClientWorld world;

    @Inject(
            method = "handleBlockBreaking",
            locals = LocalCapture.CAPTURE_FAILHARD,
            at = @At(value = "INVOKE", target = "net/minecraft/client/particle/ParticleManager.addBlockBreakingParticles(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/util/math/Direction;)V"
            ))
    private void mythicmania$injectToxicOreParticles(boolean bl, CallbackInfo ci, BlockHitResult blockHitResult, BlockPos pos, Direction direction) {
        if (world == null) return;

        BlockState state = this.world.getBlockState(pos);
        if (state.getBlock() instanceof ToxicOreBlock) {
            for (int i = 0; i < 15; i++) {
                if (world.random.nextInt(5) != 0) continue;

                float velocityX = (world.random.nextFloat() - 0.5f) * 0.03f;
                float velocityZ = (world.random.nextFloat() - 0.5f) * 0.03f;

                float spawnPosX = (world.random.nextInt(2)) + pos.getX();
                float spawnPosY = (world.random.nextInt(2)) + pos.getY();
                float spawnPosZ = (world.random.nextInt(2)) + pos.getZ();

                world.addParticle(MythicManiaParticles.POISON_CLOUD, false, spawnPosX, spawnPosY, spawnPosZ, velocityX, 0, velocityZ);
            }
        }
    }
}
