package my.krbmod.automc.aisystem.actions.terraformer;

import my.krbmod.automc.aisystem.aihelpers.Actions;
import my.krbmod.automc.aisystem.commandqueue.CommandQueue;
import my.krbmod.automc.utility.LogHelper;

//
// class to teraform areas for building, farming, etc.
//
public class TerraformManager {

	public static final Actions thisAction = Actions.TERRAFORMER;

	// TODO Setup TerraformManager Fields
	private static int terraform = 0;

	public static void init(){
		//
		// TODO - For now we will assume only one init will be needed later we may need different Pre- and Post-Inits
		//

		// TODO Implement TerraformManager
		LogHelper.info("Terraform Manager Initialization Started");
		registerCommands();
		LogHelper.info("Terraform Manager Initialization Complete");

	}
	

	public static void registerCommands() {
		CommandQueue.registerCommand(thisAction, "Refresh Status");
		CommandQueue.registerCommand(thisAction, "Flatten");
		CommandQueue.registerCommand(thisAction, "Fill");
		CommandQueue.registerCommand(thisAction, "Raise");
		CommandQueue.registerCommand(thisAction, "Nerd Pole");
	}

	public static void refreshStatus() {
		//TODO - Get/Refresh Status of Manager
		
	}
	
}
