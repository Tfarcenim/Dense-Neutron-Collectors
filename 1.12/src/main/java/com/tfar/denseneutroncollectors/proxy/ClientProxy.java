package com.tfar.denseneutroncollectors.proxy;

import morph.avaritia.api.registration.IModelRegister;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.util.HashSet;
import java.util.Set;

public class ClientProxy extends CommonProxy {

    private Set<IModelRegister> modelRegisters = new HashSet<>();
    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
        for (IModelRegister register : modelRegisters) {
            register.registerModels();
        }
    }

    @Override
    public void addModelRegister(IModelRegister register) {
        modelRegisters.add(register);
    }

}
