package my.krbmod.automc.aisystem.actions.terraformer;

import my.krbmod.automc.aisystem.aihelpers.ActionPriority;
import my.krbmod.automc.aisystem.aihelpers.Actions;
import my.krbmod.automc.aisystem.commandqueue.CommandQueue;
import my.krbmod.automc.utility.LogHelper;

//
// class to teraform areas for building, farming, etc.
//
public class TerraformManager {

	public static final Actions thisAction = Actions.TERRAFORMER;
	public static long lastChecked = 0;
	public static int defaultPriority = ActionPriority.PRIORITY_TERRAFORMER;
	public static int defaultTimer = ActionPriority.TIMER_TERRAFORMER;


	// TODO Setup remaining TerraformManager Fields
	private static int terraform = 0;

	public static void init(){
		//
		// TODO - For now we will assume everything can be done in Init; later we may need different Pre- and Post-Inits
		//

		// TODO Implement Terraform Manager
		LogHelper.info("Terraform Manager Initialization Started");
		
		registerCommands();
		lastChecked = 0; // this is the last time we checked the status; set to 0 so refreshStatus will always run the first time.
		
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
		if ((System.currentTimeMillis() - lastChecked) >= defaultTimer) {
			//TODO - Get/Refresh Status of Manager
			LogHelper.info("Terraform Manager Status Check");

			// the last thing we do is reset the timer
			lastChecked = System.currentTimeMillis();
		}
		// else we're not ready to check yet and we don't reset the timer
				
	}
	
}
