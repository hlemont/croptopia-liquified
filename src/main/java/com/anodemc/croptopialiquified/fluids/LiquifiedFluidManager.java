package com.anodemc.croptopialiquified.fluids;

import com.anodemc.croptopialiquified.Liquified;
import com.anodemc.croptopialiquified.compat.croptopia.CroptopiaNames;
import com.anodemc.croptopialiquified.fluids.block.HardenedBlock;
import com.anodemc.croptopialiquified.fluids.variant.DrinkFluidVariant;
import com.anodemc.croptopialiquified.fluids.variant.IngredientFluidVariant;
import com.anodemc.croptopialiquified.fluids.variant.LiquifiedFluidVariant;
import com.anodemc.croptopialiquified.fluids.variant.MeltedFluidVariant;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class LiquifiedFluidManager {
    private static final int DRINK_MULTIPLIER = 3;
    private static final int LIQUID_INGREDIENT_MULTIPLIER = 3;
    private static final int MELTED_INGREDIENT_MULTIPLIER = 9;


    private static Map<Identifier, LiquifiedFluidVariant> allFluidMap = new HashMap<>();
    private static Map<Identifier, DrinkFluidVariant> drinkFluidMap = new HashMap<>();
    private static Map<Identifier, IngredientFluidVariant> liquidIngredientFluidMap = new HashMap<>();
    private static Map<Identifier, MeltedFluidVariant> meltedIngredientFluidMap = new HashMap<>();


    // drink fluids
    public static final DrinkFluidVariant GRAPE_JUICE = registerDrinkFluid(
        new Identifier(CroptopiaNames.MOD_ID, CroptopiaNames.GRAPE_JUICE),
        DRINK_MULTIPLIER,
        0x503f5f
    );
    public static final DrinkFluidVariant ORANGE_JUICE = registerDrinkFluid(
        new Identifier(CroptopiaNames.MOD_ID, CroptopiaNames.ORANGE_JUICE),
        DRINK_MULTIPLIER,
        0xf27700
    );
    public static final DrinkFluidVariant APPLE_JUICE = registerDrinkFluid(
        new Identifier(CroptopiaNames.MOD_ID, CroptopiaNames.APPLE_JUICE),
        DRINK_MULTIPLIER,
        0xf2d67c
    );
    public static final DrinkFluidVariant CRANBERRY_JUICE = registerDrinkFluid(
        new Identifier(CroptopiaNames.MOD_ID, CroptopiaNames.CRANBERRY_JUICE),
        DRINK_MULTIPLIER,
        0x9c1b2b
    );
    public static final DrinkFluidVariant SAGUARO_JUICE = registerDrinkFluid(
        new Identifier(CroptopiaNames.MOD_ID, CroptopiaNames.SAGUARO_JUICE),
        DRINK_MULTIPLIER,
        0xe67a58
    );
    public static final DrinkFluidVariant TOMATO_JUICE = registerDrinkFluid(
        new Identifier(CroptopiaNames.MOD_ID, CroptopiaNames.TOMATO_JUICE),
        DRINK_MULTIPLIER,
        0xda4017
    );
    public static final DrinkFluidVariant MELON_JUICE = registerDrinkFluid(
        new Identifier(CroptopiaNames.MOD_ID, CroptopiaNames.MELON_JUICE),
        DRINK_MULTIPLIER,
        0xd17c54
    );
    public static final DrinkFluidVariant PINEAPPLE_JUICE = registerDrinkFluid(
        new Identifier(CroptopiaNames.MOD_ID, CroptopiaNames.PINEAPPLE_JUICE),
        DRINK_MULTIPLIER,
        0xd7a222
    );
    public static final DrinkFluidVariant COFFEE = registerDrinkFluid(
        new Identifier(CroptopiaNames.MOD_ID, CroptopiaNames.COFFEE),
        DRINK_MULTIPLIER,
        0x5c3c2c
    );
    public static final DrinkFluidVariant LEMONADE = registerDrinkFluid(
        new Identifier(CroptopiaNames.MOD_ID, CroptopiaNames.LEMONADE),
        DRINK_MULTIPLIER,
        0xfce41f
    );
    public static final DrinkFluidVariant LIMEADE = registerDrinkFluid(
        new Identifier(CroptopiaNames.MOD_ID, CroptopiaNames.LIMEADE),
        DRINK_MULTIPLIER,
        0xa0de33
    );
    public static final DrinkFluidVariant TEA = registerDrinkFluid(
        new Identifier(CroptopiaNames.MOD_ID, CroptopiaNames.TEA),
        DRINK_MULTIPLIER,
        0xe27d47
    );
    public static final DrinkFluidVariant STRAWBERRY_SMOOTHIE = registerDrinkFluid(
        new Identifier(CroptopiaNames.MOD_ID, CroptopiaNames.STRAWBERRY_SMOOTHIE),
        DRINK_MULTIPLIER,
        0xf97291
    );
    public static final DrinkFluidVariant BANANA_SMOOTHIE = registerDrinkFluid(
        new Identifier(CroptopiaNames.MOD_ID, CroptopiaNames.BANANA_SMOOTHIE),
        DRINK_MULTIPLIER,
        0xf2e089
    );
    public static final DrinkFluidVariant KALE_SMOOTHIE = registerDrinkFluid(
        new Identifier(CroptopiaNames.MOD_ID, CroptopiaNames.KALE_SMOOTHIE),
        DRINK_MULTIPLIER,
        0xb2bd40
    );
    public static final DrinkFluidVariant FRUIT_SMOOTHIE = registerDrinkFluid(
        new Identifier(CroptopiaNames.MOD_ID, CroptopiaNames.FRUIT_SMOOTHIE),
        DRINK_MULTIPLIER,
        0xab5895
    );
    public static final DrinkFluidVariant CHOCOLATE_MILKSHAKE = registerDrinkFluid(
        new Identifier(CroptopiaNames.MOD_ID, CroptopiaNames.CHOCOLATE_MILKSHAKE),
        DRINK_MULTIPLIER,
        0xac7040
    );
    public static final DrinkFluidVariant BEER = registerDrinkFluid(
        new Identifier(CroptopiaNames.MOD_ID, CroptopiaNames.BEER),
        DRINK_MULTIPLIER,
        0xcfb016
    );
    public static final DrinkFluidVariant WINE = registerDrinkFluid(
        new Identifier(CroptopiaNames.MOD_ID, CroptopiaNames.WINE),
        DRINK_MULTIPLIER,
        0x7c2b38
    );
    public static final DrinkFluidVariant MEAD = registerDrinkFluid(
        new Identifier(CroptopiaNames.MOD_ID, CroptopiaNames.MEAD),
        DRINK_MULTIPLIER,
        0xb87c14
    );
    public static final DrinkFluidVariant RUM = registerDrinkFluid(
        new Identifier(CroptopiaNames.MOD_ID, CroptopiaNames.RUM),
        DRINK_MULTIPLIER,
        0xc36d1d
    );
    public static final DrinkFluidVariant PUMPKIN_SPICE_LATTE = registerDrinkFluid(
        new Identifier(CroptopiaNames.MOD_ID, CroptopiaNames.PUMPKIN_SPICE_LATTE),
        DRINK_MULTIPLIER,
        0xbd7641
    );
    public static final DrinkFluidVariant SOY_MILK = registerDrinkFluid(
        new Identifier(CroptopiaNames.MOD_ID, CroptopiaNames.SOY_MILK),
        DRINK_MULTIPLIER,
        0xdbd0c0
    );


    // jam fluids
    public static final IngredientFluidVariant GRAPE_JAM = registerLiquidIngredientFluid(
        new Identifier(CroptopiaNames.MOD_ID, CroptopiaNames.GRAPE_JAM),
        LIQUID_INGREDIENT_MULTIPLIER,
        0x43326e
    );
    public static final IngredientFluidVariant STRAWBERRY_JAM = registerLiquidIngredientFluid(
        new Identifier(CroptopiaNames.MOD_ID, CroptopiaNames.STRAWBERRY_JAM),
        LIQUID_INGREDIENT_MULTIPLIER,
        0xc70045
    );
    public static final IngredientFluidVariant PEACH_JAM = registerLiquidIngredientFluid(
        new Identifier(CroptopiaNames.MOD_ID, CroptopiaNames.PEACH_JAM),
        LIQUID_INGREDIENT_MULTIPLIER,
        0xd05d45
    );
    public static final IngredientFluidVariant APRICOT_JAM = registerLiquidIngredientFluid(
        new Identifier(CroptopiaNames.MOD_ID, CroptopiaNames.APRICOT_JAM),
        LIQUID_INGREDIENT_MULTIPLIER,
        0xef901b
    );
    public static final IngredientFluidVariant BLACKBERRY_JAM = registerLiquidIngredientFluid(
        new Identifier(CroptopiaNames.MOD_ID, CroptopiaNames.BLACKBERRY_JAM),
        LIQUID_INGREDIENT_MULTIPLIER,
        0x371a39
    );
    public static final IngredientFluidVariant BLUEBERRY_JAM = registerLiquidIngredientFluid(
        new Identifier(CroptopiaNames.MOD_ID, CroptopiaNames.BLUEBERRY_JAM),
        LIQUID_INGREDIENT_MULTIPLIER,
        0x3c3e7a
    );
    public static final IngredientFluidVariant CHERRY_JAM = registerLiquidIngredientFluid(
        new Identifier(CroptopiaNames.MOD_ID, CroptopiaNames.CHERRY_JAM),
        LIQUID_INGREDIENT_MULTIPLIER,
        0xa92f25
    );
    public static final IngredientFluidVariant ELDERBERRY_JAM = registerLiquidIngredientFluid(
        new Identifier(CroptopiaNames.MOD_ID, CroptopiaNames.ELDERBERRY_JAM),
        LIQUID_INGREDIENT_MULTIPLIER,
        0x232a3a
    );
    public static final IngredientFluidVariant RASPBERRY_JAM = registerLiquidIngredientFluid(
        new Identifier(CroptopiaNames.MOD_ID, CroptopiaNames.RASPBERRY_JAM),
        LIQUID_INGREDIENT_MULTIPLIER,
        0xa63d49
    );
    public static final IngredientFluidVariant PEANUT_BUTTER = registerLiquidIngredientFluid(
        new Identifier(CroptopiaNames.MOD_ID, CroptopiaNames.PEANUT_BUTTER),
        LIQUID_INGREDIENT_MULTIPLIER,
        0xdb934f
    );
    public static final IngredientFluidVariant YAM_JAM = registerLiquidIngredientFluid(
        new Identifier(CroptopiaNames.MOD_ID, CroptopiaNames.YAM_JAM),
        LIQUID_INGREDIENT_MULTIPLIER,
        0x8c6664
    );

    // other ingredients
    public static final IngredientFluidVariant WHIPPING_CREAM = registerLiquidIngredientFluid(
        new Identifier(CroptopiaNames.MOD_ID, CroptopiaNames.WHIPPING_CREAM),
        LIQUID_INGREDIENT_MULTIPLIER,
        0xdfdfe7
    );
    public static final IngredientFluidVariant OLIVE_OIL = registerLiquidIngredientFluid(
        new Identifier(CroptopiaNames.MOD_ID, CroptopiaNames.OLIVE_OIL),
        LIQUID_INGREDIENT_MULTIPLIER,
        0xf4c446
    );
    public static final IngredientFluidVariant SALSA = registerLiquidIngredientFluid(
        new Identifier(CroptopiaNames.MOD_ID, CroptopiaNames.SALSA),
        4,
        0xd15f2f
    );
    public static final IngredientFluidVariant ARTICHOKE_DIP = registerLiquidIngredientFluid(
        new Identifier(CroptopiaNames.MOD_ID, CroptopiaNames.ARTICHOKE_DIP),
        LIQUID_INGREDIENT_MULTIPLIER,
        0xd5d5a1
    );
    public static final IngredientFluidVariant AJVAR = registerLiquidIngredientFluid(
        new Identifier(CroptopiaNames.MOD_ID, CroptopiaNames.AJVAR),
        LIQUID_INGREDIENT_MULTIPLIER,
        0xd46631
    );
    public static final IngredientFluidVariant MOLASSES = registerLiquidIngredientFluid(
        new Identifier(CroptopiaNames.MOD_ID, CroptopiaNames.MOLASSES),
        LIQUID_INGREDIENT_MULTIPLIER,
        0x3d2922
    );
    public static final IngredientFluidVariant SOY_SAUCE = registerLiquidIngredientFluid(
        new Identifier(CroptopiaNames.MOD_ID, CroptopiaNames.SOY_SAUCE),
        LIQUID_INGREDIENT_MULTIPLIER,
        0x1f0303
    );

    // melted fluids
    public static final MeltedFluidVariant BUTTER = registerMeltedIngredientFluid(
        new Identifier(CroptopiaNames.MOD_ID, CroptopiaNames.BUTTER),
        MELTED_INGREDIENT_MULTIPLIER,
        0xffeeab
    );
    public static final MeltedFluidVariant CHEESE = registerMeltedIngredientFluid(
        new Identifier(CroptopiaNames.MOD_ID, CroptopiaNames.CHEESE),
        MELTED_INGREDIENT_MULTIPLIER,
        0xfeca5f
    );
    public static final MeltedFluidVariant CARAMEL = registerMeltedIngredientFluid(
        new Identifier(CroptopiaNames.MOD_ID, CroptopiaNames.CARAMEL),
        MELTED_INGREDIENT_MULTIPLIER,
        0xdc904b
    );
    public static final MeltedFluidVariant CHOCOLATE = registerMeltedIngredientFluid(
        new Identifier(CroptopiaNames.MOD_ID, CroptopiaNames.CHOCOLATE),
        MELTED_INGREDIENT_MULTIPLIER,
        0x603c20
    );

    public static Collection<LiquifiedFluidVariant> getAllFluids() {
        return allFluidMap.values();
    }

    public static Collection<DrinkFluidVariant> getDrinkFluids() {
        return drinkFluidMap.values();
    }

    public static Collection<IngredientFluidVariant> getLiquidIngredientFluids() {
        return liquidIngredientFluidMap.values();
    }

    public static Collection<MeltedFluidVariant> getMeltedIngredientFluids() {
        return meltedIngredientFluidMap.values();
    }

    public static LiquifiedFluidVariant get(Identifier id) {
        return allFluidMap.get(id);
    }

    public static LiquifiedFluidVariant getFromBucketId(Identifier id) { return allFluidMap.get(LiquifiedFluidVariant.getIdFromBucketId(id));}

    public static LiquifiedFluidVariant getFromBlockId(Identifier id) { return allFluidMap.get(LiquifiedFluidVariant.getIdFromBlockId(id));}

    /* TODO: make registers have builder patterns and transparency options, etc.*/

    private static DrinkFluidVariant registerDrinkFluid(Identifier id, int multiplier, int color, FabricBlockSettings fluidBlockSettings, FabricItemSettings bucketItemSettings) {
        DrinkFluidVariant fluid = new DrinkFluidVariant(id, multiplier, color, fluidBlockSettings, bucketItemSettings);
        allFluidMap.putIfAbsent(fluid.getId(), fluid);
        drinkFluidMap.putIfAbsent(fluid.getId(), fluid);
        return fluid;
    }

    private static DrinkFluidVariant registerDrinkFluid(Identifier id, int multiplier, int color) {
        return registerDrinkFluid(id, multiplier, color,
            FabricBlockSettings.copyOf(Blocks.WATER),
            new FabricItemSettings().group(Liquified.ITEM_GROUP).maxCount(1).recipeRemainder(Items.BUCKET)
        );
    }

    private static IngredientFluidVariant registerLiquidIngredientFluid(Identifier id, int multiplier, int color, FabricBlockSettings fluidBlockSettings, FabricItemSettings bucketItemSettings) {
        IngredientFluidVariant fluid = new IngredientFluidVariant(id, multiplier, color, fluidBlockSettings, bucketItemSettings);
        allFluidMap.putIfAbsent(fluid.getId(), fluid);
        liquidIngredientFluidMap.putIfAbsent(fluid.getId(), fluid);
        return fluid;
    }

    private static IngredientFluidVariant registerLiquidIngredientFluid(Identifier id, int multiplier, int color) {
        return registerLiquidIngredientFluid(id, multiplier, color,
            FabricBlockSettings.copyOf(Blocks.WATER),
            new FabricItemSettings().group(Liquified.ITEM_GROUP).maxCount(1).recipeRemainder(Items.BUCKET)
        );
    }

    private static MeltedFluidVariant registerMeltedIngredientFluid(Identifier id, int multiplier, int color, FabricBlockSettings fluidBlockSettings, FabricItemSettings bucketItemSettings, FabricBlockSettings hardenedBlockSettings, FabricItemSettings hardenedBlockItemSettings) {
        MeltedFluidVariant fluid = new MeltedFluidVariant(id, multiplier, color, fluidBlockSettings, bucketItemSettings, hardenedBlockSettings, hardenedBlockItemSettings);
        allFluidMap.putIfAbsent(fluid.getId(), fluid);
        meltedIngredientFluidMap.putIfAbsent(fluid.getId(), fluid);
        return fluid;
    }

    private static MeltedFluidVariant registerMeltedIngredientFluid(Identifier id, int multiplier, int color) {
        return registerMeltedIngredientFluid(id, multiplier, color,
            FabricBlockSettings.copyOf(Blocks.WATER),
            new FabricItemSettings().group(Liquified.ITEM_GROUP).maxCount(1).recipeRemainder(Items.BUCKET),
            FabricBlockSettings.of(Material.SOLID_ORGANIC).breakInstantly(),
            new FabricItemSettings().group(Liquified.ITEM_GROUP)
        );
    }
}
