package my.krbmod.automc.handler;

import java.io.File;

import my.krbmod.automc.reference.Reference;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ConfigurationHandler {
	
	public static Configuration configuration;
	public static boolean testValue = false;
	
	public static void init(File configFile){
		//Create the configuration object from the given configuration file
		if (configuration == null) {
			configuration = new Configuration(configFile);
			loadConfiguration();
		}
		
	}

	@SubscribeEvent
	public void onConfiguratinChangeEvent(ConfigChangedEvent.OnConfigChangedEvent event){
		if (event.modID.equalsIgnoreCase(Reference.MOD_ID)){
			//resync configs
			loadConfiguration();
		}
	
	}
	
		
	private static void loadConfiguration() {
		testValue = configuration.getBoolean("configValue", Configuration.CATEGORY_GENERAL, true, "This is an example config value");
		
		if (configuration.hasChanged()){
			configuration.save();
		}

	}
	
}

