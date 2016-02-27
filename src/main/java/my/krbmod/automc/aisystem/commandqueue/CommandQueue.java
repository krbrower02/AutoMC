package my.krbmod.automc.aisystem.commandqueue;

//TODO - confirm whether java.util.List or java.awt.List should be used here.
import java.util.List;

import my.krbmod.automc.aisystem.actions.combat.CombatManager;
import my.krbmod.automc.aisystem.actions.crafter.CraftingManager;
import my.krbmod.automc.aisystem.actions.exploration.ExplorationManager;
import my.krbmod.automc.aisystem.actions.farmer.FarmingManager;
import my.krbmod.automc.aisystem.actions.inventory.InventoryManager;
import my.krbmod.automc.aisystem.actions.lumberjack.LumberManager;
import my.krbmod.automc.aisystem.actions.miner.MiningManager;
import my.krbmod.automc.aisystem.actions.movement.MovementManager;
import my.krbmod.automc.aisystem.actions.terraformer.TerraformManager;
import my.krbmod.automc.aisystem.aihelpers.Actions;
import my.krbmod.automc.aisystem.aihelpers.CommandStatus;
import my.krbmod.automc.utility.LogHelper;

import java.util.LinkedList;
import java.util.ArrayList;

//
//All actions (other than inits) are managed through a priority queue.
//Each action manager puts in a request at a certain priority based on perceived need
//priority queue manager will authorize requests bases on priority levels
//individual action managers can only perform tasks if there are no competing priorities
//

public class CommandQueue {
	//
	// Maintain list of all potential commands.  Each Manager registers potential commands.
	// This allows us to better check to see if a command is valid
	//
	private static ArrayList<CommandItem> commandList = new ArrayList<CommandItem>();
	private static int nowServing = 0;
	
	//
	// Maintain list of all active commands.  AI system will add or remove commands as they are processed.
	//
	private static ArrayList<CommandQueueItem> commandQueue = new ArrayList<CommandQueueItem>();
	
	public static void preInit() {
		LogHelper.info("Command Queue Pre-Initialization Started");
			
		LogHelper.info("Command Queue Pre-Initialization Complete");
	}
	
	public static void init() {
		LogHelper.info("Command Queue Initialization Started");
		//
		// Start with category order then we will reorder and move above this line as we implement dependencies
		//
		CombatManager.init();
		CraftingManager.init();
		ExplorationManager.init();
		FarmingManager.init();
		InventoryManager.init();
		LumberManager.init();
		MiningManager.init();
		MovementManager.init();
		TerraformManager.init();
		
		LogHelper.info("Command Queue Initialization Complete");
	}
	
	public static void postInit() {
		LogHelper.info("Command Queue Post-Initialization Started");
			
		LogHelper.info("Command Queue Post-Initialization Complete");
	}
	
	public static void run(){
		//
		// For testing purposes we are just going to run refreshStatus() on all Managers
		//
		// TODO - build in logic for checking priorities and Authorize Task with Highest Priority
		//
		CombatManager.refreshStatus();
		CraftingManager.refreshStatus();
		ExplorationManager.refreshStatus();
		FarmingManager.refreshStatus();
		InventoryManager.refreshStatus();
		LumberManager.refreshStatus();
		MiningManager.refreshStatus();
		MovementManager.refreshStatus();
		TerraformManager.refreshStatus();
	}
	
	public void add(){
		// Add new request to Command Queue
		//TODO - 
	}
	
	public void remove(){
		// Add remove request from Command Queue
	}
	
	public CommandQueueItem nextItem() {
		CommandQueueItem p = null;
		
		return p;
	}
	
	public static CommandQueueItem nextItem(Actions a) {
		CommandQueueItem p = null;
		
		return p;
	}

	public static void removeCompleted(){
		for (CommandQueueItem o : commandQueue){
			if (o.status == CommandStatus.COMPLETED)
				commandQueue.remove(o);
		}
	}
	
	public static void registerCommand(Actions s, String c) {
		//TODO - See if command is already registered.  If not, add it.
		CommandItem cmd = new CommandItem(s, c);
		//LogHelper.info("Registering Command"+cmd.toString());
	}
	
	public static void unregisterCommand(CommandItem c) {
		//TODO - See if command is registered.  If so, remove it.
		
	}
	
}
