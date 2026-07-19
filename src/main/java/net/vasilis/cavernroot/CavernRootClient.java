package net.vasilis.cavernroot;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;
import net.vasilis.cavernroot.block.ModBlocks;

public class CavernRootClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        BlockRenderLayerMap.putBlock(ModBlocks.CAVERN_ROOT_BLOCK,ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.LUMEN_ROOT, ChunkSectionLayer.CUTOUT);

    }
}
