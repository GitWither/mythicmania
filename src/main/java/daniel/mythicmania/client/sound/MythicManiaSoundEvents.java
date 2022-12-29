package daniel.mythicmania.client.sound;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MythicManiaSoundEvents {
    public static final Identifier WASTED_STAFF_FIRE_SOUND_ID = new Identifier("mythicmania:wasted_staff_fire");
    public static SoundEvent WASTED_STAFF_FIRE = new SoundEvent(WASTED_STAFF_FIRE_SOUND_ID);

    public static final Identifier SHOCK_BOLT_STAFF_FIRE_SOUND_ID = new Identifier("mythicmania:shock_bolt_staff_fire");
    public static SoundEvent SHOCK_BOLT_STAFF_FIRE = new SoundEvent(SHOCK_BOLT_STAFF_FIRE_SOUND_ID);

    public static void registerSoundEvents() {
        Registry.register(Registry.SOUND_EVENT, WASTED_STAFF_FIRE_SOUND_ID, WASTED_STAFF_FIRE);
        Registry.register(Registry.SOUND_EVENT, SHOCK_BOLT_STAFF_FIRE_SOUND_ID, SHOCK_BOLT_STAFF_FIRE);
    }
}