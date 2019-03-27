package com.tfar.denseneutroncollectors.proxy;

import com.tfar.denseneutroncollectors.DenseNeutronCollectors;
import com.tfar.denseneutroncollectors.init.ModBlocks;
import morph.avaritia.api.registration.IModelRegister;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import com.tfar.denseneutroncollectors.client.gui.GUIHandler;

public class CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {ModBlocks.init();
    ModBlocks.init2();
        NetworkRegistry.INSTANCE.registerGuiHandler(DenseNeutronCollectors.instance, new GUIHandler());
    }
    public void init(FMLInitializationEvent event){
    }
    public void addModelRegister(IModelRegister register) {}
}
