package com.anodemc.croptopialiquified.registry;

import com.anodemc.croptopialiquified.fluids.LiquifiedFluidManager;
import net.minecraft.fluid.Fluid;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import javax.swing.text.LayoutQueue;

public class FluidRegistry {
    // juices
    public static final Fluid GRAPE_JUICE = LiquifiedFluidManager.GRAPE_JUICE.getStillFluid();
    public static final Fluid GRAPE_JUICE_FLOWING = LiquifiedFluidManager.GRAPE_JUICE.getFlowingFluid();
    public static final Fluid ORANGE_JUICE = LiquifiedFluidManager.ORANGE_JUICE.getStillFluid();
    public static final Fluid ORANGE_JUICE_FLOWING = LiquifiedFluidManager.ORANGE_JUICE.getFlowingFluid();
    public static final Fluid APPLE_JUICE = LiquifiedFluidManager.APPLE_JUICE.getStillFluid();
    public static final Fluid APPLE_JUICE_FLOWING = LiquifiedFluidManager.APPLE_JUICE.getFlowingFluid();
    public static final Fluid CRANBERRY_JUICE = LiquifiedFluidManager.CRANBERRY_JUICE.getStillFluid();
    public static final Fluid CRANBERRY_JUICE_FLOWING = LiquifiedFluidManager.CRANBERRY_JUICE.getFlowingFluid();
    public static final Fluid SAGUARO_JUICE = LiquifiedFluidManager.SAGUARO_JUICE.getStillFluid();
    public static final Fluid SAGUARO_JUICE_FLOWING = LiquifiedFluidManager.SAGUARO_JUICE.getFlowingFluid();
    public static final Fluid TOMATO_JUICE = LiquifiedFluidManager.TOMATO_JUICE.getStillFluid();
    public static final Fluid TOMATO_JUICE_FLOWING = LiquifiedFluidManager.TOMATO_JUICE.getFlowingFluid();
    public static final Fluid MELON_JUICE = LiquifiedFluidManager.MELON_JUICE.getStillFluid();
    public static final Fluid MELON_JUICE_FLOWING = LiquifiedFluidManager.MELON_JUICE.getFlowingFluid();
    public static final Fluid PINEAPPLE_JUICE = LiquifiedFluidManager.PINEAPPLE_JUICE.getStillFluid();
    public static final Fluid PINEAPPLE_JUICE_FLOWING = LiquifiedFluidManager.PINEAPPLE_JUICE.getFlowingFluid();
    public static final Fluid COFFEE = LiquifiedFluidManager.COFFEE.getStillFluid();
    public static final Fluid COFFEE_FLOWING = LiquifiedFluidManager.COFFEE.getFlowingFluid();
    public static final Fluid LEMONADE = LiquifiedFluidManager.LEMONADE.getStillFluid();
    public static final Fluid LEMONADE_FLOWING = LiquifiedFluidManager.LEMONADE.getFlowingFluid();
    public static final Fluid LIMEADE = LiquifiedFluidManager.LIMEADE.getStillFluid();
    public static final Fluid LIMEADE_FLOWING = LiquifiedFluidManager.LIMEADE.getFlowingFluid();
    public static final Fluid TEA = LiquifiedFluidManager.TEA.getStillFluid();
    public static final Fluid TEA_FLOWING = LiquifiedFluidManager.TEA.getFlowingFluid();
    public static final Fluid STRAWBERRY_SMOOTHIE = LiquifiedFluidManager.STRAWBERRY_SMOOTHIE.getStillFluid();
    public static final Fluid STRAWBERRY_SMOOTHIE_FLOWING = LiquifiedFluidManager.STRAWBERRY_SMOOTHIE.getFlowingFluid();
    public static final Fluid BANANA_SMOOTHIE = LiquifiedFluidManager.BANANA_SMOOTHIE.getStillFluid();
    public static final Fluid BANANA_SMOOTHIE_FLOWING = LiquifiedFluidManager.BANANA_SMOOTHIE.getFlowingFluid();
    public static final Fluid KALE_SMOOTHIE = LiquifiedFluidManager.KALE_SMOOTHIE.getStillFluid();
    public static final Fluid KALE_SMOOTHIE_FLOWING = LiquifiedFluidManager.KALE_SMOOTHIE.getFlowingFluid();
    public static final Fluid FRUIT_SMOOTHIE = LiquifiedFluidManager.FRUIT_SMOOTHIE.getStillFluid();
    public static final Fluid FRUIT_SMOOTHIE_FLOWING = LiquifiedFluidManager.FRUIT_SMOOTHIE.getFlowingFluid();
    public static final Fluid CHOCOLATE_MILKSHAKE = LiquifiedFluidManager.CHOCOLATE_MILKSHAKE.getStillFluid();
    public static final Fluid CHOCOLATE_MILKSHAKE_FLOWING = LiquifiedFluidManager.CHOCOLATE_MILKSHAKE.getFlowingFluid();
    public static final Fluid BEER = LiquifiedFluidManager.BEER.getStillFluid();
    public static final Fluid BEER_FLOWING = LiquifiedFluidManager.BEER.getFlowingFluid();
    public static final Fluid WINE = LiquifiedFluidManager.WINE.getStillFluid();
    public static final Fluid WINE_FLOWING = LiquifiedFluidManager.WINE.getFlowingFluid();
    public static final Fluid MEAD = LiquifiedFluidManager.MEAD.getStillFluid();
    public static final Fluid MEAD_FLOWING = LiquifiedFluidManager.MEAD.getFlowingFluid();
    public static final Fluid RUM = LiquifiedFluidManager.RUM.getStillFluid();
    public static final Fluid RUM_FLOWING = LiquifiedFluidManager.RUM.getFlowingFluid();
    public static final Fluid PUMPKIN_SPICE_LATTE = LiquifiedFluidManager.PUMPKIN_SPICE_LATTE.getStillFluid();
    public static final Fluid PUMPKIN_SPICE_LATTE_FLOWING = LiquifiedFluidManager.PUMPKIN_SPICE_LATTE.getFlowingFluid();
    public static final Fluid SOY_MILK = LiquifiedFluidManager.SOY_MILK.getStillFluid();
    public static final Fluid SOY_MILK_FLOWING = LiquifiedFluidManager.SOY_MILK.getFlowingFluid();

    // jams
    public static final Fluid GRAPE_JAM = LiquifiedFluidManager.GRAPE_JAM.getStillFluid();
    public static final Fluid GRAPE_JAM_FLOWING = LiquifiedFluidManager.GRAPE_JAM.getFlowingFluid();
    public static final Fluid STRAWBERRY_JAM = LiquifiedFluidManager.STRAWBERRY_JAM.getStillFluid();
    public static final Fluid STRAWBERRY_JAM_FLOWING = LiquifiedFluidManager.STRAWBERRY_JAM.getFlowingFluid();
    public static final Fluid PEACH_JAM = LiquifiedFluidManager.PEACH_JAM.getStillFluid();
    public static final Fluid PEACH_JAM_FLOWING = LiquifiedFluidManager.PEACH_JAM.getFlowingFluid();
    public static final Fluid APRICOT_JAM = LiquifiedFluidManager.APRICOT_JAM.getStillFluid();
    public static final Fluid APRICOT_JAM_FLOWING = LiquifiedFluidManager.APRICOT_JAM.getFlowingFluid();
    public static final Fluid BLACKBERRY_JAM = LiquifiedFluidManager.BLACKBERRY_JAM.getStillFluid();
    public static final Fluid BLACKBERRY_JAM_FLOWING = LiquifiedFluidManager.BLACKBERRY_JAM.getFlowingFluid();
    public static final Fluid BLUEBERRY_JAM = LiquifiedFluidManager.BLUEBERRY_JAM.getStillFluid();
    public static final Fluid BLUEBERRY_JAM_FLOWING = LiquifiedFluidManager.BLUEBERRY_JAM.getFlowingFluid();
    public static final Fluid CHERRY_JAM = LiquifiedFluidManager.CHERRY_JAM.getStillFluid();
    public static final Fluid CHERRY_JAM_FLOWING = LiquifiedFluidManager.CHERRY_JAM.getFlowingFluid();
    public static final Fluid ELDERBERRY_JAM = LiquifiedFluidManager.ELDERBERRY_JAM.getStillFluid();
    public static final Fluid ELDERBERRY_JAM_FLOWING = LiquifiedFluidManager.ELDERBERRY_JAM.getFlowingFluid();
    public static final Fluid RASPBERRY_JAM = LiquifiedFluidManager.RASPBERRY_JAM.getStillFluid();
    public static final Fluid RASPBERRY_JAM_FLOWING = LiquifiedFluidManager.RASPBERRY_JAM.getFlowingFluid();
    public static final Fluid PEANUT_BUTTER = LiquifiedFluidManager.PEANUT_BUTTER.getStillFluid();
    public static final Fluid PEANUT_BUTTER_FLOWING = LiquifiedFluidManager.PEANUT_BUTTER.getFlowingFluid();
    public static final Fluid YAM_JAM = LiquifiedFluidManager.YAM_JAM.getStillFluid();
    public static final Fluid YAM_JAM_FLOWING = LiquifiedFluidManager.YAM_JAM.getFlowingFluid();

    // other ingredients
    public static final Fluid WHIPPING_CREAM = LiquifiedFluidManager.WHIPPING_CREAM.getStillFluid();
    public static final Fluid WHIPPING_CREAM_FLOWING = LiquifiedFluidManager.WHIPPING_CREAM.getFlowingFluid();
    public static final Fluid OLIVE_OIL = LiquifiedFluidManager.OLIVE_OIL.getStillFluid();
    public static final Fluid OLIVE_OIL_FLOWING = LiquifiedFluidManager.OLIVE_OIL.getFlowingFluid();
    public static final Fluid SALSA = LiquifiedFluidManager.SALSA.getStillFluid();
    public static final Fluid SALSA_FLOWING = LiquifiedFluidManager.SALSA.getFlowingFluid();
    public static final Fluid ARTICHOKE_DIP = LiquifiedFluidManager.ARTICHOKE_DIP.getStillFluid();
    public static final Fluid ARTICHOKE_DIP_FLOWING = LiquifiedFluidManager.ARTICHOKE_DIP.getFlowingFluid();
    public static final Fluid AJVAR = LiquifiedFluidManager.AJVAR.getStillFluid();
    public static final Fluid AJVAR_FLOWING = LiquifiedFluidManager.AJVAR.getFlowingFluid();
    public static final Fluid MOLASSES = LiquifiedFluidManager.MOLASSES.getStillFluid();
    public static final Fluid MOLASSES_FLOWING = LiquifiedFluidManager.MOLASSES.getFlowingFluid();
    public static final Fluid SOY_SAUCE = LiquifiedFluidManager.SOY_SAUCE.getStillFluid();
    public static final Fluid SOY_SAUCE_FLOWING = LiquifiedFluidManager.SOY_SAUCE.getFlowingFluid();

    // melted ingredients
    public static final Fluid BUTTER = LiquifiedFluidManager.BUTTER.getStillFluid();
    public static final Fluid BUTTER_FLOWING = LiquifiedFluidManager.BUTTER.getFlowingFluid();
    public static final Fluid CHEESE = LiquifiedFluidManager.CHEESE.getStillFluid();
    public static final Fluid CHEESE_FLOWING = LiquifiedFluidManager.CHEESE.getFlowingFluid();
    public static final Fluid CARAMEL = LiquifiedFluidManager.CARAMEL.getStillFluid();
    public static final Fluid CARAMEL_FLOWING = LiquifiedFluidManager.CARAMEL.getFlowingFluid();
    public static final Fluid CHOCOLATE = LiquifiedFluidManager.CHOCOLATE.getStillFluid();
    public static final Fluid CHOCOLATE_FLOWING = LiquifiedFluidManager.CHOCOLATE.getFlowingFluid();

    private static void register(Identifier id, Fluid fluid) {
        Registry.register(Registry.FLUID, id, fluid);
    }

    public static void init() {
        // juices
        register(LiquifiedFluidManager.GRAPE_JUICE.getStillFluidId(), GRAPE_JUICE);
        register(LiquifiedFluidManager.GRAPE_JUICE.getFlowingFluidId(), GRAPE_JUICE_FLOWING);
        register(LiquifiedFluidManager.ORANGE_JUICE.getStillFluidId(), ORANGE_JUICE);
        register(LiquifiedFluidManager.ORANGE_JUICE.getFlowingFluidId(), ORANGE_JUICE_FLOWING);
        register(LiquifiedFluidManager.APPLE_JUICE.getStillFluidId(), APPLE_JUICE);
        register(LiquifiedFluidManager.APPLE_JUICE.getFlowingFluidId(), APPLE_JUICE_FLOWING);
        register(LiquifiedFluidManager.CRANBERRY_JUICE.getStillFluidId(), CRANBERRY_JUICE);
        register(LiquifiedFluidManager.CRANBERRY_JUICE.getFlowingFluidId(), CRANBERRY_JUICE_FLOWING);
        register(LiquifiedFluidManager.SAGUARO_JUICE.getStillFluidId(), SAGUARO_JUICE);
        register(LiquifiedFluidManager.SAGUARO_JUICE.getFlowingFluidId(), SAGUARO_JUICE_FLOWING);
        register(LiquifiedFluidManager.TOMATO_JUICE.getStillFluidId(), TOMATO_JUICE);
        register(LiquifiedFluidManager.TOMATO_JUICE.getFlowingFluidId(), TOMATO_JUICE_FLOWING);
        register(LiquifiedFluidManager.MELON_JUICE.getStillFluidId(), MELON_JUICE);
        register(LiquifiedFluidManager.MELON_JUICE.getFlowingFluidId(), MELON_JUICE_FLOWING);
        register(LiquifiedFluidManager.PINEAPPLE_JUICE.getStillFluidId(), PINEAPPLE_JUICE);
        register(LiquifiedFluidManager.PINEAPPLE_JUICE.getFlowingFluidId(), PINEAPPLE_JUICE_FLOWING);
        register(LiquifiedFluidManager.COFFEE.getStillFluidId(), COFFEE);
        register(LiquifiedFluidManager.COFFEE.getFlowingFluidId(), COFFEE_FLOWING);
        register(LiquifiedFluidManager.LEMONADE.getStillFluidId(), LEMONADE);
        register(LiquifiedFluidManager.LEMONADE.getFlowingFluidId(), LEMONADE_FLOWING);
        register(LiquifiedFluidManager.LIMEADE.getStillFluidId(), LIMEADE);
        register(LiquifiedFluidManager.LIMEADE.getFlowingFluidId(), LIMEADE_FLOWING);
        register(LiquifiedFluidManager.TEA.getStillFluidId(), TEA);
        register(LiquifiedFluidManager.TEA.getFlowingFluidId(), TEA_FLOWING);
        register(LiquifiedFluidManager.STRAWBERRY_SMOOTHIE.getStillFluidId(), STRAWBERRY_SMOOTHIE);
        register(LiquifiedFluidManager.STRAWBERRY_SMOOTHIE.getFlowingFluidId(), STRAWBERRY_SMOOTHIE_FLOWING);
        register(LiquifiedFluidManager.BANANA_SMOOTHIE.getStillFluidId(), BANANA_SMOOTHIE);
        register(LiquifiedFluidManager.BANANA_SMOOTHIE.getFlowingFluidId(), BANANA_SMOOTHIE_FLOWING);
        register(LiquifiedFluidManager.KALE_SMOOTHIE.getStillFluidId(), KALE_SMOOTHIE);
        register(LiquifiedFluidManager.KALE_SMOOTHIE.getFlowingFluidId(), KALE_SMOOTHIE_FLOWING);
        register(LiquifiedFluidManager.FRUIT_SMOOTHIE.getStillFluidId(), FRUIT_SMOOTHIE);
        register(LiquifiedFluidManager.FRUIT_SMOOTHIE.getFlowingFluidId(), FRUIT_SMOOTHIE_FLOWING);
        register(LiquifiedFluidManager.CHOCOLATE_MILKSHAKE.getStillFluidId(), CHOCOLATE_MILKSHAKE);
        register(LiquifiedFluidManager.CHOCOLATE_MILKSHAKE.getFlowingFluidId(), CHOCOLATE_MILKSHAKE_FLOWING);
        register(LiquifiedFluidManager.BEER.getStillFluidId(), BEER);
        register(LiquifiedFluidManager.BEER.getFlowingFluidId(), BEER_FLOWING);
        register(LiquifiedFluidManager.WINE.getStillFluidId(), WINE);
        register(LiquifiedFluidManager.WINE.getFlowingFluidId(), WINE_FLOWING);
        register(LiquifiedFluidManager.MEAD.getStillFluidId(), MEAD);
        register(LiquifiedFluidManager.MEAD.getFlowingFluidId(), MEAD_FLOWING);
        register(LiquifiedFluidManager.RUM.getStillFluidId(), RUM);
        register(LiquifiedFluidManager.RUM.getFlowingFluidId(), RUM_FLOWING);
        register(LiquifiedFluidManager.PUMPKIN_SPICE_LATTE.getStillFluidId(), PUMPKIN_SPICE_LATTE);
        register(LiquifiedFluidManager.PUMPKIN_SPICE_LATTE.getFlowingFluidId(), PUMPKIN_SPICE_LATTE_FLOWING);
        register(LiquifiedFluidManager.SOY_MILK.getStillFluidId(), SOY_MILK);
        register(LiquifiedFluidManager.SOY_MILK.getFlowingFluidId(), SOY_MILK_FLOWING);

        // jams
        register(LiquifiedFluidManager.GRAPE_JAM.getStillFluidId(), GRAPE_JAM);
        register(LiquifiedFluidManager.GRAPE_JAM.getFlowingFluidId(), GRAPE_JAM_FLOWING);
        register(LiquifiedFluidManager.STRAWBERRY_JAM.getStillFluidId(), STRAWBERRY_JAM);
        register(LiquifiedFluidManager.STRAWBERRY_JAM.getFlowingFluidId(), STRAWBERRY_JAM_FLOWING);
        register(LiquifiedFluidManager.PEACH_JAM.getStillFluidId(), PEACH_JAM);
        register(LiquifiedFluidManager.PEACH_JAM.getFlowingFluidId(), PEACH_JAM_FLOWING);
        register(LiquifiedFluidManager.APRICOT_JAM.getStillFluidId(), APRICOT_JAM);
        register(LiquifiedFluidManager.APRICOT_JAM.getFlowingFluidId(), APRICOT_JAM_FLOWING);
        register(LiquifiedFluidManager.BLACKBERRY_JAM.getStillFluidId(), BLACKBERRY_JAM);
        register(LiquifiedFluidManager.BLACKBERRY_JAM.getFlowingFluidId(), BLACKBERRY_JAM_FLOWING);
        register(LiquifiedFluidManager.BLUEBERRY_JAM.getStillFluidId(), BLUEBERRY_JAM);
        register(LiquifiedFluidManager.BLUEBERRY_JAM.getFlowingFluidId(), BLUEBERRY_JAM_FLOWING);
        register(LiquifiedFluidManager.CHERRY_JAM.getStillFluidId(), CHERRY_JAM);
        register(LiquifiedFluidManager.CHERRY_JAM.getFlowingFluidId(), CHERRY_JAM_FLOWING);
        register(LiquifiedFluidManager.ELDERBERRY_JAM.getStillFluidId(), ELDERBERRY_JAM);
        register(LiquifiedFluidManager.ELDERBERRY_JAM.getFlowingFluidId(), ELDERBERRY_JAM_FLOWING);
        register(LiquifiedFluidManager.RASPBERRY_JAM.getStillFluidId(), RASPBERRY_JAM);
        register(LiquifiedFluidManager.RASPBERRY_JAM.getFlowingFluidId(), RASPBERRY_JAM_FLOWING);
        register(LiquifiedFluidManager.PEANUT_BUTTER.getStillFluidId(), PEANUT_BUTTER);
        register(LiquifiedFluidManager.PEANUT_BUTTER.getFlowingFluidId(), PEANUT_BUTTER_FLOWING);
        register(LiquifiedFluidManager.YAM_JAM.getStillFluidId(),YAM_JAM);
        register(LiquifiedFluidManager.YAM_JAM.getFlowingFluidId(), YAM_JAM_FLOWING);

        // other ingredients
        register(LiquifiedFluidManager.WHIPPING_CREAM.getStillFluidId(), WHIPPING_CREAM);
        register(LiquifiedFluidManager.WHIPPING_CREAM.getFlowingFluidId(), WHIPPING_CREAM_FLOWING);
        register(LiquifiedFluidManager.OLIVE_OIL.getStillFluidId(), OLIVE_OIL);
        register(LiquifiedFluidManager.OLIVE_OIL.getFlowingFluidId(), OLIVE_OIL_FLOWING);
        register(LiquifiedFluidManager.SALSA.getStillFluidId(), SALSA);
        register(LiquifiedFluidManager.SALSA.getFlowingFluidId(), SALSA_FLOWING);
        register(LiquifiedFluidManager.ARTICHOKE_DIP.getStillFluidId(), ARTICHOKE_DIP);
        register(LiquifiedFluidManager.ARTICHOKE_DIP.getFlowingFluidId(), ARTICHOKE_DIP_FLOWING);
        register(LiquifiedFluidManager.AJVAR.getStillFluidId(), AJVAR);
        register(LiquifiedFluidManager.AJVAR.getFlowingFluidId(), AJVAR_FLOWING);
        register(LiquifiedFluidManager.MOLASSES.getStillFluidId(), MOLASSES);
        register(LiquifiedFluidManager.MOLASSES.getFlowingFluidId(), MOLASSES_FLOWING);
        register(LiquifiedFluidManager.SOY_SAUCE.getStillFluidId(), SOY_SAUCE);
        register(LiquifiedFluidManager.SOY_SAUCE.getFlowingFluidId(), SOY_SAUCE_FLOWING);

        // melted ingredients
        register(LiquifiedFluidManager.BUTTER.getStillFluidId(), BUTTER);
        register(LiquifiedFluidManager.BUTTER.getFlowingFluidId(), BUTTER_FLOWING);
        register(LiquifiedFluidManager.CHEESE.getStillFluidId(),CHEESE);
        register(LiquifiedFluidManager.CHEESE.getFlowingFluidId(), CHEESE_FLOWING);
        register(LiquifiedFluidManager.CARAMEL.getStillFluidId(), CARAMEL);
        register(LiquifiedFluidManager.CARAMEL.getFlowingFluidId(), CARAMEL_FLOWING);
        register(LiquifiedFluidManager.CHOCOLATE.getStillFluidId(), CHOCOLATE);
        register(LiquifiedFluidManager.CHOCOLATE.getFlowingFluidId(), CHOCOLATE_FLOWING);
    }
}
