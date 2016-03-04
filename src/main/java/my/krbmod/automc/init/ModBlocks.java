package my.krbmod.automc.init;

import my.krbmod.automc.AutoMC;
import my.krbmod.automc.init.blocks.BlockFlag;
import my.krbmod.automc.reference.Names;
import my.krbmod.automc.reference.Reference;
import my.krbmod.automc.utility.LogHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks {

	//public static final ModBlock flag = new BlockFlag();
	
	//BlockFlag abc;
	
	public static void init()
	{
		
		//GameRegistry.registerBlock(flag, Names.Blocks.FLAG);
		
	}
		
	public static void registerRenders()
	{
		//ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(flag), 0, new ModelResourceLocation(Reference.MOD_ID + ":" + Names.Blocks.FLAG));
		
	}
	

}
