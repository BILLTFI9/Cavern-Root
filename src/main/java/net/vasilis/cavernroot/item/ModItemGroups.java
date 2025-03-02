package net.vasilis.cavernroot.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.vasilis.cavernroot.CavernRoot;
import net.vasilis.cavernroot.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup CAVERN_ROOT_ITEMS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(CavernRoot.MOD_ID, "cavern_root_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.CAVERN_ROOT_BLOCK))
                    .displayName(Text.translatable("itemgroup.cavernroot.cavern_root_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.TWISTED_CAVERN_ROOT);
                        entries.add(ModBlocks.CAVERN_ROOT_BLOCK);
                        entries.add(ModItems.LUMEN_ROOT);

                    }).build());


    public static void registerItemGroups() {
        CavernRoot.LOGGER.info("Registering Item Groups for " + CavernRoot.MOD_ID);
    }
}