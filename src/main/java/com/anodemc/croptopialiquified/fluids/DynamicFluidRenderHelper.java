package com.anodemc.croptopialiquified.fluids;

import com.anodemc.croptopialiquified.Liquified;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandler;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;

import java.io.IOException;
import java.util.Arrays;

public class DynamicFluidRenderHelper {
    // fluid texture identifiers
    public static final Identifier DRINK_STILL = new Identifier(Liquified.MOD_ID, "fluid/drink");
    public static final Identifier DRINK_FLOWING = new Identifier(Liquified.MOD_ID, "fluid/drink_flowing");
    public static final Identifier INGREDIENT_STILL = new Identifier(Liquified.MOD_ID, "fluid/ingredient");
    public static final Identifier INGREDIENT_FLOWING = new Identifier(Liquified.MOD_ID, "fluid/ingredient_flowing");
    public static final Identifier MELTED_INGREDIENT_STILL = new Identifier(Liquified.MOD_ID, "fluid/melted_ingredient");
    public static final Identifier MELTED_INGREDIENT_FLOWING = new Identifier(Liquified.MOD_ID, "fluid/melted_ingredient_flowing");

    public static final ClientSpriteRegistryCallback registerFluidSprites = (atlasTexture, registry) -> {
        registry.register(DRINK_STILL);
        registry.register(DRINK_FLOWING);
        registry.register(INGREDIENT_STILL);
        registry.register(INGREDIENT_FLOWING);
        registry.register(MELTED_INGREDIENT_STILL);
        registry.register(MELTED_INGREDIENT_FLOWING);
    };

    public static void setupFluidRenderHandler() {
        LiquifiedFluidManager.getDrinkFluids().forEach(c -> {
                FluidRenderHandlerRegistry.INSTANCE.register(c.getStillFluid(), c.getFlowingFluid(),
                    new SimpleFluidRenderHandler(
                        DRINK_STILL,
                        DRINK_FLOWING,
                        DRINK_STILL,
                        c.getColor()));
            }
        );
        LiquifiedFluidManager.getLiquidIngredientFluids().forEach(c -> {
                FluidRenderHandlerRegistry.INSTANCE.register(c.getStillFluid(), c.getFlowingFluid(),
                    new SimpleFluidRenderHandler(
                        INGREDIENT_STILL,
                        INGREDIENT_FLOWING,
                        INGREDIENT_STILL,
                        c.getColor()));
            }
        );
        LiquifiedFluidManager.getMeltedIngredientFluids().forEach(c -> {
                FluidRenderHandlerRegistry.INSTANCE.register(c.getStillFluid(), c.getFlowingFluid(),
                    new SimpleFluidRenderHandler(
                        MELTED_INGREDIENT_STILL,
                        MELTED_INGREDIENT_FLOWING,
                        MELTED_INGREDIENT_STILL,
                        c.getColor()));
            }
        );
        LiquifiedFluidManager.getAllFluids().forEach(c ->
            BlockRenderLayerMap.INSTANCE.putFluids(
                c.isTranslucent() ? RenderLayer.getTranslucent() : RenderLayer.getSolid(),
                c.getStillFluid(),
                c.getFlowingFluid())
        );
    }

    public static Boolean allResourceExists(Identifier... ids) {
        return Arrays.stream(ids).allMatch(id -> MinecraftClient.getInstance().getResourceManager().getResource(id).isPresent());
    }
}
