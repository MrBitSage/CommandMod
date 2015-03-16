package com.mrbitsage.commandmod;
// Created by Jason on 3/14/2015.

import com.mrbitsage.commandmod.blocks.BlockCommandOre;
import com.mrbitsage.commandmod.blocks.CustomBlock;
import com.mrbitsage.commandmod.items.CustomItem;
import com.mrbitsage.commandmod.items.ItemCommandDust;
import com.mrbitsage.commandmod.items.ItemCommandGears;
import com.mrbitsage.commandmod.tools.ItemBlackDiamondPickaxe;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {

    // Material
    private static final ToolMaterial blackDiamondToolMaterial = EnumHelper.addToolMaterial("blackDiamondToolMaterial", 4, 2000, 10.0F, 4.0F, 16);
    // Blocks
    private static CustomBlock blockCommandOre;
    // Items
    private static CustomItem itemCommandDust;
    private static CustomItem itemCommandGears;

    // Tools
    private static ItemBlackDiamondPickaxe itemBlackDiamondPickaxe;

    // World Generator
    private static CommandOreGenerator generator;

    public static ToolMaterial getBlackDiamondToolMaterial() {
        return blackDiamondToolMaterial;
    }

    public static CustomBlock getBlockCommandOre() {
        return blockCommandOre;
    }

    public static CustomItem getItemCommandDust() {
        return itemCommandDust;
    }

    public static CustomItem getItemCommandGears() {
        return itemCommandGears;
    }

    public static ItemBlackDiamondPickaxe getItemBlackDiamondPickaxe() {
        return itemBlackDiamondPickaxe;
    }

    public static CommandOreGenerator getGenerator() {
        return generator;
    }

    public void preInit(FMLPreInitializationEvent event) {
        // Init Blocks
        blockCommandOre = new BlockCommandOre();

        // Init Items
        itemCommandDust = new ItemCommandDust();
        itemCommandGears = new ItemCommandGears();

        // Init Tools
        itemBlackDiamondPickaxe = new ItemBlackDiamondPickaxe(blackDiamondToolMaterial);

        // Init World Generators
        generator = new CommandOreGenerator();


        // Register Blocks
        Utilities.registerBlock(blockCommandOre);

        // Register Items
        Utilities.registerItem(itemCommandDust);
        Utilities.registerItem(itemCommandGears);

        // Register Tools
        GameRegistry.registerItem(itemBlackDiamondPickaxe, itemBlackDiamondPickaxe.getName());

        // Register Generators
        Utilities.registerGenerator(generator);
    }

    public void init(FMLInitializationEvent event) {
        // Add Block Recipes/Smelting
        GameRegistry.addRecipe(new ItemStack(Blocks.command_block, 1), "IGI", "GRG", "IGI", 'I', Items.iron_ingot, 'G', itemCommandGears, 'R', Items.redstone);

        // Add Item Recipes/Smelting
        GameRegistry.addSmelting(new ItemStack(itemCommandDust, 2), new ItemStack(itemCommandGears), 1.5F);

        // Add Tool Recipes
        GameRegistry.addRecipe(new ItemStack(itemBlackDiamondPickaxe, 1), "DOD", " P ", " S ", 'D', Items.diamond, 'O', Blocks.obsidian, 'P', Items.diamond_pickaxe, 'S', Items.stick);
    }

    public void postInit(FMLPostInitializationEvent event) {

    }
}
