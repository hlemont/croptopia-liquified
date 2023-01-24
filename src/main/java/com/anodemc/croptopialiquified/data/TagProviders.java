package com.anodemc.croptopialiquified.data;

import com.anodemc.croptopialiquified.fluids.LiquifiedFluidManager;
import com.anodemc.croptopialiquified.tags.CustomBlockTags;
import com.anodemc.croptopialiquified.tags.CustomFluidTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.fluid.Fluid;
import net.minecraft.tag.BlockTags;
import net.minecraft.tag.FluidTags;

public class TagProviders {
    public static class FluidTagProvider extends FabricTagProvider.FluidTagProvider {
        public FluidTagProvider(FabricDataGenerator dataGenerator) {
            super(dataGenerator);
        }

        @Override
        protected void generateTags() {
            FabricTagBuilder<Fluid> waterTagBuilder = getOrCreateTagBuilder(FluidTags.WATER);
//            FabricTagBuilder<Fluid> lavaTagBuilder = getOrCreateTagBuilder(FluidTags.LAVA);

            FabricTagBuilder<Fluid> drinkTagBuilder = getOrCreateTagBuilder(CustomFluidTags.DRINK);
            FabricTagBuilder<Fluid> liquidIngredientTagBuilder = getOrCreateTagBuilder(CustomFluidTags.LIQUID_INGREDIENTS);
            FabricTagBuilder<Fluid> meltedIngredientTagBuilder = getOrCreateTagBuilder(CustomFluidTags.MELTED_INGREDIENT);

            // add DrinkFluids to water tag
            LiquifiedFluidManager.getDrinkFluids().forEach(fluid -> {
                drinkTagBuilder.add(fluid.getStillFluidId(), fluid.getFlowingFluidId());
                waterTagBuilder.add(fluid.getStillFluidId(), fluid.getFlowingFluidId());
            });

            // add LiquidIngredientFluids to water tag
            LiquifiedFluidManager.getLiquidIngredientFluids().forEach(fluid -> {
                liquidIngredientTagBuilder.add(fluid.getStillFluidId(), fluid.getFlowingFluidId());
                waterTagBuilder.add(fluid.getStillFluidId(), fluid.getFlowingFluidId());
            });

            // add MeltedIngredient
            LiquifiedFluidManager.getMeltedIngredientFluids().forEach(fluid -> {
                meltedIngredientTagBuilder.add(fluid.getStillFluidId(), fluid.getFlowingFluidId());
                waterTagBuilder.add(fluid.getStillFluidId(), fluid.getFlowingFluidId());
            });
        }
    }

    public static class BlockTagProviders extends FabricTagProvider.BlockTagProvider {

        public BlockTagProviders(FabricDataGenerator dataGenerator) {
            super(dataGenerator);
        }

        @Override
        protected void generateTags() {
            FabricTagBuilder<Block> hardenedBlockTagBuilder = getOrCreateTagBuilder(CustomBlockTags.HARDENED_BLOCK);
            FabricTagBuilder<Block> mineableTagBuilder = getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE);

            LiquifiedFluidManager.getMeltedIngredientFluids()
                .forEach(fluidVariant -> {
                    hardenedBlockTagBuilder.add(fluidVariant.getHardenedBlock());
                    mineableTagBuilder.add(fluidVariant.getHardenedBlock());
                });
        }
    }
}
