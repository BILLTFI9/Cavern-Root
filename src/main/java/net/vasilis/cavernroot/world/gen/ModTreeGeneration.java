package net.vasilis.cavernroot.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.vasilis.cavernroot.world.ModPlacedFeatures;

public class ModTreeGeneration {
    public static void generateTrees() {

        // The following code is similar to cancer. It spreads and grows larger, but I cannot stop it.
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(
                        BiomeKeys.DRIPSTONE_CAVES,
                        BiomeKeys.DEEP_DARK,
                        BiomeKeys.PLAINS,
                        BiomeKeys.FOREST,
                        BiomeKeys.TAIGA,
                        BiomeKeys.DESERT,
                        BiomeKeys.BADLANDS,
                        BiomeKeys.SNOWY_PLAINS,
                        BiomeKeys.SNOWY_TAIGA,
                        BiomeKeys.MEADOW,
                        BiomeKeys.JUNGLE,
                        BiomeKeys.BAMBOO_JUNGLE,
                        BiomeKeys.OCEAN,
                        BiomeKeys.COLD_OCEAN,
                        BiomeKeys.DEEP_COLD_OCEAN,
                        BiomeKeys.DEEP_OCEAN,
                        BiomeKeys.DEEP_FROZEN_OCEAN,
                        BiomeKeys.DEEP_LUKEWARM_OCEAN,
                        BiomeKeys.LUKEWARM_OCEAN,
                        BiomeKeys.WARM_OCEAN,
                        BiomeKeys.FROZEN_OCEAN,
                        BiomeKeys.FROZEN_PEAKS,
                        BiomeKeys.SWAMP,
                        BiomeKeys.MANGROVE_SWAMP,
                        BiomeKeys.WINDSWEPT_FOREST,
                        BiomeKeys.WINDSWEPT_HILLS,
                        BiomeKeys.WINDSWEPT_GRAVELLY_HILLS,
                        BiomeKeys.WINDSWEPT_SAVANNA,
                        BiomeKeys.SAVANNA,
                        BiomeKeys.SAVANNA_PLATEAU,
                        BiomeKeys.CHERRY_GROVE,
                        BiomeKeys.OLD_GROWTH_BIRCH_FOREST,
                        BiomeKeys.OLD_GROWTH_PINE_TAIGA,
                        BiomeKeys.OLD_GROWTH_SPRUCE_TAIGA,
                        BiomeKeys.DARK_FOREST,
                        BiomeKeys.RIVER,
                        BiomeKeys.BIRCH_FOREST
                    ),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.CAVERN_ROOT_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(
                        BiomeKeys.DRIPSTONE_CAVES,
                        BiomeKeys.DEEP_DARK,
                        BiomeKeys.PLAINS,
                        BiomeKeys.FOREST,
                        BiomeKeys.TAIGA,
                        BiomeKeys.DESERT,
                        BiomeKeys.BADLANDS,
                        BiomeKeys.SNOWY_PLAINS,
                        BiomeKeys.SNOWY_TAIGA,
                        BiomeKeys.MEADOW,
                        BiomeKeys.JUNGLE,
                        BiomeKeys.BAMBOO_JUNGLE,
                        BiomeKeys.OCEAN,
                        BiomeKeys.COLD_OCEAN,
                        BiomeKeys.DEEP_COLD_OCEAN,
                        BiomeKeys.DEEP_OCEAN,
                        BiomeKeys.DEEP_FROZEN_OCEAN,
                        BiomeKeys.DEEP_LUKEWARM_OCEAN,
                        BiomeKeys.LUKEWARM_OCEAN,
                        BiomeKeys.WARM_OCEAN,
                        BiomeKeys.FROZEN_OCEAN,
                        BiomeKeys.FROZEN_PEAKS,
                        BiomeKeys.SWAMP,
                        BiomeKeys.MANGROVE_SWAMP,
                        BiomeKeys.WINDSWEPT_FOREST,
                        BiomeKeys.WINDSWEPT_HILLS,
                        BiomeKeys.WINDSWEPT_GRAVELLY_HILLS,
                        BiomeKeys.WINDSWEPT_SAVANNA,
                        BiomeKeys.SAVANNA,
                        BiomeKeys.SAVANNA_PLATEAU,
                        BiomeKeys.CHERRY_GROVE,
                        BiomeKeys.OLD_GROWTH_BIRCH_FOREST,
                        BiomeKeys.OLD_GROWTH_PINE_TAIGA,
                        BiomeKeys.OLD_GROWTH_SPRUCE_TAIGA,
                        BiomeKeys.DARK_FOREST,
                        BiomeKeys.RIVER,
                        BiomeKeys.BIRCH_FOREST
                ),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.LUMEN_ROOT_PLACED_KEY);


    }
}