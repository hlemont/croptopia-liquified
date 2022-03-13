package com.anodemc.croptopia.liquified;

import com.anodemc.croptopia.liquified.compat.croptopia.Names;
import com.anodemc.croptopia.liquified.registry.BlockRegistry;
import com.anodemc.croptopia.liquified.registry.FluidRegistry;
import com.anodemc.croptopia.liquified.registry.ItemRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CroptopiaLiquified implements ModInitializer {
	public static final String MOD_ID = "liquified";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final ItemGroup LIQUIFIED_ITEM_GROUP = FabricItemGroupBuilder.create(new Identifier(Names.MOD_ID, MOD_ID))
			.icon(() -> new ItemStack(ItemRegistry.getInstance().APPLE_JUICE_BUCKET))
			.build();

	@Override
	public void onInitialize() {
		BlockRegistry.getInstance().init();
		FluidRegistry.getInstance().init();
		ItemRegistry.getInstance().init();
	}
}
