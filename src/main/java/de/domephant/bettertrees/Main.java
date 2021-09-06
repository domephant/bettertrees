package de.domephant.bettertrees;

import de.domephant.bettertrees.client.init.ClientProxy;
import de.domephant.bettertrees.client.init.CommonProxy;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Main.MOD_ID)
public class Main
{
    // Directly reference a log4j logger.
    public static Main instance;
    public static final String MOD_ID = "bettertrees";
    public static final Logger LOGGER = LogManager.getLogger();
    private static CommonProxy proxy = DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> CommonProxy::new);

    public Main() {
        FMLJavaModLoadingContext.get().getModEventBus().register(this);
        proxy.construct();
        instance = this;
    }

    @SubscribeEvent
    public void setup(final FMLCommonSetupEvent event) {
        proxy.setup();
    }

    @SubscribeEvent
    public void ready(final FMLLoadCompleteEvent event) {
        proxy.complete();
    }
}
