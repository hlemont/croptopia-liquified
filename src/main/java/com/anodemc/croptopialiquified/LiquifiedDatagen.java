package com.anodemc.croptopialiquified;

import com.anodemc.croptopialiquified.compat.create.*;
import com.anodemc.croptopialiquified.compat.croptopia.registry.CroptopiaItems;
import com.anodemc.croptopialiquified.data.*;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class LiquifiedDatagen implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        // generate dummies for croptopia items
        CroptopiaItems.register();

        // tags
        fabricDataGenerator.addProvider(TagProviders.FluidTagProvider::new);
        fabricDataGenerator.addProvider(TagProviders.BlockTagProviders::new);
        fabricDataGenerator.addProvider(CreateCompatTagProvider::new);

        fabricDataGenerator.addProvider(ModelProviders.FluidModelProvider::new);
        fabricDataGenerator.addProvider(LootTablesProviders.BlockLootTablesProvider::new);

        // recipes
        fabricDataGenerator.addProvider(RecipesProviders.BucketRecipesProvider::new);
        fabricDataGenerator.addProvider(RecipesProviders.HardenedBlockRecipesProvider::new);
        fabricDataGenerator.addProvider(RecipesProviders.GeneralRecipesProvider::new);
        fabricDataGenerator.addProvider(CompatCompactingRecipeGen::new);
        fabricDataGenerator.addProvider(CompatCuttingRecipeGen::new);
        fabricDataGenerator.addProvider(CompatDeployingRecipeGen::new);
        fabricDataGenerator.addProvider(CompatEmptyingRecipeGen::new);
        fabricDataGenerator.addProvider(CompatFillingRecipeGen::new);
        fabricDataGenerator.addProvider(CompatMixingRecipeGen::new);
    }
}
