package de.domephant.bettertrees.client.events;

import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class BlockColorRegisterHandler {
    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public void BlockColorRegister(ColorHandlerEvent.Block event) {
        event.getBlockColors().register((bs, world, pos, index) -> {return world != null && pos != null ? BiomeColors.getAverageFoliageColor(world, pos) : FoliageColor.getDefaultColor();}, RegistryEvents.HAZELNUT_LEAVES);
    }
}
