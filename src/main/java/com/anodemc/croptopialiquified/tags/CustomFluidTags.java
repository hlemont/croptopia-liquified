package com.anodemc.croptopialiquified.tags;

import com.anodemc.croptopialiquified.Liquified;
import net.minecraft.fluid.Fluid;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class CustomFluidTags {
    public static final TagKey<Fluid> DRINK = TagKey.of(Registry.FLUID_KEY, new Identifier(Liquified.MOD_ID, "drink"));
    public static final TagKey<Fluid> LIQUID_INGREDIENTS = TagKey.of(Registry.FLUID_KEY, new Identifier(Liquified.MOD_ID, "ingredient"));
    public static final TagKey<Fluid> MELTED_INGREDIENT = TagKey.of(Registry.FLUID_KEY, new Identifier(Liquified.MOD_ID, "melted_ingredient"));
}
