package net.vasilis.cavernroot.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.vasilis.cavernroot.CavernRoot;

public class ModItems {


    public static final Item TWISTED_CAVERN_ROOT = registerItem("twisted_cavern_root", new Item(new Item.Properties()
            .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(CavernRoot.MOD_ID, "twisted_cavern_root")))
            .food(ModFoodComponents.TWISTED_CAVERN_ROOT)
            )
    );

    public static final Item CAVERN_ROOT_STEW = registerItem("cavern_root_stew", new CavernRootStewItem(new Item.Properties()
            .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(CavernRoot.MOD_ID, "cavern_root_stew")))
            .food(ModFoodComponents.CAVERN_ROOT_STEW)
            .stacksTo(1) // Required for stew-like items
            )
    );


    private static Item registerItem(String name, Item item) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(CavernRoot.MOD_ID, name), item);
    }

    public static void registerModItems() {
        CavernRoot.LOGGER.info("Registering Mod Items for " + CavernRoot.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FOOD_AND_DRINKS).register(entries -> {

        });
    }
}