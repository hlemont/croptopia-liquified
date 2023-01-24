package com.anodemc.croptopialiquified.tags;

import com.anodemc.croptopialiquified.Liquified;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class CustomItemTags {
    public static final TagKey<Item> DRINK_BUCKETS = TagKey.of(Registry.ITEM_KEY, new Identifier(Liquified.MOD_ID, "drink_buckets"));
    public static final TagKey<Item> INGREDIENT_BUCKETS = TagKey.of(Registry.ITEM_KEY, new Identifier(Liquified.MOD_ID, "ingredient_buckets"));
    public static final TagKey<Item> MELTED_INGREDIENT_BUCKETS = TagKey.of(Registry.ITEM_KEY, new Identifier(Liquified.MOD_ID, "melted_ingredient_buckets"));
}
