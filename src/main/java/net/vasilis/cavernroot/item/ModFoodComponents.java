package net.vasilis.cavernroot.item;

import net.minecraft.component.type.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent TWISTED_CAVERN_ROOT = new FoodComponent.Builder()
            .nutrition(3)
            .saturationModifier(0.1F)
            .build();

    public static final FoodComponent CAVERN_ROOT_STEW = new FoodComponent.Builder()
            .nutrition(8)
            .saturationModifier(0.6F)
            .build();

}