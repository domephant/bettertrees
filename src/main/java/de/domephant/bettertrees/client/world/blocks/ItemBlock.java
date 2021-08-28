package de.domephant.bettertrees.client.world.blocks;

import de.domephant.bettertrees.client.events.BlockColorRegisterHandler;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class ItemBlock extends Block {

    public ItemBlock(MaterialColor color, SoundType sound){
        super(Properties.of(Material.STONE, color).strength(5F,6F).sound(sound));
    }

}