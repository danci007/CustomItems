package com.Otho.customItems.mod.items.food;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import com.Otho.customItems.ModReference;
import com.Otho.customItems.configuration.jsonReaders.common.Cfg_PotionEffect;
import com.Otho.customItems.util.Util;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CustomFood extends ItemFood{
	
	private Cfg_PotionEffect[] effectsArray;
	
	public CustomFood (int healAmount, float saturationModifier, boolean isWolfsFavoriteMeat){
		super(healAmount, saturationModifier, isWolfsFavoriteMeat);   
	}
	
	@Override
    public String getUnlocalizedName() {
        return super.getUnlocalizedName();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
    	if(this.iconString == null)
    	{
    		itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".")+1));
    	}else
    	{
    		itemIcon = iconRegister.registerIcon(ModReference.MOD_ID.toLowerCase() + ":" + this.iconString);
    	}
    }
    
    @Override
    protected void onFoodEaten(ItemStack p_77849_1_, World p_77849_2_, EntityPlayer p_77849_3_)
    {
        if (!p_77849_2_.isRemote)
        {        	
        	if(effectsArray != null)
        	{
	        	for(int i = 0; i < effectsArray.length; i++){
	        		Cfg_PotionEffect effect = effectsArray[i];
	        		if(p_77849_2_.rand.nextFloat() < effect.potionEffectProbability){
	        			p_77849_3_.addPotionEffect(new PotionEffect(Util.potionEffectId(effect.effect), effect.potionDuration * 20, effect.potionAmplifier));
	        		}
	        	}
        	}
        }
    }
    
    public void setFoodEffectsArray(Cfg_PotionEffect[] effectsArray){
    	this.effectsArray = effectsArray;
    }

}
