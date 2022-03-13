package com.anodemc.croptopia.liquified.fluids;

import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class LiquidIngredientFluid extends BaseFluid {
    public static FluidSetting FLUID_SETTING = new FluidSetting(2, 2, 15);

    protected LiquidIngredientFluid(Identifier id) {
        super(FLUID_SETTING, id);
    }
}
