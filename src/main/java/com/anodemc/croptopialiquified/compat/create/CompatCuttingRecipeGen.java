package com.anodemc.croptopialiquified.compat.create;

import com.anodemc.croptopialiquified.fluids.LiquifiedFluidManager;
import com.simibubi.create.AllRecipeTypes;
import com.simibubi.create.foundation.data.recipe.ProcessingRecipeGen;
import com.simibubi.create.foundation.utility.recipe.IRecipeTypeInfo;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class CompatCuttingRecipeGen extends ProcessingRecipeGen {

    public CompatCuttingRecipeGen(FabricDataGenerator generator) {
        super(generator);
        generateHardenBlockCuttingRecipes();
    }

    public void generateHardenBlockCuttingRecipes() {
        for (var fluidVariant : LiquifiedFluidManager.getMeltedIngredientFluids()) {
            create(fluidVariant.getHardenBlockId(), b ->
                b.require(fluidVariant.getHardenedBlock())
                    .output(fluidVariant.getOriginalItem(), fluidVariant.getMultiplier())
            );
        }
    }

    @Override
    protected IRecipeTypeInfo getRecipeType() {
        return AllRecipeTypes.CUTTING;
    }
}
