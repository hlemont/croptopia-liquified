package com.anodemc.croptopialiquified.fluids.variant;

import com.anodemc.croptopialiquified.Liquified;
import com.anodemc.croptopialiquified.fluids.fluid.LiquifiedFluid;
import com.anodemc.croptopialiquified.fluids.fluid.LiquifiedFluidSetting;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;


public abstract class LiquifiedFluidVariant {
    protected static final String STILL_FLUID_SUFFIX = "";
    protected static final String FLOWING_FLUID_SUFFIX = "_flowing";
    protected static final String FLUID_BLOCK_SUFFIX = "";
    protected static final String BUCKET_SUFFIX = "_bucket";
    protected static final String BLOCK_SUFFIX = "_block";

    private final Identifier id;
    private final Identifier originalItemId;
    private final int multiplier;
    private final int color;
    private final LiquifiedFluid stillFluid;
    private final LiquifiedFluid flowingFluid;

    protected LiquifiedFluidVariant(Identifier originalItemId, int multiplier, int color, LiquifiedFluidSetting liquifiedFluidSetting) {
        this.id = getIdFromOriginalItemId(originalItemId);
        this.originalItemId = originalItemId;
        this.multiplier = multiplier;
        this.color = color;
        this.stillFluid = new LiquifiedFluid(this, liquifiedFluidSetting, true);
        this.flowingFluid = new LiquifiedFluid(this, liquifiedFluidSetting, false);
    }

    public abstract Type getType();

    public Identifier getId() {
        return id;
    }

    public int getMultiplier() {
        return multiplier;
    }

    public int getColor() {
        return color;
    }

    public LiquifiedFluid getStillFluid() {
        return stillFluid;
    }

    public LiquifiedFluid getFlowingFluid() {
        return flowingFluid;
    }

    public abstract FluidBlock getFluidBlock();

    public abstract BucketItem getBucketItem();

    public Item getOriginalItem() {
        return Registry.ITEM.get(getOriginalItemId());
    }

    public Identifier getStillFluidId() {
        return getStillFluidId(getId());
    }

    public Identifier getFlowingFluidId() {
        return getFlowingFluidId(getId());
    }

    public Identifier getFluidBlockId() {
        return getFluidBlockId(getId());
    }

    public Identifier getBucketId() {
        return getBucketId(getId());
    }

    public Identifier getOriginalItemId() {
        return originalItemId;
    }

    public boolean canBeReplacedWith(FluidState state, BlockView world, BlockPos pos, Fluid fluid, Direction direction) {
        return fluid.isIn(FluidTags.LAVA);
    }

    public Block getHardenedBlock() { return null; }

    public boolean shouldHardenFluidBlock(World world, BlockPos pos, BlockState state) {
        return false;
    }

    public boolean isTranslucent() { return true; }

    public static Identifier getStillFluidId(Identifier id) {
        return new Identifier(id.getNamespace(), id.getPath() + STILL_FLUID_SUFFIX);
    }

    public static Identifier getFlowingFluidId(Identifier id) {
        return new Identifier(id.getNamespace(), id.getPath() + FLOWING_FLUID_SUFFIX);
    }

    public static Identifier getFluidBlockId(Identifier id) {
        return new Identifier(id.getNamespace(), id.getPath() + FLUID_BLOCK_SUFFIX);
    }

    public static Identifier getBucketId(Identifier id) {
        return new Identifier(id.getNamespace(), id.getPath() + BUCKET_SUFFIX);
    }

    public static Identifier getIdFromOriginalItemId(Identifier originalItemId) {
        return new Identifier(Liquified.MOD_ID, originalItemId.getPath());
    }

    public static Identifier getIdFromBucketId(Identifier bucketItemId) {
        return bucketItemId.getPath().endsWith(BUCKET_SUFFIX) ?
            new Identifier(
                bucketItemId.getNamespace(),
                bucketItemId.getPath().substring(0, bucketItemId.getPath().length() - BUCKET_SUFFIX.length())
            ) : null;
    }

    public static Identifier getIdFromBlockId(Identifier blockId) {
        return blockId.getPath().endsWith(BLOCK_SUFFIX) ?
            new Identifier(
                blockId.getNamespace(),
                blockId.getPath().substring(0, blockId.getPath().length() - BLOCK_SUFFIX.length())
            ) : null;

    }

    public enum Type {
        DRINK,
        INGREDIENT,
        MELTED
    }
}
