package com.anodemc.croptopialiquified.data;


import com.anodemc.croptopialiquified.fluids.LiquifiedFluidManager;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModelProviders {
    public static class FluidModelProvider extends FabricModelProvider {

        public FluidModelProvider(FabricDataGenerator dataGenerator) {
            super(dataGenerator);
        }

        public void generateBlockStateModels(BlockStateModelGenerator generator) {
            LiquifiedFluidManager.getAllFluids()
                .forEach(fluidVariant -> generator.registerStateWithModelReference(fluidVariant.getFluidBlock(), Blocks.WATER));

            // add hardened blocks for melted ingredients
            LiquifiedFluidManager.getMeltedIngredientFluids()
                    .forEach(fluidVariant -> generator.registerSimpleCubeAll(fluidVariant.getHardenedBlock()));
        }

        public void generateItemModels(ItemModelGenerator generator) {
            // add buckets for all fluids
            LiquifiedFluidManager.getAllFluids()
                .forEach(fluidVariant -> generator.register(fluidVariant.getBucketItem(), Models.GENERATED));
        }
    }
}
