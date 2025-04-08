package net.vasilis.cavernroot.block.custom;


import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import net.minecraft.world.tick.ScheduledTickView;

public class LumenRoot extends Block {
    public LumenRoot(Settings settings) { super(settings); }

    private static final VoxelShape SHAPE = VoxelShapes.cuboid(0.3, 0.0, 0.3, 0.7, 0.5, 0.7);

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockState belowBlock = world.getBlockState(pos.down());
        return belowBlock.isOf(Blocks.STONE) || belowBlock.isOf(Blocks.DEEPSLATE) || belowBlock.isOf(Blocks.GRANITE) || belowBlock.isOf(Blocks.ANDESITE) || belowBlock.isOf(Blocks.DIORITE) || belowBlock.isOf(Blocks.TUFF) || belowBlock.isOf(Blocks.DRIPSTONE_BLOCK);
    }

    @Override
    protected BlockState getStateForNeighborUpdate(
            BlockState state,
            WorldView world,
            ScheduledTickView tickView,
            BlockPos pos,
            Direction direction,
            BlockPos neighborPos,
            BlockState neighborState,
            Random random
    ) {
        if (direction == Direction.DOWN && !canPlaceAt(state, world, pos)) {
            return Blocks.AIR.getDefaultState();
        }
        return state;
    }

    @Override
    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        if (!canPlaceAt(state, world, pos)) {
            world.breakBlock(pos, true);
        }
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (world.isClient) {
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
