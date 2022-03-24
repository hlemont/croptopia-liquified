package com.anodemc.croptopialiquified.fluids.block;

import com.anodemc.croptopialiquified.fluids.variant.LiquifiedFluidVariant;
import net.minecraft.block.Block;
import net.minecraft.block.FluidBlock;

public class LiquifiedFluidBlock extends FluidBlock {
    private final LiquifiedFluidVariant liquifiedFluidVariant;

    public LiquifiedFluidBlock(LiquifiedFluidVariant liquifiedFluidVariant, Block.Settings properties) {
        super(liquifiedFluidVariant.getStillFluid(), properties);
        this.liquifiedFluidVariant = liquifiedFluidVariant;
    }
    public LiquifiedFluidVariant getCompoundFluid() {
        return this.liquifiedFluidVariant;
    }
}
