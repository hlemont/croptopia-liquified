package com.anodemc.croptopialiquified;

import com.anodemc.croptopialiquified.compat.croptopia.CroptopiaNames;
import com.anodemc.croptopialiquified.registry.BlockRegistry;
import com.anodemc.croptopialiquified.registry.FluidRegistry;
import com.anodemc.croptopialiquified.registry.ItemRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Liquified implements ModInitializer {
    public static final String MOD_ID = "liquified";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static ItemGroup ITEM_GROUP = FabricItemGroupBuilder.create(new Identifier(CroptopiaNames.MOD_ID, MOD_ID))
        .icon(() -> new ItemStack(ItemRegistry.GRAPE_JAM_BUCKET))
        .build();

    @Override
    public void onInitialize() {
        FabricLoader.getInstance().getModContainer(CroptopiaNames.MOD_ID)
                .map(modContainer -> ResourceManagerHelper.registerBuiltinResourcePack(new Identifier(MOD_ID, "croptopia"),
                    modContainer,
                    ResourcePackActivationType.DEFAULT_ENABLED)).filter(success -> !success);

        FluidRegistry.init();
        BlockRegistry.init();
        ItemRegistry.init();
    }
}
