package com.anodemc.croptopia.liquified.fluids;

public class FluidSetting {
    public final int flowSpeed;
    public final int levelDecreasePerBlock;
    public final int tickRate;

    public FluidSetting(int flowSpeed, int levelDecreasePerBlock, int tickRate) {
        this.flowSpeed = flowSpeed;
        this.levelDecreasePerBlock = levelDecreasePerBlock;
        this.tickRate = tickRate;
    }
}
