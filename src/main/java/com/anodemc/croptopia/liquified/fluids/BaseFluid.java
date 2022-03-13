package com.anodemc.croptopia.liquified.fluids;

import com.anodemc.croptopia.liquified.CroptopiaLiquified;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

import java.util.function.Supplier;


public abstract class BaseFluid {
    private final Identifier id;

    private ActualFluid flowingFluid;
    private ActualFluid stillFluid;

    private FluidBlock fluidBlock;
    private BucketItem bucketItem;


    protected BaseFluid(FluidSetting fluidSetting, Identifier id) {
        this.id = id;

        flowingFluid = new ActualFluid(fluidSetting, false, () -> fluidBlock, () -> bucketItem, () -> flowingFluid, () -> stillFluid);
        stillFluid = new ActualFluid(fluidSetting, true, () -> fluidBlock, () -> bucketItem, () -> flowingFluid, () -> stillFluid);

        fluidBlock = new FluidBlock(stillFluid, FabricBlockSettings.copy(Blocks.WATER)) {};
        bucketItem = new BucketItem(stillFluid, new Item.Settings().group(CroptopiaLiquified.LIQUIFIED_ITEM_GROUP).recipeRemainder(Items.BUCKET).maxCount(1));
    }

    public Identifier getId() { return id; }

    public ActualFluid getFlowingFluid() { return flowingFluid; }

    public ActualFluid getStillFluid() { return stillFluid; }

    public FluidBlock getFluidBlock() { return fluidBlock; }

    public BucketItem getBucketItem() { return bucketItem;}

    public Item getOriginalItem() { return Registry.ITEM.get(getId()); }

    public void setBeforeBreakingBlockHandler(BeforeBreakingBlockHandler handler) {
        this.flowingFluid.beforeBreakingBlockHandler = handler;
        this.stillFluid.beforeBreakingBlockHandler = handler;
    }

    public void setCanBeReplacedWithPredicate(CanBeReplacedWithPredicate predicate) {
        this.flowingFluid.canBeReplacedWithPredicate = predicate;
        this.stillFluid.canBeReplacedWithPredicate = predicate;
    }

    public Identifier getStillFluidId() { return getStillFluidId(id); }

    public Identifier getFlowingFluidId() { return getFlowingFluidId(id); }

    public Identifier getFluidBlockId() { return getFluidBlockId(id); }

    public Identifier getBucketId() { return getBucketId(id); }

    protected static Identifier getStillFluidId(Identifier id) {
        return id;
    }

    protected static Identifier getFlowingFluidId(Identifier id) {
        return new Identifier(id.getNamespace(), id.getPath() + "_flowing");
    }

    protected static Identifier getFluidBlockId(Identifier id) {
        return id;
    }

    protected static Identifier getBucketId(Identifier id) {
        return new Identifier(id.getNamespace(), id.getPath() + "_bucket");
    }


    public static class ActualFluid extends FlowableFluid {

        private final FluidSetting setting;
        private final boolean isStill;
        private final Supplier<FluidBlock> fluidBlockSupplier;
        private final Supplier<BucketItem> bucketItemSupplier;
        private final Supplier<Fluid> flowingFluidSupplier;
        private final Supplier<Fluid> stillFluidSupplier;

        private BeforeBreakingBlockHandler beforeBreakingBlockHandler;
        private CanBeReplacedWithPredicate canBeReplacedWithPredicate;

        protected ActualFluid(FluidSetting setting,
                              boolean isStill,
                              Supplier<FluidBlock> fluidBlockSupplier,
                              Supplier<BucketItem> bucketItemSupplier,
                              Supplier<Fluid> flowingFluidSupplier,
                              Supplier<Fluid> stillFluidSupplier) {
            this.setting = setting;
            this.isStill = isStill;
            this.fluidBlockSupplier = fluidBlockSupplier;
            this.bucketItemSupplier = bucketItemSupplier;
            this.flowingFluidSupplier = flowingFluidSupplier;
            this.stillFluidSupplier = stillFluidSupplier;
            this.beforeBreakingBlockHandler = null;
            this.canBeReplacedWithPredicate = null;
        }

        @Override
        protected BlockState toBlockState(FluidState state) {
            return fluidBlockSupplier.get().getDefaultState().with(Properties.LEVEL_15, getBlockStateLevel(state));
        }

        @Override
        public boolean isStill(FluidState state) {
            return false;
        }

        @Override
        public Item getBucketItem() {
            return bucketItemSupplier.get();
        }

        @Override
        public Fluid getFlowing() {
            return flowingFluidSupplier.get();
        }

        @Override
        public Fluid getStill() {
            return stillFluidSupplier.get();
        }

        @Override
        protected boolean isInfinite() {
            return false;
        }

        @Override
        public boolean matchesType(Fluid fluid) {
            return fluid == getStill() || fluid == getFlowing();
        }

        @Override
        protected void beforeBreakingBlock(WorldAccess world, BlockPos pos, BlockState state) {
            if(beforeBreakingBlockHandler != null) {
                beforeBreakingBlockHandler.run(world, pos, state);
            }
        }

        @Override
        protected int getFlowSpeed(WorldView world) {
            return setting.flowSpeed;
        }

        @Override
        protected int getLevelDecreasePerBlock(WorldView world) {
            return setting.levelDecreasePerBlock;
        }

        @Override
        public int getTickRate(WorldView world) {
            return setting.tickRate;
        }

        @Override
        public int getLevel(FluidState state) {
            return isStill ? 8 : state.get(LEVEL);
        }

        @Override
        protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {
            super.appendProperties(builder);
            if(!isStill) {
                builder.add(LEVEL);
            }
        }

        @Override
        protected boolean canBeReplacedWith(FluidState state, BlockView world, BlockPos pos, Fluid fluid, Direction direction) {
            return canBeReplacedWithPredicate.check(state, world, pos, fluid, direction);
        }

        @Override
        protected float getBlastResistance() {
            return 100.0f;
        }
    }

    @FunctionalInterface
    public interface BeforeBreakingBlockHandler {
        void run(WorldAccess world, BlockPos pos, BlockState state);
    }

    @FunctionalInterface
    public interface CanBeReplacedWithPredicate {
        boolean check(FluidState state, BlockView world, BlockPos pos, Fluid fluid, Direction direction);
    }
}
