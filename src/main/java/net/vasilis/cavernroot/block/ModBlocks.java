package net.vasilis.cavernroot.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.vasilis.cavernroot.CavernRoot;
import net.vasilis.cavernroot.block.custom.CavernRootBlock;
import net.vasilis.cavernroot.block.custom.LumenRoot;

public class ModBlocks {

    public static final Block CAVERN_ROOT_BLOCK = registerBlock("cavern_root_block",
            new CavernRootBlock(AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(CavernRoot.MOD_ID, "cavern_root_block")))
                    .noCollision()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.GRASS)
                    .pistonBehavior(PistonBehavior.DESTROY)
            )
    );

    public static final Block LUMEN_ROOT = registerLumen("lumen_root",
            new LumenRoot(AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(CavernRoot.MOD_ID, "lumen_root")))
                    .mapColor(MapColor.BLUE)
                    .noCollision()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.GRASS)
                    .pistonBehavior(PistonBehavior.DESTROY)
                    .luminance(state -> 10)
                    .nonOpaque()
            )
    );

    private static Block registerBlockWithoutBlockItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, Identifier.of(CavernRoot.MOD_ID, name), block);
    }

    // Block and BlockItem registration
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(CavernRoot.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(CavernRoot.MOD_ID, name),
                new BlockItem(block, new Item.Settings()
                        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CavernRoot.MOD_ID, name)))
                        .useBlockPrefixedTranslationKey()
                )
        );
    }

    // Lumen Root registration
    private static Block registerLumen(String name, Block block) {
        registerLumenItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(CavernRoot.MOD_ID, name), block);
    }

    private static void registerLumenItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(CavernRoot.MOD_ID, name),
                new BlockItem(block, new Item.Settings()
                        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CavernRoot.MOD_ID, name)))
                        .useBlockPrefixedTranslationKey()
                        .rarity(Rarity.UNCOMMON)
                )
        );
    }

    public static void registerModBlocks() {
        CavernRoot.LOGGER.info("Registering Mod Blocks for" + CavernRoot.MOD_ID);
    }
}