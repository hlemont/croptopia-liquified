package com.anodemc.croptopialiquified.compat.croptopia.tags;

import com.anodemc.croptopialiquified.compat.croptopia.CroptopiaNames;
import net.fabricmc.fabric.api.tag.TagFactory;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class CroptopiaItemTags {
    public static Tag.Identified<Item> create(String path) {
        return TagFactory.ITEM.create(new Identifier(CroptopiaNames.MOD_ID, path));
    }

    public static final Tag.Identified<Item> MELONS = create("melons");
    public static final Tag.Identified<Item> CHICKEN_REPLACEMENTS = create("chicken_replacements");
    public static final Tag.Identified<Item> BEEF_REPLACEMENTS = create("beef_replacements");
    public static final Tag.Identified<Item> MEAT_REPLACEMENTS = create("meat_replacements");
}
