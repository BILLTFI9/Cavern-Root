package net.vasilis.cavernroot.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.vasilis.cavernroot.CavernRoot;

public class ModItems {
    public static final Item UNWRAPPED_CAVERN_ROOT = registerItem("unwrapped_cavern_root", new Item(new Item.Settings()));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(CavernRoot.MOD_ID, name), item);
    }

    public static void registerModItems() {
        CavernRoot.LOGGER.info("Registering Mod Items for " + CavernRoot.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.add(UNWRAPPED_CAVERN_ROOT);
        });
    }
}
