package de.domephant.bettertrees.client.tabs;

import de.domephant.bettertrees.Main;
import de.domephant.bettertrees.client.events.RegistryEvents;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class BetterTreesTab extends CreativeModeTab {
    public BetterTreesTab(String name){
        super(Main.MOD_ID + "." + name);

    }
    @Override
    public ItemStack makeIcon() {
        return new ItemStack(RegistryEvents.HAZELNUT);
    }
}
