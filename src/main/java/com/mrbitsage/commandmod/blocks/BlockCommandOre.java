package com.mrbitsage.commandmod.blocks;
// Created by Jason on 3/14/2015.

import com.mrbitsage.commandmod.CommonProxy;
import com.mrbitsage.commandmod.Reference;
import com.mrbitsage.commandmod.Utilities;
import com.mrbitsage.commandmod.blocks.CustomBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import java.util.Random;

public class BlockCommandOre extends CustomBlock {

    public BlockCommandOre() {
        super(Material.rock);
        setName(Reference.BLOCK_COMMAND_ORE_NAME);
        setUnlocalizedName(Utilities.prependModId(getName()));
        setCreativeTab(CreativeTabs.tabBlock);
        setHardness(10.0f);
        setHarvestLevel("pickaxe", 4);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return CommonProxy.getItemCommandDust();
    }

    @Override
    public int quantityDropped(Random random) {
        return 1 + random.nextInt(4);
    }
}
