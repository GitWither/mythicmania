package daniel.mythicmania.client.sound;

import daniel.mythicmania.MythicMania;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class MythicManiaSoundEvents {
    public static SoundEvent WASTED_STAFF_FIRE = SoundEvent.of(new Identifier(MythicMania.MOD_ID, "wasted_staff_fire"));
    public static SoundEvent SHOCK_BOLT_STAFF_FIRE = SoundEvent.of(new Identifier(MythicMania.MOD_ID, "shock_bolt_staff_fire"));

    public static void registerSoundEvents() {
        Registry.register(Registries.SOUND_EVENT, WASTED_STAFF_FIRE.getId(), WASTED_STAFF_FIRE);
        Registry.register(Registries.SOUND_EVENT, SHOCK_BOLT_STAFF_FIRE.getId(), SHOCK_BOLT_STAFF_FIRE);
    }
}