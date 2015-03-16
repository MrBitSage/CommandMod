package com.mrbitsage.commandmod;
// Created by Jason on 3/14/2015.

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
    }

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);

        // Register Block Renders
        Utilities.registerBlockRender(CommonProxy.getBlockCommandOre());

        // Register Item Renders
        Utilities.registerItemRender(CommonProxy.getItemCommandDust());
        Utilities.registerItemRender(CommonProxy.getItemCommandGears());

        // Register Tool Renders
        ModelResourceLocation loc = new ModelResourceLocation(Utilities.prependModId(getItemBlackDiamondPickaxe().getName()), "inventory");
        ItemModelMesher modelMesher = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
        modelMesher.register(getItemBlackDiamondPickaxe(), 0, loc);
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
    }
}
