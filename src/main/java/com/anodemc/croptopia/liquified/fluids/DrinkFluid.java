package com.anodemc.croptopia.liquified.fluids;

import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class DrinkFluid extends BaseFluid {
    public static FluidSetting FLUID_SETTING = new FluidSetting(4, 1, 5);

    public DrinkFluid(Identifier id) {
        super(FLUID_SETTING, id);
    }
}
