package com.anodemc.croptopialiquified;

import com.anodemc.croptopialiquified.fluids.*;
import com.anodemc.croptopialiquified.fluids.block.DerivedBlockModels;
import com.anodemc.croptopialiquified.fluids.block.HardenedBlockColorProvider;
import com.anodemc.croptopialiquified.fluids.item.BucketColorProvider;
import com.anodemc.croptopialiquified.fluids.item.BucketModels;
import com.anodemc.croptopialiquified.fluids.variant.LiquifiedFluidVariant;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.model.ModelLoadingRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.fabricmc.fabric.api.renderer.v1.RendererAccess;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.model.json.JsonUnbakedModel;
import net.minecraft.resource.ResourceManager;
import net.minecraft.screen.PlayerScreenHandler;

public class LiquifiedClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register(DynamicFluidRenderHelper.registerFluidSprites);
        DynamicFluidRenderHelper.setupFluidRenderHandler();
        LiquifiedFluidManager.getAllFluids().forEach(fluidVariant -> {
            ColorProviderRegistry.ITEM.register(new BucketColorProvider(), fluidVariant.getBucketItem());
        });

        LiquifiedFluidManager.getMeltedIngredientFluids().forEach(fluidVariant -> {
            ColorProviderRegistry.BLOCK.register(new HardenedBlockColorProvider(), fluidVariant.getHardenedBlock());
            ColorProviderRegistry.ITEM.register(new HardenedBlockColorProvider(), fluidVariant.getHardenedBlock().asItem());
        });

        ModelLoadingRegistry.INSTANCE.registerModelProvider((manager, out) -> {
            out.accept(BucketModels.DRINK_BUCKET_MODEL);
            out.accept(BucketModels.INGREDIENT_BUCKET_MODEL);
            out.accept(BucketModels.MELTED_INGREDIENT_BUCKET_MODEL);
            out.accept(DerivedBlockModels.HARDENED);
        });

        ModelLoadingRegistry.INSTANCE.registerVariantProvider(resourceManager -> ((modelId, context) -> {
            if(modelId.getNamespace().equals(Liquified.MOD_ID)) {
                if(modelId.getPath().endsWith("_bucket")) {
                    if(!RendererAccess.INSTANCE.hasRenderer()) {
                        return JsonUnbakedModel.deserialize("{\"parent\":\"minecraft:item/generated\",\"textures\":{\"layer0\":\"liquified:item/bucket_background\"}}");
                    }
                    LiquifiedFluidVariant fluidVariant = LiquifiedFluidManager.getFromBucketId(modelId);
                    if(fluidVariant != null) {
                        switch (fluidVariant.getType()) {
                            case DRINK -> {
                                return context.loadModel(BucketModels.DRINK_BUCKET_MODEL);
                            }
                            case INGREDIENT -> {
                                return context.loadModel(BucketModels.INGREDIENT_BUCKET_MODEL);
                            }
                            case MELTED -> {
                                return context.loadModel(BucketModels.MELTED_INGREDIENT_BUCKET_MODEL);
                            }
                        }
                    }
                } else if(modelId.getPath().endsWith("_block")) {
                    if(!RendererAccess.INSTANCE.hasRenderer()) {
                        return JsonUnbakedModel.deserialize("{\"parent\":\"minecraft:item/generated\",\"textures\":{\"layer0\":\"minecraft:block/smooth_quartz_block\"}}");
                    }
                    LiquifiedFluidVariant fluidVariant = LiquifiedFluidManager.getFromBlockId(modelId);
                    if(fluidVariant != null) {
                        if(modelId.getVariant().equals("inventory")) {
                            return context.loadModel(DerivedBlockModels.HARDENED_ITEM);
                        } else {
                            return context.loadModel(DerivedBlockModels.HARDENED);
                        }
                    }
                }
            }
            return null;
        }));
    }
}
