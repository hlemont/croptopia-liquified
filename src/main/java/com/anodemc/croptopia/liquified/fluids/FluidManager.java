package com.anodemc.croptopia.liquified.fluids;

import com.anodemc.croptopia.liquified.compat.croptopia.Names;
import net.minecraft.block.AbstractBlock;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.Map;

public class FluidManager {
    private static FluidManager INSTANCE;

    public static FluidManager getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new FluidManager();
        }
        return INSTANCE;
    }

    private Map<Identifier, BaseFluid> AllFluids = new HashMap<>();
    private Map<Identifier, DrinkFluid> DrinkFluids = new HashMap<>();
    private Map<Identifier, LiquidIngredientFluid> LiquidIngredientFluids = new HashMap<>();
    private Map<Identifier, MeltedIngredientFluid> MeltedIngredientFluids = new HashMap<>();

    // drink fluids
    public DrinkFluid GRAPE_JUICE;
    public DrinkFluid ORANGE_JUICE;
    public DrinkFluid APPLE_JUICE;
    public DrinkFluid CRANBERRY_JUICE;
    public DrinkFluid SAGUARO_JUICE;
    public DrinkFluid TOMATO_JUICE;
    public DrinkFluid MELON_JUICE;
    public DrinkFluid PINEAPPLE_JUICE;
    public DrinkFluid COFFEE;
    public DrinkFluid LEMONADE;
    public DrinkFluid LIMEADE;
    public DrinkFluid SOY_MILK;
    public DrinkFluid TEA;
    public DrinkFluid STRAWBERRY_SMOOTHIE;
    public DrinkFluid BANANA_SMOOTHIE;
    public DrinkFluid KALE_SMOOTHIE;
    public DrinkFluid FRUIT_SMOOTHIE;
    public DrinkFluid CHOCOLATE_MILKSHAKE;
    public DrinkFluid BEER;
    public DrinkFluid WINE;
    public DrinkFluid MEAD;
    public DrinkFluid RUM;
    public DrinkFluid PUMPKIN_SPICE_LATTE;

    // jam fluids
    public LiquidIngredientFluid GRAPE_JAM;
    public LiquidIngredientFluid STRAWBERRY_JAM;
    public LiquidIngredientFluid PEACH_JAM;
    public LiquidIngredientFluid APRICOT_JAM;
    public LiquidIngredientFluid BLACKBERRY_JAM;
    public LiquidIngredientFluid BLUEBERRY_JAM;
    public LiquidIngredientFluid CHERRY_JAM;
    public LiquidIngredientFluid ELDERBERRY_JAM;
    public LiquidIngredientFluid RASPBERRY_JAM;

    // melted fluids



    private FluidManager() {
        GRAPE_JUICE = registerDrinkFluid(new Identifier(Names.MOD_ID, Names.GRAPE_JUICE));
        ORANGE_JUICE = registerDrinkFluid(new Identifier(Names.MOD_ID, Names.ORANGE_JUICE));
        APPLE_JUICE = registerDrinkFluid(new Identifier(Names.MOD_ID, Names.APPLE_JUICE));
        CRANBERRY_JUICE = registerDrinkFluid(new Identifier(Names.MOD_ID, Names.CRANBERRY_JUICE));
        SAGUARO_JUICE = registerDrinkFluid(new Identifier(Names.MOD_ID, Names.SAGUARO_JUICE));
        TOMATO_JUICE = registerDrinkFluid(new Identifier(Names.MOD_ID, Names.TOMATO_JUICE));
        MELON_JUICE = registerDrinkFluid(new Identifier(Names.MOD_ID, Names.MELON_JUICE));
        PINEAPPLE_JUICE = registerDrinkFluid(new Identifier(Names.MOD_ID, Names.PINEAPPLE_JUICE));
        COFFEE = registerDrinkFluid(new Identifier(Names.MOD_ID, Names.COFFEE));
        LEMONADE = registerDrinkFluid(new Identifier(Names.MOD_ID, Names.LEMONADE));
        LIMEADE = registerDrinkFluid(new Identifier(Names.MOD_ID, Names.LIMEADE));
        SOY_MILK = registerDrinkFluid(new Identifier(Names.MOD_ID, Names.SOY_MILK));
        TEA = registerDrinkFluid(new Identifier(Names.MOD_ID, Names.TEA));
        STRAWBERRY_SMOOTHIE = registerDrinkFluid(new Identifier(Names.MOD_ID, Names.STRAWBERRY_SMOOTHIE));
        BANANA_SMOOTHIE = registerDrinkFluid(new Identifier(Names.MOD_ID, Names.BANANA_SMOOTHIE));
        KALE_SMOOTHIE = registerDrinkFluid(new Identifier(Names.MOD_ID, Names.KALE_SMOOTHIE));
        FRUIT_SMOOTHIE = registerDrinkFluid(new Identifier(Names.MOD_ID, Names.FRUIT_SMOOTHIE));
        CHOCOLATE_MILKSHAKE = registerDrinkFluid(new Identifier(Names.MOD_ID, Names.CHOCOLATE_MILKSHAKE));
        BEER = registerDrinkFluid(new Identifier(Names.MOD_ID, Names.BEER));
        WINE = registerDrinkFluid(new Identifier(Names.MOD_ID, Names.WINE));
        MEAD = registerDrinkFluid(new Identifier(Names.MOD_ID, Names.MEAD));
        RUM = registerDrinkFluid(new Identifier(Names.MOD_ID, Names.RUM));
        PUMPKIN_SPICE_LATTE = registerDrinkFluid(new Identifier(Names.MOD_ID, Names.PUMPKIN_SPICE_LATTE));

        // jam fluids
        GRAPE_JAM = registerLiquidIngredientFluid(new Identifier(Names.MOD_ID, Names.GRAPE_JAM));
        STRAWBERRY_JAM = registerLiquidIngredientFluid(new Identifier(Names.MOD_ID, Names.STRAWBERRY_JAM));
        PEACH_JAM = registerLiquidIngredientFluid(new Identifier(Names.MOD_ID, Names.PEACH_JAM));
        APRICOT_JAM = registerLiquidIngredientFluid(new Identifier(Names.MOD_ID, Names.APRICOT_JAM));
        BLACKBERRY_JAM = registerLiquidIngredientFluid(new Identifier(Names.MOD_ID, Names.BLACKBERRY_JAM));
        BLUEBERRY_JAM = registerLiquidIngredientFluid(new Identifier(Names.MOD_ID, Names.BLUEBERRY_JAM));
        CHERRY_JAM = registerLiquidIngredientFluid(new Identifier(Names.MOD_ID, Names.CHERRY_JAM));
        ELDERBERRY_JAM = registerLiquidIngredientFluid(new Identifier(Names.MOD_ID, Names.ELDERBERRY_JAM));
        RASPBERRY_JAM = registerLiquidIngredientFluid(new Identifier(Names.MOD_ID, Names.RASPBERRY_JAM));
    }


    public Map<Identifier, BaseFluid> getAllFluids() {
        return new HashMap<>(AllFluids);
    }

    public Map<Identifier, DrinkFluid> getDrinkFluids() {
        return new HashMap<>(DrinkFluids);
    }

    public Map<Identifier, LiquidIngredientFluid> getLiquidIngredientFluids() {
        return new HashMap<>(LiquidIngredientFluids);
    }

    public Map<Identifier, MeltedIngredientFluid> getMeltedIngredientFluids() {
        return new HashMap<>(MeltedIngredientFluids);
    }

    private DrinkFluid registerDrinkFluid(Identifier id) {
        DrinkFluid fluid = new DrinkFluid(id);
        AllFluids.putIfAbsent(id, fluid);
        DrinkFluids.putIfAbsent(id, fluid);
        return fluid;
    }

    private LiquidIngredientFluid registerLiquidIngredientFluid(Identifier id) {
        LiquidIngredientFluid fluid = new LiquidIngredientFluid(id);
        AllFluids.putIfAbsent(id, fluid);
        LiquidIngredientFluids.putIfAbsent(id, fluid);
        return fluid;
    }

    private MeltedIngredientFluid registerMeltedIngredientFluid(Identifier id, AbstractBlock.Settings settings) {
        MeltedIngredientFluid fluid = new MeltedIngredientFluid(id, settings);
        AllFluids.putIfAbsent(id, fluid);
        MeltedIngredientFluids.putIfAbsent(id, fluid);
        return fluid;
    }
}
