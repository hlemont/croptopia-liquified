package com.anodemc.croptopialiquified.fluids.item;

import com.anodemc.croptopialiquified.fluids.variant.LiquifiedFluidVariant;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

public class BaseBucketItem extends BucketItem {
    private final LiquifiedFluidVariant liquifiedFluidVariant;

    public BaseBucketItem(LiquifiedFluidVariant liquifiedFluidVariant, Item.Settings settings) {
        super(liquifiedFluidVariant.getStillFluid(),
                settings.recipeRemainder(Items.BUCKET).maxCount(1));
        this.liquifiedFluidVariant = liquifiedFluidVariant;
    }

    public LiquifiedFluidVariant getCompoundFluid() { return this.liquifiedFluidVariant; }
}
