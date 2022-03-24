package com.anodemc.croptopialiquified.fluids.variant;

import com.anodemc.croptopialiquified.fluids.block.HardenedBlock;
import com.anodemc.croptopialiquified.fluids.item.BaseBucketItem;
import com.anodemc.croptopialiquified.fluids.block.LiquifiedFluidBlock;
import com.anodemc.croptopialiquified.fluids.fluid.LiquifiedFluidSetting;
import com.anodemc.croptopialiquified.tags.CustomFluidTags;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.BucketItem;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class MeltedFluidVariant extends LiquifiedFluidVariant {
    private static final LiquifiedFluidSetting FLUID_SETTING = new LiquifiedFluidSetting(2, 2, 60);
    private final LiquifiedFluidBlock fluidBlock;
    private final BaseBucketItem bucketItem;
    private final HardenedBlock hardenedBlock;

    public MeltedFluidVariant(Identifier originalItemId,
                              int multiplier,
                              int color,
                              FabricBlockSettings fluidBlockSettings,
                              FabricItemSettings bucketItemSetting,
                              FabricBlockSettings hardenedBlockSettings,
                              FabricItemSettings hardenedBlockItemSettings) {
        super(originalItemId, multiplier, color, FLUID_SETTING);
        fluidBlock = new LiquifiedFluidBlock(this, fluidBlockSettings);
        bucketItem = new BaseBucketItem(this, bucketItemSetting);
        hardenedBlock = new HardenedBlock(this, hardenedBlockSettings, hardenedBlockItemSettings);
    }

    @Override
    public Type getType() {
        return Type.MELTED;
    }

    @Override
    public FluidBlock getFluidBlock() {
        return fluidBlock;
    }

    @Override
    public BucketItem getBucketItem() {
        return bucketItem;
    }

    @Override
    public boolean canBeReplacedWith(FluidState state, BlockView world, BlockPos pos, Fluid fluid, Direction direction) {
        return fluid.isIn(FluidTags.WATER) && !fluid.isIn(CustomFluidTags.MELTED_INGREDIENT);
    }

    @Override
    public Block getHardenedBlock() {
        return hardenedBlock;
    }

    @Override
    public boolean shouldHardenFluidBlock(World world, BlockPos pos, BlockState state) {
        return state.getFluidState().isStill();
    }

    @Override
    public boolean isTranslucent() {
        return false;
    }

    public Identifier getHardenBlockId() {
        return getHardenedBlockId(getId());
    }

    public static Identifier getHardenedBlockId(Identifier id) {
        return new Identifier(id.getNamespace(), id.getPath() + BLOCK_SUFFIX);
    }
}
