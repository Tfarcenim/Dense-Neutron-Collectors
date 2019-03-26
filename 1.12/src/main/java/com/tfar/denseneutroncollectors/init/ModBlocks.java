package com.tfar.denseneutroncollectors.init;

import com.tfar.denseneutroncollectors.DenseNeutronCollectors;
import com.tfar.denseneutroncollectors.block.BlockCompressedNeutronCollector;
import com.tfar.denseneutroncollectors.block.BlockDoubleCompressedNeutronCollector;
import com.tfar.denseneutroncollectors.block.BlockTripleCompressedNeutronCollector;
import com.tfar.denseneutroncollectors.tile.TileCompressedNeutronCollector;
import com.tfar.denseneutroncollectors.tile.TileDoubleCompressedNeutronCollector;
import com.tfar.denseneutroncollectors.tile.TileTripleCompressedNeutronCollector;
import morph.avaritia.api.registration.IModelRegister;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

import java.util.function.Consumer;
import static com.tfar.denseneutroncollectors.DenseNeutronCollectors.proxy;
public class ModBlocks {

    public static BlockCompressedNeutronCollector compressed_neutron_collector;
    public static BlockDoubleCompressedNeutronCollector double_compressed_neutron_collector;
    public static BlockTripleCompressedNeutronCollector triple_compressed_neutron_collector;

    public static void init() {
        compressed_neutron_collector = registerBlock(new BlockCompressedNeutronCollector());
        registerItemBlock(compressed_neutron_collector);
        GameRegistry.registerTileEntity(TileCompressedNeutronCollector.class, "compressed_neutron_collector");

        double_compressed_neutron_collector = registerBlock(new BlockDoubleCompressedNeutronCollector());
        registerItemBlock(double_compressed_neutron_collector);
        GameRegistry.registerTileEntity(TileDoubleCompressedNeutronCollector.class, "double_compressed_neutron_collector");

        triple_compressed_neutron_collector = registerBlock(new BlockTripleCompressedNeutronCollector());
        registerItemBlock(triple_compressed_neutron_collector);
        GameRegistry.registerTileEntity(TileTripleCompressedNeutronCollector.class, "triple_compressed_neutron_collector");
    }

    public static <V extends Block> V registerBlock(V block) {
        registerImpl(block, ForgeRegistries.BLOCKS::register);
        return block;
    }

    public static <V extends Item> V registerItem(V item) {
        registerImpl(item, ForgeRegistries.ITEMS::register);
        return item;
    }

    public static <V extends IForgeRegistryEntry<V>> V registerImpl(V registryObject, Consumer<V> registerCallback) {
        registerCallback.accept(registryObject);

        if (registryObject instanceof IModelRegister) {
            proxy.addModelRegister((IModelRegister) registryObject);
        }

        return registryObject;
    }

    public static ItemBlock registerItemBlock(Block block) {
        ItemBlock itemBlock = new ItemBlock(block);
        registerItem(itemBlock.setRegistryName(block.getRegistryName()));
        return itemBlock;
    }

    }
