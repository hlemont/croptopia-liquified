package com.anodemc.croptopialiquified.compat.create;

import com.anodemc.croptopialiquified.compat.common.tags.CommonItemTags;
import com.anodemc.croptopialiquified.compat.croptopia.registry.CroptopiaItems;
import com.anodemc.croptopialiquified.compat.croptopia.tags.CroptopiaItemTags;
import com.anodemc.croptopialiquified.fluids.LiquifiedFluidManager;
import com.anodemc.croptopialiquified.fluids.variant.DrinkFluidVariant;
import com.anodemc.croptopialiquified.fluids.variant.LiquifiedFluidVariant;
import com.simibubi.create.AllRecipeTypes;
import com.simibubi.create.content.contraptions.processing.HeatCondition;
import com.simibubi.create.content.contraptions.processing.ProcessingRecipe;
import com.simibubi.create.content.contraptions.processing.ProcessingRecipeBuilder;
import com.simibubi.create.foundation.data.recipe.ProcessingRecipeGen;
import com.simibubi.create.foundation.utility.recipe.IRecipeTypeInfo;
import io.github.tropheusj.milk.Milk;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.function.UnaryOperator;

public class CompatCompactingRecipeGen extends ProcessingRecipeGen {
    public CompatCompactingRecipeGen(FabricDataGenerator generator) {
        super(generator);
        generateHardenedBlockCompactingRecipes();
        generateCookingCompactingRecipes();
    }

    private void generateHardenedBlockCompactingRecipes() {
        for (var fluidVariant : LiquifiedFluidManager.getMeltedIngredientFluids()) {
            create(fluidVariant.getHardenBlockId(), b -> b
                .require(fluidVariant.getStillFluid(), FluidConstants.BUCKET)
                .output(fluidVariant.getHardenedBlock().asItem())
            );
        }
    }

    private void generateCookingCompactingRecipes() {
        GeneratedRecipe
            GRAPE_JUICE = generateSquashingCompactingRecipes(LiquifiedFluidManager.GRAPE_JUICE, CommonItemTags.FRUITS.GRAPES),
            ORANGE_JUICE = generateSquashingCompactingRecipes(LiquifiedFluidManager.ORANGE_JUICE, CommonItemTags.FRUITS.ORANGES),
            APPLE_JUICE = generateSquashingCompactingRecipes(LiquifiedFluidManager.APPLE_JUICE, Items.APPLE),
            CRANBERRY_JUICE = generateSquashingCompactingRecipes(LiquifiedFluidManager.CRANBERRY_JUICE, CommonItemTags.FRUITS.CRANBERRIES),
            SAGUARO_JUICE = generateSquashingCompactingRecipes(LiquifiedFluidManager.SAGUARO_JUICE, CommonItemTags.FRUITS.SAGUAROS),
            TOMATO_JUICE = generateSquashingCompactingRecipes(LiquifiedFluidManager.TOMATO_JUICE, CommonItemTags.VEGETABLES.TOMATOES),
            MELON_JUICE = generateSquashingCompactingRecipes(LiquifiedFluidManager.MELON_JUICE, CroptopiaItemTags.MELONS),
            PINEAPPLE_JUICE = generateSquashingCompactingRecipes(LiquifiedFluidManager.PINEAPPLE_JUICE, CommonItemTags.FRUITS.PINEAPPLES),
            BEER = generateSquashingCompactingRecipes(LiquifiedFluidManager.BEER, CommonItemTags.CROPS.HOPS),
            LEMONADE = generateSquashingCompactingRecipes(LiquifiedFluidManager.LEMONADE, CommonItemTags.FRUITS.LEMONS),

            SOY_MILK = generateSquashingCompactingRecipes(LiquifiedFluidManager.SOY_MILK, CommonItemTags.VEGETABLES.SOYBEANS),
            PEANUT_BUTTER = generateSquashingCompactingRecipes(LiquifiedFluidManager.PEANUT_BUTTER, CommonItemTags.CROPS.PEANUTS),

            COFFEE = create(LiquifiedFluidManager.COFFEE.getId(), b -> b
                .require(CommonItemTags.CROPS.COFFEE_BEANS)
                .require(Fluids.WATER, FluidConstants.BOTTLE * 2)
                .requiresHeat(HeatCondition.HEATED)
                .output(LiquifiedFluidManager.COFFEE.getStillFluid(), FluidConstants.BOTTLE * 2)),
            LIMEADE = create(LiquifiedFluidManager.LIMEADE.getId(), b -> b
                .require(CommonItemTags.FRUITS.LEMONS)
                .require(CommonItemTags.FRUITS.LEMONS)
                .require(CommonItemTags.FRUITS.LIMES)
                .output(LiquifiedFluidManager.LIMEADE.getStillFluid(), FluidConstants.BOTTLE * 3 * 3 / 2)),

            OLIVE_OIL = create(LiquifiedFluidManager.OLIVE_OIL.getId(), b -> b
                .require(CommonItemTags.FRUITS.OLIVES)
                .require(CommonItemTags.FRUITS.OLIVES)
                .output(LiquifiedFluidManager.OLIVE_OIL.getStillFluid(), FluidConstants.BUCKET / LiquifiedFluidManager.OLIVE_OIL.getMultiplier() * 3 / 2)),
            SOY_SAUCE = create(LiquifiedFluidManager.SOY_SAUCE.getId(), b -> b
                .require(Fluids.WATER, FluidConstants.BOTTLE)
                .require(CommonItemTags.VEGETABLES.SOYBEANS)
                .output(LiquifiedFluidManager.SOY_MILK.getStillFluid(), FluidConstants.BUCKET / LiquifiedFluidManager.SOY_MILK.getMultiplier() * 3 / 2)),
            PAPRIKA = create(Registry.ITEM.getId(CroptopiaItems.PAPRIKA), b -> b
                .require(CommonItemTags.CROPS.CHILE_PEPPERS)
                .output(CroptopiaItems.PAPRIKA)),
            TORTILLA = create(Registry.ITEM.getId(CroptopiaItems.TORTILLA), b -> b
                .require(Fluids.WATER, FluidConstants.BOTTLE)
                .require(CommonItemTags.FLOUR)
                .output(CroptopiaItems.TORTILLA)
                .requiresHeat(HeatCondition.HEATED)),
            BROWNIES = createRecipeWithAnyMilk(Registry.ITEM.getId(CroptopiaItems.BROWNIES), false, b -> b
                .require(LiquifiedFluidManager.CHOCOLATE.getStillFluid(), FluidConstants.BUCKET / LiquifiedFluidManager.CHOCOLATE.getMultiplier())
                .require(Items.SUGAR)
                .require(CommonItemTags.FLOUR)
                .require(Items.EGG)
                .output(CroptopiaItems.BROWNIES, 1)
                .output(0.5f, CroptopiaItems.BROWNIES, 1)
                .requiresHeat(HeatCondition.HEATED)),
            BROWNIES_SOY_MILK = createRecipeWithAnyMilk(Registry.ITEM.getId(CroptopiaItems.BROWNIES), true, b -> b
                .require(LiquifiedFluidManager.CHOCOLATE.getStillFluid(), FluidConstants.BUCKET / LiquifiedFluidManager.CHOCOLATE.getMultiplier())
                .require(Items.SUGAR)
                .require(CommonItemTags.FLOUR)
                .require(Items.EGG)
                .output(CroptopiaItems.BROWNIES, 1)
                .output(0.5f, CroptopiaItems.BROWNIES, 1)
                .requiresHeat(HeatCondition.HEATED)),
            PROTEIN_BAR = create(Registry.ITEM.getId(CroptopiaItems.PROTEIN_BAR), b -> b
                .require(LiquifiedFluidManager.CHOCOLATE.getStillFluid(), FluidConstants.BUCKET / LiquifiedFluidManager.CHOCOLATE.getMultiplier())
                .require(LiquifiedFluidManager.CARAMEL.getStillFluid(), FluidConstants.BUCKET / LiquifiedFluidManager.CARAMEL.getMultiplier())
                .require(CommonItemTags.NUTS.ROOT)
                .require(CommonItemTags.NUTS.ROOT)
                .require(Items.SUGAR)
                .require(CommonItemTags.SALTS)
                .output(CroptopiaItems.PROTEIN_BAR, 12)),
            LEMON_COCONUT_BAR = create(Registry.ITEM.getId(CroptopiaItems.LEMON_COCONUT_BAR), b -> b
                .require(LiquifiedFluidManager.BUTTER.getStillFluid(), FluidConstants.BUCKET / LiquifiedFluidManager.BUTTER.getMultiplier())
                .require(CommonItemTags.FRUITS.LEMONS)
                .require(CommonItemTags.FRUITS.COCONUTS)
                .require(Items.SUGAR)
                .require(Items.EGG)
                .require(CommonItemTags.FLOUR)
                .output(CroptopiaItems.LEMON_COCONUT_BAR, 1)
                .output(0.5f, CroptopiaItems.LEMON_COCONUT_BAR, 1))

        ;

    }

    private GeneratedRecipe generateSquashingCompactingRecipes(LiquifiedFluidVariant fluidVariant, TagKey<Item> tag) {
        return create(fluidVariant.getId(), b -> b
            .require(tag)
            .output(fluidVariant.getStillFluid(), FluidConstants.BOTTLE * 3 / 2)
        );
    }

    private GeneratedRecipe generateSquashingCompactingRecipes(LiquifiedFluidVariant fluidVariant, Item item) {
        return create(fluidVariant.getId(), b -> b
            .require(item)
            .output(fluidVariant.getStillFluid(), FluidConstants.BOTTLE * 3 / 2)
        );
    }

    private GeneratedRecipe createRecipeWithAnyMilk(Identifier id, Boolean withSoyMilk, UnaryOperator<ProcessingRecipeBuilder<ProcessingRecipe<?>>> transform) {
        Identifier newId = withSoyMilk ?
            new Identifier(id.getNamespace(), id.getPath() + "_with_soy_milk")
            : id;
        return create(newId, b -> transform.apply(b
            .require(withSoyMilk ? LiquifiedFluidManager.SOY_MILK.getStillFluid() : Milk.STILL_MILK, FluidConstants.BOTTLE))
        );
    }

    @Override
    protected IRecipeTypeInfo getRecipeType() {
        return AllRecipeTypes.COMPACTING;
    }
}
