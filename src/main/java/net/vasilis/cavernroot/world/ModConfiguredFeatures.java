package net.vasilis.cavernroot.world;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.vasilis.cavernroot.CavernRoot;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.vasilis.cavernroot.block.ModBlocks;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> CAVERN_ROOT_BLOCK_KEY = registerKey("cavern_root_block");
    public static final RegistryKey<ConfiguredFeature<?, ?>> LUMEN_ROOT_KEY =registerKey("lumen_root");


    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> featureRegisterable) {
        ConfiguredFeatures.register(
                featureRegisterable,
                CAVERN_ROOT_BLOCK_KEY,
                Feature.RANDOM_PATCH,  // Generates patches like grass
                new RandomPatchFeatureConfig(
                        32,  // Tries per chunk (adjust for density)
                        2,   // X spread
                        3,   // Y spread
                        PlacedFeatures.createEntry(
                                Feature.SIMPLE_BLOCK,
                                new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.CAVERN_ROOT_BLOCK))
                        )
                )
        );


        ConfiguredFeatures.register(
                featureRegisterable,
                LUMEN_ROOT_KEY,
                Feature.RANDOM_PATCH,
                new RandomPatchFeatureConfig(
                        5,  // Tries per chunk (adjust for density)
                        1,   // X spread
                        1,   // Y spread
                        PlacedFeatures.createEntry(
                                Feature.SIMPLE_BLOCK,
                                new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.LUMEN_ROOT))
                        )
                )
        );


    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(CavernRoot.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}