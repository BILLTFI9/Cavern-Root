package net.vasilis.cavernroot.world;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.vasilis.cavernroot.CavernRoot;
import net.vasilis.cavernroot.block.ModBlocks;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> CAVERN_ROOT_BLOCK_KEY = registerKey("cavern_root_block");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LUMEN_ROOT_KEY =registerKey("lumen_root");


    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> featureRegisterable) {
        FeatureUtils.register(
                featureRegisterable,
                CAVERN_ROOT_BLOCK_KEY,
                Feature.RANDOM_PATCH,  // Generates patches like grass
                new RandomPatchConfiguration(
                        8,  // Tries per chunk (adjust for density)
                        2,   // X spread
                        2,   // Y spread
                        PlacementUtils.onlyWhenEmpty(
                                Feature.SIMPLE_BLOCK,
                                new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.CAVERN_ROOT_BLOCK))
                        )
                )
        );


        FeatureUtils.register(
                featureRegisterable,
                LUMEN_ROOT_KEY,
                Feature.RANDOM_PATCH,
                new RandomPatchConfiguration(
                        5,  // Tries per chunk (adjust for density)
                        1,   // X spread
                        1,   // Y spread
                        PlacementUtils.onlyWhenEmpty(
                                Feature.SIMPLE_BLOCK,
                                new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.LUMEN_ROOT))
                        )
                )
        );


    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, Identifier.fromNamespaceAndPath(CavernRoot.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                   ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}