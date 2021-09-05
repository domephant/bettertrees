package de.domephant.bettertrees.client.init;

import de.domephant.bettertrees.client.events.BlockColorRegisterHandler;
import de.domephant.bettertrees.client.events.ItemColorRegisterHandler;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class ClientProxy extends CommonProxy{

    public void construct() {
        FMLJavaModLoadingContext.get().getModEventBus().register(new BlockColorRegisterHandler());
        FMLJavaModLoadingContext.get().getModEventBus().register(new ItemColorRegisterHandler());
        super.construct();
    }

    public void setup() {
        super.setup();
    }

    public void complete() {
        super.complete();
    }
}