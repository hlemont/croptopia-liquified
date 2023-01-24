package com.anodemc.croptopialiquified.compat.create;

import com.anodemc.croptopialiquified.compat.croptopia.registry.CroptopiaItems;
import com.anodemc.croptopialiquified.fluids.LiquifiedFluidManager;
import com.anodemc.croptopialiquified.fluids.variant.LiquifiedFluidVariant;
import com.anodemc.croptopialiquified.registry.ItemRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import static com.simibubi.create.AllTags.AllItemTags.UPRIGHT_ON_BELT;

public class CreateCompatTagProvider extends FabricTagProvider.ItemTagProvider {

    public CreateCompatTagProvider(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void generateTags() {
        FabricTagBuilder<Item> builder = getOrCreateTagBuilder(UPRIGHT_ON_BELT.tag);
        for(var drink: LiquifiedFluidManager.getDrinkFluids().stream().map(LiquifiedFluidVariant::getOriginalItem).toList()) {
            builder.add(drink);
        }
        builder.add(CroptopiaItems.WATER_BOTTLE);
        builder.add(CroptopiaItems.MILK_BOTTLE);
        builder.add(ItemRegistry.DISPOSABLE_BOTTLE);
    }
}
