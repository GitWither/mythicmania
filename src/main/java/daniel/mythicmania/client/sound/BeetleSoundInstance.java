package daniel.mythicmania.client.sound;

import daniel.mythicmania.entity.abstract_entity.AbstractFlyingEntity;
import net.minecraft.client.sound.MovingSoundInstance;
import net.minecraft.client.sound.SoundInstance;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.MathHelper;

public class BeetleSoundInstance extends MovingSoundInstance {
    private final AbstractFlyingEntity beetle;

    public BeetleSoundInstance(AbstractFlyingEntity beetleEntity, SoundEvent sound, SoundCategory category) {
        super(sound, category, SoundInstance.createRandom());

        this.beetle = beetleEntity;
        this.x = (float) beetleEntity.getX();
        this.y = (float) beetleEntity.getY();
        this.z = (float) beetleEntity.getZ();
        this.repeat = true;
        this.repeatDelay = 0;
        this.volume = 0.0f;
    }

    @Override
    public void tick() {
        if (this.beetle.isRemoved()) {
            this.setDone();
            return;
        }

        this.x = (float)this.beetle.getX();
        this.y = (float)this.beetle.getY();
        this.z = (float)this.beetle.getZ();

        float horizontalVelocity = (float)this.beetle.getVelocity().horizontalLength();

        if (horizontalVelocity >= 0.01f) {
            this.pitch = MathHelper.lerp(MathHelper.clamp(horizontalVelocity, this.getMinPitch(), this.getMaxPitch()), this.getMinPitch(), this.getMaxPitch());
            this.volume = MathHelper.lerp(MathHelper.clamp(horizontalVelocity, 0.0f, 0.5f), 0.0f, 1.2f);
        } else {
            this.pitch = 0.0f;
            this.volume = 0.0f;
        }
    }

    private float getMinPitch() {
        return 0.7f;
    }

    private float getMaxPitch() {
        return 1.7f;
    }

    @Override
    public boolean shouldAlwaysPlay() {
        return true;
    }

    @Override
    public boolean canPlay() {
        return !this.beetle.isSilent();
    }
}
