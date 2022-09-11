package daniel.mythicmania.particle;

import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;
import org.jetbrains.annotations.Nullable;

public class LuminescentSacParticle extends SpriteBillboardParticle {
    protected LuminescentSacParticle(ClientWorld clientWorld, double d, double e, double f, double velocityX, double velocityY, double velocityZ) {
        super(clientWorld, d, e, f);
        this.setBoundingBoxSpacing(0.25f, 0.25f);
        this.maxAge = this.random.nextInt(40) + 40;
        this.scale(1.4f);
        this.velocityX = 0;
        this.velocityY = -(velocityZ + (double)(this.random.nextFloat() / 50));
        this.velocityZ = 0;
    }

    @Override
    public void tick() {
        this.prevPosX = this.x;
        this.prevPosY = this.y;
        this.prevPosZ = this.z;
        if (this.age++ >= this.maxAge || this.alpha <= 0.0f) {
            this.markDead();
            return;
        }
        this.velocityX -= this.random.nextFloat() / 5000.0f * (float)(this.random.nextBoolean() ? 1 : -1);
        this.velocityZ -= this.random.nextFloat() / 5000.0f * (float)(this.random.nextBoolean() ? 1 : -1);

        this.move(this.velocityX, this.velocityY, this.velocityZ);
        if (this.age >= this.maxAge - 60 && this.alpha > 0.01f) {
            this.alpha -= 0.015f;
        }
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT;
    }

    public static class PoisonCloudFactory implements ParticleFactory<DefaultParticleType> {
        private final SpriteProvider spriteProvider;

        public PoisonCloudFactory(SpriteProvider spriteProvider) {
            this.spriteProvider = spriteProvider;
        }

        @Nullable
        @Override
        public Particle createParticle(DefaultParticleType parameters, ClientWorld world, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
            LuminescentSacParticle sacParticle = new LuminescentSacParticle(world, x, y, z, velocityX, velocityY, velocityZ);
            sacParticle.setAlpha(0.8f);
            sacParticle.setSprite(this.spriteProvider);
            return sacParticle;
        }
    }
}
