package net.vasilis.cavernroot.block.custom;


import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class LumenRoot extends Block {
    public LumenRoot(Properties settings) { super(settings); }

    private static final VoxelShape SHAPE = Shapes.box(0.3, 0.0, 0.3, 0.7, 0.5, 0.7);

    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
        BlockState belowBlock = world.getBlockState(pos.below());
        return belowBlock.is(Blocks.STONE) || belowBlock.is(Blocks.DEEPSLATE) || belowBlock.is(Blocks.GRANITE) || belowBlock.is(Blocks.ANDESITE) || belowBlock.is(Blocks.DIORITE) || belowBlock.is(Blocks.TUFF) || belowBlock.is(Blocks.DRIPSTONE_BLOCK);
    }

    @Override
    protected BlockState updateShape(
            BlockState state,
            LevelReader world,
            ScheduledTickAccess tickView,
            BlockPos pos,
            Direction direction,
            BlockPos neighborPos,
            BlockState neighborState,
            RandomSource random
    ) {
        if (direction == Direction.DOWN && !canSurvive(state, world, pos)) {
            return Blocks.AIR.defaultBlockState();
        }
        return state;
    }

    @Override
    public void onPlace(BlockState state, Level world, BlockPos pos, BlockState oldState, boolean notify) {
        if (!canSurvive(state, world, pos)) {
            world.destroyBlock(pos, true);
        }
    }

    @Override
    public void animateTick(BlockState state, Level world, BlockPos pos, RandomSource random) {
        if (world.isClientSide()) {
            if (random.nextFloat() < 0.3f) {
                for (int i = 0; i < 2; i++) {
                    double offsetX = (random.nextDouble() - 0.5) * 0.6;
                    double offsetY = random.nextDouble() * 0.5;
                    double offsetZ = (random.nextDouble() - 0.5) * 0.6;

                    world.addParticle(ParticleTypes.SCRAPE,
                            pos.getX() + 0.5 + offsetX,
                            pos.getY() + offsetY,
                            pos.getZ() + 0.5 + offsetZ,
                            0.0, 0.0, 0.0);
                }
            }
        }
    }

}
