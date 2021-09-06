package de.domephant.bettertrees.client.entity.model;

import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SquirrelEntityModel<T extends Entity> extends HierarchicalModel<T> {
    private final ModelPart root;

    public SquirrelEntityModel(ModelPart p_170530_) {
        this.root = p_170530_;
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        partdefinition.addOrReplaceChild("1", CubeListBuilder.create().texOffs(0, 0).addBox(8.0F, -6.0F, -1.0F, 1.0F, 1.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
        partdefinition.addOrReplaceChild("2", CubeListBuilder.create().texOffs(16, 16).addBox(-12.0F, -6.0F, -1.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
        partdefinition.addOrReplaceChild("3", CubeListBuilder.create().texOffs(40, 16).addBox(-10.0F, -8.0F, -2.0F, 4.0F, 4.0F, 4.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
        partdefinition.addOrReplaceChild("4", CubeListBuilder.create().texOffs(40, 16).addBox(-7.0F, -7.0F, -2.0F, 4.0F, 4.0F, 4.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
        partdefinition.addOrReplaceChild("5", CubeListBuilder.create().texOffs(0, 16).addBox(-4.0F, -5.0F, -1.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
        partdefinition.addOrReplaceChild("6", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, -2.0F, -2.0F, 1.0F, 2.0F, 1.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
        partdefinition.addOrReplaceChild("7", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -2.0F, 1.0F, 1.0F, 2.0F, 1.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
        partdefinition.addOrReplaceChild("8", CubeListBuilder.create().texOffs(16, 16).addBox(3.0F, -2.0F, -2.0F, 1.0F, 2.0F, 1.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
        partdefinition.addOrReplaceChild("9", CubeListBuilder.create().texOffs(40, 16).addBox(3.0F, -2.0F, 1.0F, 1.0F, 2.0F, 1.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
        partdefinition.addOrReplaceChild("10", CubeListBuilder.create().texOffs(40, 16).addBox(-2.0F, -5.0F, -2.0F, 6.0F, 3.0F, 4.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
        partdefinition.addOrReplaceChild("11", CubeListBuilder.create().texOffs(0, 16).addBox(7.0F, -10.0F, 1.0F, 1.0F, 2.0F, 1.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
        partdefinition.addOrReplaceChild("12", CubeListBuilder.create().texOffs(0, 16).addBox(7.0F, -10.0F, -2.0F, 1.0F, 2.0F, 1.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
        partdefinition.addOrReplaceChild("13", CubeListBuilder.create().texOffs(0, 16).addBox(4.0F, -8.0F, -2.0F, 4.0F, 4.0F, 4.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    public ModelPart root() {
        return this.root;
    }

    @Override
    public void setupAnim(T p_102618_, float p_102619_, float p_102620_, float p_102621_, float p_102622_, float p_102623_) {

    }

}