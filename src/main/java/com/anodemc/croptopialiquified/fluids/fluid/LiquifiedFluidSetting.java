package com.anodemc.croptopialiquified.fluids.fluid;

public class LiquifiedFluidSetting {
    public final int flowSpeed;
    public final int levelDecreasePerBlock;
    public final int tickRate;

    public LiquifiedFluidSetting(int flowSpeed, int levelDecreasePerBlock, int tickRate) {
        this.flowSpeed = flowSpeed;
        this.levelDecreasePerBlock = levelDecreasePerBlock;
        this.tickRate = tickRate;
    }
}
