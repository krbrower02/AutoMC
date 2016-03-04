package my.krbmod.automc.init;


import my.krbmod.automc.AutoMC;
import my.krbmod.automc.init.items.ItemMapleLeaf;
import my.krbmod.automc.reference.Names;
import my.krbmod.automc.reference.Reference;
import my.krbmod.automc.utility.LogHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems {

	//public static final ModItem maple_leaf = new ItemMapleLeaf();
	
	public static void init() {
		
       // GameRegistry.registerItem(maple_leaf, Names.Items.MAPLE_LEAF);        

	}
		
	public static void registerRenders()
	{
		//ModelLoader.setCustomModelResourceLocation(maple_leaf, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + Names.Items.MAPLE_LEAF));
	}
	

}
