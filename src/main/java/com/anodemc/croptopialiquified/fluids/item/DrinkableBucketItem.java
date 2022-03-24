package com.anodemc.croptopialiquified.fluids.item;

import com.anodemc.croptopialiquified.fluids.variant.LiquifiedFluidVariant;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;
import org.checkerframework.checker.nullness.qual.Nullable;

public class DrinkableBucketItem extends BaseBucketItem {
    public DrinkableBucketItem(LiquifiedFluidVariant liquifiedFluidVariant, Settings settings, int multiplier) {
        super(liquifiedFluidVariant, settings
                .food(getMultipliedFoodComponent(liquifiedFluidVariant.getOriginalItem().getFoodComponent(), multiplier)));
    }

    public static FoodComponent getMultipliedFoodComponent(@Nullable FoodComponent foodComponent, int multiplier) {
        if(foodComponent == null) return null;
        FoodComponent.Builder builder = new FoodComponent.Builder()
                .hunger(foodComponent.getHunger() * multiplier / 2)
                .saturationModifier(foodComponent.getSaturationModifier() * multiplier / 2);
        if (foodComponent.isMeat()) builder.meat();
        if (foodComponent.isAlwaysEdible()) builder.alwaysEdible();
//        builder.alwaysEdible();
        if (foodComponent.isSnack()) builder.snack();
        foodComponent.getStatusEffects().forEach(s -> builder.statusEffect(s.getFirst(), s.getSecond()));
        return builder.build();
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        TypedActionResult<ItemStack> result = super.use(world, user, hand);
        if(!result.getResult().isAccepted()) {
            if (this.isFood()) {
                ItemStack itemStack = user.getStackInHand(hand);
                if (user.canConsume(this.getFoodComponent().isAlwaysEdible())) {
                    user.setCurrentHand(hand);
                    return TypedActionResult.consume(itemStack);
                }
                return TypedActionResult.fail(itemStack);
            }
        }
        return result;
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (user instanceof ServerPlayerEntity) {
            ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity)user;
            Criteria.CONSUME_ITEM.trigger(serverPlayerEntity, stack);
            serverPlayerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
        }
        if (user instanceof PlayerEntity && !((PlayerEntity)user).getAbilities().creativeMode) {
            stack.decrement(1);
        }
        if (stack.isEmpty()) {
            return new ItemStack(Items.BUCKET);
        }
        if (user instanceof PlayerEntity && !((PlayerEntity)user).getAbilities().creativeMode) {
            ItemStack itemStack = new ItemStack(Items.BUCKET);
            PlayerEntity playerEntity = (PlayerEntity)user;
            if (!playerEntity.getInventory().insertStack(itemStack)) {
                playerEntity.dropItem(itemStack, false);
            }
        }
        return stack;
    }
}
