package de.domephant.bettertrees.client.entity.render;

import de.domephant.bettertrees.client.entity.model.SquirrelEntityModel;
import de.domephant.bettertrees.client.entity.model.WhaleEntityModel;
import de.domephant.bettertrees.client.modellayers.CustomModelLayers;
import de.domephant.bettertrees.common.entity.SquirrelEntity;
import de.domephant.bettertrees.common.entity.WhaleEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SquirrelEntityRenderer extends MobRenderer<SquirrelEntity, SquirrelEntityModel<SquirrelEntity>> {
    private static final ResourceLocation SQUIRRELENTITY_LOCATION = new ResourceLocation("textures/entity/squirrel.png");

    public SquirrelEntityRenderer(EntityRendererProvider.Context p_173960_) {
        super(p_173960_, new SquirrelEntityModel<>(p_173960_.bakeLayer(CustomModelLayers.SQUIRRELENTITY)), 0.7F);
    }

    @Override
    public ResourceLocation getTextureLocation(SquirrelEntity p_114482_) {
        return SQUIRRELENTITY_LOCATION;
    }
}
