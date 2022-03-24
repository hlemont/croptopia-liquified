package com.anodemc.croptopialiquified.data;

import com.anodemc.croptopialiquified.compat.croptopia.CroptopiaNames;
import com.anodemc.croptopialiquified.compat.croptopia.registry.CroptopiaItems;
import com.anodemc.croptopialiquified.fluids.LiquifiedFluidManager;
import com.anodemc.croptopialiquified.fluids.variant.LiquifiedFluidVariant;
import com.anodemc.croptopialiquified.registry.ItemRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipesProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.DefaultResourceConditions;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonFactory;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonFactory;
import net.minecraft.item.Items;

import java.util.function.Consumer;

public class RecipesProviders {
    public static class BucketRecipesProvider extends FabricRecipesProvider {

        public BucketRecipesProvider(FabricDataGenerator dataGenerator) {
            super(dataGenerator);
        }

        @Override
        protected void generateRecipes(Consumer<RecipeJsonProvider> exporter) {
            LiquifiedFluidManager.getAllFluids().forEach(fluidVariant -> {
                if (fluidVariant.getType() == LiquifiedFluidVariant.Type.MELTED) return;

                ShapelessRecipeJsonFactory toBucketRecipeFactory = ShapelessRecipeJsonFactory.create(fluidVariant.getBucketItem()).input(Items.BUCKET);
                for (int i = 0; i < fluidVariant.getMultiplier(); i++) {
                    toBucketRecipeFactory.input(fluidVariant.getOriginalItem());
                }
                toBucketRecipeFactory.criterion("has_original", conditionsFromItem(fluidVariant.getOriginalItem()))
                    .offerTo(withConditions(exporter, DefaultResourceConditions.allModsLoaded(CroptopiaNames.MOD_ID)));

                ShapelessRecipeJsonFactory fromBucketRecipeFactory = ShapelessRecipeJsonFactory.create(fluidVariant.getOriginalItem(), fluidVariant.getMultiplier()).input(fluidVariant.getBucketItem());
                if(fluidVariant.getType() == LiquifiedFluidVariant.Type.DRINK && fluidVariant.getOriginalItem() != CroptopiaItems.TEA)
                    for(int i = 0; i < fluidVariant.getMultiplier(); i++) fromBucketRecipeFactory.input(Items.GLASS_BOTTLE);
                fromBucketRecipeFactory.criterion("has_bucket", conditionsFromItem(fluidVariant.getBucketItem()))
                .offerTo(withConditions(exporter, DefaultResourceConditions.allModsLoaded(CroptopiaNames.MOD_ID)));
            });
        }
    }

    public static class HardenedBlockRecipesProvider extends FabricRecipesProvider {

        public HardenedBlockRecipesProvider(FabricDataGenerator dataGenerator) {
            super(dataGenerator);
        }

        @Override
        protected void generateRecipes(Consumer<RecipeJsonProvider> exporter) {
            LiquifiedFluidManager.getMeltedIngredientFluids().forEach(fluidVariant -> {
                if(fluidVariant.getMultiplier() != 4 && fluidVariant.getMultiplier() != 9) {
                    ShapelessRecipeJsonFactory toBlockRecipeFactory = ShapelessRecipeJsonFactory.create(fluidVariant.getHardenedBlock());
                    for(int i=0; i<fluidVariant.getMultiplier(); i++) {
                        toBlockRecipeFactory.input(fluidVariant.getOriginalItem());
                    }
                    toBlockRecipeFactory.criterion("has_original", conditionsFromItem(fluidVariant.getOriginalItem()))
                        .offerTo(withConditions(exporter, DefaultResourceConditions.allModsLoaded(CroptopiaNames.MOD_ID)));
                } else {
                    ShapedRecipeJsonFactory toBlockRecipeFactory = ShapedRecipeJsonFactory.create(fluidVariant.getHardenedBlock()).input('A', fluidVariant.getOriginalItem());
                    if(fluidVariant.getMultiplier() == 4) {
                        toBlockRecipeFactory.pattern("AA")
                            .pattern("AA");
                    } else {
                        toBlockRecipeFactory.pattern("AAA")
                            .pattern("AAA")
                            .pattern("AAA");
                    }
                    toBlockRecipeFactory.criterion("has_original", conditionsFromItem(fluidVariant.getOriginalItem()))
                        .offerTo(withConditions(exporter, DefaultResourceConditions.allModsLoaded(CroptopiaNames.MOD_ID)));
                }

                ShapelessRecipeJsonFactory.create(fluidVariant.getOriginalItem(), fluidVariant.getMultiplier())
                    .input(fluidVariant.getHardenedBlock().asItem())
                    .criterion("has_hardened", conditionsFromItem(fluidVariant.getHardenedBlock().asItem()))
                    .offerTo(withConditions(exporter, DefaultResourceConditions.allModsLoaded(CroptopiaNames.MOD_ID)));
            });
        }
    }

    public static class GeneralRecipesProvider extends FabricRecipesProvider {

        public GeneralRecipesProvider(FabricDataGenerator dataGenerator) {
            super(dataGenerator);
        }

        @Override
        protected void generateRecipes(Consumer<RecipeJsonProvider> exporter) {
            ShapedRecipeJsonFactory.create(ItemRegistry.DISPOSABLE_BOTTLE, 16)
                .input('G', Items.GLASS)
                .pattern(" G ")
                .pattern("G G")
                .criterion("has_glass", conditionsFromItem(Items.GLASS))
                .offerTo(withConditions(exporter, DefaultResourceConditions.allModsLoaded(CroptopiaNames.MOD_ID)));
        }
    }
}
