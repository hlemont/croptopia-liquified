package com.anodemc.croptopialiquified.mixin;

import com.anodemc.croptopialiquified.fluids.LiquifiedFluidManager;
import com.anodemc.croptopialiquified.fluids.variant.MeltedFluidVariant;
import com.anodemc.croptopialiquified.tags.CustomFluidTags;
import com.google.common.collect.ImmutableList;
import net.minecraft.block.BlockState;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FluidBlock.class)
public class FluidBlockMixin {
    @Final
    @Shadow
    protected FlowableFluid fluid;

    @Final
    @Shadow
    public static ImmutableList<Direction> FLOW_DIRECTIONS;

    @Shadow
    public final void playExtinguishSound(WorldAccess world, BlockPos pos) {
        throw new AbstractMethodError("shadow");
    }

    @Inject(method = "receiveNeighborFluids(Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;)Z", at = @At("HEAD"), cancellable = true)
    public void handleMeltedFluidHardening(World world, BlockPos pos, BlockState state, CallbackInfoReturnable<Boolean> cir) {
        Identifier id = Registry.FLUID.getId(fluid);
        if (this.fluid.isIn(CustomFluidTags.MELTED_INGREDIENT)) {
            MeltedFluidVariant fluid = (MeltedFluidVariant) LiquifiedFluidManager.get(id);
            if (fluid != null
                && FLOW_DIRECTIONS.stream()
                .map(direction -> pos.offset(direction.getOpposite()))
                .anyMatch(blockPos -> world.getFluidState(blockPos).isIn(FluidTags.WATER) && !world.getFluidState(blockPos).isIn(CustomFluidTags.MELTED_INGREDIENT))
                && fluid.shouldHardenFluidBlock(world, pos, state)) {
                world.setBlockState(pos, fluid.getHardenedBlock().getDefaultState());
                this.playExtinguishSound(world, pos);
                cir.setReturnValue(false);
                return;
            }
            cir.setReturnValue(true);
        }
    }

}
