package com.mrbitsage.commandmod;
// Created by Jason on 3/15/2015.

import com.mrbitsage.commandmod.blocks.CustomBlock;
import com.mrbitsage.commandmod.items.CustomItem;
import net.minecraft.block.Block;
import net.minecraft.block.state.pattern.BlockHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Random;

public class Utilities {

    public static String prependModId(String input) {
        return Reference.MODID + ":" + input;
    }

    public static void registerBlock(CustomBlock block) {
        GameRegistry.registerBlock(block, block.getName());
    }

    public static void registerBlockRender(CustomBlock block) {
        Item item = GameRegistry.findItem(Reference.MODID, block.getName());

        ModelResourceLocation loc = new ModelResourceLocation(prependModId(block.getName()), "inventory");

        ItemModelMesher modelMesher = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();

        modelMesher.register(item, 0, loc);
    }

    public static void registerItem(CustomItem item) {
        GameRegistry.registerItem(item, item.getName());
    }

    public static void registerItemRender(CustomItem item) {
        ModelResourceLocation loc = new ModelResourceLocation(prependModId(item.getName()), "inventory");

        ItemModelMesher modelMesher = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();

        modelMesher.register(item, 0, loc);
    }

    public static void generateOre(Block block, World world, Random rand, int chunkX, int chunkZ, int minVeinSize, int maxVeinSize, int chance, int minY, int maxY, Block generateIn) {
        int veinSize, xPos, yPos, zPos;

        BlockPos pos;

        WorldGenMinable gen;

        for(int i = 0; i < chance; i++) {
            veinSize = minVeinSize + rand.nextInt(maxVeinSize - minVeinSize);

            xPos = chunkX*16 + rand.nextInt(16);
            yPos = minY + rand.nextInt(maxY - minY);
            zPos = chunkZ*16 + rand.nextInt(16);

            pos = new BlockPos(xPos, yPos, zPos);

            gen = new WorldGenMinable(block.getDefaultState(), veinSize, BlockHelper.forBlock(generateIn));
            gen.generate(world, rand, pos);
        }
    }

    public static void registerGenerator(IWorldGenerator generator) {
        GameRegistry.registerWorldGenerator(generator, 0);
    }
}
