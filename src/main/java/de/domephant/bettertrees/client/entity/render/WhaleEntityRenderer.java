package de.domephant.bettertrees.client.entity.render;

import de.domephant.bettertrees.client.entity.model.WhaleEntityModel;
import de.domephant.bettertrees.client.modellayers.CustomModelLayers;
import de.domephant.bettertrees.common.entity.WhaleEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class WhaleEntityRenderer extends MobRenderer<WhaleEntity, WhaleEntityModel<WhaleEntity>> {
    private static final ResourceLocation WHALEENTITY_LOCATION = new ResourceLocation("textures/entity/whale.png");

    public WhaleEntityRenderer(EntityRendererProvider.Context p_173960_) {
        super(p_173960_, new WhaleEntityModel<>(p_173960_.bakeLayer(CustomModelLayers.WHALEENTITY)), 0.7F);
    }

    @Override
    public ResourceLocation getTextureLocation(WhaleEntity p_114482_){
        return WHALEENTITY_LOCATION;
    }
}
