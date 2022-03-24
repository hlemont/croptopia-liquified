package com.anodemc.croptopialiquified.tags;

import com.anodemc.croptopialiquified.Liquified;
import net.fabricmc.fabric.api.tag.TagFactory;
import net.minecraft.fluid.Fluid;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class CustomFluidTags {
    public static final Tag.Identified<Fluid> DRINK = TagFactory.FLUID.create(new Identifier(Liquified.MOD_ID, "drink"));
    public static final Tag.Identified<Fluid> LIQUID_INGREDIENTS = TagFactory.FLUID.create(new Identifier(Liquified.MOD_ID, "ingredient"));
    public static final Tag.Identified<Fluid> MELTED_INGREDIENT = TagFactory.FLUID.create(new Identifier(Liquified.MOD_ID, "melted_ingredient"));
}
