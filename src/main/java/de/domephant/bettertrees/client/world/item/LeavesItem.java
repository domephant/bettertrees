package de.domephant.bettertrees.client.world.item;

import de.domephant.bettertrees.client.events.RegistryEvents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.RenderProperties;

public class LeavesItem extends BlockItem {

    public LeavesItem(Block p_40565_, CreativeModeTab creativeTab) {
        super(p_40565_, new Item.Properties().tab(creativeTab));
    }
}
