package com.mrbitsage.commandmod.items;
// Created by Jason on 3/14/2015.

import com.mrbitsage.commandmod.Reference;
import com.mrbitsage.commandmod.Utilities;
import net.minecraft.creativetab.CreativeTabs;

public class ItemCommandDust extends CustomItem {

    public ItemCommandDust() {
        setName(Reference.ITEM_COMMAND_DUST_NAME);
        setUnlocalizedName(Utilities.prependModId(getName()));
        setCreativeTab(CreativeTabs.tabRedstone);
    }
}
