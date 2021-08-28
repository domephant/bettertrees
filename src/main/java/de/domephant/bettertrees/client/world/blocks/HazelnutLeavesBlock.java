package de.domephant.bettertrees.client.world.blocks;

import de.domephant.bettertrees.client.events.BlockColorRegisterHandler;
import de.domephant.bettertrees.client.events.ItemColorRegisterHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class HazelnutLeavesBlock extends LeavesBlock {

    public HazelnutLeavesBlock(MaterialColor color, SoundType sound) {
        super(BlockBehaviour.Properties.of(Material.LEAVES).strength(0.2F).randomTicks().sound(sound).noOcclusion().isSuffocating(HazelnutLeavesBlock::never).isViewBlocking(HazelnutLeavesBlock::never));
        FMLJavaModLoadingContext.get().getModEventBus().register(new BlockColorRegisterHandler());
        FMLJavaModLoadingContext.get().getModEventBus().register(new ItemColorRegisterHandler());
    }

    private static boolean never(BlockState p_50806_, BlockGetter p_50807_, BlockPos p_50808_) {
        return false;
    }

}
