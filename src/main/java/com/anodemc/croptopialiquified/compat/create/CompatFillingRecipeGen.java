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

public class CompatFillingRecipeGen extends ProcessingRecipeGen {
    public CompatFillingRecipeGen(FabricDataGenerator generator) {
        super(generator);
        generateDrinkFillingRecipes();
        generateGeneralFillingRecipes();
    }

    @Override
    protected IRecipeTypeInfo getRecipeType() {
        return AllRecipeTypes.FILLING;
    }

    private void generateDrinkFillingRecipes() {
        for(var fluidVariant: LiquifiedFluidManager.getDrinkFluids()) {
            if(fluidVariant == LiquifiedFluidManager.TEA) continue;
            create(fluidVariant.getOriginalItemId(), b ->
                b.require(fluidVariant.getStillFluid(), FluidConstants.BUCKET / fluidVariant.getMultiplier())
                    .require(Items.GLASS_BOTTLE)
                    .output(fluidVariant.getOriginalItem())
            );
        }
        create(LiquifiedFluidManager.TEA.getOriginalItemId(), b -> b
            .require(LiquifiedFluidManager.TEA.getStillFluid(), FluidConstants.BUCKET / LiquifiedFluidManager.TEA.getMultiplier())
            .require(ItemRegistry.DISPOSABLE_BOTTLE)
            .output(LiquifiedFluidManager.TEA.getOriginalItem()));
    }

    private void generateIngredientFillingRecipes() {
        for(var fluidVariant: LiquifiedFluidManager.getLiquidIngredientFluids()) {
            create(fluidVariant.getOriginalItemId(), b -> b
                .require(fluidVariant.getStillFluid(), FluidConstants.BUCKET / fluidVariant.getMultiplier())
                .require(ItemRegistry.DISPOSABLE_BOTTLE)
                .output(fluidVariant.getOriginalItem()));
        }
    }

    private void generateGeneralFillingRecipes() {
        create(Registry.ITEM.getId(CroptopiaItems.WATER_BOTTLE), b -> b
            .require(Fluids.WATER, FluidConstants.BOTTLE)
            .require(ItemRegistry.DISPOSABLE_BOTTLE)
            .output(CroptopiaItems.WATER_BOTTLE));

        create(Registry.ITEM.getId(CroptopiaItems.MILK_BOTTLE), b -> b
            .require(Milk.STILL_MILK, FluidConstants.BOTTLE)
            .require(ItemRegistry.DISPOSABLE_BOTTLE)
            .output(CroptopiaItems.MILK_BOTTLE));
    }
}
