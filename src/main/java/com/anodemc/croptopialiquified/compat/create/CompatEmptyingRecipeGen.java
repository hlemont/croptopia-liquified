package com.anodemc.croptopialiquified.compat.create;

import com.anodemc.croptopialiquified.compat.croptopia.registry.CroptopiaItems;
import com.anodemc.croptopialiquified.fluids.LiquifiedFluidManager;
import com.anodemc.croptopialiquified.registry.ItemRegistry;
import com.simibubi.create.AllRecipeTypes;
import com.simibubi.create.foundation.data.recipe.ProcessingRecipeGen;
import com.simibubi.create.foundation.utility.recipe.IRecipeTypeInfo;
import io.github.tropheusj.milk.Milk;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Items;
import net.minecraft.util.registry.Registry;

public class CompatEmptyingRecipeGen extends ProcessingRecipeGen {
    public CompatEmptyingRecipeGen(FabricDataGenerator gen) {
        super(gen);
        generateDrinkEmptyingRecipes();
        generateIngredientEmptyingRecipes();
        generateGeneralEmptyingRecipes();
    }

    @Override
    protected IRecipeTypeInfo getRecipeType() {
        return AllRecipeTypes.EMPTYING;
    }

    private void generateDrinkEmptyingRecipes() {
        for(var fluidVariant: LiquifiedFluidManager.getDrinkFluids()) {
            // to be removed:
            if(fluidVariant == LiquifiedFluidManager.TEA) continue;
            create(fluidVariant.getOriginalItemId(), b -> b
                .require(fluidVariant.getOriginalItem())
                .output(fluidVariant.getStillFluid(), FluidConstants.BUCKET / fluidVariant.getMultiplier())
                .output(Items.GLASS_BOTTLE)
            );
        }
        create(LiquifiedFluidManager.TEA.getId(), b -> b
            .require(LiquifiedFluidManager.TEA.getOriginalItem())
            .output(LiquifiedFluidManager.TEA.getStillFluid(), FluidConstants.BUCKET / LiquifiedFluidManager.TEA.getMultiplier()));
    }

    private void generateIngredientEmptyingRecipes() {
        for(var fluidVariant: LiquifiedFluidManager.getLiquidIngredientFluids()) {
            create(fluidVariant.getOriginalItemId(), b -> b
                .require(fluidVariant.getOriginalItem())
                .output(fluidVariant.getStillFluid(), FluidConstants.BUCKET / fluidVariant.getMultiplier())
            );
        }
    }

    private void generateGeneralEmptyingRecipes() {
        create(Registry.ITEM.getId(CroptopiaItems.WATER_BOTTLE), b -> b
            .require(CroptopiaItems.WATER_BOTTLE)
            .output(ItemRegistry.DISPOSABLE_BOTTLE)
            .output(Fluids.WATER, FluidConstants.BOTTLE)
        );
        create(Registry.ITEM.getId(CroptopiaItems.MILK_BOTTLE), b -> b
            .require(CroptopiaItems.MILK_BOTTLE)
            .output(ItemRegistry.DISPOSABLE_BOTTLE)
            .output(Milk.STILL_MILK, FluidConstants.BOTTLE)
        );
    }
}
