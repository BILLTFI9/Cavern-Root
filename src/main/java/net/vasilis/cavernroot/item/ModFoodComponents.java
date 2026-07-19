package net.vasilis.cavernroot.item;

import net.minecraft.world.food.FoodProperties;

public class ModFoodComponents {
    public static final FoodProperties TWISTED_CAVERN_ROOT = new FoodProperties.Builder()
            .nutrition(3)
            .saturationModifier(0.1F)
            .build();

    public static final FoodProperties CAVERN_ROOT_STEW = new FoodProperties.Builder()
            .nutrition(8)
            .saturationModifier(0.6F)
            .build();

}