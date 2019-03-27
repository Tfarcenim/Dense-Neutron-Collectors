package com.tfar.denseneutroncollectors;

import com.tfar.denseneutroncollectors.proxy.CommonProxy;
import com.tfar.denseneutroncollectors.tile.TileGoodNeutronCollector;
import morph.avaritia.Avaritia;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.ReflectionHelper;
import net.minecraftforge.registries.IForgeRegistryEntry;
import org.apache.logging.log4j.Logger;

@Mod(modid = DenseNeutronCollectors.MODID, name = DenseNeutronCollectors.NAME, version = DenseNeutronCollectors.VERSION, dependencies = "after:avaritia")
public class DenseNeutronCollectors {
    public static final String MODID = "denseneutroncollectors";
    public static final String NAME = "Dense Neutron Collectors";
    public static final String VERSION = "@VERSION@";
    @Mod.Instance(MODID)
    public static DenseNeutronCollectors instance;

    public static Logger logger;
    @SidedProxy(clientSide = "com.tfar.denseneutroncollectors.proxy.ClientProxy", serverSide = "com.tfar.denseneutroncollectors.proxy.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        GameRegistry.registerTileEntity(TileGoodNeutronCollector.class, new ResourceLocation(Avaritia.MOD_ID, "neutron_collector"));
        logger = event.getModLog();
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    public static void overrideRegistryLocation(IForgeRegistryEntry.Impl forgeRegistryEntry, String name) {
        try {
            ReflectionHelper.findField(IForgeRegistryEntry.Impl.class, "registryName").set(forgeRegistryEntry, new ResourceLocation(Avaritia.MOD_ID, name));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

