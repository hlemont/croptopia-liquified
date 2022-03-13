package com.anodemc.croptopia.liquified.registry;

import com.anodemc.croptopia.liquified.fluids.FluidManager;
import net.minecraft.fluid.Fluid;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class FluidRegistry {
    private static FluidRegistry INSTANCE;

    public static FluidRegistry getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new FluidRegistry();
        }
        return INSTANCE;
    }

    private FluidRegistry() {
        FluidManager manager = FluidManager.getInstance();

        // juices
        GRAPE_JUICE = manager.GRAPE_JUICE.getStillFluid();
        GRAPE_JUICE_FLOWING = manager.GRAPE_JUICE.getFlowingFluid();
        ORANGE_JUICE = manager.ORANGE_JUICE.getStillFluid();
        ORANGE_JUICE_FLOWING = manager.ORANGE_JUICE.getFlowingFluid();
        APPLE_JUICE = manager.APPLE_JUICE.getStillFluid();
        APPLE_JUICE_FLOWING = manager.APPLE_JUICE.getFlowingFluid();
        CRANBERRY_JUICE = manager.CRANBERRY_JUICE.getStillFluid();
        CRANBERRY_JUICE_FLOWING = manager.CRANBERRY_JUICE.getFlowingFluid();
        SAGUARO_JUICE = manager.SAGUARO_JUICE.getStillFluid();
        SAGUARO_JUICE_FLOWING = manager.SAGUARO_JUICE.getFlowingFluid();
        TOMATO_JUICE = manager.TOMATO_JUICE.getStillFluid();
        TOMATO_JUICE_FLOWING = manager.TOMATO_JUICE.getFlowingFluid();
        MELON_JUICE = manager.MELON_JUICE.getStillFluid();
        MELON_JUICE_FLOWING = manager.MELON_JUICE.getFlowingFluid();
        PINEAPPLE_JUICE = manager.PINEAPPLE_JUICE.getStillFluid();
        PINEAPPLE_JUICE_FLOWING = manager.PINEAPPLE_JUICE.getFlowingFluid();
        COFFEE = manager.COFFEE.getStillFluid();
        COFFEE_FLOWING = manager.COFFEE.getFlowingFluid();
        LEMONADE = manager.LEMONADE.getStillFluid();
        LEMONADE_FLOWING = manager.LEMONADE.getFlowingFluid();
        LIMEADE = manager.LIMEADE.getStillFluid();
        LIMEADE_FLOWING = manager.LIMEADE.getFlowingFluid();
        SOY_MILK = manager.SOY_MILK.getStillFluid();
        SOY_MILK_FLOWING = manager.SOY_MILK.getFlowingFluid();
        TEA = manager.TEA.getStillFluid();
        TEA_FLOWING = manager.TEA.getFlowingFluid();
        STRAWBERRY_SMOOTHIE = manager.STRAWBERRY_SMOOTHIE.getStillFluid();
        STRAWBERRY_SMOOTHIE_FLOWING = manager.STRAWBERRY_SMOOTHIE.getFlowingFluid();
        BANANA_SMOOTHIE = manager.BANANA_SMOOTHIE.getStillFluid();
        BANANA_SMOOTHIE_FLOWING = manager.BANANA_SMOOTHIE.getFlowingFluid();
        KALE_SMOOTHIE = manager.KALE_SMOOTHIE.getStillFluid();
        KALE_SMOOTHIE_FLOWING = manager.KALE_SMOOTHIE.getFlowingFluid();
        FRUIT_SMOOTHIE = manager.FRUIT_SMOOTHIE.getStillFluid();
        FRUIT_SMOOTHIE_FLOWING = manager.FRUIT_SMOOTHIE.getFlowingFluid();
        CHOCOLATE_MILKSHAKE = manager.CHOCOLATE_MILKSHAKE.getStillFluid();
        CHOCOLATE_MILKSHAKE_FLOWING = manager.CHOCOLATE_MILKSHAKE.getFlowingFluid();
        BEER = manager.BEER.getStillFluid();
        BEER_FLOWING = manager.BEER.getFlowingFluid();
        WINE = manager.WINE.getStillFluid();
        WINE_FLOWING = manager.WINE.getFlowingFluid();
        MEAD = manager.MEAD.getStillFluid();
        MEAD_FLOWING = manager.MEAD.getFlowingFluid();
        RUM = manager.RUM.getStillFluid();
        RUM_FLOWING = manager.RUM.getFlowingFluid();
        PUMPKIN_SPICE_LATTE = manager.PUMPKIN_SPICE_LATTE.getStillFluid();
        PUMPKIN_SPICE_LATTE_FLOWING = manager.PUMPKIN_SPICE_LATTE.getFlowingFluid();

        // jams
        GRAPE_JAM = manager.GRAPE_JAM.getStillFluid();
        GRAPE_JAM_FLOWING = manager.GRAPE_JAM.getFlowingFluid();
        STRAWBERRY_JAM = manager.STRAWBERRY_JAM.getStillFluid();
        STRAWBERRY_JAM_FLOWING = manager.STRAWBERRY_JAM.getFlowingFluid();
        PEACH_JAM = manager.PEACH_JAM.getStillFluid();
        PEACH_JAM_FLOWING = manager.PEACH_JAM.getFlowingFluid();
        APRICOT_JAM = manager.APRICOT_JAM.getStillFluid();
        APRICOT_JAM_FLOWING = manager.APRICOT_JAM.getFlowingFluid();
        BLACKBERRY_JAM = manager.BLACKBERRY_JAM.getStillFluid();
        BLACKBERRY_JAM_FLOWING = manager.BLACKBERRY_JAM.getFlowingFluid();
        BLUEBERRY_JAM = manager.BLUEBERRY_JAM.getStillFluid();
        BLUEBERRY_JAM_FLOWING = manager.BLUEBERRY_JAM.getFlowingFluid();
        CHERRY_JAM = manager.CHERRY_JAM.getStillFluid();
        CHERRY_JAM_FLOWING = manager.CHERRY_JAM.getFlowingFluid();
        ELDERBERRY_JAM = manager.ELDERBERRY_JAM.getStillFluid();
        ELDERBERRY_JAM_FLOWING = manager.ELDERBERRY_JAM.getFlowingFluid();
        RASPBERRY_JAM = manager.RASPBERRY_JAM.getStillFluid();
        RASPBERRY_JAM_FLOWING = manager.RASPBERRY_JAM.getFlowingFluid();
    }

    // juices
    public final Fluid GRAPE_JUICE;
    public final Fluid GRAPE_JUICE_FLOWING;
    public final Fluid ORANGE_JUICE;
    public final Fluid ORANGE_JUICE_FLOWING;
    public final Fluid APPLE_JUICE;
    public final Fluid APPLE_JUICE_FLOWING;
    public final Fluid CRANBERRY_JUICE;
    public final Fluid CRANBERRY_JUICE_FLOWING;
    public final Fluid SAGUARO_JUICE;
    public final Fluid SAGUARO_JUICE_FLOWING;
    public final Fluid TOMATO_JUICE;
    public final Fluid TOMATO_JUICE_FLOWING;
    public final Fluid MELON_JUICE;
    public final Fluid MELON_JUICE_FLOWING;
    public final Fluid PINEAPPLE_JUICE;
    public final Fluid PINEAPPLE_JUICE_FLOWING;
    public final Fluid COFFEE;
    public final Fluid COFFEE_FLOWING;
    public final Fluid LEMONADE;
    public final Fluid LEMONADE_FLOWING;
    public final Fluid LIMEADE;
    public final Fluid LIMEADE_FLOWING;
    public final Fluid SOY_MILK;
    public final Fluid SOY_MILK_FLOWING;
    public final Fluid TEA;
    public final Fluid TEA_FLOWING;
    public final Fluid STRAWBERRY_SMOOTHIE;
    public final Fluid STRAWBERRY_SMOOTHIE_FLOWING;
    public final Fluid BANANA_SMOOTHIE;
    public final Fluid BANANA_SMOOTHIE_FLOWING;
    public final Fluid KALE_SMOOTHIE;
    public final Fluid KALE_SMOOTHIE_FLOWING;
    public final Fluid FRUIT_SMOOTHIE;
    public final Fluid FRUIT_SMOOTHIE_FLOWING;
    public final Fluid CHOCOLATE_MILKSHAKE;
    public final Fluid CHOCOLATE_MILKSHAKE_FLOWING;
    public final Fluid BEER;
    public final Fluid BEER_FLOWING;
    public final Fluid WINE;
    public final Fluid WINE_FLOWING;
    public final Fluid MEAD;
    public final Fluid MEAD_FLOWING;
    public final Fluid RUM;
    public final Fluid RUM_FLOWING;
    public final Fluid PUMPKIN_SPICE_LATTE;
    public final Fluid PUMPKIN_SPICE_LATTE_FLOWING;

    // jams
    public final Fluid GRAPE_JAM;
    public final Fluid GRAPE_JAM_FLOWING;
    public final Fluid STRAWBERRY_JAM;
    public final Fluid STRAWBERRY_JAM_FLOWING;
    public final Fluid PEACH_JAM;
    public final Fluid PEACH_JAM_FLOWING;
    public final Fluid APRICOT_JAM;
    public final Fluid APRICOT_JAM_FLOWING;
    public final Fluid BLACKBERRY_JAM;
    public final Fluid BLACKBERRY_JAM_FLOWING;
    public final Fluid BLUEBERRY_JAM;
    public final Fluid BLUEBERRY_JAM_FLOWING;
    public final Fluid CHERRY_JAM;
    public final Fluid CHERRY_JAM_FLOWING;
    public final Fluid ELDERBERRY_JAM;
    public final Fluid ELDERBERRY_JAM_FLOWING;
    public final Fluid RASPBERRY_JAM;
    public final Fluid RASPBERRY_JAM_FLOWING;

    private static void register(Identifier id, Fluid fluid) {
        Registry.register(Registry.FLUID, id, fluid);
    }

    public void init() {
        FluidManager manager = FluidManager.getInstance();

        // juices
        register(manager.GRAPE_JUICE.getStillFluidId(), GRAPE_JUICE);
        register(manager.GRAPE_JUICE.getFlowingFluidId(), GRAPE_JUICE_FLOWING);
        register(manager.ORANGE_JUICE.getStillFluidId(), ORANGE_JUICE);
        register(manager.ORANGE_JUICE.getFlowingFluidId(), ORANGE_JUICE_FLOWING);
        register(manager.APPLE_JUICE.getStillFluidId(), APPLE_JUICE);
        register(manager.APPLE_JUICE.getFlowingFluidId(), APPLE_JUICE_FLOWING);
        register(manager.CRANBERRY_JUICE.getStillFluidId(), CRANBERRY_JUICE);
        register(manager.CRANBERRY_JUICE.getFlowingFluidId(), CRANBERRY_JUICE_FLOWING);
        register(manager.SAGUARO_JUICE.getStillFluidId(), SAGUARO_JUICE);
        register(manager.SAGUARO_JUICE.getFlowingFluidId(), SAGUARO_JUICE_FLOWING);
        register(manager.TOMATO_JUICE.getStillFluidId(), TOMATO_JUICE);
        register(manager.TOMATO_JUICE.getFlowingFluidId(), TOMATO_JUICE_FLOWING);
        register(manager.MELON_JUICE.getStillFluidId(), MELON_JUICE);
        register(manager.MELON_JUICE.getFlowingFluidId(), MELON_JUICE_FLOWING);
        register(manager.PINEAPPLE_JUICE.getStillFluidId(), PINEAPPLE_JUICE);
        register(manager.PINEAPPLE_JUICE.getFlowingFluidId(), PINEAPPLE_JUICE_FLOWING);
        register(manager.COFFEE.getStillFluidId(), COFFEE);
        register(manager.COFFEE.getFlowingFluidId(), COFFEE_FLOWING);
        register(manager.LEMONADE.getStillFluidId(), LEMONADE);
        register(manager.LEMONADE.getFlowingFluidId(), LEMONADE_FLOWING);
        register(manager.LIMEADE.getStillFluidId(), LIMEADE);
        register(manager.LIMEADE.getFlowingFluidId(), LIMEADE_FLOWING);
        register(manager.SOY_MILK.getStillFluidId(), SOY_MILK);
        register(manager.SOY_MILK.getFlowingFluidId(), SOY_MILK_FLOWING);
        register(manager.TEA.getStillFluidId(), TEA);
        register(manager.TEA.getFlowingFluidId(), TEA_FLOWING);
        register(manager.STRAWBERRY_SMOOTHIE.getStillFluidId(), STRAWBERRY_SMOOTHIE);
        register(manager.STRAWBERRY_SMOOTHIE.getFlowingFluidId(), STRAWBERRY_SMOOTHIE_FLOWING);
        register(manager.BANANA_SMOOTHIE.getStillFluidId(), BANANA_SMOOTHIE);
        register(manager.BANANA_SMOOTHIE.getFlowingFluidId(), BANANA_SMOOTHIE_FLOWING);
        register(manager.KALE_SMOOTHIE.getStillFluidId(), KALE_SMOOTHIE);
        register(manager.KALE_SMOOTHIE.getFlowingFluidId(), KALE_SMOOTHIE_FLOWING);
        register(manager.FRUIT_SMOOTHIE.getStillFluidId(), FRUIT_SMOOTHIE);
        register(manager.FRUIT_SMOOTHIE.getFlowingFluidId(), FRUIT_SMOOTHIE_FLOWING);
        register(manager.CHOCOLATE_MILKSHAKE.getStillFluidId(), CHOCOLATE_MILKSHAKE);
        register(manager.CHOCOLATE_MILKSHAKE.getFlowingFluidId(), CHOCOLATE_MILKSHAKE_FLOWING);
        register(manager.BEER.getStillFluidId(), BEER);
        register(manager.BEER.getFlowingFluidId(), BEER_FLOWING);
        register(manager.WINE.getStillFluidId(), WINE);
        register(manager.WINE.getFlowingFluidId(), WINE_FLOWING);
        register(manager.MEAD.getStillFluidId(), MEAD);
        register(manager.MEAD.getFlowingFluidId(), MEAD_FLOWING);
        register(manager.RUM.getStillFluidId(), RUM);
        register(manager.RUM.getFlowingFluidId(), RUM_FLOWING);
        register(manager.PUMPKIN_SPICE_LATTE.getStillFluidId(), PUMPKIN_SPICE_LATTE);
        register(manager.PUMPKIN_SPICE_LATTE.getFlowingFluidId(), PUMPKIN_SPICE_LATTE_FLOWING);

        // jams
        register(manager.GRAPE_JAM.getStillFluidId(), GRAPE_JAM);
        register(manager.GRAPE_JAM.getFlowingFluidId(), GRAPE_JAM_FLOWING);
        register(manager.STRAWBERRY_JAM.getStillFluidId(), STRAWBERRY_JAM);
        register(manager.STRAWBERRY_JAM.getFlowingFluidId(), STRAWBERRY_JAM_FLOWING);
        register(manager.PEACH_JAM.getStillFluidId(), PEACH_JAM);
        register(manager.PEACH_JAM.getFlowingFluidId(), PEACH_JAM_FLOWING);
        register(manager.APRICOT_JAM.getStillFluidId(), APRICOT_JAM);
        register(manager.APRICOT_JAM.getFlowingFluidId(), APRICOT_JAM_FLOWING);
        register(manager.BLACKBERRY_JAM.getStillFluidId(), BLACKBERRY_JAM);
        register(manager.BLACKBERRY_JAM.getFlowingFluidId(), BLACKBERRY_JAM_FLOWING);
        register(manager.BLUEBERRY_JAM.getStillFluidId(), BLUEBERRY_JAM);
        register(manager.BLUEBERRY_JAM.getFlowingFluidId(), BLUEBERRY_JAM_FLOWING);
        register(manager.CHERRY_JAM.getStillFluidId(), CHERRY_JAM);
        register(manager.CHERRY_JAM.getFlowingFluidId(), CHERRY_JAM_FLOWING);
        register(manager.ELDERBERRY_JAM.getStillFluidId(), ELDERBERRY_JAM);
        register(manager.ELDERBERRY_JAM.getFlowingFluidId(), ELDERBERRY_JAM_FLOWING);
        register(manager.RASPBERRY_JAM.getStillFluidId(), RASPBERRY_JAM);
        register(manager.RASPBERRY_JAM.getFlowingFluidId(), RASPBERRY_JAM_FLOWING);
    }
}
