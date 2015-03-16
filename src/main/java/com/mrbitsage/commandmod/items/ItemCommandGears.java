package com.mrbitsage.commandmod.items;
// Created by Jason on 3/15/2015.

import com.mrbitsage.commandmod.Reference;
import com.mrbitsage.commandmod.Utilities;
import net.minecraft.creativetab.CreativeTabs;

public class ItemCommandGears extends CustomItem {

    public ItemCommandGears() {
        setName(Reference.ITEM_COMMAND_GEARS_NAME);
        setUnlocalizedName(Utilities.prependModId(getName()));
        setCreativeTab(CreativeTabs.tabRedstone);
    }
}
