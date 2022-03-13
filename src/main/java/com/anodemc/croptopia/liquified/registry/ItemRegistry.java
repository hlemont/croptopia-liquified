package com.anodemc.croptopia.liquified.registry;

import com.anodemc.croptopia.liquified.fluids.FluidManager;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ItemRegistry {
    private static ItemRegistry INSTANCE;

    public static ItemRegistry getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new ItemRegistry();
        }
        return INSTANCE;
    }

    private ItemRegistry() {
        FluidManager manager = FluidManager.getInstance();
        // juices
        GRAPE_JUICE_BUCKET = manager.GRAPE_JUICE.getBucketItem();
        ORANGE_JUICE_BUCKET = manager.ORANGE_JUICE.getBucketItem();
        APPLE_JUICE_BUCKET = manager.APPLE_JUICE.getBucketItem();
        CRANBERRY_JUICE_BUCKET = manager.CRANBERRY_JUICE.getBucketItem();
        SAGUARO_JUICE_BUCKET = manager.SAGUARO_JUICE.getBucketItem();
        TOMATO_JUICE_BUCKET = manager.TOMATO_JUICE.getBucketItem();
        MELON_JUICE_BUCKET = manager.MELON_JUICE.getBucketItem();
        PINEAPPLE_JUICE_BUCKET = manager.PINEAPPLE_JUICE.getBucketItem();
        COFFEE_BUCKET = manager.COFFEE.getBucketItem();
        LEMONADE_BUCKET = manager.LEMONADE.getBucketItem();
        LIMEADE_BUCKET = manager.LIMEADE.getBucketItem();
        SOY_MILK_BUCKET = manager.SOY_MILK.getBucketItem();
        TEA_BUCKET = manager.TEA.getBucketItem();
        STRAWBERRY_SMOOTHIE_BUCKET = manager.STRAWBERRY_SMOOTHIE.getBucketItem();
        BANANA_SMOOTHIE_BUCKET = manager.BANANA_SMOOTHIE.getBucketItem();
        KALE_SMOOTHIE_BUCKET = manager.KALE_SMOOTHIE.getBucketItem();
        FRUIT_SMOOTHIE_BUCKET = manager.FRUIT_SMOOTHIE.getBucketItem();
        CHOCOLATE_MILKSHAKE_BUCKET = manager.CHOCOLATE_MILKSHAKE.getBucketItem();
        BEER_BUCKET = manager.BEER.getBucketItem();
        WINE_BUCKET = manager.WINE.getBucketItem();
        MEAD_BUCKET = manager.MEAD.getBucketItem();
        RUM_BUCKET = manager.RUM.getBucketItem();
        PUMPKIN_SPICE_LATTE_BUCKET = manager.PUMPKIN_SPICE_LATTE.getBucketItem();

        // jams
        GRAPE_JAM_BUCKET = manager.GRAPE_JAM.getBucketItem();
        STRAWBERRY_JAM_BUCKET = manager.STRAWBERRY_JAM.getBucketItem();
        PEACH_JAM_BUCKET = manager.PEACH_JAM.getBucketItem();
        APRICOT_JAM_BUCKET = manager.APRICOT_JAM.getBucketItem();
        BLACKBERRY_JAM_BUCKET = manager.BLACKBERRY_JAM.getBucketItem();
        BLUEBERRY_JAM_BUCKET = manager.BLUEBERRY_JAM.getBucketItem();
        CHERRY_JAM_BUCKET = manager.CHERRY_JAM.getBucketItem();
        ELDERBERRY_JAM_BUCKET = manager.ELDERBERRY_JAM.getBucketItem();
        RASPBERRY_JAM_BUCKET = manager.RASPBERRY_JAM.getBucketItem();
    }

    // juices
    public final Item GRAPE_JUICE_BUCKET;
    public final Item ORANGE_JUICE_BUCKET;
    public final Item APPLE_JUICE_BUCKET;
    public final Item CRANBERRY_JUICE_BUCKET;
    public final Item SAGUARO_JUICE_BUCKET;
    public final Item TOMATO_JUICE_BUCKET;
    public final Item MELON_JUICE_BUCKET;
    public final Item PINEAPPLE_JUICE_BUCKET;
    public final Item COFFEE_BUCKET;
    public final Item LEMONADE_BUCKET;
    public final Item LIMEADE_BUCKET;
    public final Item SOY_MILK_BUCKET;
    public final Item TEA_BUCKET;
    public final Item STRAWBERRY_SMOOTHIE_BUCKET;
    public final Item BANANA_SMOOTHIE_BUCKET;
    public final Item KALE_SMOOTHIE_BUCKET;
    public final Item FRUIT_SMOOTHIE_BUCKET;
    public final Item CHOCOLATE_MILKSHAKE_BUCKET;
    public final Item BEER_BUCKET;
    public final Item WINE_BUCKET;
    public final Item MEAD_BUCKET;
    public final Item RUM_BUCKET;
    public final Item PUMPKIN_SPICE_LATTE_BUCKET;

    // jams
    public final Item GRAPE_JAM_BUCKET;
    public final Item STRAWBERRY_JAM_BUCKET;
    public final Item PEACH_JAM_BUCKET;
    public final Item APRICOT_JAM_BUCKET;
    public final Item BLACKBERRY_JAM_BUCKET;
    public final Item BLUEBERRY_JAM_BUCKET;
    public final Item CHERRY_JAM_BUCKET;
    public final Item ELDERBERRY_JAM_BUCKET;
    public final Item RASPBERRY_JAM_BUCKET;

    private static void register(Identifier id, Item item) {
        Registry.register(Registry.ITEM, id, item);
    }

    public void init() {
        FluidManager manager = FluidManager.getInstance();

        // juices
        register(manager.GRAPE_JUICE.getBucketId(), GRAPE_JUICE_BUCKET);
        register(manager.ORANGE_JUICE.getBucketId(), ORANGE_JUICE_BUCKET);
        register(manager.APPLE_JUICE.getBucketId(), APPLE_JUICE_BUCKET);
        register(manager.CRANBERRY_JUICE.getBucketId(), CRANBERRY_JUICE_BUCKET);
        register(manager.SAGUARO_JUICE.getBucketId(), SAGUARO_JUICE_BUCKET);
        register(manager.TOMATO_JUICE.getBucketId(), TOMATO_JUICE_BUCKET);
        register(manager.MELON_JUICE.getBucketId(), MELON_JUICE_BUCKET);
        register(manager.PINEAPPLE_JUICE.getBucketId(), PINEAPPLE_JUICE_BUCKET);
        register(manager.COFFEE.getBucketId(), COFFEE_BUCKET);
        register(manager.LEMONADE.getBucketId(), LEMONADE_BUCKET);
        register(manager.LIMEADE.getBucketId(), LIMEADE_BUCKET);
        register(manager.SOY_MILK.getBucketId(), SOY_MILK_BUCKET);
        register(manager.TEA.getBucketId(), TEA_BUCKET);
        register(manager.STRAWBERRY_SMOOTHIE.getBucketId(), STRAWBERRY_SMOOTHIE_BUCKET);
        register(manager.BANANA_SMOOTHIE.getBucketId(), BANANA_SMOOTHIE_BUCKET);
        register(manager.KALE_SMOOTHIE.getBucketId(), KALE_SMOOTHIE_BUCKET);
        register(manager.FRUIT_SMOOTHIE.getBucketId(), FRUIT_SMOOTHIE_BUCKET);
        register(manager.CHOCOLATE_MILKSHAKE.getBucketId(), CHOCOLATE_MILKSHAKE_BUCKET);
        register(manager.BEER.getBucketId(), BEER_BUCKET);
        register(manager.WINE.getBucketId(), WINE_BUCKET);
        register(manager.MEAD.getBucketId(), MEAD_BUCKET);
        register(manager.RUM.getBucketId(), RUM_BUCKET);
        register(manager.PUMPKIN_SPICE_LATTE.getBucketId(), PUMPKIN_SPICE_LATTE_BUCKET);

        // jams
        register(manager.GRAPE_JAM.getBucketId(), GRAPE_JAM_BUCKET);
        register(manager.STRAWBERRY_JAM.getBucketId(), STRAWBERRY_JAM_BUCKET);
        register(manager.PEACH_JAM.getBucketId(), PEACH_JAM_BUCKET);
        register(manager.APRICOT_JAM.getBucketId(), APRICOT_JAM_BUCKET);
        register(manager.BLACKBERRY_JAM.getBucketId(), BLACKBERRY_JAM_BUCKET);
        register(manager.BLUEBERRY_JAM.getBucketId(), BLUEBERRY_JAM_BUCKET);
        register(manager.CHERRY_JAM.getBucketId(), CHERRY_JAM_BUCKET);
        register(manager.ELDERBERRY_JAM.getBucketId(), ELDERBERRY_JAM_BUCKET);
        register(manager.RASPBERRY_JAM.getBucketId(), RASPBERRY_JAM_BUCKET);
    }
}
