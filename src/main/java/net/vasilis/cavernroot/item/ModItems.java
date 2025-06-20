package net.vasilis.cavernroot.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.vasilis.cavernroot.CavernRoot;

public class ModItems {


    public static final Item TWISTED_CAVERN_ROOT = registerItem("twisted_cavern_root", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CavernRoot.MOD_ID, "twisted_cavern_root")))
            .food(ModFoodComponents.TWISTED_CAVERN_ROOT)
            )
    );

    public static final Item CAVERN_ROOT_STEW = registerItem("cavern_root_stew", new CavernRootStewItem(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CavernRoot.MOD_ID, "cavern_root_stew")))
            .food(ModFoodComponents.CAVERN_ROOT_STEW)
            .maxCount(1) // Required for stew-like items
            )
    );


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(CavernRoot.MOD_ID, name), item);
    }

    public static void registerModItems() {
        CavernRoot.LOGGER.info("Registering Mod Items for " + CavernRoot.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {

        });
    }
}