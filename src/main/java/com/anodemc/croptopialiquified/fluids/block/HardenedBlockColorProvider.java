package com.anodemc.croptopialiquified.fluids.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.color.block.BlockColorProvider;
import net.minecraft.client.color.item.ItemColorProvider;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockRenderView;
import org.jetbrains.annotations.Nullable;

public class HardenedBlockColorProvider implements BlockColorProvider, ItemColorProvider {
    @Override
    public int getColor(BlockState state, @Nullable BlockRenderView world, @Nullable BlockPos pos, int tintIndex) {
        return ((HardenedBlock) state.getBlock()).getFluidVariant().getColor();
    }

    @Override
    public int getColor(ItemStack stack, int tintIndex) {
        return ((HardenedBlock) ((BlockItem)stack.getItem()).getBlock()).getFluidVariant().getColor();
    }
}
