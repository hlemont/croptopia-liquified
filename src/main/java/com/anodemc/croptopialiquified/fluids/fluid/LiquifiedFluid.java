package com.anodemc.croptopialiquified.fluids.fluid;

import com.anodemc.croptopialiquified.fluids.variant.LiquifiedFluidVariant;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.WaterFluid;
import net.minecraft.item.Item;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class LiquifiedFluid extends WaterFluid {
    private final LiquifiedFluidSetting setting;
    private final boolean still;

    private final LiquifiedFluidVariant liquifiedFluidVariant;

    public LiquifiedFluid(LiquifiedFluidVariant liquifiedFluidVariant, LiquifiedFluidSetting setting,
                             boolean still) {
        this.setting = setting;
        this.still = still;
        this.liquifiedFluidVariant = liquifiedFluidVariant;
    }

    public LiquifiedFluidVariant getCompoundFluid() { return liquifiedFluidVariant; }

    @Override
    public BlockState toBlockState(FluidState state) {
        return getCompoundFluid().getFluidBlock().getDefaultState().with(Properties.LEVEL_15, getBlockStateLevel(state));
    }

    @Override
    public boolean isStill(FluidState state) {
        return still;
    }

    @Override
    public Item getBucketItem() {
        return getCompoundFluid().getBucketItem();
    }

    @Override
    public Fluid getFlowing() {
        return getCompoundFluid().getFlowingFluid();
    }

    @Override
    public Fluid getStill() { return getCompoundFluid().getStillFluid(); }

    @Override
    protected boolean isInfinite() {
        return false;
    }

    @Override
    public boolean matchesType(Fluid fluid) {
        return fluid == getStill() || fluid == getFlowing();
    }

    @Override
    protected void beforeBreakingBlock(WorldAccess world, BlockPos pos, BlockState state) {
        final BlockEntity blockEntity = state.hasBlockEntity() ? world.getBlockEntity(pos) : null;
        Block.dropStacks(state, world, pos, blockEntity);
    }

    @Override
    public int getFlowSpeed(WorldView world) {
        return setting.flowSpeed;
    }

    @Override
    public int getLevelDecreasePerBlock(WorldView world) {
        return setting.levelDecreasePerBlock;
    }

    @Override
    public int getTickRate(WorldView world) {
        return setting.tickRate;
    }

    @Override
    public int getLevel(FluidState state) {
        return still ? 8 : state.get(LEVEL);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {
        super.appendProperties(builder);
        if (!still) {
            builder.add(LEVEL);
        }
    }

    @Override
    public boolean canBeReplacedWith(FluidState state, BlockView world, BlockPos pos, Fluid fluid, Direction direction) {
            return getCompoundFluid().canBeReplacedWith(state, world, pos, fluid, direction);
    }

    @Override
    protected float getBlastResistance() {
        return 100.0f;
    }
}