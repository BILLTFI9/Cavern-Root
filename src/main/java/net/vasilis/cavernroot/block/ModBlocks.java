package net.vasilis.cavernroot.block;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.vasilis.cavernroot.CavernRoot;
import net.vasilis.cavernroot.block.custom.CavernRootBlock;
import net.vasilis.cavernroot.block.custom.LumenRoot;

public class ModBlocks {

    public static final Block CAVERN_ROOT_BLOCK = registerBlock("cavern_root_block",
            new CavernRootBlock(BlockBehaviour.Properties.of()
                    .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(CavernRoot.MOD_ID, "cavern_root_block")))
                    .noCollision()
                    .instabreak()
                    .sound(SoundType.GRASS)
                    .pushReaction(PushReaction.DESTROY)
            )
    );

    public static final Block LUMEN_ROOT = registerLumen("lumen_root",
            new LumenRoot(BlockBehaviour.Properties.of()
                    .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(CavernRoot.MOD_ID, "lumen_root")))
                    .mapColor(MapColor.COLOR_BLUE)
                    .noCollision()
                    .instabreak()
                    .sound(SoundType.GRASS)
                    .pushReaction(PushReaction.DESTROY)
                    .lightLevel(state -> 10)
                    .noOcclusion()
            )
    );

    private static Block registerBlockWithoutBlockItem(String name, Block block) {
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(CavernRoot.MOD_ID, name), block);
    }

    // Block and BlockItem registration
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(CavernRoot.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(CavernRoot.MOD_ID, name),
                new BlockItem(block, new Item.Properties()
                        .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(CavernRoot.MOD_ID, name)))
                        .useBlockDescriptionPrefix()
                )
        );
    }

    // Lumen Root registration
    private static Block registerLumen(String name, Block block) {
        registerLumenItem(name, block);
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(CavernRoot.MOD_ID, name), block);
    }

    private static void registerLumenItem(String name, Block block) {
        Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(CavernRoot.MOD_ID, name),
                new BlockItem(block, new Item.Properties()
                        .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(CavernRoot.MOD_ID, name)))
                        .useBlockDescriptionPrefix()
                        .rarity(Rarity.UNCOMMON)
                )
        );
    }

    public static void registerModBlocks() {
        CavernRoot.LOGGER.info("Registering Mod Blocks for" + CavernRoot.MOD_ID);
    }
}