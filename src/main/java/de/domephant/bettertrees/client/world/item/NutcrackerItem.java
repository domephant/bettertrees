package de.domephant.bettertrees.client.world.item;

import de.domephant.bettertrees.client.events.RegistryEvents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class NutcrackerItem extends Item {

    public NutcrackerItem(Properties properties){
        super(properties.durability(10));
    }

    @Override
    public ItemStack getContainerItem(ItemStack item) {
        if(item.getItem().equals(RegistryEvents.NUTCRACKER)){
            item.setDamageValue(item.getDamageValue() + 1);
            if (item.getDamageValue() == item.getMaxDamage()) {
                return ItemStack.EMPTY;
            } else {
                return item.copy();
            }
        } else {
            return ItemStack.EMPTY;
        }
        //return item.copy();
    }

    @Override
    public boolean hasContainerItem(ItemStack stack) {
        return true;
    }
}

