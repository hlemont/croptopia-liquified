package com.anodemc.croptopialiquified.data;

import com.anodemc.croptopialiquified.fluids.LiquifiedFluidManager;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTablesProvider;

public class LootTablesProviders {
    public static class BlockLootTablesProvider extends FabricBlockLootTablesProvider {
        public BlockLootTablesProvider(FabricDataGenerator dataGenerator) {
            super(dataGenerator);
        }

        @Override
        protected void generateBlockLootTables() {
            LiquifiedFluidManager.getMeltedIngredientFluids()
                .forEach(fluidVariant -> {
                    addDrop(fluidVariant.getHardenedBlock());
                });
        }
    }
}
