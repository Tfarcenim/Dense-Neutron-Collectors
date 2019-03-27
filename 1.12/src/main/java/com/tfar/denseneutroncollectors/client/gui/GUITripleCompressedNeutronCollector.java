package com.tfar.denseneutroncollectors.client.gui;

import codechicken.lib.math.MathHelper;
import com.tfar.denseneutroncollectors.container.ContainerTripleCompressedNeutronCollector;
import com.tfar.denseneutroncollectors.tile.TileTripleCompressedNeutronCollector;
import morph.avaritia.client.gui.GuiMachineBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;

import static com.tfar.denseneutroncollectors.client.gui.GUICompressedNeutronCollector.GUI_TEX;

public class GUITripleCompressedNeutronCollector extends GuiMachineBase<TileTripleCompressedNeutronCollector, ContainerTripleCompressedNeutronCollector> {

    public GUITripleCompressedNeutronCollector(InventoryPlayer player, TileTripleCompressedNeutronCollector machine) {
        super(new ContainerTripleCompressedNeutronCollector(player, machine));
        setBackgroundTexture(GUI_TEX);
    }

    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {

        String s = I18n.format("container.triple_compressed_neutron_collector");
        float scaled_progress = scaleF(machineTile.getProgress(), TileTripleCompressedNeutronCollector.ticks, 100);
        String progress = "Progress: " + MathHelper.round(scaled_progress, 10) + "%";

        fontRenderer.drawString(s, xSize / 2 - fontRenderer.getStringWidth(s) / 2, 6, 0x404040);
        fontRenderer.drawString(progress, xSize / 2 - fontRenderer.getStringWidth(progress) / 2, 60, 0x404040);
        fontRenderer.drawString(I18n.format("container.inventory"), 8, ySize - 96 + 2, 0x404040);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        drawBackground();
        super.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);
    }
}
