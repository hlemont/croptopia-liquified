package com.anodemc.croptopia.liquified.fluids;

import net.minecraft.block.Block;
import net.minecraft.block.FluidBlock;

public class BaseFluidBlock extends FluidBlock {
    public BaseFluidBlock(BaseFluid.ActualFluid fluid, Block.Settings properties) {
        super(fluid, properties);
    }
}
