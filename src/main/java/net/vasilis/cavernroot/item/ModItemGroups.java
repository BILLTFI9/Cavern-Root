package net.vasilis.cavernroot.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.vasilis.cavernroot.CavernRoot;
import net.vasilis.cavernroot.block.ModBlocks;

public class ModItemGroups {
    public static final CreativeModeTab CAVERN_ROOT_ITEMS = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(CavernRoot.MOD_ID, "cavern_root_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.CAVERN_ROOT_BLOCK))
                    .title(Component.translatable("itemgroup.cavernroot.cavern_root_items"))
                    .displayItems((displayContext, entries) -> {
                        entries.accept(ModItems.TWISTED_CAVERN_ROOT);
                        entries.accept(ModBlocks.CAVERN_ROOT_BLOCK);
                        entries.accept(ModBlocks.LUMEN_ROOT);
                        entries.accept(ModItems.CAVERN_ROOT_STEW);

                    }).build());


    public static void registerItemGroups() {
        CavernRoot.LOGGER.info("Registering Item Groups for " + CavernRoot.MOD_ID);
    }
}