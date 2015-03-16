package com.mrbitsage.commandmod;
// Created by Jason on 3/15/2015.

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class CommandOreGenerator implements IWorldGenerator{

    private final int MIN_VEIN_SIZE = 1;
    private final int MAX_VEIN_SIZE = 3;
    private final int MIN_Y = 0;
    private final int MAX_Y = 20;
    private final int CHANCE = 20;

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        switch(world.provider.getDimensionId()) {
            case -1:
                break;
            case 0:
                generateSurface(world, random, chunkX, chunkZ);
                break;
            case 1:
                break;
        }
    }

    public void generateSurface(World world, Random rand, int chunkX, int chunkZ) {
        Utilities.generateOre(CommonProxy.getBlockCommandOre(), world, rand, chunkX, chunkZ, MIN_VEIN_SIZE, MAX_VEIN_SIZE, CHANCE, MIN_Y, MAX_Y, Blocks.stone);
    }
}
