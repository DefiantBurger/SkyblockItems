package net.minecraft.world.level.block;

import javax.annotation.Nullable;
import net.minecraft.core.BlockPosition;
import net.minecraft.core.EnumDirection;
import net.minecraft.world.item.context.BlockActionContext;
import net.minecraft.world.level.GeneratorAccess;
import net.minecraft.world.level.IBlockAccess;
import net.minecraft.world.level.IWorldReader;
import net.minecraft.world.level.World;
import net.minecraft.world.level.block.state.BlockBase;
import net.minecraft.world.level.block.state.BlockStateList;
import net.minecraft.world.level.block.state.IBlockData;
import net.minecraft.world.level.block.state.properties.BlockProperties;
import net.minecraft.world.level.block.state.properties.BlockStateBoolean;
import net.minecraft.world.level.block.state.properties.BlockStateDirection;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidTypes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.VoxelShapeCollision;

public class BlockLadder extends Block implements IBlockWaterlogged {

    public static final BlockStateDirection FACING = BlockFacingHorizontal.FACING;
    public static final BlockStateBoolean WATERLOGGED = BlockProperties.WATERLOGGED;
    protected static final float AABB_OFFSET = 3.0F;
    protected static final VoxelShape EAST_AABB = Block.a(0.0D, 0.0D, 0.0D, 3.0D, 16.0D, 16.0D);
    protected static final VoxelShape WEST_AABB = Block.a(13.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    protected static final VoxelShape SOUTH_AABB = Block.a(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 3.0D);
    protected static final VoxelShape NORTH_AABB = Block.a(0.0D, 0.0D, 13.0D, 16.0D, 16.0D, 16.0D);

    protected BlockLadder(BlockBase.Info blockbase_info) {
        super(blockbase_info);
        this.k((IBlockData) ((IBlockData) ((IBlockData) this.stateDefinition.getBlockData()).set(BlockLadder.FACING, EnumDirection.NORTH)).set(BlockLadder.WATERLOGGED, false));
    }

    @Override
    public VoxelShape a(IBlockData iblockdata, IBlockAccess iblockaccess, BlockPosition blockposition, VoxelShapeCollision voxelshapecollision) {
        switch ((EnumDirection) iblockdata.get(BlockLadder.FACING)) {
            case NORTH:
                return BlockLadder.NORTH_AABB;
            case SOUTH:
                return BlockLadder.SOUTH_AABB;
            case WEST:
                return BlockLadder.WEST_AABB;
            case EAST:
            default:
                return BlockLadder.EAST_AABB;
        }
    }

    private boolean a(IBlockAccess iblockaccess, BlockPosition blockposition, EnumDirection enumdirection) {
        IBlockData iblockdata = iblockaccess.getType(blockposition);

        return iblockdata.d(iblockaccess, blockposition, enumdirection);
    }

    @Override
    public boolean canPlace(IBlockData iblockdata, IWorldReader iworldreader, BlockPosition blockposition) {
        EnumDirection enumdirection = (EnumDirection) iblockdata.get(BlockLadder.FACING);

        return this.a((IBlockAccess) iworldreader, blockposition.shift(enumdirection.opposite()), enumdirection);
    }

    @Override
    public IBlockData updateState(IBlockData iblockdata, EnumDirection enumdirection, IBlockData iblockdata1, GeneratorAccess generatoraccess, BlockPosition blockposition, BlockPosition blockposition1) {
        if (enumdirection.opposite() == iblockdata.get(BlockLadder.FACING) && !iblockdata.canPlace(generatoraccess, blockposition)) {
            return Blocks.AIR.getBlockData();
        } else {
            if ((Boolean) iblockdata.get(BlockLadder.WATERLOGGED)) {
                generatoraccess.getFluidTickList().a(blockposition, FluidTypes.WATER, FluidTypes.WATER.a((IWorldReader) generatoraccess));
            }

            return super.updateState(iblockdata, enumdirection, iblockdata1, generatoraccess, blockposition, blockposition1);
        }
    }

    @Nullable
    @Override
    public IBlockData getPlacedState(BlockActionContext blockactioncontext) {
        IBlockData iblockdata;

        if (!blockactioncontext.c()) {
            iblockdata = blockactioncontext.getWorld().getType(blockactioncontext.getClickPosition().shift(blockactioncontext.getClickedFace().opposite()));
            if (iblockdata.a((Block) this) && iblockdata.get(BlockLadder.FACING) == blockactioncontext.getClickedFace()) {
                return null;
            }
        }

        iblockdata = this.getBlockData();
        World world = blockactioncontext.getWorld();
        BlockPosition blockposition = blockactioncontext.getClickPosition();
        Fluid fluid = blockactioncontext.getWorld().getFluid(blockactioncontext.getClickPosition());
        EnumDirection[] aenumdirection = blockactioncontext.f();
        int i = aenumdirection.length;

        for (int j = 0; j < i; ++j) {
            EnumDirection enumdirection = aenumdirection[j];

            if (enumdirection.n().d()) {
                iblockdata = (IBlockData) iblockdata.set(BlockLadder.FACING, enumdirection.opposite());
                if (iblockdata.canPlace(world, blockposition)) {
                    return (IBlockData) iblockdata.set(BlockLadder.WATERLOGGED, fluid.getType() == FluidTypes.WATER);
                }
            }
        }

        return null;
    }

    @Override
    public IBlockData a(IBlockData iblockdata, EnumBlockRotation enumblockrotation) {
        return (IBlockData) iblockdata.set(BlockLadder.FACING, enumblockrotation.a((EnumDirection) iblockdata.get(BlockLadder.FACING)));
    }

    @Override
    public IBlockData a(IBlockData iblockdata, EnumBlockMirror enumblockmirror) {
        return iblockdata.a(enumblockmirror.a((EnumDirection) iblockdata.get(BlockLadder.FACING)));
    }

    @Override
    protected void a(BlockStateList.a<Block, IBlockData> blockstatelist_a) {
        blockstatelist_a.a(BlockLadder.FACING, BlockLadder.WATERLOGGED);
    }

    @Override
    public Fluid c_(IBlockData iblockdata) {
        return (Boolean) iblockdata.get(BlockLadder.WATERLOGGED) ? FluidTypes.WATER.a(false) : super.c_(iblockdata);
    }
}
