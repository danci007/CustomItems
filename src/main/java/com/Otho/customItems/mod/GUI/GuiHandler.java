package com.Otho.customItems.mod.GUI;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.Otho.customItems.mod.containers.CustomChestContainer;
import com.Otho.customItems.mod.tileentitys.TileEntityCustomChest;

import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {
        //returns an instance of the Container you made earlier
        @Override
        public Object getServerGuiElement(int id, EntityPlayer player, World world,
                        int x, int y, int z) {
                TileEntity tileEntity = world.getTileEntity(x, y, z);
                if(tileEntity instanceof TileEntityCustomChest){
                        return new CustomChestContainer(player.inventory, (TileEntityCustomChest) tileEntity);
                }
                return null;
        }

        //returns an instance of the Gui you made earlier
        @Override
        public Object getClientGuiElement(int id, EntityPlayer player, World world,
                        int x, int y, int z) {
                TileEntity tileEntity = world.getTileEntity(x, y, z);
                if(tileEntity instanceof TileEntityCustomChest){
                        return new CustomChestGui(player.inventory, (TileEntityCustomChest) tileEntity);
                }
                return null;

        }
}