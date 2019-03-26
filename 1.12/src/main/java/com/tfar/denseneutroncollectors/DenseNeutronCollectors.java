package com.tfar.denseneutroncollectors;

import com.tfar.denseneutroncollectors.proxy.CommonProxy;
import morph.avaritia.tile.TileNeutronCollector;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import static com.tfar.denseneutroncollectors.Configs.production_ticks;

@Mod(modid = DenseNeutronCollectors.MODID, name = DenseNeutronCollectors.NAME, version = DenseNeutronCollectors.VERSION)
public class DenseNeutronCollectors

{
    public static final String MODID = "denseneutroncollectors";
    public static final String NAME = "Dense Neutron Collectors";
    public static final String VERSION = "@VERSION@";


    @Mod.Instance (MODID)
    public static DenseNeutronCollectors instance;

    public static Logger logger;
    @SidedProxy(clientSide = "com.tfar.denseneutroncollectors.proxy.ClientProxy", serverSide = "com.tfar.denseneutroncollectors.proxy.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {

        //MinecraftForge.EVENT_BUS.register(new Configs.ConfigEventHandler());



        logger = event.getModLog();
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    }
}
