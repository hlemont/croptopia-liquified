package com.anodemc.croptopialiquified.tags;

import com.anodemc.croptopialiquified.Liquified;
import net.fabricmc.fabric.api.tag.TagFactory;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class CustomItemTags {
    public static final Tag.Identified<Item> DRINK_BUCKETS = TagFactory.ITEM.create(new Identifier(Liquified.MOD_ID, "drink_buckets"));
    public static final Tag.Identified<Item> INGREDIENT_BUCKETS = TagFactory.ITEM.create(new Identifier(Liquified.MOD_ID, "ingredient_buckets"));
    public static final Tag.Identified<Item> MELTED_INGREDIENT_BUCKETS = TagFactory.ITEM.create(new Identifier(Liquified.MOD_ID, "melted_ingredient_buckets"));
}
