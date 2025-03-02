package net.vasilis.cavernroot;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.vasilis.cavernroot.block.ModBlocks;
import net.vasilis.cavernroot.item.ModItemGroups;
import net.vasilis.cavernroot.item.ModItems;
import net.vasilis.cavernroot.world.gen.ModWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CavernRoot implements ModInitializer {
	public static final String MOD_ID = "cavern-root";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModBlocks.registerModBlocks();
		ModItems.registerModItems();
		ModWorldGeneration.generateModWorldGen();

		CompostingChanceRegistry.INSTANCE.add(ModBlocks.CAVERN_ROOT_BLOCK, 0.75f); //Composter functionality for the cavern root.

		FuelRegistry.INSTANCE.add(ModBlocks.CAVERN_ROOT_BLOCK, 200); //Fuel!

	}
}