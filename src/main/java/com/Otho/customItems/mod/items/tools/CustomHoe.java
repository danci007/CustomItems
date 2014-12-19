package com.Otho.customItems.mod.items.tools;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemHoe;

import com.Otho.customItems.ModReference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CustomHoe extends ItemHoe {
    public CustomHoe(ToolMaterial mat) {
        super(mat);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister iconRegister) {
    	if(this.iconString == null)
    	{
    		itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".")+1));
    	}else
    	{
    		itemIcon = iconRegister.registerIcon(ModReference.MOD_ID.toLowerCase() + ":" + this.iconString);
    	}
    }
}
