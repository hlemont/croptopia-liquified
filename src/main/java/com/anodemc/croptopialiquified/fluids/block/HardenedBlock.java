package com.anodemc.croptopialiquified.fluids.block;

import com.anodemc.croptopialiquified.fluids.variant.LiquifiedFluidVariant;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class HardenedBlock extends Block {
    private final LiquifiedFluidVariant fluidVariant;
    private final BlockItem blockItem;

    public HardenedBlock(LiquifiedFluidVariant fluidVariant, Settings blockSettings, Item.Settings itemSettings) {
        super(blockSettings);
        this.fluidVariant = fluidVariant;
        blockItem = new BlockItem(this, itemSettings);
    }

    @Override
    public Item asItem() {
        return blockItem;
    }

    public LiquifiedFluidVariant getFluidVariant() {
        return fluidVariant;
    }
}
