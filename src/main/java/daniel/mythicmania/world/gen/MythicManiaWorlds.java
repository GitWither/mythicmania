package daniel.mythicmania.world.gen;

import daniel.mythicmania.MythicMania;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class MythicManiaWorlds {
    public static final RegistryKey<World> RUINED;

    static {
        RUINED = RegistryKey.of(RegistryKeys.WORLD, new Identifier(MythicMania.MOD_ID, "ruined"));
    }
}