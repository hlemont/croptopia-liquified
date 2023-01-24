package com.anodemc.croptopialiquified.tags;

import com.anodemc.croptopialiquified.Liquified;
import com.anodemc.croptopialiquified.fluids.LiquifiedFluidManager;
import net.minecraft.block.Block;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class CustomBlockTags {
    public static final TagKey<Block> HARDENED_BLOCK = TagKey.of(Registry.BLOCK_KEY, new Identifier(Liquified.MOD_ID, "hardened_block"));
}
