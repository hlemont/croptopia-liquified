package com.anodemc.croptopialiquified.registry;

import com.anodemc.croptopialiquified.Liquified;
import com.anodemc.croptopialiquified.fluids.LiquifiedFluidManager;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ItemRegistry {

    // juices
    public static final Item GRAPE_JUICE_BUCKET = LiquifiedFluidManager.GRAPE_JUICE.getBucketItem();
    public static final Item ORANGE_JUICE_BUCKET = LiquifiedFluidManager.ORANGE_JUICE.getBucketItem();
    public static final Item APPLE_JUICE_BUCKET = LiquifiedFluidManager.APPLE_JUICE.getBucketItem();
    public static final Item CRANBERRY_JUICE_BUCKET = LiquifiedFluidManager.CRANBERRY_JUICE.getBucketItem();
    public static final Item SAGUARO_JUICE_BUCKET = LiquifiedFluidManager.SAGUARO_JUICE.getBucketItem();
    public static final Item TOMATO_JUICE_BUCKET = LiquifiedFluidManager.TOMATO_JUICE.getBucketItem();
    public static final Item MELON_JUICE_BUCKET = LiquifiedFluidManager.MELON_JUICE.getBucketItem();
    public static final Item PINEAPPLE_JUICE_BUCKET = LiquifiedFluidManager.PINEAPPLE_JUICE.getBucketItem();
    public static final Item COFFEE_BUCKET = LiquifiedFluidManager.COFFEE.getBucketItem();
    public static final Item LEMONADE_BUCKET = LiquifiedFluidManager.LEMONADE.getBucketItem();
    public static final Item LIMEADE_BUCKET = LiquifiedFluidManager.LIMEADE.getBucketItem();
    public static final Item TEA_BUCKET = LiquifiedFluidManager.TEA.getBucketItem();
    public static final Item STRAWBERRY_SMOOTHIE_BUCKET = LiquifiedFluidManager.STRAWBERRY_SMOOTHIE.getBucketItem();
    public static final Item BANANA_SMOOTHIE_BUCKET = LiquifiedFluidManager.BANANA_SMOOTHIE.getBucketItem();
    public static final Item KALE_SMOOTHIE_BUCKET = LiquifiedFluidManager.KALE_SMOOTHIE.getBucketItem();
    public static final Item FRUIT_SMOOTHIE_BUCKET = LiquifiedFluidManager.FRUIT_SMOOTHIE.getBucketItem();
    public static final Item CHOCOLATE_MILKSHAKE_BUCKET = LiquifiedFluidManager.CHOCOLATE_MILKSHAKE.getBucketItem();
    public static final Item BEER_BUCKET = LiquifiedFluidManager.BEER.getBucketItem();
    public static final Item WINE_BUCKET = LiquifiedFluidManager.WINE.getBucketItem();
    public static final Item MEAD_BUCKET = LiquifiedFluidManager.MEAD.getBucketItem();
    public static final Item RUM_BUCKET = LiquifiedFluidManager.RUM.getBucketItem();
    public static final Item PUMPKIN_SPICE_LATTE_BUCKET = LiquifiedFluidManager.PUMPKIN_SPICE_LATTE.getBucketItem();
    public static final Item SOY_MILK_BUCKET = LiquifiedFluidManager.SOY_MILK.getBucketItem();

    // jams
    public static final Item GRAPE_JAM_BUCKET = LiquifiedFluidManager.GRAPE_JAM.getBucketItem();
    public static final Item STRAWBERRY_JAM_BUCKET = LiquifiedFluidManager.STRAWBERRY_JAM.getBucketItem();
    public static final Item PEACH_JAM_BUCKET = LiquifiedFluidManager.PEACH_JAM.getBucketItem();
    public static final Item APRICOT_JAM_BUCKET = LiquifiedFluidManager.APRICOT_JAM.getBucketItem();
    public static final Item BLACKBERRY_JAM_BUCKET = LiquifiedFluidManager.BLACKBERRY_JAM.getBucketItem();
    public static final Item BLUEBERRY_JAM_BUCKET = LiquifiedFluidManager.BLUEBERRY_JAM.getBucketItem();
    public static final Item CHERRY_JAM_BUCKET = LiquifiedFluidManager.CHERRY_JAM.getBucketItem();
    public static final Item ELDERBERRY_JAM_BUCKET = LiquifiedFluidManager.ELDERBERRY_JAM.getBucketItem();
    public static final Item RASPBERRY_JAM_BUCKET = LiquifiedFluidManager.RASPBERRY_JAM.getBucketItem();
    public static final Item PEANUT_BUTTER_BUCKET = LiquifiedFluidManager.PEANUT_BUTTER.getBucketItem();
    public static final Item YAM_JAM_BUCKET = LiquifiedFluidManager.YAM_JAM.getBucketItem();

    // ingredients
    public static final Item WHIPPING_CREAM_BUCKET = LiquifiedFluidManager.WHIPPING_CREAM.getBucketItem();
    public static final Item OLIVE_OIL_BUCKET = LiquifiedFluidManager.OLIVE_OIL.getBucketItem();
    public static final Item SALSA_BUCKET = LiquifiedFluidManager.SALSA.getBucketItem();
    public static final Item ARTICHOKE_DIP_BUCKET = LiquifiedFluidManager.ARTICHOKE_DIP.getBucketItem();
    public static final Item AJVAR_BUCKET = LiquifiedFluidManager.AJVAR.getBucketItem();
    public static final Item MOLASSES_BUCKET = LiquifiedFluidManager.MOLASSES.getBucketItem();
    public static final Item SOY_SAUCE_BUCKET = LiquifiedFluidManager.SOY_SAUCE.getBucketItem();


    // melted ingredients
    public static final Item BUTTER_BUCKET = LiquifiedFluidManager.BUTTER.getBucketItem();
    public static final Item BUTTER_BLOCK = LiquifiedFluidManager.BUTTER.getHardenedBlock().asItem();
    public static final Item CHEESE_BUCKET = LiquifiedFluidManager.CHEESE.getBucketItem();
    public static final Item CHEESE_BLOCK = LiquifiedFluidManager.CHEESE.getHardenedBlock().asItem();
    public static final Item CARAMEL_BUCKET = LiquifiedFluidManager.CARAMEL.getBucketItem();
    public static final Item CARAMEL_BLOCK = LiquifiedFluidManager.CARAMEL.getHardenedBlock().asItem();
    public static final Item CHOCOLATE_BUCKET = LiquifiedFluidManager.CHOCOLATE.getBucketItem();
    public static final Item CHOCOLATE_BLOCK = LiquifiedFluidManager.CHOCOLATE.getHardenedBlock().asItem();

    public static final Item DISPOSABLE_BOTTLE = new Item(new Item.Settings().group(Liquified.ITEM_GROUP).maxCount(64));


    private static void register(Identifier id, Item item) {
        Registry.register(Registry.ITEM, id, item);
    }

    public static void init() {

        // juices
        register(LiquifiedFluidManager.GRAPE_JUICE.getBucketId(), GRAPE_JUICE_BUCKET);
        register(LiquifiedFluidManager.ORANGE_JUICE.getBucketId(), ORANGE_JUICE_BUCKET);
        register(LiquifiedFluidManager.APPLE_JUICE.getBucketId(), APPLE_JUICE_BUCKET);
        register(LiquifiedFluidManager.CRANBERRY_JUICE.getBucketId(), CRANBERRY_JUICE_BUCKET);
        register(LiquifiedFluidManager.SAGUARO_JUICE.getBucketId(), SAGUARO_JUICE_BUCKET);
        register(LiquifiedFluidManager.TOMATO_JUICE.getBucketId(), TOMATO_JUICE_BUCKET);
        register(LiquifiedFluidManager.MELON_JUICE.getBucketId(), MELON_JUICE_BUCKET);
        register(LiquifiedFluidManager.PINEAPPLE_JUICE.getBucketId(), PINEAPPLE_JUICE_BUCKET);
        register(LiquifiedFluidManager.COFFEE.getBucketId(), COFFEE_BUCKET);
        register(LiquifiedFluidManager.LEMONADE.getBucketId(), LEMONADE_BUCKET);
        register(LiquifiedFluidManager.LIMEADE.getBucketId(), LIMEADE_BUCKET);
        register(LiquifiedFluidManager.TEA.getBucketId(), TEA_BUCKET);
        register(LiquifiedFluidManager.STRAWBERRY_SMOOTHIE.getBucketId(), STRAWBERRY_SMOOTHIE_BUCKET);
        register(LiquifiedFluidManager.BANANA_SMOOTHIE.getBucketId(), BANANA_SMOOTHIE_BUCKET);
        register(LiquifiedFluidManager.KALE_SMOOTHIE.getBucketId(), KALE_SMOOTHIE_BUCKET);
        register(LiquifiedFluidManager.FRUIT_SMOOTHIE.getBucketId(), FRUIT_SMOOTHIE_BUCKET);
        register(LiquifiedFluidManager.CHOCOLATE_MILKSHAKE.getBucketId(), CHOCOLATE_MILKSHAKE_BUCKET);
        register(LiquifiedFluidManager.BEER.getBucketId(), BEER_BUCKET);
        register(LiquifiedFluidManager.WINE.getBucketId(), WINE_BUCKET);
        register(LiquifiedFluidManager.MEAD.getBucketId(), MEAD_BUCKET);
        register(LiquifiedFluidManager.RUM.getBucketId(), RUM_BUCKET);
        register(LiquifiedFluidManager.PUMPKIN_SPICE_LATTE.getBucketId(), PUMPKIN_SPICE_LATTE_BUCKET);

        // jams
        register(LiquifiedFluidManager.GRAPE_JAM.getBucketId(), GRAPE_JAM_BUCKET);
        register(LiquifiedFluidManager.STRAWBERRY_JAM.getBucketId(), STRAWBERRY_JAM_BUCKET);
        register(LiquifiedFluidManager.PEACH_JAM.getBucketId(), PEACH_JAM_BUCKET);
        register(LiquifiedFluidManager.APRICOT_JAM.getBucketId(), APRICOT_JAM_BUCKET);
        register(LiquifiedFluidManager.BLACKBERRY_JAM.getBucketId(), BLACKBERRY_JAM_BUCKET);
        register(LiquifiedFluidManager.BLUEBERRY_JAM.getBucketId(), BLUEBERRY_JAM_BUCKET);
        register(LiquifiedFluidManager.CHERRY_JAM.getBucketId(), CHERRY_JAM_BUCKET);
        register(LiquifiedFluidManager.ELDERBERRY_JAM.getBucketId(), ELDERBERRY_JAM_BUCKET);
        register(LiquifiedFluidManager.RASPBERRY_JAM.getBucketId(), RASPBERRY_JAM_BUCKET);
        register(LiquifiedFluidManager.PEANUT_BUTTER.getBucketId(), PEANUT_BUTTER_BUCKET);
        register(LiquifiedFluidManager.YAM_JAM.getBucketId(), YAM_JAM_BUCKET);

        // other ingredients
        register(LiquifiedFluidManager.WHIPPING_CREAM.getBucketId(), WHIPPING_CREAM_BUCKET);
        register(LiquifiedFluidManager.OLIVE_OIL.getBucketId(), OLIVE_OIL_BUCKET);
        register(LiquifiedFluidManager.SALSA.getBucketId(), SALSA_BUCKET);
        register(LiquifiedFluidManager.ARTICHOKE_DIP.getBucketId(), ARTICHOKE_DIP_BUCKET);
        register(LiquifiedFluidManager.AJVAR.getBucketId(), AJVAR_BUCKET);
        register(LiquifiedFluidManager.MOLASSES.getBucketId(), MOLASSES_BUCKET);
        register(LiquifiedFluidManager.SOY_SAUCE.getBucketId(), SOY_SAUCE_BUCKET);
        register(LiquifiedFluidManager.SOY_MILK.getBucketId(), SOY_MILK_BUCKET);

        // melted ingredients
        register(LiquifiedFluidManager.BUTTER.getBucketId(), BUTTER_BUCKET);
        register(LiquifiedFluidManager.BUTTER.getHardenBlockId(), BUTTER_BLOCK);
        register(LiquifiedFluidManager.CHEESE.getBucketId(), CHEESE_BUCKET);
        register(LiquifiedFluidManager.CHEESE.getHardenBlockId(), CHEESE_BLOCK);
        register(LiquifiedFluidManager.CARAMEL.getBucketId(), CARAMEL_BUCKET);
        register(LiquifiedFluidManager.CARAMEL.getHardenBlockId(), CARAMEL_BLOCK);
        register(LiquifiedFluidManager.CHOCOLATE.getBucketId(), CHOCOLATE_BUCKET);
        register(LiquifiedFluidManager.CHOCOLATE.getHardenBlockId(), CHOCOLATE_BLOCK);

        register(new Identifier(Liquified.MOD_ID, "disposable_bottle"), DISPOSABLE_BOTTLE);
    }
}
