package com.anodemc.croptopialiquified.registry;

import com.anodemc.croptopialiquified.fluids.LiquifiedFluidManager;
import net.minecraft.block.Block;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlockRegistry {
    // fluids
    // juices
    public static final Block GRAPE_JUICE = LiquifiedFluidManager.GRAPE_JUICE.getFluidBlock();
    public static final Block ORANGE_JUICE = LiquifiedFluidManager.ORANGE_JUICE.getFluidBlock();
    public static final Block APPLE_JUICE = LiquifiedFluidManager.APPLE_JUICE.getFluidBlock();
    public static final Block CRANBERRY_JUICE = LiquifiedFluidManager.CRANBERRY_JUICE.getFluidBlock();
    public static final Block SAGUARO_JUICE = LiquifiedFluidManager.SAGUARO_JUICE.getFluidBlock();
    public static final Block TOMATO_JUICE = LiquifiedFluidManager.TOMATO_JUICE.getFluidBlock();
    public static final Block MELON_JUICE = LiquifiedFluidManager.MELON_JUICE.getFluidBlock();
    public static final Block PINEAPPLE_JUICE = LiquifiedFluidManager.PINEAPPLE_JUICE.getFluidBlock();
    public static final Block COFFEE = LiquifiedFluidManager.COFFEE.getFluidBlock();
    public static final Block LEMONADE = LiquifiedFluidManager.LEMONADE.getFluidBlock();
    public static final Block LIMEADE = LiquifiedFluidManager.LIMEADE.getFluidBlock();
    public static final Block TEA = LiquifiedFluidManager.TEA.getFluidBlock();
    public static final Block STRAWBERRY_SMOOTHIE = LiquifiedFluidManager.STRAWBERRY_SMOOTHIE.getFluidBlock();
    public static final Block BANANA_SMOOTHIE = LiquifiedFluidManager.BANANA_SMOOTHIE.getFluidBlock();
    public static final Block KALE_SMOOTHIE = LiquifiedFluidManager.KALE_SMOOTHIE.getFluidBlock();
    public static final Block FRUIT_SMOOTHIE = LiquifiedFluidManager.FRUIT_SMOOTHIE.getFluidBlock();
    public static final Block CHOCOLATE_MILKSHAKE = LiquifiedFluidManager.CHOCOLATE_MILKSHAKE.getFluidBlock();
    public static final Block BEER = LiquifiedFluidManager.BEER.getFluidBlock();
    public static final Block WINE = LiquifiedFluidManager.WINE.getFluidBlock();
    public static final Block MEAD = LiquifiedFluidManager.MEAD.getFluidBlock();
    public static final Block RUM = LiquifiedFluidManager.RUM.getFluidBlock();
    public static final Block PUMPKIN_SPICE_LATTE = LiquifiedFluidManager.PUMPKIN_SPICE_LATTE.getFluidBlock();
    public static final Block SOY_MILK = LiquifiedFluidManager.SOY_MILK.getFluidBlock();

    // jams
    public static final Block GRAPE_JAM = LiquifiedFluidManager.GRAPE_JAM.getFluidBlock();
    public static final Block STRAWBERRY_JAM = LiquifiedFluidManager.STRAWBERRY_JAM.getFluidBlock();
    public static final Block PEACH_JAM = LiquifiedFluidManager.PEACH_JAM.getFluidBlock();
    public static final Block APRICOT_JAM = LiquifiedFluidManager.APRICOT_JAM.getFluidBlock();
    public static final Block BLACKBERRY_JAM = LiquifiedFluidManager.BLACKBERRY_JAM.getFluidBlock();
    public static final Block BLUEBERRY_JAM = LiquifiedFluidManager.BLUEBERRY_JAM.getFluidBlock();
    public static final Block CHERRY_JAM = LiquifiedFluidManager.CHERRY_JAM.getFluidBlock();
    public static final Block ELDERBERRY_JAM = LiquifiedFluidManager.ELDERBERRY_JAM.getFluidBlock();
    public static final Block RASPBERRY_JAM = LiquifiedFluidManager.RASPBERRY_JAM.getFluidBlock();
    public static final Block PEANUT_BUTTER = LiquifiedFluidManager.PEANUT_BUTTER.getFluidBlock();
    public static final Block YAM_JAM = LiquifiedFluidManager.YAM_JAM.getFluidBlock();

    // other ingredients
    public static final Block WHIPPING_CREAM = LiquifiedFluidManager.WHIPPING_CREAM.getFluidBlock();
    public static final Block OLIVE_OIL = LiquifiedFluidManager.OLIVE_OIL.getFluidBlock();
    public static final Block SALSA = LiquifiedFluidManager.SALSA.getFluidBlock();
    public static final Block ARTICHOKE_DIP = LiquifiedFluidManager.ARTICHOKE_DIP.getFluidBlock();
    public static final Block AJVAR = LiquifiedFluidManager.AJVAR.getFluidBlock();
    public static final Block MOLASSES = LiquifiedFluidManager.MOLASSES.getFluidBlock();
    public static final Block SOY_SAUCE = LiquifiedFluidManager.SOY_SAUCE.getFluidBlock();

    // melted ingredients
    public static final Block BUTTER = LiquifiedFluidManager.BUTTER.getFluidBlock();
    public static final Block BUTTER_BLOCK = LiquifiedFluidManager.BUTTER.getHardenedBlock();
    public static final Block CHEESE = LiquifiedFluidManager.CHEESE.getFluidBlock();
    public static final Block CHEESE_BLOCK = LiquifiedFluidManager.CHEESE.getHardenedBlock();
    public static final Block CARAMEL = LiquifiedFluidManager.CARAMEL.getFluidBlock();
    public static final Block CARAMEL_BLOCK = LiquifiedFluidManager.CARAMEL.getHardenedBlock();
    public static final Block CHOCOLATE = LiquifiedFluidManager.CHOCOLATE.getFluidBlock();
    public static final Block CHOCOLATE_BLOCK = LiquifiedFluidManager.CHOCOLATE.getHardenedBlock();

    private static void register(Identifier id, Block block) {
        Registry.register(Registry.BLOCK, id, block);
    }

    public static void init() {
        // fluids
        // juices
        register(LiquifiedFluidManager.GRAPE_JUICE.getFluidBlockId(), GRAPE_JUICE);
        register(LiquifiedFluidManager.ORANGE_JUICE.getFluidBlockId(), ORANGE_JUICE);
        register(LiquifiedFluidManager.APPLE_JUICE.getFluidBlockId(), APPLE_JUICE);
        register(LiquifiedFluidManager.CRANBERRY_JUICE.getFluidBlockId(), CRANBERRY_JUICE);
        register(LiquifiedFluidManager.SAGUARO_JUICE.getFluidBlockId(), SAGUARO_JUICE);
        register(LiquifiedFluidManager.TOMATO_JUICE.getFluidBlockId(), TOMATO_JUICE);
        register(LiquifiedFluidManager.MELON_JUICE.getFluidBlockId(), MELON_JUICE);
        register(LiquifiedFluidManager.PINEAPPLE_JUICE.getFluidBlockId(), PINEAPPLE_JUICE);
        register(LiquifiedFluidManager.COFFEE.getFluidBlockId(), COFFEE);
        register(LiquifiedFluidManager.LEMONADE.getFluidBlockId(), LEMONADE);
        register(LiquifiedFluidManager.LIMEADE.getFluidBlockId(), LIMEADE);
        register(LiquifiedFluidManager.TEA.getFluidBlockId(), TEA);
        register(LiquifiedFluidManager.STRAWBERRY_SMOOTHIE.getFluidBlockId(), STRAWBERRY_SMOOTHIE);
        register(LiquifiedFluidManager.BANANA_SMOOTHIE.getFluidBlockId(), BANANA_SMOOTHIE);
        register(LiquifiedFluidManager.KALE_SMOOTHIE.getFluidBlockId(), KALE_SMOOTHIE);
        register(LiquifiedFluidManager.FRUIT_SMOOTHIE.getFluidBlockId(), FRUIT_SMOOTHIE);
        register(LiquifiedFluidManager.CHOCOLATE_MILKSHAKE.getFluidBlockId(), CHOCOLATE_MILKSHAKE);
        register(LiquifiedFluidManager.BEER.getFluidBlockId(), BEER);
        register(LiquifiedFluidManager.WINE.getFluidBlockId(), WINE);
        register(LiquifiedFluidManager.MEAD.getFluidBlockId(), MEAD);
        register(LiquifiedFluidManager.RUM.getFluidBlockId(), RUM);
        register(LiquifiedFluidManager.PUMPKIN_SPICE_LATTE.getFluidBlockId(), PUMPKIN_SPICE_LATTE);
        register(LiquifiedFluidManager.SOY_MILK.getFluidBlockId(), SOY_MILK);

        // jams
        register(LiquifiedFluidManager.GRAPE_JAM.getFluidBlockId(), GRAPE_JAM);
        register(LiquifiedFluidManager.STRAWBERRY_JAM.getFluidBlockId(), STRAWBERRY_JAM);
        register(LiquifiedFluidManager.PEACH_JAM.getFluidBlockId(), PEACH_JAM);
        register(LiquifiedFluidManager.APRICOT_JAM.getFluidBlockId(), APRICOT_JAM);
        register(LiquifiedFluidManager.BLACKBERRY_JAM.getFluidBlockId(), BLACKBERRY_JAM);
        register(LiquifiedFluidManager.BLUEBERRY_JAM.getFluidBlockId(), BLUEBERRY_JAM);
        register(LiquifiedFluidManager.CHERRY_JAM.getFluidBlockId(), CHERRY_JAM);
        register(LiquifiedFluidManager.ELDERBERRY_JAM.getFluidBlockId(), ELDERBERRY_JAM);
        register(LiquifiedFluidManager.RASPBERRY_JAM.getFluidBlockId(), RASPBERRY_JAM);
        register(LiquifiedFluidManager.PEANUT_BUTTER.getFluidBlockId(), PEANUT_BUTTER);
        register(LiquifiedFluidManager.YAM_JAM.getFluidBlockId(), YAM_JAM);

        // other ingredients
        register(LiquifiedFluidManager.WHIPPING_CREAM.getFluidBlockId(), WHIPPING_CREAM);
        register(LiquifiedFluidManager.OLIVE_OIL.getFluidBlockId(), OLIVE_OIL);
        register(LiquifiedFluidManager.SALSA.getFluidBlockId(), SALSA);
        register(LiquifiedFluidManager.ARTICHOKE_DIP.getFluidBlockId(), ARTICHOKE_DIP);
        register(LiquifiedFluidManager.AJVAR.getFluidBlockId(), AJVAR);
        register(LiquifiedFluidManager.MOLASSES.getFluidBlockId(), MOLASSES);
        register(LiquifiedFluidManager.SOY_SAUCE.getFluidBlockId(), SOY_SAUCE);


        // melted ingredients
        register(LiquifiedFluidManager.BUTTER.getFluidBlockId(), BUTTER);
        register(LiquifiedFluidManager.BUTTER.getHardenBlockId(), BUTTER_BLOCK);
        register(LiquifiedFluidManager.CHEESE.getFluidBlockId(), CHEESE);
        register(LiquifiedFluidManager.CHEESE.getHardenBlockId(), CHEESE_BLOCK);
        register(LiquifiedFluidManager.CARAMEL.getFluidBlockId(), CARAMEL);
        register(LiquifiedFluidManager.CARAMEL.getHardenBlockId(), CARAMEL_BLOCK);
        register(LiquifiedFluidManager.CHOCOLATE.getFluidBlockId(), CHOCOLATE);
        register(LiquifiedFluidManager.CHOCOLATE.getHardenBlockId(), CHOCOLATE_BLOCK);
    }
}
