package com.anodemc.croptopialiquified.fluids.item;

import net.minecraft.client.color.item.ItemColorProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class BucketColorProvider implements ItemColorProvider {
    @Override
    public int getColor(ItemStack stack, int tintIndex) {
        Item item = stack.getItem();
        if(item instanceof BaseBucketItem && tintIndex == 1) {
            return ((BaseBucketItem) item).getCompoundFluid().getColor();
        }
        else return -1;
    }
}
