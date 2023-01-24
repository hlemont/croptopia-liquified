package com.anodemc.croptopialiquified.mixin;

import com.anodemc.croptopialiquified.fluids.fluid.LiquifiedFluid;
import com.anodemc.croptopialiquified.fluids.variant.LiquifiedFluidVariant;
import com.anodemc.croptopialiquified.tags.CustomFluidTags;
import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.BackgroundRenderer;
import net.minecraft.client.render.BackgroundRenderer.FogType;
import net.minecraft.client.render.Camera;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.fluid.FluidState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Environment(EnvType.CLIENT)
@Mixin(BackgroundRenderer.class)
public class BackgroundRendererMixin {
    @Shadow
    private static float red;

    @Shadow
    private static float green;

    @Shadow
    private static float blue;

    @ModifyArgs(method = "render", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/systems/RenderSystem;clearColor(FFFF)V", remap = false))
    private static void modifyFluidFogColor(Args args, Camera camera, float partialTicks, ClientWorld level, int renderDistanceChunks, float bossColorModifier) {
        FluidState state = level.getFluidState(camera.getBlockPos());
        if (state.isIn(CustomFluidTags.DRINK) || state.isIn(CustomFluidTags.LIQUID_INGREDIENTS) || state.isIn(CustomFluidTags.MELTED_INGREDIENT)) {
            int color = ((LiquifiedFluid) state.getFluid()).getCompoundFluid().getColor();
            red = ((color & 0xFF0000) >> 16) / 256.0f;
            green = ((color & 0xFF00)>> 8) / 256.0f;
            blue = (color & 0xFF) / 256.0f;
        }
    }

    @Inject(method = "applyFog", at = @At("HEAD"), cancellable = true)
    private static void applyFluidFog(Camera camera, BackgroundRenderer.FogType fogType, float viewDistance, boolean thickFog, float tickDelta, CallbackInfo ci) {
        FluidState state = MinecraftClient.getInstance().world.getFluidState(camera.getBlockPos());
        if (state.isIn(CustomFluidTags.DRINK) || state.isIn(CustomFluidTags.LIQUID_INGREDIENTS) || state.isIn(CustomFluidTags.MELTED_INGREDIENT)) {
            LiquifiedFluidVariant fluidVariant = ((LiquifiedFluid) state.getFluid()).getCompoundFluid();
            int weight;
            switch (fluidVariant.getType()) {
                case INGREDIENT -> {
                    weight = 16;
                }
                case MELTED -> {
                    weight = 8;
                }
                default -> {
                    weight = 64;
                }
            }
            RenderSystem.setShaderFogStart(-2);
            RenderSystem.setShaderFogEnd(0.5f * weight);
            ci.cancel();
        }
    }
}
