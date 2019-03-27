package com.tfar.denseneutroncollectors;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = DenseNeutronCollectors.MODID)
public class Configs {
    @Config.Name("Neutron collection time")
    public static int production_ticks = 7111;

    @Mod.EventBusSubscriber
    public static class ConfigEventHandler {

        @SubscribeEvent
        public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
            if (event.getModID().equals(DenseNeutronCollectors.MODID)) {
                DenseNeutronCollectors.logger.info("Syncing Configs");
                ConfigManager.sync(DenseNeutronCollectors.MODID, Config.Type.INSTANCE);

                }
            }
        }
    }