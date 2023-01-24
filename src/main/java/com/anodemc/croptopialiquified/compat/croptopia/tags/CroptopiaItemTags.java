package com.anodemc.croptopialiquified.compat.croptopia.tags;

import com.anodemc.croptopialiquified.compat.croptopia.CroptopiaNames;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class CroptopiaItemTags {
    public static TagKey<Item> create(String path) {
        return TagKey.of(Registry.ITEM_KEY, new Identifier(CroptopiaNames.MOD_ID, path));
    }

    public static final TagKey<Item> MELONS = create("melons");
    public static final TagKey<Item> CHICKEN_REPLACEMENTS = create("chicken_replacements");
    public static final TagKey<Item> BEEF_REPLACEMENTS = create("beef_replacements");
    public static final TagKey<Item> MEAT_REPLACEMENTS = create("meat_replacements");
}
