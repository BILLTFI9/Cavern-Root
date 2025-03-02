package net.vasilis.cavernroot.world;

import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.vasilis.cavernroot.CavernRoot;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> CAVERN_ROOT_PLACED_KEY = registerKey("cavern_root_placed");
    public static final RegistryKey<PlacedFeature> LUMEN_ROOT_PLACED_KEY = registerKey("lumen_root_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(
                context,
                CAVERN_ROOT_PLACED_KEY,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.CAVERN_ROOT_BLOCK_KEY),
                CountPlacementModifier.of(10),  // Spawns 10 patches per chunk
                HeightRangePlacementModifier.uniform(YOffset.fixed(-59), YOffset.fixed(40)), // Spawns between Y=-59 and Y=40
                BiomePlacementModifier.of() // Ensures it only spawns in valid biomes
        );

        // THIS FEATURE IS DISABLED!!!
        register(
                context,
                LUMEN_ROOT_PLACED_KEY,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.LUMEN_ROOT_KEY),
                CountPlacementModifier.of(0),  // Spawns 2 patches per chunk
                HeightRangePlacementModifier.uniform(YOffset.fixed(-59), YOffset.fixed(0)), // Spawns between Y=-59 and Y=40
                BiomePlacementModifier.of() // Ensures it only spawns in valid biomes
        );

    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(CavernRoot.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}