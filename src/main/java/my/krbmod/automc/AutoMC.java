package my.krbmod.automc;

import java.util.Map;

import my.krbmod.automc.aisystem.AISystem;
import my.krbmod.automc.eventhandler.ConfigurationHandler;
import my.krbmod.automc.eventhandler.MFEvent;
import my.krbmod.automc.eventhandler.MFEventHandler;
import my.krbmod.automc.eventhandler.MFEventHandlerBrewing;
import my.krbmod.automc.eventhandler.MFEventHandlerEntity;
import my.krbmod.automc.eventhandler.MFEventHandlerEntityItem;
import my.krbmod.automc.eventhandler.MFEventHandlerEntityLiving;
import my.krbmod.automc.eventhandler.MFEventHandlerEntityMinecart;
import my.krbmod.automc.eventhandler.MFEventHandlerEntityPlayer;
import my.krbmod.automc.eventhandler.MFEventHandlerOreGen;
import my.krbmod.automc.eventhandler.MFEventHandlerTerrainGen;
import my.krbmod.automc.eventhandler.MFEventHandlerWorld;
import my.krbmod.automc.proxy.ClientProxy;
import my.krbmod.automc.proxy.IProxy;
import my.krbmod.automc.proxy.ServerProxy;
import my.krbmod.automc.reference.Reference;
import my.krbmod.automc.utility.LogHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInterModComms;
import net.minecraftforge.fml.common.event.FMLMissingMappingsEvent;
import net.minecraftforge.fml.common.event.FMLModIdMappingEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerAboutToStartEvent;
import net.minecraftforge.fml.common.event.FMLServerStartedEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppedEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppingEvent;
import net.minecraftforge.fml.common.eventhandler.Event.HasResult;
import net.minecraftforge.fml.common.network.NetworkRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class AutoMC {

	@Instance(Reference.MOD_ID)
	public static AutoMC instance;

	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static ClientProxy proxy;

	//
	// Initialization Events
	//
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)

	{
		LogHelper.info("Pre Initialization Started");

		ConfigurationHandler.init(event.getSuggestedConfigurationFile());
		MinecraftForge.EVENT_BUS.register(new ConfigurationHandler());

		MinecraftForge.EVENT_BUS.register(new MFEventHandler());
		MinecraftForge.EVENT_BUS.register(new MFEventHandlerBrewing());
		MinecraftForge.EVENT_BUS.register(new MFEventHandlerEntity());
		MinecraftForge.EVENT_BUS.register(new MFEventHandlerEntityItem());
		MinecraftForge.EVENT_BUS.register(new MFEventHandlerEntityLiving());
		MinecraftForge.EVENT_BUS.register(new MFEventHandlerEntityMinecart());
		MinecraftForge.EVENT_BUS.register(new MFEventHandlerEntityPlayer());
		MinecraftForge.EVENT_BUS.register(new MFEventHandlerWorld());
		
		MinecraftForge.TERRAIN_GEN_BUS.register(new MFEventHandlerTerrainGen());
		MinecraftForge.ORE_GEN_BUS.register(new MFEventHandlerOreGen());
		
		//
		// Pre-Initialize the AI System
		//
		AISystem.preInit();

		LogHelper.info("Pre Initialization Complete");
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		//
		// Initialize the AI System
		//
		LogHelper.info("Initialization Started");
        proxy.registerKeybindings();
        NetworkRegistry.INSTANCE.registerGuiHandler(instance, proxy);

		AISystem.Init();

		LogHelper.info("Initialization Complete");

	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		LogHelper.info("Post Initialization Started");
		//
		// Post-Initialize the AI System
		//
		AISystem.postInit();

		LogHelper.info("Post Initialization Complete");

		// I know this doesn't belong here but it's a convenient way to kick off
		// the AI system during testing until I can actually get it to respond
		// to events.
		AISystem.runAI();

	}

	//
	// Server Events
	//

	@EventHandler
	public void interModComms(FMLInterModComms event) {
		LogHelper.info("Another MOD is Sending me a Message");
		//

		LogHelper.info("I am ignoring It");

	}

	@EventHandler
	public void missingMapEvent(FMLMissingMappingsEvent event) {
		LogHelper.info("One of my mappings failed");
	}

	@EventHandler
	public void modIdMappingEvent(FMLModIdMappingEvent event) {
		LogHelper.info("Mappings have changed");

	}

	@EventHandler
	public void serverAboutToStartEvent(FMLServerAboutToStartEvent event) {
		LogHelper.info("FMLServerAboutToStartEvent");

	}

	@EventHandler
	public void serverStartedEvent(FMLServerStartedEvent event) {
		LogHelper.info("FMLServerStartedEvent");

	}

	@EventHandler
	public void serverStoppingEvent(FMLServerStoppingEvent event) {
		LogHelper.info("FMLServerStoppingEvent");

	}

	@EventHandler
	public void serverStoppedEvent(FMLServerStoppedEvent event) {
		LogHelper.info("FMLServerStoppedEvent");
		MFEventHandler.logEventCounts();
		MFEventHandlerBrewing.logEventCounts();
		MFEventHandlerEntity.logEventCounts();
		MFEventHandlerEntityItem.logEventCounts();
		MFEventHandlerEntityLiving.logEventCounts();
		MFEventHandlerEntityMinecart.logEventCounts();
		MFEventHandlerEntityPlayer.logEventCounts();
		MFEventHandlerOreGen.logEventCounts();
		MFEventHandlerTerrainGen.logEventCounts();
		MFEventHandlerWorld.logEventCounts();
	}

	
}
