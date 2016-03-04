package my.krbmod.automc.init;

import my.krbmod.automc.reference.Names;
import my.krbmod.automc.reference.Textures;
import my.krbmod.automc.utility.LogHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModItem extends Item {

	   public ModItem()
	    {
	        super();	        
	    }

	    @Override
	    public String getUnlocalizedName()
	    {
	    	return String.format("item.%s%s", Textures.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	    }

	    @Override
	    public String getUnlocalizedName(ItemStack itemStack)
	    {

	    	return String.format("item.%s%s", Textures.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	    }

	    
	    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
	    {
	    	
	        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
	    }
	    
}
