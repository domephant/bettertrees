package de.domephant.bettertrees.client.modellayers;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class CustomModelLayers {

    public static final ModelLayerLocation WHALEENTITY = register("whale");

    private static ModelLayerLocation register(String p_171294_) {
        return register(p_171294_, "main");
    }

    private static ModelLayerLocation register(String p_171296_, String p_171297_) {
        return createLocation(p_171296_, p_171297_);
    }

    private static ModelLayerLocation createLocation(String p_171301_, String p_171302_) {
        return new ModelLayerLocation(new ResourceLocation("minecraft", p_171301_), p_171302_);
    }
}
