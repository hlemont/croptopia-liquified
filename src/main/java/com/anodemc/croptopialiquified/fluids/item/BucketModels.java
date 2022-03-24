package com.anodemc.croptopialiquified.fluids.item;

import com.anodemc.croptopialiquified.Liquified;
import net.minecraft.client.render.model.UnbakedModel;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.util.Identifier;

public abstract class BucketModels implements UnbakedModel {
    public static final ModelIdentifier DRINK_BUCKET_MODEL = new ModelIdentifier(new Identifier(Liquified.MOD_ID, "bucket_drink"), "inventory");
    public static final ModelIdentifier INGREDIENT_BUCKET_MODEL = new ModelIdentifier(new Identifier(Liquified.MOD_ID, "bucket_ingredient"), "inventory");
    public static final ModelIdentifier MELTED_INGREDIENT_BUCKET_MODEL = new ModelIdentifier(new Identifier(Liquified.MOD_ID, "bucket_melted_ingredient"), "inventory");
}
