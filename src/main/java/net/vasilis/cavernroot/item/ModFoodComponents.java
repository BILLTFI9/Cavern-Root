package net.vasilis.cavernroot.item;

import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent TWISTED_CAVERN_ROOT = new FoodComponent.Builder()
            .hunger(3)
            .saturationModifier(0.4F)
            .snack()
            .build();
}
