package com.tfar.denseneutroncollectors;

import morph.avaritia.tile.TileNeutronCollector;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

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
                try {

                    Field field = TileNeutronCollector.class.getDeclaredField("PRODUCTION_TICKS");
                    setValue(null,field,70);
                }catch (Exception e){
                    throw new RuntimeException(e);
                }
            }
        }
        protected static void makeModifiable(Field nameField) throws Exception {
            nameField.setAccessible(true);
            int modifiers = nameField.getModifiers();
            Field modifierField = nameField.getClass().getDeclaredField("modifiers");
            modifiers = modifiers & ~Modifier.FINAL;
            modifierField.setAccessible(true);
            modifierField.setInt(nameField, modifiers);
        }
        protected static void setValue(Object owner, Field field, Object value) throws Exception {
            makeModifiable(field);
            field.set(owner, value);
        }
    }
}