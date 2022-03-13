package com.anodemc.croptopia.liquified.fluids;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MeltedIngredientFluid extends BaseFluid {
    public static FluidSetting FLUID_SETTING = new FluidSetting(1, 4, 60);

    private final Block hardenBlock;

    protected MeltedIngredientFluid(Identifier id, AbstractBlock.Settings hardenBlockSetting) {
        super(FLUID_SETTING, id);
        this.hardenBlock = new Block(hardenBlockSetting.breakInstantly());
    }

    public Block getHardenBlock() { return hardenBlock; }

    public Identifier getHardenBlockId() { return getFlowingFluidId(getId());}

    public static Identifier getHardenBlockId(Identifier id) {
        return new Identifier(id.getNamespace(), id.getPath()  + "_block");
    }
}
