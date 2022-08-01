package daniel.mythicmania.particle;

import daniel.mythicmania.MythicMania;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.client.particle.CampfireSmokeParticle;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public final class MythicManiaParticles {


    public static final DefaultParticleType POISON_CLOUD =
            Registry.register(Registry.PARTICLE_TYPE, new Identifier(MythicMania.MOD_ID, "poison_cloud"), FabricParticleTypes.simple());


    public static void registerParticleSprites(ClientSpriteRegistryCallback.Registry registry) {
        registry.register(new Identifier(MythicMania.MOD_ID, "particle/poison_cloud"));
    }

    public static void registerParticleFactories() {
        ParticleFactoryRegistry factoryRegistry = ParticleFactoryRegistry.getInstance();

        factoryRegistry.register(POISON_CLOUD, PoisonCloudParticle.PoisonCloudFactory::new);
    }
}
