package net.vasilis.cavernroot.world;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.vasilis.cavernroot.CavernRoot;
import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> CAVERN_ROOT_PLACED_KEY = registerKey("cavern_root_placed");
    public static final ResourceKey<PlacedFeature> LUMEN_ROOT_PLACED_KEY = registerKey("lumen_root_placed");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(
                context,
                CAVERN_ROOT_PLACED_KEY,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.CAVERN_ROOT_BLOCK_KEY),
                CountPlacement.of(10),  // Spawns 10 patches per chunk
                HeightRangePlacement.uniform(VerticalAnchor.absolute(-59), VerticalAnchor.absolute(40)), // Spawns between Y=-59 and Y=40
                BiomeFilter.biome() // Ensures it only spawns in valid biomes
        );

        register(
                context,
                LUMEN_ROOT_PLACED_KEY,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.LUMEN_ROOT_KEY),
                CountPlacement.of(2),  // Spawns 2 patches per chunk
                HeightRangePlacement.uniform(VerticalAnchor.absolute(-59), VerticalAnchor.absolute(0)), // Spawns between Y=-59 and Y=40
                BiomeFilter.biome() // Ensures it only spawns in valid biomes
        );

    }

    public static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(CavernRoot.MOD_ID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key,
                                                                                   Holder<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}