package com.anodemc.croptopialiquified.compat.create;

import com.anodemc.croptopialiquified.compat.common.tags.CommonItemTags;
import com.anodemc.croptopialiquified.compat.croptopia.registry.CroptopiaItems;
import com.anodemc.croptopialiquified.fluids.LiquifiedFluidManager;
import com.simibubi.create.AllRecipeTypes;
import com.simibubi.create.foundation.data.recipe.ProcessingRecipeGen;
import com.simibubi.create.foundation.utility.recipe.IRecipeTypeInfo;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.minecraft.util.registry.Registry;

public class CompatDeployingRecipeGen extends ProcessingRecipeGen {

    public CompatDeployingRecipeGen(FabricDataGenerator generator) {
        super(generator);
        generateCookingDeployingRecipes();
    }

    private void generateCookingDeployingRecipes() {
        GeneratedRecipe
            BUTTERED_TOAST = create(Registry.ITEM.getId(CroptopiaItems.BUTTERED_TOAST), b -> b
            .require(CommonItemTags.TOASTS)
            .require(CroptopiaItems.BUTTER)
            .output(CroptopiaItems.BUTTERED_TOAST)),
            TOAST_WITH_JAM = create(Registry.ITEM.getId(CroptopiaItems.TOAST_WITH_JAM), b -> b
                .require(CommonItemTags.TOASTS)
                .require(CommonItemTags.JELLIES)
                .output(CroptopiaItems.TOAST_WITH_JAM)),
            AJVAR_TOAST = create(Registry.ITEM.getId(CroptopiaItems.AJVAR_TOAST), b -> b
                .require(CommonItemTags.TOASTS)
                .require(CroptopiaItems.AJVAR)
                .output(CroptopiaItems.AJVAR_TOAST)),
            AVOCADO_TOAST = create(Registry.ITEM.getId(CroptopiaItems.AVOCADO_TOAST), b -> b
                .require(CommonItemTags.TOASTS)
                .require(CommonItemTags.FRUITS.AVOCADOS)
                .output(CroptopiaItems.TOAST)),
            PEANUT_BUTTER_W_CELERY = create(Registry.ITEM.getId(CroptopiaItems.PEANUT_BUTTER_W_CELERY), b -> b
                .require(CommonItemTags.VEGETABLES.CELERY)
                .require(CroptopiaItems.BUTTER)
                .output(CroptopiaItems.PEANUT_BUTTER_W_CELERY))
        ;
    }

    @Override
    protected IRecipeTypeInfo getRecipeType() {
        return AllRecipeTypes.DEPLOYING;
    }
}
