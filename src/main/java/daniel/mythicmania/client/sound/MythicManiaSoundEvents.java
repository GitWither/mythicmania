package daniel.mythicmania.client.sound;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MythicManiaSoundEvents {
    public static final Identifier WASTED_STAFF_FIRE_SOUND_ID = new Identifier("mythicmania:wasted_staff_fire");
    public static SoundEvent WASTED_STAFF_FIRE = new SoundEvent(WASTED_STAFF_FIRE_SOUND_ID);

    public static void registerSoundEvents() {
        Registry.register(Registry.SOUND_EVENT, WASTED_STAFF_FIRE_SOUND_ID, WASTED_STAFF_FIRE);
    }
}