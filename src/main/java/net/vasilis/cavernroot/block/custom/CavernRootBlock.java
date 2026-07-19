package net.vasilis.cavernroot.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
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


public class CavernRootBlock extends Block {
    public CavernRootBlock(Properties settings) {
        super(settings);
    }

    private static final VoxelShape SHAPE = Shapes.box(0.2, 0.0, 0.2, 0.8, 1.0, 0.8);

    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return SHAPE; // Defines the block’s hitbox
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
        BlockState belowBlock = world.getBlockState(pos.below());
        return belowBlock.is(Blocks.STONE) || belowBlock.is(Blocks.DEEPSLATE) || belowBlock.is(Blocks.GRANITE) || belowBlock.is(Blocks.ANDESITE) || belowBlock.is(Blocks.DIORITE) || belowBlock.is(Blocks.TUFF) || belowBlock.is(Blocks.DRIPSTONE_BLOCK);
        // Ensures it can only be placed on certain blocks (prevents stacking on itself).
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
            return Blocks.AIR.defaultBlockState(); // Breaks if the supporting block is removed.
        }
        return state;
    }

    @Override
    public void onPlace(BlockState state, Level world, BlockPos pos, BlockState oldState, boolean notify) {
        if (!canSurvive(state, world, pos)) {
            world.destroyBlock(pos, true); // Breaks instantly if somehow placed incorrectly.
        }
    }

}