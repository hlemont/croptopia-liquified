package com.anodemc.croptopialiquified.fluids.variant;

import com.anodemc.croptopialiquified.fluids.item.DrinkableBucketItem;
import com.anodemc.croptopialiquified.fluids.block.LiquifiedFluidBlock;
import com.anodemc.croptopialiquified.fluids.fluid.LiquifiedFluidSetting;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.FluidBlock;
import net.minecraft.item.BucketItem;
import net.minecraft.util.Identifier;

public class IngredientFluidVariant extends LiquifiedFluidVariant {
    private static final LiquifiedFluidSetting FLUID_SETTING = new LiquifiedFluidSetting(4, 2, 15);
    private final LiquifiedFluidBlock fluidBlock;
    private final DrinkableBucketItem bucketItem;

    public IngredientFluidVariant(Identifier originalItemId, int multiplier, int color, FabricBlockSettings fluidBlockSettings, FabricItemSettings bucketItemSettings) {
        super(originalItemId, multiplier, color, FLUID_SETTING);
        fluidBlock = new LiquifiedFluidBlock(this, fluidBlockSettings);
        bucketItem = new DrinkableBucketItem(this, bucketItemSettings, multiplier);
    }

    @Override
    public boolean isTranslucent() {
        return true;
    }

    @Override
    public Type getType() {
        return Type.INGREDIENT;
    }

    @Override
    public FluidBlock getFluidBlock() {
        return fluidBlock;
    }

    @Override
    public BucketItem getBucketItem() {
        return bucketItem;
    }
}
