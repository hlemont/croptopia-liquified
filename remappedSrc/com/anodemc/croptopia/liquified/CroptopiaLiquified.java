package com.anodemc.croptopia.liquified;

import com.anodemc.croptopia.liquified.registry.BlockRegistry;
import com.anodemc.croptopia.liquified.registry.FluidRegistry;
import com.anodemc.croptopia.liquified.registry.ItemRegistry;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CroptopiaLiquified implements ModInitializer {
	public static final String MOD_ID = "liquified";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		BlockRegistry.getInstance().init();
		FluidRegistry.getInstance().init();
		ItemRegistry.getInstance().init();
	}
}
