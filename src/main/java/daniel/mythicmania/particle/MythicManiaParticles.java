package daniel.mythicmania.particle;

import daniel.mythicmania.MythicMania;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public final class MythicManiaParticles {
    public static final DefaultParticleType POISON_CLOUD = Registry.register(
            Registries.PARTICLE_TYPE,
            new Identifier(MythicMania.MOD_ID, "poison_cloud"),
            FabricParticleTypes.simple()
    );

    public static final DefaultParticleType SAC_PARTICLE = Registry.register(
            Registries.PARTICLE_TYPE,
            new Identifier(MythicMania.MOD_ID, "luminescent_sac"),
            FabricParticleTypes.simple()
    );

    public static void registerParticleFactories() {
        ParticleFactoryRegistry factoryRegistry = ParticleFactoryRegistry.getInstance();

        factoryRegistry.register(POISON_CLOUD, PoisonCloudParticle.PoisonCloudFactory::new);
        factoryRegistry.register(SAC_PARTICLE, LuminescentSacParticle.PoisonCloudFactory::new);
    }
}
