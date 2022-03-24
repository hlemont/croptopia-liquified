package com.anodemc.croptopialiquified.data;


import com.anodemc.croptopialiquified.Liquified;
import com.anodemc.croptopialiquified.fluids.LiquifiedFluidManager;
import com.anodemc.croptopialiquified.fluids.block.DerivedBlockModels;
import com.anodemc.croptopialiquified.fluids.variant.LiquifiedFluidVariant;
import net.fabricmc.fabric.api.client.model.ExtraModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockStateDefinitionProvider;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.model.BlockStateModelGenerator;
import net.minecraft.data.client.model.Models;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.Identifier;

public class BlockStateDefinitionProviders {
    public static class FluidBlockStateDefinitionProvider extends FabricBlockStateDefinitionProvider {

        public FluidBlockStateDefinitionProvider(FabricDataGenerator dataGenerator) {
            super(dataGenerator);
        }

        @Override
        public void generateBlockStateModels(BlockStateModelGenerator generator) {
            LiquifiedFluidManager.getAllFluids()
                .forEach(fluidVariant -> generator.registerStateWithModelReference(fluidVariant.getFluidBlock(), Blocks.WATER));

            // add hardened blocks for melted ingredients
            LiquifiedFluidManager.getMeltedIngredientFluids()
                    .forEach(fluidVariant -> generator.registerSimpleCubeAll(fluidVariant.getHardenedBlock()));
        }

        @Override
        public void generateItemModels(ItemModelGenerator generator) {
            // add buckets for all fluids
            LiquifiedFluidManager.getAllFluids()
                .forEach(fluidVariant -> generator.register(fluidVariant.getBucketItem(), Models.GENERATED));
        }
    }
}
