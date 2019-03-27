package com.tfar.denseneutroncollectors.client.gui;

import com.tfar.denseneutroncollectors.container.ContainerCompressedNeutronCollector;
import com.tfar.denseneutroncollectors.container.ContainerDoubleCompressedNeutronCollector;
import com.tfar.denseneutroncollectors.container.ContainerTripleCompressedNeutronCollector;
import com.tfar.denseneutroncollectors.tile.TileCompressedNeutronCollector;
import com.tfar.denseneutroncollectors.tile.TileDoubleCompressedNeutronCollector;
import com.tfar.denseneutroncollectors.tile.TileGoodNeutronCollector;
import com.tfar.denseneutroncollectors.tile.TileTripleCompressedNeutronCollector;
import morph.avaritia.container.ContainerNeutronCollector;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GUIHandler implements IGuiHandler {
        @Override
        public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

            BlockPos pos = new BlockPos(x, y, z);
            TileEntity tile = world.getTileEntity(pos);
            switch (ID) {
                case 0:
                    return new GUICompressedNeutronCollector(player.inventory, ((TileCompressedNeutronCollector) tile));
                case 1:
                    return new GUIDoubleCompressedNeutronCollector(player.inventory, ((TileDoubleCompressedNeutronCollector) tile));
                case 2:
                    return new GUITripleCompressedNeutronCollector(player.inventory, ((TileTripleCompressedNeutronCollector) tile));
                case 3:
                    return new GUIGoodNeutronCollector(player.inventory,((TileGoodNeutronCollector)tile));
                default:
                    return null;
            }
        }

        @Override
        public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

            BlockPos pos = new BlockPos(x, y, z);
            TileEntity tile = world.getTileEntity(pos);
            switch (ID) {
                case 0:
                    return new ContainerCompressedNeutronCollector(player.inventory, ((TileCompressedNeutronCollector) tile));
                case 1:
                    return new ContainerDoubleCompressedNeutronCollector(player.inventory, ((TileDoubleCompressedNeutronCollector) tile));
                case 2:
                    return new ContainerTripleCompressedNeutronCollector(player.inventory, ((TileTripleCompressedNeutronCollector) tile));
                case 3:
                    return new ContainerNeutronCollector(player.inventory,((TileGoodNeutronCollector)tile));
                default:
            return null;
        }
    }

}
