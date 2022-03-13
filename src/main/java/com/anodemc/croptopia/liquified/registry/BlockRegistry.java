package com.anodemc.croptopia.liquified.registry;

import com.anodemc.croptopia.liquified.fluids.FluidManager;
import net.minecraft.block.Block;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlockRegistry {
    private static BlockRegistry INSTANCE;

    public static BlockRegistry getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new BlockRegistry();
        }
        return INSTANCE;
    }

    private BlockRegistry() {
        FluidManager manager = FluidManager.getInstance();
        // fluids
        // juices
        GRAPE_JUICE = manager.GRAPE_JUICE.getFluidBlock();
        ORANGE_JUICE = manager.ORANGE_JUICE.getFluidBlock();
        APPLE_JUICE = manager.APPLE_JUICE.getFluidBlock();
        CRANBERRY_JUICE = manager.CRANBERRY_JUICE.getFluidBlock();
        SAGUARO_JUICE = manager.SAGUARO_JUICE.getFluidBlock();
        TOMATO_JUICE = manager.TOMATO_JUICE.getFluidBlock();
        MELON_JUICE = manager.MELON_JUICE.getFluidBlock();
        PINEAPPLE_JUICE = manager.PINEAPPLE_JUICE.getFluidBlock();
        COFFEE = manager.COFFEE.getFluidBlock();
        LEMONADE = manager.LEMONADE.getFluidBlock();
        LIMEADE = manager.LIMEADE.getFluidBlock();
        SOY_MILK = manager.SOY_MILK.getFluidBlock();
        TEA = manager.TEA.getFluidBlock();
        STRAWBERRY_SMOOTHIE = manager.STRAWBERRY_SMOOTHIE.getFluidBlock();
        BANANA_SMOOTHIE = manager.BANANA_SMOOTHIE.getFluidBlock();
        KALE_SMOOTHIE = manager.KALE_SMOOTHIE.getFluidBlock();
        FRUIT_SMOOTHIE = manager.FRUIT_SMOOTHIE.getFluidBlock();
        CHOCOLATE_MILKSHAKE = manager.CHOCOLATE_MILKSHAKE.getFluidBlock();
        BEER = manager.BEER.getFluidBlock();
        WINE = manager.WINE.getFluidBlock();
        MEAD = manager.MEAD.getFluidBlock();
        RUM = manager.RUM.getFluidBlock();
        PUMPKIN_SPICE_LATTE = manager.PUMPKIN_SPICE_LATTE.getFluidBlock();

        // jams
        GRAPE_JAM = manager.GRAPE_JAM.getFluidBlock();
        STRAWBERRY_JAM = manager.STRAWBERRY_JAM.getFluidBlock();
        PEACH_JAM = manager.PEACH_JAM.getFluidBlock();
        APRICOT_JAM = manager.APRICOT_JAM.getFluidBlock();
        BLACKBERRY_JAM = manager.BLACKBERRY_JAM.getFluidBlock();
        BLUEBERRY_JAM = manager.BLUEBERRY_JAM.getFluidBlock();
        CHERRY_JAM = manager.CHERRY_JAM.getFluidBlock();
        ELDERBERRY_JAM = manager.ELDERBERRY_JAM.getFluidBlock();
        RASPBERRY_JAM = manager.RASPBERRY_JAM.getFluidBlock();
    }

    // fluids
    // juices
    public final Block GRAPE_JUICE;
    public final Block ORANGE_JUICE;
    public final Block APPLE_JUICE;
    public final Block CRANBERRY_JUICE;
    public final Block SAGUARO_JUICE;
    public final Block TOMATO_JUICE;
    public final Block MELON_JUICE;
    public final Block PINEAPPLE_JUICE;
    public final Block COFFEE;
    public final Block LEMONADE;
    public final Block LIMEADE;
    public final Block SOY_MILK;
    public final Block TEA;
    public final Block STRAWBERRY_SMOOTHIE;
    public final Block BANANA_SMOOTHIE;
    public final Block KALE_SMOOTHIE;
    public final Block FRUIT_SMOOTHIE;
    public final Block CHOCOLATE_MILKSHAKE;
    public final Block BEER;
    public final Block WINE;
    public final Block MEAD;
    public final Block RUM;
    public final Block PUMPKIN_SPICE_LATTE;

    // jams
    public final Block GRAPE_JAM;
    public final Block STRAWBERRY_JAM;
    public final Block PEACH_JAM;
    public final Block APRICOT_JAM;
    public final Block BLACKBERRY_JAM;
    public final Block BLUEBERRY_JAM;
    public final Block CHERRY_JAM;
    public final Block ELDERBERRY_JAM;
    public final Block RASPBERRY_JAM;


    private static void register(Identifier id, Block block) {
        Registry.register(Registry.BLOCK, id, block);
    }

    public void init() {
        FluidManager manager = FluidManager.getInstance();

        register(manager.GRAPE_JUICE.getFluidBlockId(), GRAPE_JUICE);
        register(manager.ORANGE_JUICE.getFluidBlockId(), ORANGE_JUICE);
        register(manager.APPLE_JUICE.getFluidBlockId(), APPLE_JUICE);
        register(manager.CRANBERRY_JUICE.getFluidBlockId(), CRANBERRY_JUICE);
        register(manager.SAGUARO_JUICE.getFluidBlockId(), SAGUARO_JUICE);
        register(manager.TOMATO_JUICE.getFluidBlockId(), TOMATO_JUICE);
        register(manager.MELON_JUICE.getFluidBlockId(), MELON_JUICE);
        register(manager.PINEAPPLE_JUICE.getFluidBlockId(), PINEAPPLE_JUICE);
        register(manager.COFFEE.getFluidBlockId(), COFFEE);
        register(manager.LEMONADE.getFluidBlockId(), LEMONADE);
        register(manager.LIMEADE.getFluidBlockId(), LIMEADE);
        register(manager.SOY_MILK.getFluidBlockId(), SOY_MILK);
        register(manager.TEA.getFluidBlockId(), TEA);
        register(manager.STRAWBERRY_SMOOTHIE.getFluidBlockId(), STRAWBERRY_SMOOTHIE);
        register(manager.BANANA_SMOOTHIE.getFluidBlockId(), BANANA_SMOOTHIE);
        register(manager.KALE_SMOOTHIE.getFluidBlockId(), KALE_SMOOTHIE);
        register(manager.FRUIT_SMOOTHIE.getFluidBlockId(), FRUIT_SMOOTHIE);
        register(manager.CHOCOLATE_MILKSHAKE.getFluidBlockId(), CHOCOLATE_MILKSHAKE);
        register(manager.BEER.getFluidBlockId(), BEER);
        register(manager.WINE.getFluidBlockId(), WINE);
        register(manager.MEAD.getFluidBlockId(), MEAD);
        register(manager.RUM.getFluidBlockId(), RUM);
        register(manager.PUMPKIN_SPICE_LATTE.getFluidBlockId(), PUMPKIN_SPICE_LATTE);

        // jams
        register(manager.GRAPE_JAM.getFluidBlockId(), GRAPE_JAM);
        register(manager.STRAWBERRY_JAM.getFluidBlockId(), STRAWBERRY_JAM);
        register(manager.PEACH_JAM.getFluidBlockId(), PEACH_JAM);
        register(manager.APRICOT_JAM.getFluidBlockId(), APRICOT_JAM);
        register(manager.BLACKBERRY_JAM.getFluidBlockId(), BLACKBERRY_JAM);
        register(manager.BLUEBERRY_JAM.getFluidBlockId(), BLUEBERRY_JAM);
        register(manager.CHERRY_JAM.getFluidBlockId(), CHERRY_JAM);
        register(manager.ELDERBERRY_JAM.getFluidBlockId(), ELDERBERRY_JAM);
        register(manager.RASPBERRY_JAM.getFluidBlockId(), RASPBERRY_JAM);
    }
}
