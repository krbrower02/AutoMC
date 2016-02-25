package my.krbmod.automc;

import my.krbmod.automc.aisystem.AISystem;
import my.krbmod.automc.handler.ConfigurationHandler;
import my.krbmod.automc.proxy.IProxy;
import my.krbmod.automc.reference.Reference;
import my.krbmod.automc.utility.LogHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS) 
public class AutoMC {

	   
	   @Instance(Reference.MOD_ID)
	   public static AutoMC instance;

	   @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, 
			   serverSide = Reference.SERVER_PROXY_CLASS)
	   public static IProxy proxy;
	   
	   @EventHandler
	   public void preInit(FMLPreInitializationEvent event)
	  
	    {
			LogHelper.info("Pre Initialization Started");
			
			ConfigurationHandler.init(event.getSuggestedConfigurationFile());
			//FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
			MinecraftForge.EVENT_BUS.register(new ConfigurationHandler());
			
			//
			// Pre-Initialize the AI System
			//
			AISystem.preInit();
			
			LogHelper.info("Pre Initialization Complete");
	    }
	   

	   @EventHandler
	   public void init(FMLInitializationEvent event)
	   {
			//
			// Initialize the AI System
			//
			LogHelper.info("Initialization Started");

			AISystem.Init();
			
			LogHelper.info("Initialization Complete");

	   }

	   @EventHandler
	   public void postInit(FMLPostInitializationEvent event)
	   {
			LogHelper.info("Post Initialization Started");
			//
			// Post-Initialize the AI System
			//
			AISystem.postInit();
			
			LogHelper.info("Post Initialization Complete");

	   }

	   
}
