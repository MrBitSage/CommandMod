package com.mrbitsage.commandmod.blocks;
// Created by Jason on 3/15/2015.

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class CustomBlock extends Block {
    protected CustomBlock(Material materialIn) {
        super(materialIn);
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
