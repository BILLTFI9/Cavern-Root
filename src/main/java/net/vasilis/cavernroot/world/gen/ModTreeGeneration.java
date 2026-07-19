package net.vasilis.cavernroot.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.vasilis.cavernroot.world.ModPlacedFeatures;

public class ModTreeGeneration {
    public static void generateTrees() {

        // The following code is similar to cancer. It spreads and grows larger, but I cannot stop it.
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(
                        Biomes.DRIPSTONE_CAVES,
                        Biomes.DEEP_DARK,
                        Biomes.PLAINS,
                        Biomes.FOREST,
                        Biomes.TAIGA,
                        Biomes.DESERT,
                        Biomes.BADLANDS,
                        Biomes.SNOWY_PLAINS,
                        Biomes.SNOWY_TAIGA,
                        Biomes.MEADOW,
                        Biomes.JUNGLE,
                        Biomes.BAMBOO_JUNGLE,
                        Biomes.OCEAN,
                        Biomes.COLD_OCEAN,
                        Biomes.DEEP_COLD_OCEAN,
                        Biomes.DEEP_OCEAN,
                        Biomes.DEEP_FROZEN_OCEAN,
                        Biomes.DEEP_LUKEWARM_OCEAN,
                        Biomes.LUKEWARM_OCEAN,
                        Biomes.WARM_OCEAN,
                        Biomes.FROZEN_OCEAN,
                        Biomes.FROZEN_PEAKS,
                        Biomes.SWAMP,
                        Biomes.MANGROVE_SWAMP,
                        Biomes.WINDSWEPT_FOREST,
                        Biomes.WINDSWEPT_HILLS,
                        Biomes.WINDSWEPT_GRAVELLY_HILLS,
                        Biomes.WINDSWEPT_SAVANNA,
                        Biomes.SAVANNA,
                        Biomes.SAVANNA_PLATEAU,
                        Biomes.CHERRY_GROVE,
                        Biomes.OLD_GROWTH_BIRCH_FOREST,
                        Biomes.OLD_GROWTH_PINE_TAIGA,
                        Biomes.OLD_GROWTH_SPRUCE_TAIGA,
                        Biomes.DARK_FOREST,
                        Biomes.RIVER,
                        Biomes.BIRCH_FOREST
                    ),
                GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.CAVERN_ROOT_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(
                        Biomes.DRIPSTONE_CAVES,
                        Biomes.DEEP_DARK,
                        Biomes.PLAINS,
                        Biomes.FOREST,
                        Biomes.TAIGA,
                        Biomes.DESERT,
                        Biomes.BADLANDS,
                        Biomes.SNOWY_PLAINS,
                        Biomes.SNOWY_TAIGA,
                        Biomes.MEADOW,
                        Biomes.JUNGLE,
                        Biomes.BAMBOO_JUNGLE,
                        Biomes.OCEAN,
                        Biomes.COLD_OCEAN,
                        Biomes.DEEP_COLD_OCEAN,
                        Biomes.DEEP_OCEAN,
                        Biomes.DEEP_FROZEN_OCEAN,
                        Biomes.DEEP_LUKEWARM_OCEAN,
                        Biomes.LUKEWARM_OCEAN,
                        Biomes.WARM_OCEAN,
                        Biomes.FROZEN_OCEAN,
                        Biomes.FROZEN_PEAKS,
                        Biomes.SWAMP,
                        Biomes.MANGROVE_SWAMP,
                        Biomes.WINDSWEPT_FOREST,
                        Biomes.WINDSWEPT_HILLS,
                        Biomes.WINDSWEPT_GRAVELLY_HILLS,
                        Biomes.WINDSWEPT_SAVANNA,
                        Biomes.SAVANNA,
                        Biomes.SAVANNA_PLATEAU,
                        Biomes.CHERRY_GROVE,
                        Biomes.OLD_GROWTH_BIRCH_FOREST,
                        Biomes.OLD_GROWTH_PINE_TAIGA,
                        Biomes.OLD_GROWTH_SPRUCE_TAIGA,
                        Biomes.DARK_FOREST,
                        Biomes.RIVER,
                        Biomes.BIRCH_FOREST
                ),
                GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.LUMEN_ROOT_PLACED_KEY);


    }
}