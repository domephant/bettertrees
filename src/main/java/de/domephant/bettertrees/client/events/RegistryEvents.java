package de.domephant.bettertrees.client.events;

import de.domephant.bettertrees.Main;

import de.domephant.bettertrees.client.entity.model.SquirrelEntityModel;
import de.domephant.bettertrees.client.entity.render.SquirrelEntityRenderer;
import de.domephant.bettertrees.client.entity.render.WhaleEntityRenderer;
import de.domephant.bettertrees.client.entity.model.WhaleEntityModel;
import de.domephant.bettertrees.client.modellayers.CustomModelLayers;
import de.domephant.bettertrees.client.world.blocks.HazelnutLeavesBlock;
import de.domephant.bettertrees.client.world.blocks.HazelnutLogBlock;
import de.domephant.bettertrees.client.world.blocks.ItemBlock;
import de.domephant.bettertrees.client.tabs.BetterTreesTab;
import de.domephant.bettertrees.client.world.item.LeavesItem;
import de.domephant.bettertrees.client.world.item.NutcrackerItem;
import de.domephant.bettertrees.common.entity.SquirrelEntity;
import de.domephant.bettertrees.common.entity.WhaleEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.logging.log4j.Logger;
import net.minecraft.world.level.block.LeavesBlock;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class RegistryEvents {
    //#region Requirements
    public static final Logger LOGGER = Main.LOGGER;
    public static final String MOD_ID = Main.MOD_ID;
    //#endregion

    //#region CreativeModeTab
    public static final CreativeModeTab BETTER_TREES_TAB = new BetterTreesTab("betterTreesTab");
    //#endregion

    //#region Blocks
    public static final ItemBlock BLOCK_OF_HAZELNUT = new ItemBlock(MaterialColor.STONE, SoundType.WART_BLOCK);
    public static final HazelnutLogBlock HAZELNUT_LOG = new HazelnutLogBlock(MaterialColor.WOOD, SoundType.WOOD);
    public static final HazelnutLeavesBlock HAZELNUT_LEAVES = new HazelnutLeavesBlock(MaterialColor.COLOR_GREEN, SoundType.GRASS);
    //#endregion

    //#region Items
    //Food
    public static final Item ROASTED_HAZELNUT = new Item(new Item.Properties().tab(BETTER_TREES_TAB).food(new FoodProperties.Builder().nutrition(6).saturationMod(0.4F).alwaysEat().fast().build()));
    public static final Item HAZELNUT = new Item(new Item.Properties().tab(BETTER_TREES_TAB).food(new FoodProperties.Builder().nutrition(2).saturationMod(0.2F).effect(new MobEffectInstance(MobEffects.HUNGER, 200, 10),1f).alwaysEat().fast().build()));
    public static final Item PEELED_HAZELNUT = new Item(new Item.Properties().tab(BETTER_TREES_TAB).food(new FoodProperties.Builder().nutrition(4).saturationMod(0.2F).alwaysEat().fast().build()));
    public static final Item BLOCK_OF_HAZELNUT_item = new BlockItem(RegistryEvents.BLOCK_OF_HAZELNUT, new Item.Properties().tab(BETTER_TREES_TAB));
    public static final Item HAZELNUT_LOG_item = new BlockItem(RegistryEvents.HAZELNUT_LOG, new Item.Properties().tab(BETTER_TREES_TAB));
    public static final Item HAZELNUT_LEAVES_item = new LeavesItem(RegistryEvents.HAZELNUT_LEAVES, BETTER_TREES_TAB);

    //Tools
    public static final NutcrackerItem NUTCRACKER = new NutcrackerItem(new Item.Properties().tab(BETTER_TREES_TAB));
    //#endregion

    //#region Entities
    public static final EntityType<WhaleEntity> WHALEENTITY = EntityType.Builder.of(WhaleEntity::new, MobCategory.WATER_CREATURE).sized(0.6F, 1.95F).build("bettertrees.whale");
    public static final EntityType<SquirrelEntity> SQUIRRELENTITY = EntityType.Builder.of(SquirrelEntity::new, MobCategory.CREATURE).sized(0.6F, 1.95F).build("bettertrees.squirrel");
    //endregion

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

    @SubscribeEvent
    public static void registerEntity(RegistryEvent.Register<EntityType<?>> event) {
        event.getRegistry().register(WHALEENTITY.setRegistryName("whale"));
        event.getRegistry().register(SQUIRRELENTITY.setRegistryName("squirrel"));
    }

    @SubscribeEvent
    public static void registerEntityAttribute(EntityAttributeCreationEvent event) {
        event.put(WHALEENTITY, WhaleEntity.createAttributes().build());
        event.put(SQUIRRELENTITY, SquirrelEntity.createAttributes().build());
    }

    @SubscribeEvent
    public static void registerEntityRenders(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(RegistryEvents.WHALEENTITY, WhaleEntityRenderer::new);
        event.registerEntityRenderer(RegistryEvents.SQUIRRELENTITY, SquirrelEntityRenderer::new);
    }
    @SubscribeEvent
    public static void registerLayerDefinition(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(CustomModelLayers.WHALEENTITY, WhaleEntityModel::createBodyLayer);
        event.registerLayerDefinition(CustomModelLayers.SQUIRRELENTITY, SquirrelEntityModel::createBodyLayer);
    }


    private static void register(Item item, IForgeRegistry<Item> registry, String locationName) {
        item.setRegistryName(location(locationName));
        registry.register(item);
    }

    private static void register(Item item, IForgeRegistry<Item> registry, ResourceLocation location) {
        item.setRegistryName(location);
        registry.register(item);
    }

    private static void register(HazelnutLogBlock block, IForgeRegistry<Block> registry, String locationName) {
        block.setRegistryName(location(locationName));
        registry.register(block);
    }

    private static void register(ItemBlock block, IForgeRegistry<Block> registry, String locationName) {
        block.setRegistryName(location(locationName));
        registry.register(block);
    }

    private static void register(LeavesBlock block, IForgeRegistry<Block> registry, String locationName) {
        block.setRegistryName(location(locationName));
        registry.register(block);
    }

    public static ResourceLocation location(String name) {
        return new ResourceLocation(MOD_ID, name);
    }
}
