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
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.vasilis.cavernroot.CavernRoot;
import net.vasilis.cavernroot.block.custom.CavernRootBlock;
import net.vasilis.cavernroot.block.custom.LumenRoot;

public class ModBlocks {

    public static final Block CAVERN_ROOT_BLOCK = registerBlock("cavern_root_block",
            new CavernRootBlock(AbstractBlock.Settings.create()
                    .noCollision()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.GRASS)
                    .pistonBehavior(PistonBehavior.DESTROY)
            )
    );

    //TODO Add functionality to the Lumen root.
    public static final Block LUMEN_ROOT = registerBlock("lumen_root",
            new LumenRoot(AbstractBlock.Settings.create()
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

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(CavernRoot.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(CavernRoot.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        CavernRoot.LOGGER.info("Registering Mod Blocks for" + CavernRoot.MOD_ID);
    }
}