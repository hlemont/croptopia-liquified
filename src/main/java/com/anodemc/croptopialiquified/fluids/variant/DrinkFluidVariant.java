package com.anodemc.croptopialiquified.fluids.variant;

import com.anodemc.croptopialiquified.fluids.item.DrinkableBucketItem;
import com.anodemc.croptopialiquified.fluids.block.LiquifiedFluidBlock;
import com.anodemc.croptopialiquified.fluids.fluid.LiquifiedFluidSetting;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.BucketItem;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;

public class DrinkFluidVariant extends LiquifiedFluidVariant {
    private static final LiquifiedFluidSetting FLUID_SETTING = new LiquifiedFluidSetting(8, 1, 5);
    private final LiquifiedFluidBlock fluidBlock;
    private final DrinkableBucketItem bucketItem;

    public DrinkFluidVariant(Identifier originalItemId,
                             int multiplier,
                             int color,
                             FabricBlockSettings fluidBlockSettings,
                             FabricItemSettings bucketItemSettings) {
        super(originalItemId, multiplier, color, FLUID_SETTING);
        fluidBlock = new LiquifiedFluidBlock(this, fluidBlockSettings);
        bucketItem = new DrinkableBucketItem(this, bucketItemSettings, multiplier);
    }

    @Override
    public Type getType() {
        return Type.DRINK;
    }

    @Override
    public FluidBlock getFluidBlock() {
        return fluidBlock;
    }

    @Override
    public BucketItem getBucketItem() {
        return bucketItem;
    }

    @Override
    public boolean isTranslucent() {
        return true;
    }

    @Override
    public boolean canBeReplacedWith(FluidState state, BlockView world, BlockPos pos, Fluid fluid, Direction direction) {
        return fluid.isIn(FluidTags.LAVA);
    }
}
