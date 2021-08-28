package de.domephant.bettertrees.client.events;

import de.domephant.bettertrees.client.Main;

import de.domephant.bettertrees.client.world.blocks.HazelnutLeavesBlock;
import de.domephant.bettertrees.client.world.blocks.HazelnutLogBlock;
import de.domephant.bettertrees.client.world.blocks.ItemBlock;
import de.domephant.bettertrees.client.tabs.BetterTreesTab;
import de.domephant.bettertrees.client.world.item.LeavesItem;
import de.domephant.bettertrees.client.world.item.NutcrackerItem;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.ColorResolver;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.lighting.LevelLightEngine;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.logging.log4j.Logger;
import net.minecraft.world.level.block.LeavesBlock;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class RegistryEvents {
    //Requirements
    public static final Logger LOGGER = Main.LOGGER;
    public static final String MOD_ID = Main.MOD_ID;

    //CreativeModeTab
    public static final CreativeModeTab BETTER_TREES_TAB = new BetterTreesTab("betterTreesTab");


    //Blocks
    public static final ItemBlock BLOCK_OF_HAZELNUT = new ItemBlock(MaterialColor.STONE, SoundType.WART_BLOCK);
    public static final HazelnutLogBlock HAZELNUT_LOG = new HazelnutLogBlock(MaterialColor.WOOD, SoundType.WOOD);
    public static final HazelnutLeavesBlock HAZELNUT_LEAVES = new HazelnutLeavesBlock(MaterialColor.COLOR_GREEN, SoundType.GRASS);

    //Items
    //Food
    public static final Item ROASTED_HAZELNUT = new Item(new Item.Properties().tab(BETTER_TREES_TAB).food(new FoodProperties.Builder().nutrition(6).saturationMod(0.4F).alwaysEat().fast().build()));
    public static final Item HAZELNUT = new Item(new Item.Properties().tab(BETTER_TREES_TAB).food(new FoodProperties.Builder().nutrition(2).saturationMod(0.2F).effect(new MobEffectInstance(MobEffects.HUNGER, 200, 10),1f).alwaysEat().fast().build()));
    public static final Item PEELED_HAZELNUT = new Item(new Item.Properties().tab(BETTER_TREES_TAB).food(new FoodProperties.Builder().nutrition(4).saturationMod(0.2F).alwaysEat().fast().build()));
    public static final Item BLOCK_OF_HAZELNUT_item = new BlockItem(RegistryEvents.BLOCK_OF_HAZELNUT, new Item.Properties().tab(BETTER_TREES_TAB));
    public static final Item HAZELNUT_LOG_item = new BlockItem(RegistryEvents.HAZELNUT_LOG, new Item.Properties().tab(BETTER_TREES_TAB));
    public static final Item HAZELNUT_LEAVES_item = new LeavesItem(RegistryEvents.HAZELNUT_LEAVES, BETTER_TREES_TAB);


    //Tools
    public static final NutcrackerItem NUTCRACKER = new NutcrackerItem(new Item.Properties().tab(BETTER_TREES_TAB));

    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event){
        IForgeRegistry<Item> registry = event.getRegistry();
        register(HAZELNUT, registry, "hazelnut");
        register(PEELED_HAZELNUT, registry, "peeled_hazelnut");
        register(ROASTED_HAZELNUT, registry, "roasted_hazelnut");
        register(NUTCRACKER, registry, "nutcracker");
        register(BLOCK_OF_HAZELNUT_item, registry, BLOCK_OF_HAZELNUT.getRegistryName());
        register(HAZELNUT_LOG_item, registry, HAZELNUT_LOG.getRegistryName());
        register(HAZELNUT_LEAVES_item, registry, HAZELNUT_LEAVES.getRegistryName());
    }

    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> event){
        IForgeRegistry<Block> registry = event.getRegistry();
        register(BLOCK_OF_HAZELNUT, registry, "block_of_hazelnut");
        register(HAZELNUT_LOG, registry, "hazelnut_log");
        register(HAZELNUT_LEAVES, registry, "hazelnut_leaves");
    }

    public static void register(Item item, IForgeRegistry<Item> registry, String locationName) {
        item.setRegistryName(location(locationName));
        registry.register(item);
    }

    public static void register(Item item, IForgeRegistry<Item> registry, ResourceLocation location) {
        item.setRegistryName(location);
        registry.register(item);
    }

    public static void register(HazelnutLogBlock block, IForgeRegistry<Block> registry, String locationName) {
        block.setRegistryName(location(locationName));
        registry.register(block);
    }

    public static void register(ItemBlock block, IForgeRegistry<Block> registry, String locationName) {
        block.setRegistryName(location(locationName));
        registry.register(block);
    }

    public static void register(LeavesBlock block, IForgeRegistry<Block> registry, String locationName) {
        block.setRegistryName(location(locationName));
        registry.register(block);
    }

    public static ResourceLocation location(String name) {
        return new ResourceLocation(MOD_ID, name);
    }
}
