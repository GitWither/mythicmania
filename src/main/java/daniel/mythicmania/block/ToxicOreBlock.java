package daniel.mythicmania.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.World;

public class ToxicOreBlock extends ExperienceDroppingBlock {
    public ToxicOreBlock(AbstractBlock.Settings settings) {
        super(settings, UniformIntProvider.create(2, 3));
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (!entity.bypassesSteppingEffects()) {
            StatusEffectInstance steppedPoison = new StatusEffectInstance(StatusEffects.POISON, 20 * 2, 0);
            ((LivingEntity) entity).addStatusEffect(steppedPoison);
        }

        super.onSteppedOn(world, pos, state, entity);
    }
}