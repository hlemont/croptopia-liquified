package com.anodemc.croptopialiquified.compat.create;

import com.anodemc.croptopialiquified.compat.common.tags.CommonItemTags;
import com.anodemc.croptopialiquified.compat.croptopia.registry.CroptopiaItems;
import com.anodemc.croptopialiquified.compat.croptopia.tags.CroptopiaItemTags;
import com.anodemc.croptopialiquified.fluids.LiquifiedFluidManager;
import com.anodemc.croptopialiquified.fluids.variant.LiquifiedFluidVariant;
import com.simibubi.create.AllFluids;
import com.simibubi.create.AllRecipeTypes;
import com.simibubi.create.content.contraptions.processing.HeatCondition;
import com.simibubi.create.content.contraptions.processing.ProcessingRecipe;
import com.simibubi.create.content.contraptions.processing.ProcessingRecipeBuilder;
import com.simibubi.create.foundation.data.recipe.ProcessingRecipeGen;
import com.simibubi.create.foundation.utility.recipe.IRecipeTypeInfo;
import io.github.tropheusj.milk.Milk;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.function.UnaryOperator;

@SuppressWarnings("UnstableApiUsage")
public class CompatMixingRecipeGen extends ProcessingRecipeGen {

    public CompatMixingRecipeGen(FabricDataGenerator generator) {
        super(generator);
        generateMeltingRecipes();
        generateCookingBoilingRecipes();
        generateCookingMixingRecipes();

    }

    @Override
    protected IRecipeTypeInfo getRecipeType() {
        return AllRecipeTypes.MIXING;
    }

    private void generateMeltingRecipes() {
        for (var fluidVariant : LiquifiedFluidManager.getMeltedIngredientFluids()) {
            create(new Identifier(fluidVariant.getOriginalItemId().toString() + "_from_original"), b -> b
                .require(fluidVariant.getOriginalItem())
                .output(fluidVariant.getStillFluid(), FluidConstants.BUCKET / fluidVariant.getMultiplier())
                .requiresHeat(HeatCondition.HEATED));

            create(new Identifier(fluidVariant.getHardenBlockId().toString() + "_from_block"), b -> b
                .require(fluidVariant.getHardenedBlock().asItem())
                .output(fluidVariant.getStillFluid(), FluidConstants.BUCKET)
                .requiresHeat(HeatCondition.HEATED));
        }
    }

    private void generateCookingMixingRecipes() {
        GeneratedRecipe
            LIMEADE_ADDITION = create(new Identifier(CroptopiaItems.LIMEADE.toString() + "_from_lemonade"), b -> b
            .require(LiquifiedFluidManager.LEMONADE.getStillFluid(), FluidConstants.BOTTLE * 2)
            .require(CommonItemTags.FRUITS.LIMES)
            .output(LiquifiedFluidManager.LIMEADE.getStillFluid(), FluidConstants.BOTTLE * 3)),
            WINE = create(LiquifiedFluidManager.WINE.getId(), b -> b
                .require(CommonItemTags.FRUITS.GRAPES)
                .require(CommonItemTags.FRUITS.GRAPES)
                .output(LiquifiedFluidManager.WINE.getStillFluid(), FluidConstants.BOTTLE * 3 / 2)),
            MEAD = create(LiquifiedFluidManager.MEAD.getId(), b -> b
                .require(Fluids.WATER, FluidConstants.BOTTLE)
                .require(AllFluids.HONEY.get(), FluidConstants.BOTTLE)
                .output(LiquifiedFluidManager.MEAD.getStillFluid(), FluidConstants.BOTTLE * 2 * 3 / 2)),
            RUM = create(LiquifiedFluidManager.RUM.getId(), b -> b
                .require(Fluids.WATER, FluidConstants.BOTTLE)
                .require(LiquifiedFluidManager.MOLASSES.getStillFluid(), FluidConstants.BOTTLE)
                .output(LiquifiedFluidManager.RUM.getStillFluid(), FluidConstants.BOTTLE * 3 / 2)
                .requiresHeat(HeatCondition.NONE)),
            STRAWBERRY_SMOOTHIE = createRecipeWithAnyMilk(LiquifiedFluidManager.STRAWBERRY_SMOOTHIE.getId(), false, b -> b
                .require(CommonItemTags.FRUITS.STRAWBERRIES)
                .require(Items.ICE)
                .output(LiquifiedFluidManager.STRAWBERRY_SMOOTHIE.getStillFluid(), FluidConstants.BOTTLE * 2 * 3 / 2)
                .requiresHeat(HeatCondition.NONE)),
            STRAWBERRY_SMOOTHIE_SOY_MILK = createRecipeWithAnyMilk(LiquifiedFluidManager.STRAWBERRY_SMOOTHIE.getId(), true, b -> b
                .require(CommonItemTags.FRUITS.STRAWBERRIES)
                .require(Items.ICE)
                .output(LiquifiedFluidManager.STRAWBERRY_SMOOTHIE.getStillFluid(), FluidConstants.BOTTLE * 2 * 3 / 2)
                .requiresHeat(HeatCondition.NONE)),
            BANANA_SMOOTHIE = createRecipeWithAnyMilk(LiquifiedFluidManager.BANANA_SMOOTHIE.getId(), false, b -> b
                .require(CommonItemTags.FRUITS.BANANAS)
                .require(Items.ICE)
                .output(LiquifiedFluidManager.BANANA_SMOOTHIE.getStillFluid(), FluidConstants.BOTTLE * 2 * 2 / 2)
                .requiresHeat(HeatCondition.NONE)),
            BANANA_SMOOTHIE_SOY_MILK = createRecipeWithAnyMilk(LiquifiedFluidManager.BANANA_SMOOTHIE.getId(), true, b -> b
                .require(CommonItemTags.FRUITS.BANANAS)
                .require(Items.ICE)
                .output(LiquifiedFluidManager.BANANA_SMOOTHIE.getStillFluid(), FluidConstants.BOTTLE * 2 * 3 / 2)
                .requiresHeat(HeatCondition.NONE)),
            KALE_SMOOTHIE = createRecipeWithAnyMilk(LiquifiedFluidManager.KALE_SMOOTHIE.getId(), false, b -> b
                .require(CommonItemTags.VEGETABLES.KALE)
                .require(CommonItemTags.FRUITS.MANGOS)
                .require(CroptopiaItems.YOGHURT)
                .require(CommonItemTags.VEGETABLES.TOMATOES)
                .require(Items.ICE)
                .output(LiquifiedFluidManager.KALE_SMOOTHIE.getStillFluid(), FluidConstants.BOTTLE * 2 * 3 / 2)
                .requiresHeat(HeatCondition.NONE)),
            KALE_SMOOTHIE_SOY_MILK = createRecipeWithAnyMilk(LiquifiedFluidManager.KALE_SMOOTHIE.getId(), true, b -> b
                .require(CommonItemTags.VEGETABLES.KALE)
                .require(CommonItemTags.FRUITS.MANGOS)
                .require(CroptopiaItems.YOGHURT)
                .require(CommonItemTags.VEGETABLES.TOMATOES)
                .require(Items.ICE)
                .output(LiquifiedFluidManager.KALE_SMOOTHIE.getStillFluid(), FluidConstants.BOTTLE * 2 * 3 / 2)
                .requiresHeat(HeatCondition.NONE)
            ),
            FRUIT_SMOOTHIE = createRecipeWithAnyMilk(LiquifiedFluidManager.FRUIT_SMOOTHIE.getId(), false, b -> b
                .require(CommonItemTags.FRUITS.ROOT)
                .require(CommonItemTags.FRUITS.ROOT)
                .require(CommonItemTags.FRUITS.ROOT)
                .require(Items.ICE)
                .output(LiquifiedFluidManager.FRUIT_SMOOTHIE.getStillFluid(), FluidConstants.BOTTLE * 2 * 3 / 2)
                .requiresHeat(HeatCondition.NONE)
            ),
            FRUIT_SMOOTHIE_SOY_MILK = createRecipeWithAnyMilk(LiquifiedFluidManager.FRUIT_SMOOTHIE.getId(), true, b -> b
                .require(CommonItemTags.FRUITS.ROOT)
                .require(CommonItemTags.FRUITS.ROOT)
                .require(CommonItemTags.FRUITS.ROOT)
                .require(Items.ICE)
                .output(LiquifiedFluidManager.FRUIT_SMOOTHIE.getStillFluid(), FluidConstants.BOTTLE * 2 * 3 / 2)
                .requiresHeat(HeatCondition.NONE)
            ),

            VANILLA_ICE_CREAM = createRecipeWithAnyMilk(Registry.ITEM.getId(CroptopiaItems.VANILLA_ICE_CREAM), false, b -> b
                .require(Items.SUGAR)
                .require(CommonItemTags.CROPS.VANILLA)
                .require(Items.EGG)
                .output(CroptopiaItems.VANILLA_ICE_CREAM)
                .output(0.5f, CroptopiaItems.VANILLA_ICE_CREAM)
                .requiresHeat(HeatCondition.NONE)),
            VANILLA_ICE_CREAM_SOY_MILK = createRecipeWithAnyMilk(Registry.ITEM.getId(CroptopiaItems.VANILLA_ICE_CREAM), true, b -> b
                .require(Items.SUGAR)
                .require(CommonItemTags.CROPS.VANILLA)
                .require(Items.EGG)
                .output(CroptopiaItems.VANILLA_ICE_CREAM)
                .output(0.5f, CroptopiaItems.VANILLA_ICE_CREAM)
                .requiresHeat(HeatCondition.NONE)),
            MANGO_ICE_CREAM = createRecipeWithAnyMilk(Registry.ITEM.getId(CroptopiaItems.MANGO_ICE_CREAM), false, b -> b
                .require(Items.SUGAR)
                .require(CommonItemTags.FRUITS.MANGOS)
                .require(Items.EGG)
                .output(CroptopiaItems.MANGO_ICE_CREAM)
                .output(0.5f, CroptopiaItems.MANGO_ICE_CREAM)
                .requiresHeat(HeatCondition.NONE)
            ),
            MANGO_ICE_CREAM_SOY_MILK = createRecipeWithAnyMilk(Registry.ITEM.getId(CroptopiaItems.MANGO_ICE_CREAM), true, b -> b
                .require(Items.SUGAR)
                .require(CommonItemTags.FRUITS.MANGOS)
                .require(Items.EGG)
                .output(CroptopiaItems.MANGO_ICE_CREAM)
                .output(0.5f, CroptopiaItems.MANGO_ICE_CREAM)
                .requiresHeat(HeatCondition.NONE)
            ),
            PECAN_ICE_CREAM = createRecipeWithAnyMilk(Registry.ITEM.getId(CroptopiaItems.PECAN_ICE_CREAM), false, b -> b
                .require(Items.SUGAR)
                .require(CommonItemTags.NUTS.PECANS)
                .require(Items.EGG)
                .output(CroptopiaItems.PECAN_ICE_CREAM)
                .output(0.5f, CroptopiaItems.PECAN_ICE_CREAM)
                .requiresHeat(HeatCondition.NONE)),
            PECAN_ICE_CREAM_SOY_MILK = createRecipeWithAnyMilk(Registry.ITEM.getId(CroptopiaItems.PECAN_ICE_CREAM), true, b -> b
                .require(Items.SUGAR)
                .require(CommonItemTags.NUTS.PECANS)
                .require(Items.EGG)
                .output(CroptopiaItems.PECAN_ICE_CREAM)
                .output(0.5f, CroptopiaItems.PECAN_ICE_CREAM)
                .requiresHeat(HeatCondition.NONE)),
            RUM_RAISIN_ICE_CREAM = createRecipeWithAnyMilk(Registry.ITEM.getId(CroptopiaItems.RUM_RAISIN_ICE_CREAM), false, b -> b
                .require(LiquifiedFluidManager.RUM.getStillFluid(), FluidConstants.BOTTLE / 2)
                .require(Items.SUGAR)
                .require(CommonItemTags.RAISINS)
                .require(Items.EGG)
                .output(CroptopiaItems.RUM_RAISIN_ICE_CREAM)
                .output(0.5f, CroptopiaItems.RUM_RAISIN_ICE_CREAM)
                .requiresHeat(HeatCondition.NONE)),
            RUM_RAISIN_ICE_CREAM_SOY_MILK = createRecipeWithAnyMilk(Registry.ITEM.getId(CroptopiaItems.RUM_RAISIN_ICE_CREAM), true, b -> b
                .require(LiquifiedFluidManager.RUM.getStillFluid(), FluidConstants.BOTTLE / 2)
                .require(Items.SUGAR)
                .require(CommonItemTags.RAISINS)
                .require(Items.EGG)
                .output(CroptopiaItems.RUM_RAISIN_ICE_CREAM)
                .output(0.5f, CroptopiaItems.RUM_RAISIN_ICE_CREAM)
                .requiresHeat(HeatCondition.NONE)),
            CHOCOLATE_ICE_CREAM = createRecipeWithAnyMilk(Registry.ITEM.getId(CroptopiaItems.CHOCOLATE_ICE_CREAM), false, b -> b
                .require(LiquifiedFluidManager.CHOCOLATE.getStillFluid(), FluidConstants.BUCKET / LiquifiedFluidManager.CHOCOLATE.getMultiplier())
                .require(Items.SUGAR)
                .require(Items.EGG)
                .output(CroptopiaItems.CHOCOLATE_ICE_CREAM)
                .output(0.5f, CroptopiaItems.CHOCOLATE_ICE_CREAM)
                .requiresHeat(HeatCondition.NONE)),
            CHOCOLATE_ICE_CREAM_SOY_MILK = createRecipeWithAnyMilk(Registry.ITEM.getId(CroptopiaItems.CHOCOLATE_ICE_CREAM), true, b -> b
                .require(LiquifiedFluidManager.CHOCOLATE.getStillFluid(), FluidConstants.BUCKET / LiquifiedFluidManager.CHOCOLATE.getMultiplier())
                .require(Items.SUGAR)
                .require(Items.EGG)
                .output(CroptopiaItems.CHOCOLATE_ICE_CREAM)
                .output(0.5f, CroptopiaItems.CHOCOLATE_ICE_CREAM)
                .requiresHeat(HeatCondition.NONE)),
            STRAWBERRY_ICE_CREAM = createRecipeWithAnyMilk(Registry.ITEM.getId(CroptopiaItems.STRAWBERRY_ICE_CREAM), false, b -> b
                .require(Items.SUGAR)
                .require(CommonItemTags.FRUITS.STRAWBERRIES)
                .require(Items.EGG)
                .output(CroptopiaItems.STRAWBERRY_ICE_CREAM)
                .output(0.5f, CroptopiaItems.STRAWBERRY_ICE_CREAM)
                .requiresHeat(HeatCondition.NONE)
            ),
            STRAWBERRY_ICE_CREAM_SOY_MILK = createRecipeWithAnyMilk(Registry.ITEM.getId(CroptopiaItems.STRAWBERRY_ICE_CREAM), true, b -> b
                .require(Items.SUGAR)
                .require(CommonItemTags.FRUITS.STRAWBERRIES)
                .require(Items.EGG)
                .output(CroptopiaItems.STRAWBERRY_ICE_CREAM)
                .output(0.5f, CroptopiaItems.STRAWBERRY_ICE_CREAM)
                .requiresHeat(HeatCondition.NONE)
            ),
            CHOCOLATE_MILKSHAKE = createRecipeWithAnyMilk(Registry.ITEM.getId(CroptopiaItems.CHOCOLATE_MILKSHAKE), false, b -> b
                .require(LiquifiedFluidManager.CHOCOLATE.getStillFluid(), FluidConstants.BUCKET / LiquifiedFluidManager.CHOCOLATE.getMultiplier())
                .require(CroptopiaItems.VANILLA_ICE_CREAM)
                .output(LiquifiedFluidManager.CHOCOLATE_MILKSHAKE.getStillFluid(), FluidConstants.BOTTLE * 2 * 3 / 2)),
            CHOCOLATE_MILKSHAKE_SOY_MILK = createRecipeWithAnyMilk(Registry.ITEM.getId(CroptopiaItems.CHOCOLATE_MILKSHAKE), true, b -> b
                .require(LiquifiedFluidManager.CHOCOLATE.getStillFluid(), FluidConstants.BUCKET / LiquifiedFluidManager.CHOCOLATE.getMultiplier())
                .require(CroptopiaItems.VANILLA_ICE_CREAM)
                .output(LiquifiedFluidManager.CHOCOLATE_MILKSHAKE.getStillFluid(), FluidConstants.BOTTLE * 2 * 3 / 2)),
            WHIPPING_CREAM = createRecipeWithAnyMilk(LiquifiedFluidManager.WHIPPING_CREAM.getId(), false, b -> b
                .require(Items.SUGAR)
                .require(CommonItemTags.CROPS.VANILLA)
                .output(LiquifiedFluidManager.WHIPPING_CREAM.getStillFluid(), FluidConstants.BUCKET * 3 / 2)),
            WHIPPING_CREAM_SOY_MILK = createRecipeWithAnyMilk(LiquifiedFluidManager.WHIPPING_CREAM.getId(), true, b -> b
                .require(Items.SUGAR)
                .require(CommonItemTags.CROPS.VANILLA)
                .output(LiquifiedFluidManager.WHIPPING_CREAM.getStillFluid(), FluidConstants.BUCKET * 3 / 2)),

            LEMON_CHICKEN = create(Registry.ITEM.getId(CroptopiaItems.LEMON_CHICKEN), b -> b
                .require(CommonItemTags.FRUITS.LEMONS)
                .require(CommonItemTags.CROPS.CHILE_PEPPERS)
                .require(CommonItemTags.VEGETABLES.TOMATOES)
                .require(CroptopiaItemTags.CHICKEN_REPLACEMENTS)
                .output(CroptopiaItems.LEMON_CHICKEN)
                .output(0.5f, CroptopiaItems.LEMON_CHICKEN)
                .requiresHeat(HeatCondition.NONE)),
            GRILLED_CHEESE = create(Registry.ITEM.getId(CroptopiaItems.GRILLED_CHEESE), b -> b
                .require(LiquifiedFluidManager.CHEESE.getStillFluid(), FluidConstants.BUCKET / LiquifiedFluidManager.CHEESE.getMultiplier())
                .require(Items.BREAD)
                .output(CroptopiaItems.GRILLED_CHEESE)
                .output(0.5f, CroptopiaItems.GRILLED_CHEESE)),

            HAM_SANDWICH = create(Registry.ITEM.getId(CroptopiaItems.HAM_SANDWICH), b -> b
                .require(LiquifiedFluidManager.CHEESE.getStillFluid(), FluidConstants.BUCKET / LiquifiedFluidManager.CHEESE.getMultiplier())
                .require(Items.BREAD)
                .require(Items.COOKED_PORKCHOP)
                .output(CroptopiaItems.HAM_SANDWICH)
                .output(0.5f, CroptopiaItems.HAM_SANDWICH)),

            DOUGH = create(Registry.ITEM.getId(CroptopiaItems.FLOUR), b -> b
                .require(Fluids.WATER, FluidConstants.BOTTLE)
                .require(CommonItemTags.FLOUR)
                .output(CroptopiaItems.DOUGH)
                .output(0.5f, CroptopiaItems.DOUGH)
                .requiresHeat(HeatCondition.NONE)),
            NOODLE = create(Registry.ITEM.getId(CroptopiaItems.NOODLE), b -> b
                .require(Fluids.WATER, FluidConstants.BOTTLE)
                .require(CommonItemTags.SALTS)
                .require(CommonItemTags.FLOUR)
                .output(CroptopiaItems.NOODLE)
                .output(0.5f, CroptopiaItems.NOODLE)),
            AJVAR = create(Registry.ITEM.getId(CroptopiaItems.AJVAR), b -> b
                .require(LiquifiedFluidManager.OLIVE_OIL.getStillFluid(), FluidConstants.BUCKET / LiquifiedFluidManager.OLIVE_OIL.getMultiplier())
                .require(CommonItemTags.FRUITS.BELLPEPPERS)
                .require(CommonItemTags.VEGETABLES.EGGPLANT)
                .require(CommonItemTags.VEGETABLES.GARLIC)
                .require(CroptopiaItems.PEPPER)
                .require(CommonItemTags.SALTS)
                .output(LiquifiedFluidManager.AJVAR.getStillFluid(), FluidConstants.BUCKET / LiquifiedFluidManager.AJVAR.getMultiplier() * 3 / 2)),

            CREMA = createRecipeWithAnyMilk(Registry.ITEM.getId(CroptopiaItems.CREMA), false, b -> b
                .require(CommonItemTags.FRUITS.LIMES)
                .require(CommonItemTags.SALTS)
                .output(CroptopiaItems.CREMA)
                .output(0.5f, CroptopiaItems.CREMA)),
            CREMA_SOY_MILK = createRecipeWithAnyMilk(Registry.ITEM.getId(CroptopiaItems.CREMA), true, b -> b
                .require(CommonItemTags.FRUITS.LIMES)
                .require(CommonItemTags.SALTS)
                .output(CroptopiaItems.CREMA)
                .output(0.5f, CroptopiaItems.CREMA)),
            OATMEAL = createRecipeWithAnyMilk(Registry.ITEM.getId(CroptopiaItems.OATMEAL), false, b -> b
                .require(Items.BOWL)
                .require(CommonItemTags.GRAIN.OATS)
                .output(CroptopiaItems.OATMEAL)
                .output(0.5f, CroptopiaItems.OATMEAL)),
            OATMEAL_SOY_MILK = createRecipeWithAnyMilk(Registry.ITEM.getId(CroptopiaItems.OATMEAL), true, b -> b
                .require(Items.BOWL)
                .require(CommonItemTags.GRAIN.OATS)
                .output(CroptopiaItems.OATMEAL)
                .output(0.5f, CroptopiaItems.OATMEAL)),
            YOGHURT = createRecipeWithAnyMilk(Registry.ITEM.getId(CroptopiaItems.YOGHURT), false, b -> b
                .require(Items.BOWL)
                .require(CommonItemTags.FRUITS.STRAWBERRIES)
                .output(CroptopiaItems.YOGHURT)
                .output(0.5f, CroptopiaItems.YOGHURT)),
            YOGHURT_SOY_MILK = createRecipeWithAnyMilk(Registry.ITEM.getId(CroptopiaItems.YOGHURT), true, b -> b
                .require(Items.BOWL)
                .require(CommonItemTags.FRUITS.STRAWBERRIES)
                .output(CroptopiaItems.YOGHURT)
                .output(0.5f, CroptopiaItems.YOGHURT)),
            TRIFFLE = createRecipeWithAnyMilk(Registry.ITEM.getId(CroptopiaItems.TRIFLE), false, b -> b
                .require(LiquifiedFluidManager.WINE.getStillFluid(), FluidConstants.BOTTLE)
                .require(CommonItemTags.BUTTERS)
                .require(Items.EGG)
                .require(CommonItemTags.CROPS.VANILLA)
                .require(CommonItemTags.FRUITS.STRAWBERRIES)
                .require(Items.BREAD)
                .output(CroptopiaItems.TRIFLE)
                .output(0.5f, CroptopiaItems.TRIFLE)),
            TRIFFLE_SOY_MILK = createRecipeWithAnyMilk(Registry.ITEM.getId(CroptopiaItems.TRIFLE), true, b -> b
                .require(LiquifiedFluidManager.WINE.getStillFluid(), FluidConstants.BOTTLE)
                .require(CommonItemTags.BUTTERS)
                .require(Items.EGG)
                .require(CommonItemTags.CROPS.VANILLA)
                .require(CommonItemTags.FRUITS.STRAWBERRIES)
                .require(Items.BREAD)
                .output(CroptopiaItems.TRIFLE)
                .output(0.5f, CroptopiaItems.TRIFLE)),
            TRAIL_MIX = create(Registry.ITEM.getId(CroptopiaItems.TRAIL_MIX), b -> b
                .require(LiquifiedFluidManager.CHOCOLATE.getStillFluid(), FluidConstants.BUCKET / LiquifiedFluidManager.CHOCOLATE.getMultiplier())
                .require(CommonItemTags.NUTS.ROOT)
                .require(CommonItemTags.NUTS.ROOT)
                .require(CommonItemTags.NUTS.ROOT)
                .require(CommonItemTags.RAISINS)
                .require(CommonItemTags.SALTS)
                .output(CroptopiaItems.TRAIL_MIX, 6)),
            PEANUT_BUTTER_W_CELERY = create(Registry.ITEM.getId(CroptopiaItems.PEANUT_BUTTER_W_CELERY), b -> b
                .require(LiquifiedFluidManager.PEANUT_BUTTER.getStillFluid(), FluidConstants.BUCKET / LiquifiedFluidManager.PEANUT_BUTTER.getMultiplier())
                .require(CommonItemTags.VEGETABLES.CELERY)
                .output(CroptopiaItems.PEANUT_BUTTER_W_CELERY)
                .output(0.5f, CroptopiaItems.PEANUT_BUTTER_W_CELERY)),
            ETON_MESS = create(Registry.ITEM.getId(CroptopiaItems.ETON_MESS), b -> b
                .require(LiquifiedFluidManager.WHIPPING_CREAM.getStillFluid(), FluidConstants.BUCKET / LiquifiedFluidManager.WHIPPING_CREAM.getMultiplier())
                .require(Items.EGG)
                .require(Items.EGG)
                .require(CommonItemTags.FRUITS.STRAWBERRIES)
                .require(CommonItemTags.FRUITS.STRAWBERRIES)
                .require(Items.SUGAR)
                .output(CroptopiaItems.ETON_MESS)
                .output(0.5f, CroptopiaItems.ETON_MESS)),
            KIWI_SORBET = create(Registry.ITEM.getId(CroptopiaItems.KIWI_SORBET), b -> b
                .require(AllFluids.HONEY.get(), FluidConstants.BOTTLE)
                .require(CommonItemTags.FRUITS.KIWIS)
                .output(CroptopiaItems.KIWI_SORBET)
                .output(0.5f, CroptopiaItems.KIWI_SORBET));


    }

    private void generateCookingBoilingRecipes() {
        GeneratedRecipe
            SALT = create(Registry.ITEM.getId(CroptopiaItems.SALT), b -> b
            .require(Fluids.WATER, FluidConstants.BOTTLE)
            .output(CroptopiaItems.SALT, 4)
            .output(0.02f, CroptopiaItems.SALT_ORE)
            .requiresHeat(HeatCondition.HEATED)),
            MOLASSES = create(Registry.ITEM.getId(CroptopiaItems.MOLASSES), b -> b
                .require(Fluids.WATER, FluidConstants.BOTTLE)
                .require(Items.SUGAR_CANE)
                .require(Items.SUGAR_CANE)
                .output(LiquifiedFluidManager.MOLASSES.getStillFluid(), FluidConstants.BOTTLE * 3)
                .requiresHeat(HeatCondition.HEATED)
                .duration(250)),
            PUMPKIN_SPICE_LATTE = createRecipeWithAnyMilk(LiquifiedFluidManager.PUMPKIN_SPICE_LATTE.getId(), false, b -> b
                .require(LiquifiedFluidManager.COFFEE.getStillFluid(), FluidConstants.BOTTLE)
                .require(Items.SUGAR)
                .require(CroptopiaItems.PAPRIKA)
                .require(Items.PUMPKIN)
                .output(LiquifiedFluidManager.PUMPKIN_SPICE_LATTE.getStillFluid(), FluidConstants.BOTTLE * 2)
                .requiresHeat(HeatCondition.HEATED)),
            PUMPKIN_SPICE_LATTE_SOY_MILK = createRecipeWithAnyMilk(LiquifiedFluidManager.PUMPKIN_SPICE_LATTE.getId(), true, b -> b
                .require(LiquifiedFluidManager.COFFEE.getStillFluid(), FluidConstants.BOTTLE)
                .require(Items.SUGAR)
                .require(CroptopiaItems.PAPRIKA)
                .require(Items.PUMPKIN)
                .output(LiquifiedFluidManager.PUMPKIN_SPICE_LATTE.getStillFluid(), FluidConstants.BOTTLE * 2)
                .requiresHeat(HeatCondition.HEATED)),
            TEA = create(LiquifiedFluidManager.TEA.getId(), b -> b
                .require(Fluids.WATER, FluidConstants.BOTTLE * 2)
                .require(CroptopiaItems.TEA_LEAVES)
                .output(LiquifiedFluidManager.TEA.getStillFluid(), FluidConstants.BOTTLE * 2)
                .requiresHeat(HeatCondition.HEATED)),

            // jams
            GRAPE_JAM = createJamRecipe(LiquifiedFluidManager.GRAPE_JAM, CommonItemTags.FRUITS.GRAPES),
            STRAWBERRY_JAM = createJamRecipe(LiquifiedFluidManager.STRAWBERRY_JAM, CommonItemTags.FRUITS.STRAWBERRIES),
            PEACH_JAM = createJamRecipe(LiquifiedFluidManager.PEACH_JAM, CommonItemTags.FRUITS.PEACHES),
            APRICOT_JAM = createJamRecipe(LiquifiedFluidManager.APRICOT_JAM, CommonItemTags.FRUITS.APRICOTS),
            BLACKBERRY_JAM = createJamRecipe(LiquifiedFluidManager.BLACKBERRY_JAM, CommonItemTags.FRUITS.BLACKBERRIES),
            BLUEBERRY_JAM = createJamRecipe(LiquifiedFluidManager.BLUEBERRY_JAM, CommonItemTags.FRUITS.BLUEBERRIES),
            CHERRY_JAM = createJamRecipe(LiquifiedFluidManager.CRANBERRY_JUICE, CommonItemTags.FRUITS.CRANBERRIES),
            ELDERBERRY_JAM = createJamRecipe(LiquifiedFluidManager.ELDERBERRY_JAM, CommonItemTags.FRUITS.ELDERBERRIES),
            RASPBERRY_JAM = createJamRecipe(LiquifiedFluidManager.RASPBERRY_JAM, CommonItemTags.FRUITS.RASPBERRIES),
            GRAPE_JAM_FROM_JUICE = createJamRecipeFromJuice(LiquifiedFluidManager.GRAPE_JUICE, LiquifiedFluidManager.GRAPE_JAM),

            SALSA = create(LiquifiedFluidManager.SALSA.getId(), b -> b
                .require(CommonItemTags.VEGETABLES.TOMATOES)
                .require(CommonItemTags.CROPS.CHILE_PEPPERS)
                .require(CommonItemTags.SALTS)
                .require(CommonItemTags.FRUITS.LIMES)
                .require(CommonItemTags.VEGETABLES.TOMATILLOS)
                .output(LiquifiedFluidManager.SALSA.getStillFluid(), FluidConstants.BUCKET)
                .requiresHeat(HeatCondition.HEATED)),
            ARTICHOKE_DIP = create(LiquifiedFluidManager.ARTICHOKE_DIP.getId(), b -> b
                .require(LiquifiedFluidManager.CHEESE.getStillFluid(), FluidConstants.BUCKET / LiquifiedFluidManager.CHEESE.getMultiplier())
                .require(CommonItemTags.VEGETABLES.ARTICHOKES)
                .output(LiquifiedFluidManager.ARTICHOKE_DIP.getStillFluid(), FluidConstants.BUCKET / LiquifiedFluidManager.ARTICHOKE_DIP.getMultiplier() * 3 / 2)
                .requiresHeat(HeatCondition.HEATED)),

            // melted ingredients
            BUTTER = createRecipeWithAnyMilk(LiquifiedFluidManager.BUTTER.getId(), false, b -> b
                .require(CommonItemTags.SALTS)
                .require(CroptopiaItems.FOOD_PRESS)
                .output(LiquifiedFluidManager.BUTTER.getStillFluid(), FluidConstants.BUCKET / LiquifiedFluidManager.BUTTER.getMultiplier() * 3 / 2)
                .output(CroptopiaItems.FOOD_PRESS)
                .requiresHeat(HeatCondition.HEATED)),
            BUTTER_SOY_MILK = createRecipeWithAnyMilk(LiquifiedFluidManager.BUTTER.getId(), true, b -> b
                .require(CommonItemTags.SALTS)
                .require(CroptopiaItems.FOOD_PRESS)
                .output(LiquifiedFluidManager.BUTTER.getStillFluid(), FluidConstants.BUCKET / LiquifiedFluidManager.BUTTER.getMultiplier() * 3 / 2)
                .output(CroptopiaItems.FOOD_PRESS)
                .requiresHeat(HeatCondition.HEATED)),
            CHEESE = createRecipeWithAnyMilk(LiquifiedFluidManager.CHEESE.getId(), false, b -> b
                .require(CommonItemTags.SALTS)
                .output(LiquifiedFluidManager.CHEESE.getStillFluid(), FluidConstants.BUCKET / LiquifiedFluidManager.CHEESE.getMultiplier() * 3 / 2)
                .requiresHeat(HeatCondition.HEATED)),
            CHEESE_SOY_MILK = createRecipeWithAnyMilk(LiquifiedFluidManager.CHEESE.getId(), true, b -> b
                .require(CommonItemTags.SALTS)
                .output(LiquifiedFluidManager.CHEESE.getStillFluid(), FluidConstants.BUCKET / LiquifiedFluidManager.CHEESE.getMultiplier() * 3 / 2)
                .requiresHeat(HeatCondition.HEATED)),
            CHOCOLATE = create(LiquifiedFluidManager.CHOCOLATE.getId(), b -> b
                .require(LiquifiedFluidManager.BUTTER.getStillFluid(), FluidConstants.BUCKET / LiquifiedFluidManager.BUTTER.getMultiplier())
                .require(Items.COCOA_BEANS)
                .output(LiquifiedFluidManager.CHOCOLATE.getStillFluid(), FluidConstants.BUCKET)
                .requiresHeat(HeatCondition.HEATED)),
            CARAMEL = create(LiquifiedFluidManager.CARAMEL.getId(), b -> b
                .require(Items.SUGAR)
                .output(LiquifiedFluidManager.CARAMEL.getStillFluid(), FluidConstants.BUCKET / LiquifiedFluidManager.CARAMEL.getMultiplier() * 3 / 2)
                .requiresHeat(HeatCondition.HEATED)),

            // frying
            CHILI_RELLENO = create(Registry.ITEM.getId(CroptopiaItems.CHILI_RELLENO), b -> b
                .require(LiquifiedFluidManager.OLIVE_OIL.getStillFluid(), FluidConstants.BUCKET / LiquifiedFluidManager.OLIVE_OIL.getMultiplier() / 2)
                .require(Items.EGG)
                .require(CommonItemTags.CROPS.CHILE_PEPPERS)
                .require(CommonItemTags.FLOUR)
                .require(CommonItemTags.SALTS)
                .output(CroptopiaItems.CHILI_RELLENO)
                .output(0.5f, CroptopiaItems.CHILI_RELLENO)
                .requiresHeat(HeatCondition.HEATED)
                .duration(250)),
            CHICKEN_AND_NOODLES = create(Registry.ITEM.getId(CroptopiaItems.CHICKEN_AND_NOODLES), b -> b
                .require(LiquifiedFluidManager.OLIVE_OIL.getStillFluid(), FluidConstants.BUCKET / LiquifiedFluidManager.OLIVE_OIL.getMultiplier() / 2)
                .require(CommonItemTags.NOODLES)
                .require(CommonItemTags.CROPS.CHILE_PEPPERS)
                .require(CroptopiaItemTags.CHICKEN_REPLACEMENTS)
                .output(CroptopiaItems.CHICKEN_AND_NOODLES)
                .output(0.5f, CroptopiaItems.CHICKEN_AND_NOODLES)
                .requiresHeat(HeatCondition.HEATED)
                .duration(250)),
            FRENCH_FRIES = create(Registry.ITEM.getId(CroptopiaItems.FRENCH_FRIES), b -> b
                .require(LiquifiedFluidManager.OLIVE_OIL.getStillFluid(), FluidConstants.BUCKET / LiquifiedFluidManager.OLIVE_OIL.getMultiplier() / 2)
                .require(Items.POTATO)
                .require(CommonItemTags.SALTS)
                .output(CroptopiaItems.FRENCH_FRIES)
                .output(0.5f, CroptopiaItems.FRENCH_FRIES)
                .requiresHeat(HeatCondition.HEATED)
                .duration(250)),
            SWEET_POTATO_FRIES = create(Registry.ITEM.getId(CroptopiaItems.SWEET_POTATO_FRIES), b -> b
                .require(LiquifiedFluidManager.OLIVE_OIL.getStillFluid(), FluidConstants.BUCKET / LiquifiedFluidManager.OLIVE_OIL.getMultiplier() / 2)
                .require(CommonItemTags.VEGETABLES.SWEETPOTATOS)
                .require(CommonItemTags.SALTS)
                .output(CroptopiaItems.SWEET_POTATO_FRIES)
                .output(0.5f, CroptopiaItems.SWEET_POTATO_FRIES)
                .requiresHeat(HeatCondition.HEATED)
                .duration(250)),
            ONION_RINGS = create(Registry.ITEM.getId(CroptopiaItems.ONION_RINGS), b -> b
                .require(LiquifiedFluidManager.OLIVE_OIL.getStillFluid(), FluidConstants.BUCKET / LiquifiedFluidManager.OLIVE_OIL.getMultiplier() / 2)
                .require(CommonItemTags.VEGETABLES.ONION)
                .require(CommonItemTags.SALTS)
                .require(CommonItemTags.FLOUR)
                .output(CroptopiaItems.ONION_RINGS)
                .output(0.5f, CroptopiaItems.ONION_RINGS)
                .requiresHeat(HeatCondition.HEATED)
                .duration(250)),
            BEEF_STIR_FRY = create(Registry.ITEM.getId(CroptopiaItems.BEEF_STIR_FRY), b -> b
                .require(LiquifiedFluidManager.OLIVE_OIL.getStillFluid(), FluidConstants.BUCKET / LiquifiedFluidManager.OLIVE_OIL.getMultiplier() / 2)
                .require(LiquifiedFluidManager.SOY_SAUCE.getStillFluid(), FluidConstants.BUCKET / LiquifiedFluidManager.SOY_SAUCE.getMultiplier() / 2)
                .require(CommonItemTags.VEGETABLES.BROCCOLI)
                .require(CommonItemTags.VEGETABLES.GARLIC)
                .require(Items.BEEF)
                .require(Items.CARROT)
                .output(CroptopiaItems.BEEF_STIR_FRY)
                .output(0.5f, CroptopiaItems.BEEF_STIR_FRY)
                .requiresHeat(HeatCondition.HEATED)
                .duration(250)),
            STIR_FRY = create(Registry.ITEM.getId(CroptopiaItems.STIR_FRY), b -> b
                .require(LiquifiedFluidManager.OLIVE_OIL.getStillFluid(), FluidConstants.BUCKET / LiquifiedFluidManager.OLIVE_OIL.getMultiplier() / 2)
                .require(CommonItemTags.VEGETABLES.BROCCOLI)
                .require(CommonItemTags.VEGETABLES.GARLIC)
                .require(CommonItemTags.VEGETABLES.GREENONIONS)
                .require(CommonItemTags.FRUITS.BELLPEPPERS)
                .require(Items.CARROT)
                .output(CroptopiaItems.STIR_FRY)
                .output(0.5f, CroptopiaItems.STIR_FRY)
                .requiresHeat(HeatCondition.HEATED)
                .duration(250)),
            GRILLED_EGGPLANT = create(Registry.ITEM.getId(CroptopiaItems.GRILLED_EGGPLANT), b -> b
                .require(LiquifiedFluidManager.OLIVE_OIL.getStillFluid(), FluidConstants.BUCKET / LiquifiedFluidManager.OLIVE_OIL.getMultiplier() / 2)
                .require(CommonItemTags.VEGETABLES.EGGPLANT)
                .require(CommonItemTags.VEGETABLES.GARLIC)
                .require(CommonItemTags.SALTS)
                .require(CroptopiaItems.PEPPER)
                .require(CommonItemTags.CROPS.PAPRIKA)
                .output(CroptopiaItems.GRILLED_EGGPLANT)
                .output(0.5f, CroptopiaItems.GRILLED_EGGPLANT)
                .requiresHeat(HeatCondition.HEATED)
                .duration(250)),
            CHEESY_ASPARAGUS = create(Registry.ITEM.getId(CroptopiaItems.CHEESY_ASPARAGUS), b -> b
                .require(LiquifiedFluidManager.OLIVE_OIL.getStillFluid(), FluidConstants.BUCKET / LiquifiedFluidManager.OLIVE_OIL.getMultiplier() / 2)
                .require(CommonItemTags.VEGETABLES.ASPARAGUS)
                .require(CommonItemTags.CHEESES)
                .require(CroptopiaItems.PEPPER)
                .output(CroptopiaItems.CHEESY_ASPARAGUS)
                .output(0.5f, CroptopiaItems.CHEESY_ASPARAGUS)
                .requiresHeat(HeatCondition.HEATED)
                .duration(250)),
            ROASTED_ASPARAGUS = create(Registry.ITEM.getId(CroptopiaItems.ROASTED_ASPARAGUS), b -> b
                .require(LiquifiedFluidManager.OLIVE_OIL.getStillFluid(), FluidConstants.BUCKET / LiquifiedFluidManager.OLIVE_OIL.getMultiplier() / 2)
                .require(CommonItemTags.VEGETABLES.ASPARAGUS)
                .require(CommonItemTags.VEGETABLES.GARLIC)
                .require(CommonItemTags.SALTS)
                .require(CroptopiaItems.PEPPER)
                .output(CroptopiaItems.ROASTED_ASPARAGUS, 3)
                .requiresHeat(HeatCondition.HEATED)
                .duration(250)),
            ROASTED_RADISHES = create(Registry.ITEM.getId(CroptopiaItems.ROASTED_RADISHES), b -> b
                .require(LiquifiedFluidManager.OLIVE_OIL.getStillFluid(), FluidConstants.BUCKET / LiquifiedFluidManager.OLIVE_OIL.getMultiplier() / 2)
                .require(CommonItemTags.VEGETABLES.RADISHES)
                .require(CommonItemTags.VEGETABLES.GARLIC)
                .require(CommonItemTags.SALTS)
                .require(CroptopiaItems.PEPPER)
                .output(CroptopiaItems.ROASTED_RADISHES, 3)
                .requiresHeat(HeatCondition.HEATED)
                .duration(250)),
            ROASTED_SQUASH = create(Registry.ITEM.getId(CroptopiaItems.ROASTED_SQUASH), b -> b
                .require(LiquifiedFluidManager.OLIVE_OIL.getStillFluid(), FluidConstants.BUCKET / LiquifiedFluidManager.OLIVE_OIL.getMultiplier() / 2)
                .require(CommonItemTags.VEGETABLES.SQUASH)
                .require(CommonItemTags.VEGETABLES.GARLIC)
                .require(CommonItemTags.SALTS)
                .require(CroptopiaItems.PEPPER)
                .output(CroptopiaItems.ROASTED_SQUASH, 3)
                .requiresHeat(HeatCondition.HEATED)
                .duration(250)),
            ROASTED_TURNIPS = create(Registry.ITEM.getId(CroptopiaItems.ROASTED_TURNIPS), b -> b
                .require(LiquifiedFluidManager.OLIVE_OIL.getStillFluid(), FluidConstants.BUCKET / LiquifiedFluidManager.OLIVE_OIL.getMultiplier() / 2)
                .require(CommonItemTags.VEGETABLES.TURNIPS)
                .require(CommonItemTags.VEGETABLES.GARLIC)
                .require(CommonItemTags.SALTS)
                .require(CroptopiaItems.PEPPER)
                .output(CroptopiaItems.ROASTED_TURNIPS, 3)
                .requiresHeat(HeatCondition.HEATED)
                .duration(250)),
            SPAGHETTI_SQUASH = create(Registry.ITEM.getId(CroptopiaItems.SPAGHETTI_SQUASH), b -> b
                .require(LiquifiedFluidManager.OLIVE_OIL.getStillFluid(), FluidConstants.BUCKET / LiquifiedFluidManager.OLIVE_OIL.getMultiplier() / 2)
                .require(CommonItemTags.VEGETABLES.SQUASH)
                .require(CommonItemTags.CROPS.CHILE_PEPPERS)
                .output(CroptopiaItems.SPAGHETTI_SQUASH)
                .output(0.5f,  CroptopiaItems.SPAGHETTI_SQUASH)
                .requiresHeat(HeatCondition.HEATED)
                .duration(250)),
            RATATAOUILLE = create(Registry.ITEM.getId(CroptopiaItems.RATATOUILLE), b -> b
                .require(LiquifiedFluidManager.OLIVE_OIL.getStillFluid(), FluidConstants.BUCKET / LiquifiedFluidManager.OLIVE_OIL.getMultiplier() / 2)
                .require(CommonItemTags.VEGETABLES.EGGPLANT)
                .require(CommonItemTags.VEGETABLES.TOMATOES)
                .require(CommonItemTags.VEGETABLES.SQUASH)
                .require(CommonItemTags.VEGETABLES.ZUCCHINI)
                .require(CommonItemTags.VEGETABLES.ONION)
                .require(CommonItemTags.FRUITS.BELLPEPPERS)
                .require(CommonItemTags.CROPS.BASIL)
                .output(CroptopiaItems.RATATOUILLE, 3)
                .requiresHeat(HeatCondition.HEATED)
                .duration(250)),
            BUTTERED_GREEN_BEANS = create(Registry.ITEM.getId(CroptopiaItems.BUTTERED_GREEN_BEANS), b -> b
                .require(LiquifiedFluidManager.BUTTER.getStillFluid(), FluidConstants.BUCKET / LiquifiedFluidManager.BUTTER.getMultiplier())
                .require(CommonItemTags.VEGETABLES.GREENBEANS)
                .require(CommonItemTags.VEGETABLES.GINGER)
                .require(CommonItemTags.SALTS)
                .require(CroptopiaItems.PEPPER)
                .output(CroptopiaItems.BUTTERED_GREEN_BEANS)
                .output(0.5f, CroptopiaItems.BUTTERED_GREEN_BEANS)
                .requiresHeat(HeatCondition.HEATED)
                .duration(250)),
            CHEESE_BURGER = create(Registry.ITEM.getId(CroptopiaItems.CHEESEBURGER), b -> b
                .require(LiquifiedFluidManager.CHEESE.getStillFluid(), FluidConstants.BUCKET / LiquifiedFluidManager.CHEESE.getMultiplier())
                .require(Items.BREAD)
                .require(CroptopiaItemTags.MEAT_REPLACEMENTS)
                .output(CroptopiaItems.CHEESEBURGER)
                .output(0.5f, CroptopiaItems.CHEESEBURGER)
                .requiresHeat(HeatCondition.HEATED)
                .duration(250)),
            ENCHILADA = create(Registry.ITEM.getId(CroptopiaItems.ENCHILADA), b -> b
                .require(LiquifiedFluidManager.CHEESE.getStillFluid(), FluidConstants.BUCKET / LiquifiedFluidManager.CHEESE.getMultiplier())
                .require(CroptopiaItemTags.MEAT_REPLACEMENTS)
                .require(CommonItemTags.VEGETABLES.TOMATOES)
                .require(CommonItemTags.TORTILLAS)
                .output(CroptopiaItems.ENCHILADA, 3)
                .requiresHeat(HeatCondition.HEATED)
                .duration(250)),
            FAJITAS = create(Registry.ITEM.getId(CroptopiaItems.FAJITAS), b -> b
                .require(LiquifiedFluidManager.CHEESE.getStillFluid(), FluidConstants.BUCKET / LiquifiedFluidManager.CHEESE.getMultiplier())
                .require(CroptopiaItemTags.MEAT_REPLACEMENTS)
                .require(CommonItemTags.FRUITS.BELLPEPPERS)
                .require(CommonItemTags.VEGETABLES.ONION)
                .require(CommonItemTags.VEGETABLES.TOMATOES)
                .output(CroptopiaItems.FAJITAS, 3)
                .requiresHeat(HeatCondition.HEATED)
                .duration(250)),
            PINEAPPLE_PEPPERONI_PIZZA = create(Registry.ITEM.getId(CroptopiaItems.PINEAPPLE_PEPPERONI_PIZZA), b -> b
                .require(LiquifiedFluidManager.CHEESE.getStillFluid(), FluidConstants.BUCKET / LiquifiedFluidManager.CHEESE.getMultiplier())
                .require(CommonItemTags.DOUGHS)
                .require(CommonItemTags.CHEESES)
                .require(CommonItemTags.VEGETABLES.TOMATOES)
                .require(CommonItemTags.FRUITS.PINEAPPLES)
                .require(CommonItemTags.FRUITS.PINEAPPLES)
                .require(CommonItemTags.PEPPERONI)
                .output(CroptopiaItems.PINEAPPLE_PEPPERONI_PIZZA)
                .output(0.5f, CroptopiaItems.PINEAPPLE_PEPPERONI_PIZZA)
                .requiresHeat(HeatCondition.HEATED)
                .duration(250)),
            PIZZA = create(Registry.ITEM.getId(CroptopiaItems.PIZZA), b -> b
                .require(LiquifiedFluidManager.CHEESE.getStillFluid(), FluidConstants.BUCKET / LiquifiedFluidManager.CHEESE.getMultiplier())
                .require(CommonItemTags.DOUGHS)
                .require(CommonItemTags.VEGETABLES.TOMATOES)
                .output(CroptopiaItems.PIZZA)
                .output(0.5f, CroptopiaItems.PIZZA)
                .requiresHeat(HeatCondition.HEATED)
                .duration(250)),
            CHEESE_PIZZA = create(Registry.ITEM.getId(CroptopiaItems.CHEESE_PIZZA), b -> b
                .require(LiquifiedFluidManager.CHEESE.getStillFluid(), FluidConstants.BUCKET / LiquifiedFluidManager.CHEESE.getMultiplier() * 2)
                .require(CommonItemTags.DOUGHS)
                .require(CommonItemTags.VEGETABLES.TOMATOES)
                .output(CroptopiaItems.CHEESE_PIZZA)
                .output(0.5f, CroptopiaItems.CHEESE_PIZZA)
                .requiresHeat(HeatCondition.HEATED)
                .duration(250)),
            SUPREME_PIZZA = create(Registry.ITEM.getId(CroptopiaItems.SUPREME_PIZZA), b -> b
                .require(LiquifiedFluidManager.CHEESE.getStillFluid(), FluidConstants.BUCKET / LiquifiedFluidManager.CHEESE.getMultiplier())
                .require(CommonItemTags.DOUGHS)
                .require(CommonItemTags.VEGETABLES.TOMATOES)
                .require(CommonItemTags.FRUITS.BELLPEPPERS)
                .require(CommonItemTags.FRUITS.OLIVES)
                .require(CroptopiaItemTags.MEAT_REPLACEMENTS)
                .output(CroptopiaItems.SUPREME_PIZZA)
                .output(0.5f, CroptopiaItems.SUPREME_PIZZA)
                .requiresHeat(HeatCondition.HEATED)
                .duration(250)),
            QUESADILLA = create(Registry.ITEM.getId(CroptopiaItems.QUESADILLA), b -> b
                .require(LiquifiedFluidManager.CHEESE.getStillFluid(), FluidConstants.BUCKET / LiquifiedFluidManager.CHEESE.getMultiplier())
                .require(CommonItemTags.TORTILLAS)
                .require(CommonItemTags.TORTILLAS)
                .require(CommonItemTags.FRUITS.AVOCADOS)
                .require(CroptopiaItemTags.CHICKEN_REPLACEMENTS)
                .output(CroptopiaItems.QUESADILLA, 3)
                .requiresHeat(HeatCondition.HEATED)
                .duration(250)),
            RAVIOLI = create(Registry.ITEM.getId(CroptopiaItems.RAVIOLI), b -> b
                .require(LiquifiedFluidManager.CHEESE.getStillFluid(), FluidConstants.BUCKET / LiquifiedFluidManager.CHEESE.getMultiplier())
                .require(CommonItemTags.NOODLES)
                .output(CroptopiaItems.RAVIOLI, 3)
                .requiresHeat(HeatCondition.HEATED)
                .duration(250)),
            REFRIED_BEANS = create(Registry.ITEM.getId(CroptopiaItems.REFRIED_BEANS), b -> b
                .require(LiquifiedFluidManager.CHEESE.getStillFluid(), FluidConstants.BUCKET / LiquifiedFluidManager.CHEESE.getMultiplier())
                .require(CommonItemTags.CROPS.BLACKBEANS)
                .require(CommonItemTags.CROPS.BLACKBEANS)
                .require(CroptopiaItems.PEPPER)
                .output(CroptopiaItems.REFRIED_BEANS, 3)
                .requiresHeat(HeatCondition.HEATED)
                .duration(250)),
            SCRAMBLED_EGGS = create(Registry.ITEM.getId(CroptopiaItems.SCRAMBLED_EGGS), b -> b
                .require(LiquifiedFluidManager.CHEESE.getStillFluid(), FluidConstants.BUCKET / LiquifiedFluidManager.CHEESE.getMultiplier())
                .require(Items.EGG)
                .output(CroptopiaItems.SCRAMBLED_EGGS)
                .output(0.5f, CroptopiaItems.SCRAMBLED_EGGS)
                .requiresHeat(HeatCondition.HEATED)
                .duration(250)
            ),


            // others
            CHICKEN_AND_DUMPLINGS = create(Registry.ITEM.getId(CroptopiaItems.CHICKEN_AND_DUMPLINGS), b -> b
                .require(CommonItemTags.DOUGHS)
                .require(CommonItemTags.CROPS.CHILE_PEPPERS)
                .require(Items.CHICKEN)
                .output(CroptopiaItems.CHICKEN_AND_DUMPLINGS)
                .output(0.5f, CroptopiaItems.CHICKEN_AND_DUMPLINGS)
                .requiresHeat(HeatCondition.HEATED)
                .duration(250)),
            CHIMICHANGA = create(Registry.ITEM.getId(CroptopiaItems.CHIMICHANGA), b -> b
                .require(CroptopiaItems.BURRITO)
                .require(CommonItemTags.FLOUR)
                .output(CroptopiaItems.CHIMICHANGA)
                .output(0.5f, CroptopiaItems.CHIMICHANGA)
                .requiresHeat(HeatCondition.HEATED)
                .duration(250)),
            STEAMED_RICE = create(Registry.ITEM.getId(CroptopiaItems.STEAMED_RICE), b -> b
                .require(Fluids.WATER, FluidConstants.BOTTLE)
                .require(CommonItemTags.GRAIN.RICE)
                .require(CommonItemTags.SALTS)
                .output(CroptopiaItems.STEAMED_RICE)
                .output(0.5f, CroptopiaItems.STEAMED_RICE)
                .requiresHeat(HeatCondition.HEATED)
                .duration(250)),
            STUFFED_POBLANOS = create(Registry.ITEM.getId(CroptopiaItems.STUFFED_POBLANOS), b -> b
                .require(LiquifiedFluidManager.CHEESE.getStillFluid(), FluidConstants.BUCKET / LiquifiedFluidManager.CHEESE.getMultiplier())
                .require(CroptopiaItemTags.BEEF_REPLACEMENTS)
                .require(CroptopiaItems.PEPPER)
                .require(CommonItemTags.CROPS.BLACKBEANS)
                .require(CommonItemTags.GRAIN.CORN)
                .require(CommonItemTags.GRAIN.RICE)
                .output(CroptopiaItems.STUFFED_POBLANOS)
                .output(0.5f, CroptopiaItems.STUFFED_POBLANOS)
                .requiresHeat(HeatCondition.HEATED)
                .duration(250)),
            TAMALES = create(Registry.ITEM.getId(CroptopiaItems.TAMALES), b -> b
                .require(Items.CHICKEN)
                .require(CommonItemTags.VEGETABLES.ONION)
                .require(CroptopiaItems.CORN_HUSK)
                .require(CommonItemTags.FLOUR)
                .require(CommonItemTags.SALTS)
                .require(CroptopiaItems.PEPPER)
                .output(CroptopiaItems.TAMALES, 3)
                .requiresHeat(HeatCondition.HEATED)
                .duration(250)),
            TOFU = create(Registry.ITEM.getId(CroptopiaItems.TOFU), b -> b
                .require(Fluids.WATER, FluidConstants.BOTTLE)
                .require(CommonItemTags.VEGETABLES.SOYBEANS)
                .output(CroptopiaItems.TOFU)
                .output(0.5f, CroptopiaItems.TOFU)
                .requiresHeat(HeatCondition.HEATED)
                .duration(250)),
            TOFU_AND_DUMPLINGS = create(Registry.ITEM.getId(CroptopiaItems.TOFU_AND_DUMPLINGS), b -> b
                .require(CommonItemTags.DOUGHS)
                .require(CommonItemTags.CROPS.CHILE_PEPPERS)
                .require(CommonItemTags.TOFU)
                .output(CroptopiaItems.TOFU_AND_DUMPLINGS)
                .output(0.5f, CroptopiaItems.TOFU_AND_DUMPLINGS)
                .requiresHeat(HeatCondition.HEATED)
                .duration(250)),
            TACO = create(Registry.ITEM.getId(CroptopiaItems.TACO), b -> b
                .require(LiquifiedFluidManager.SALSA.getStillFluid(), FluidConstants.BUCKET / LiquifiedFluidManager.SALSA.getMultiplier())
                .require(LiquifiedFluidManager.CHEESE.getStillFluid(), FluidConstants.BUCKET / LiquifiedFluidManager.CHEESE.getMultiplier())
                .require(CommonItemTags.TORTILLAS)
                .require(CommonItemTags.VEGETABLES.LETTUCE)
                .require(CroptopiaItemTags.MEAT_REPLACEMENTS)
                .output(CroptopiaItems.TACO)
                .output(0.5f, CroptopiaItems.TACO)
                .duration(250)),
            CASHEW_CHICKEN = create(Registry.ITEM.getId(CroptopiaItems.CASHEW_CHICKEN), b -> b
                .require(LiquifiedFluidManager.SOY_SAUCE.getStillFluid(), FluidConstants.BUCKET / LiquifiedFluidManager.SOY_SAUCE.getMultiplier() / 2)
                .require(CommonItemTags.FRUITS.CASHEWS)
                .require(Items.COOKED_CHICKEN)
                .require(CommonItemTags.VEGETABLES.CABBAGE)
                .require(Items.CARROT)
                .output(CroptopiaItems.CASHEW_CHICKEN)
                .output(0.5f, CroptopiaItems.CASHEW_CHICKEN)
                .requiresHeat(HeatCondition.HEATED)
                .duration(250)),
            ALMOND_BRITTLE = create(Registry.ITEM.getId(CroptopiaItems.ALMOND_BRITTLE), b -> b
                .require(LiquifiedFluidManager.BUTTER.getStillFluid(), FluidConstants.BUCKET / LiquifiedFluidManager.BUTTER.getMultiplier())
                .require(CommonItemTags.NUTS.ALMONDS)
                .require(Items.SUGAR)
                .require(Items.SUGAR)
                .output(CroptopiaItems.ALMOND_BRITTLE)
                .output(0.5f, CroptopiaItems.ALMOND_BRITTLE)
                .requiresHeat(HeatCondition.HEATED)
                .duration(250)),
            LEEK_SOUP = createRecipeWithAnyMilk(Registry.ITEM.getId(CroptopiaItems.LEEK_SOUP), false, b -> b
                .require(Items.BOWL)
                .require(CommonItemTags.VEGETABLES.LEEK)
                .require(Items.POTATO)
                .output(CroptopiaItems.LEEK_SOUP)
                .output(0.5f, CroptopiaItems.LEEK_SOUP)
                .requiresHeat(HeatCondition.HEATED)
                .duration(250)),
            LEEK_SOUP_SOY_MILK = createRecipeWithAnyMilk(Registry.ITEM.getId(CroptopiaItems.LEEK_SOUP), true, b -> b
                .require(Items.BOWL)
                .require(CommonItemTags.VEGETABLES.LEEK)
                .require(Items.POTATO)
                .output(CroptopiaItems.LEEK_SOUP)
                .output(0.5f, CroptopiaItems.LEEK_SOUP)
                .requiresHeat(HeatCondition.HEATED)
                .duration(250)),

            CHURROS = createRecipeWithAnyMilk(Registry.ITEM.getId(CroptopiaItems.CHURROS), false, b -> b
                .require(Items.SUGAR)
                .require(CommonItemTags.FLOUR)
                .require(CroptopiaItems.CINNAMON)
                .output(CroptopiaItems.CHURROS, 5)
                .requiresHeat(HeatCondition.HEATED)
                .duration(250)),
            CHURROS_SOY_MILK = createRecipeWithAnyMilk(Registry.ITEM.getId(CroptopiaItems.CHURROS), true, b -> b
                .require(Items.SUGAR)
                .require(CommonItemTags.FLOUR)
                .require(CroptopiaItems.CINNAMON)
                .output(CroptopiaItems.CHURROS, 5)
                .requiresHeat(HeatCondition.HEATED)
                .duration(250)),
            TRES_LECHE_CAKE = createRecipeWithAnyMilk(Registry.ITEM.getId(CroptopiaItems.TRES_LECHE_CAKE), false, b -> b
                .require(LiquifiedFluidManager.RUM.getStillFluid(), FluidConstants.BOTTLE)
                .require(CroptopiaItems.WHIPPING_CREAM)
                .require(Items.EGG)
                .require(Items.SUGAR)
                .require(CommonItemTags.FLOUR)
                .require(CommonItemTags.CROPS.VANILLA)
                .output(CroptopiaItems.TRES_LECHE_CAKE, 3)
                .requiresHeat(HeatCondition.HEATED)
                .duration(250)),
            TRES_LECHE_CAKE_SOY_MILK = createRecipeWithAnyMilk(Registry.ITEM.getId(CroptopiaItems.TRES_LECHE_CAKE), true, b -> b
                .require(LiquifiedFluidManager.RUM.getStillFluid(), FluidConstants.BOTTLE)
                .require(CroptopiaItems.WHIPPING_CREAM)
                .require(Items.EGG)
                .require(Items.SUGAR)
                .require(CommonItemTags.FLOUR)
                .require(CommonItemTags.CROPS.VANILLA)
                .output(CroptopiaItems.TRES_LECHE_CAKE, 3)
                .requiresHeat(HeatCondition.HEATED)
                .duration(250)),
            DOUGHNUT = createRecipeWithAnyMilk(Registry.ITEM.getId(CroptopiaItems.DOUGHNUT), false, b -> b
                .require(CommonItemTags.FLOUR)
                .require(CommonItemTags.FLOUR)
                .require(Items.SUGAR)
                .output(CroptopiaItems.DOUGHNUT)
                .output(0.5f, CroptopiaItems.DOUGHNUT)
                .requiresHeat(HeatCondition.HEATED)
                .duration(250)),
            DOUGHNUT_SOY_MILK = createRecipeWithAnyMilk(Registry.ITEM.getId(CroptopiaItems.DOUGHNUT), true, b -> b
                .require(CommonItemTags.FLOUR)
                .require(CommonItemTags.FLOUR)
                .require(Items.SUGAR)
                .output(CroptopiaItems.DOUGHNUT)
                .output(0.5f, CroptopiaItems.DOUGHNUT)
                .requiresHeat(HeatCondition.HEATED)
                .duration(250)),
            STICKY_TOFFEE_PUDDING = create(Registry.ITEM.getId(CroptopiaItems.STICKY_TOFFEE_PUDDING), b -> b
                .require(LiquifiedFluidManager.BUTTER.getStillFluid(), FluidConstants.BUCKET / LiquifiedFluidManager.BUTTER.getMultiplier())
                .require(CroptopiaItems.WHIPPING_CREAM)
                .require(Fluids.WATER, FluidConstants.BOTTLE)
                .require(Items.EGG)
                .require(CommonItemTags.CROPS.VANILLA)
                .require(Items.SUGAR)
                .require(CommonItemTags.FRUITS.DATES)
                .require(CommonItemTags.SALTS)
                .output(CroptopiaItems.STICKY_TOFFEE_PUDDING)
                .output(0.5f, CroptopiaItems.STICKY_TOFFEE_PUDDING)
                .requiresHeat(HeatCondition.HEATED)
                .duration(250)),
            FIGGY_PUDDING = create(Registry.ITEM.getId(CroptopiaItems.FIGGY_PUDDING), b -> b
                .require(Fluids.WATER, FluidConstants.BOTTLE)
                .require(LiquifiedFluidManager.WHIPPING_CREAM.getStillFluid(), FluidConstants.BUCKET / LiquifiedFluidManager.WHIPPING_CREAM.getMultiplier())
                .require(Items.EGG)
                .require(Items.SUGAR)
                .require(CommonItemTags.FRUITS.DATES)
                .require(CommonItemTags.FRUITS.FIGS)
                .output(CroptopiaItems.FIGGY_PUDDING)
                .output(0.5f, CroptopiaItems.FIGGY_PUDDING)
                .requiresHeat(HeatCondition.HEATED)
                .duration(250)),
            TREACLE_TART = create(Registry.ITEM.getId(CroptopiaItems.TREACLE_TART), b -> b
                .require(AllFluids.HONEY.get(), FluidConstants.BOTTLE)
                .require(CommonItemTags.FRUITS.LEMONS)
                .require(LiquifiedFluidManager.WHIPPING_CREAM.getStillFluid(), FluidConstants.BUCKET / LiquifiedFluidManager.WHIPPING_CREAM.getMultiplier())
                .require(Items.BREAD)
                .require(Items.BREAD)
                .require(Items.BREAD)
                .output(CroptopiaItems.TREACLE_TART, 5)
                .requiresHeat(HeatCondition.HEATED)
                .duration(250));


    }


    private GeneratedRecipe createRecipeWithAnyMilk(Identifier id, Boolean withSoyMilk, UnaryOperator<ProcessingRecipeBuilder<ProcessingRecipe<?>>> transform) {
        Identifier newId = withSoyMilk ?
            new Identifier(id.getNamespace(), id.getPath() + "_with_soy_milk")
            : id;
        return create(newId, b -> transform.apply(b
            .require(withSoyMilk ? LiquifiedFluidManager.SOY_MILK.getStillFluid() : Milk.STILL_MILK, FluidConstants.BOTTLE))
        );
    }

    private GeneratedRecipe createJamRecipe(LiquifiedFluidVariant fluidVariant, Tag.Identified<Item> tag) {
        return create(fluidVariant.getId(), b -> b
            .require(tag)
            .require(Items.SUGAR)
            .output(fluidVariant.getStillFluid(), FluidConstants.BUCKET / fluidVariant.getMultiplier() * 3 / 2)
            .requiresHeat(HeatCondition.HEATED)
        );
    }

    private GeneratedRecipe createJamRecipeFromJuice(LiquifiedFluidVariant from, LiquifiedFluidVariant to) {
        Identifier id = new Identifier(from.getId().getNamespace(), from.getId().getPath() + "_to_" + to.getId().getPath());
        return create(id, b -> b
            .require(from.getStillFluid(), FluidConstants.BUCKET)
            .output(to.getStillFluid(), FluidConstants.BOTTLE)
            .requiresHeat(HeatCondition.HEATED));
    }
}
