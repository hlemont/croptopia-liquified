package com.anodemc.croptopialiquified.data;

import com.anodemc.croptopialiquified.compat.croptopia.CroptopiaNames;
import com.anodemc.croptopialiquified.compat.croptopia.registry.CroptopiaItems;
import com.anodemc.croptopialiquified.fluids.LiquifiedFluidManager;
import com.anodemc.croptopialiquified.fluids.variant.LiquifiedFluidVariant;
import com.anodemc.croptopialiquified.registry.ItemRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.DefaultResourceConditions;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;

import java.util.function.Consumer;

public class RecipesProviders {
    public static class BucketRecipesProvider extends FabricRecipeProvider {

        public BucketRecipesProvider(FabricDataGenerator dataGenerator) {
            super(dataGenerator);
        }

        @Override
        protected void generateRecipes(Consumer<RecipeJsonProvider> exporter) {
            LiquifiedFluidManager.getAllFluids().forEach(fluidVariant -> {
                if (fluidVariant.getType() == LiquifiedFluidVariant.Type.MELTED) return;
                ShapelessRecipeJsonBuilder toBucketRecipeFactory = ShapelessRecipeJsonBuilder.create(fluidVariant.getBucketItem()).input(Items.BUCKET);
                toBucketRecipeFactory.input(fluidVariant.getOriginalItem(), fluidVariant.getMultiplier());
                toBucketRecipeFactory.criterion("has_original", conditionsFromItem(fluidVariant.getOriginalItem()))
                    .offerTo(withConditions(exporter, DefaultResourceConditions.allModsLoaded(CroptopiaNames.MOD_ID)));

                ShapelessRecipeJsonBuilder fromBucketRecipeFactory = ShapelessRecipeJsonBuilder.create(fluidVariant.getOriginalItem(), fluidVariant.getMultiplier()).input(fluidVariant.getBucketItem());
                if (fluidVariant.getType() == LiquifiedFluidVariant.Type.DRINK && fluidVariant.getOriginalItem() != CroptopiaItems.TEA)
                    fromBucketRecipeFactory.input(Items.GLASS_BOTTLE, fluidVariant.getMultiplier());
                fromBucketRecipeFactory.criterion("has_bucket", conditionsFromItem(fluidVariant.getBucketItem()))
                    .offerTo(withConditions(exporter, DefaultResourceConditions.allModsLoaded(CroptopiaNames.MOD_ID)));
            });
        }
    }

    public static class HardenedBlockRecipesProvider extends FabricRecipeProvider {

        public HardenedBlockRecipesProvider(FabricDataGenerator dataGenerator) {
            super(dataGenerator);
        }

        @Override
        protected void generateRecipes(Consumer<RecipeJsonProvider> exporter) {
            LiquifiedFluidManager.getMeltedIngredientFluids().forEach(fluidVariant -> {
                if (fluidVariant.getMultiplier() != 4 && fluidVariant.getMultiplier() != 9) {
                    ShapelessRecipeJsonBuilder toBlockRecipeFactory = ShapelessRecipeJsonBuilder.create(fluidVariant.getHardenedBlock());
                    toBlockRecipeFactory.input(fluidVariant.getOriginalItem(), fluidVariant.getMultiplier());
                    toBlockRecipeFactory.criterion("has_original", conditionsFromItem(fluidVariant.getOriginalItem()))
                        .offerTo(withConditions(exporter, DefaultResourceConditions.allModsLoaded(CroptopiaNames.MOD_ID)));
                } else {
                    ShapedRecipeJsonBuilder toBlockRecipeFactory = ShapedRecipeJsonBuilder.create(fluidVariant.getHardenedBlock()).input('I', fluidVariant.getOriginalItem());
                    if (fluidVariant.getMultiplier() == 4) {
                        toBlockRecipeFactory.pattern("II")
                            .pattern("II");
                    } else {
                        toBlockRecipeFactory.pattern("III")
                            .pattern("III")
                            .pattern("III");
                    }
                    toBlockRecipeFactory.criterion("has_original", conditionsFromItem(fluidVariant.getOriginalItem()))
                        .offerTo(withConditions(exporter, DefaultResourceConditions.allModsLoaded(CroptopiaNames.MOD_ID)));
                }

                ShapelessRecipeJsonBuilder.create(fluidVariant.getOriginalItem(), fluidVariant.getMultiplier())
                    .input(fluidVariant.getHardenedBlock().asItem())
                    .criterion("has_hardened", conditionsFromItem(fluidVariant.getHardenedBlock().asItem()))
                    .offerTo(withConditions(exporter, DefaultResourceConditions.allModsLoaded(CroptopiaNames.MOD_ID)));
            });
        }
    }

    public static class GeneralRecipesProvider extends FabricRecipeProvider {

        public GeneralRecipesProvider(FabricDataGenerator dataGenerator) {
            super(dataGenerator);
        }

        @Override
        protected void generateRecipes(Consumer<RecipeJsonProvider> exporter) {
            ShapedRecipeJsonBuilder.create(ItemRegistry.DISPOSABLE_BOTTLE, 16)
                .input('G', Items.GLASS)
                .pattern(" G ")
                .pattern("G G")
                .criterion("has_glass", conditionsFromItem(Items.GLASS))
                .offerTo(withConditions(exporter, DefaultResourceConditions.allModsLoaded(CroptopiaNames.MOD_ID)));
        }
    }
}
