package daniel.mythicmania.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.OreBlock;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ToxicOreBlock extends OreBlock {
    public ToxicOreBlock(AbstractBlock.Settings settings) {
        super(settings, UniformIntProvider.create(2, 3));
    }

//    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
//        if (!world.isClient) {
//            if (!entity.bypassesSteppingEffects()) {
//                ((LivingEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 20*5, 1));
//            }
//        }
//
//        super.onSteppedOn(world, pos, state, entity);
//    }
}