package net.vasilis.cavernroot.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
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


public class CavernRootBlock extends Block {
    public CavernRootBlock(Settings settings) {
        super(settings);
    }

    private static final VoxelShape SHAPE = VoxelShapes.cuboid(0.2, 0.0, 0.2, 0.8, 1.0, 0.8);

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE; // Defines the block’s hitbox
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockState belowBlock = world.getBlockState(pos.down());
        return belowBlock.isOf(Blocks.STONE) || belowBlock.isOf(Blocks.DEEPSLATE) || belowBlock.isOf(Blocks.GRANITE) || belowBlock.isOf(Blocks.ANDESITE) || belowBlock.isOf(Blocks.DIORITE) || belowBlock.isOf(Blocks.TUFF) || belowBlock.isOf(Blocks.DRIPSTONE_BLOCK);
        // Ensures it can only be placed on certain blocks (prevents stacking on itself).
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
            return Blocks.AIR.getDefaultState(); // Breaks if the supporting block is removed.
        }
        return state;
    }

    @Override
    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        if (!canPlaceAt(state, world, pos)) {
            world.breakBlock(pos, true); // Breaks instantly if somehow placed incorrectly.
        }
    }

}