package com.mrbitsage.commandmod.tools;
// Created by Jason on 3/15/2015.

import com.mrbitsage.commandmod.Reference;
import com.mrbitsage.commandmod.Utilities;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemPickaxe;

public class ItemBlackDiamondPickaxe extends ItemPickaxe {

    private String name;

    public ItemBlackDiamondPickaxe(ToolMaterial material) {
        super(material);
        setName(Reference.ITEM_BLACK_DIAMOND_PICKAXE_NAME);
        setUnlocalizedName(Utilities.prependModId(getName()));
        setCreativeTab(CreativeTabs.tabTools);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
