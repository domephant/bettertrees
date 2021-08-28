package de.domephant.bettertrees.client.events;

import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.level.FoliageColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class ItemColorRegisterHandler {
    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public void BlockColorRegister(ColorHandlerEvent.Item event) {
        event.getItemColors().register((stack, index) -> {return FoliageColor.getDefaultColor();}, RegistryEvents.HAZELNUT_LEAVES_item);
    }
}
