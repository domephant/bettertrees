package de.domephant.bettertrees.client.world.blocks;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public class HazelnutLogBlock extends RotatedPillarBlock {

    public HazelnutLogBlock(MaterialColor color, SoundType sound) {
        super(Properties.of(Material.STONE, color).strength(5F,6F).sound(sound));
    }
}
