package my.krbmod.automc.init;

import my.krbmod.automc.AutoMC;
import my.krbmod.automc.init.blocks.BlockFlag;
import my.krbmod.automc.reference.Names;
import my.krbmod.automc.reference.Reference;
import my.krbmod.automc.utility.LogHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks {

	public static final ModBlock flag = new BlockFlag();
	
	private static ModBlock getRegisteredItem(String name) {
		return (ModBlock) Block.blockRegistry.getObject(new ResourceLocation(name));
	}

	public static void init()
	{
		
		LogHelper.info("Registration of Blocks should be in Pre Initialization");

		GameRegistry.registerBlock(flag, Names.Blocks.FLAG);
	
	}
		
	public static void registerRenders()
	{
		RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
		
    	renderItem.getItemModelMesher().register(Item.getItemFromBlock(flag), 0, new ModelResourceLocation(Reference.MOD_ID + ":" + ModBlocks.flag.getName(), "inventory"));

	}
	

}
