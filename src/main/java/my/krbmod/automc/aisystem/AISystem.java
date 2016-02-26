package my.krbmod.automc.aisystem;

import my.krbmod.automc.aisystem.actions.combat.CombatManager;
import my.krbmod.automc.aisystem.actions.crafter.CraftingManager;
import my.krbmod.automc.aisystem.actions.crafter.RecipeManager;
import my.krbmod.automc.aisystem.actions.exploration.ExplorationManager;
import my.krbmod.automc.aisystem.actions.farmer.FarmingManager;
import my.krbmod.automc.aisystem.actions.inventory.InventoryManager;
import my.krbmod.automc.aisystem.actions.lumberjack.LumberManager;
import my.krbmod.automc.aisystem.actions.miner.MiningManager;
import my.krbmod.automc.aisystem.actions.movement.AvoidanceManager;
import my.krbmod.automc.aisystem.actions.movement.MovementManager;
import my.krbmod.automc.aisystem.actions.movement.TrackingManager;
import my.krbmod.automc.aisystem.actions.movement.waypoints.WaypointManager;
import my.krbmod.automc.aisystem.actions.terraformer.TerraformManager;
import my.krbmod.automc.aisystem.commandqueue.CommandQueue;
import my.krbmod.automc.aisystem.goals.GoalManager;
import my.krbmod.automc.aisystem.status.PlayerStatusMonitor;
import my.krbmod.automc.utility.LogHelper;

public class AISystem {

	public static String aiSystemState = AIReference.AI_STATE_IDLE;

	public static void preInit(){
		LogHelper.info("AI Pre-Initialization Started");

		aiSystemState = AIReference.AI_STATE_PREINIT;
		//
		// TODO determine which managers kick off in preInit.
		//
		PlayerStatusMonitor.preInit();
		CommandQueue.preInit();
		
		aiSystemState = AIReference.AI_STATE_IDLE;
		
		LogHelper.info("AI Pre-Initialization Complete");
	}
	
	public static void Init(){
		LogHelper.info("AI Initialization Started");
		
		aiSystemState = AIReference.AI_STATE_INIT;
		//
		// TODO determine which managers kick off in Init.
		//
		// For now we will assume they all activate in Init.
		//
		PlayerStatusMonitor.init();
		CommandQueue.init();
		GoalManager.init();
		
		aiSystemState = AIReference.AI_STATE_IDLE;
		
		LogHelper.info("AI Initialization Complete");
	}
	
	public static void postInit(){
		LogHelper.info("AI Post-Initialization Started");

		aiSystemState = AIReference.AI_STATE_POSTINIT;
		// 
		// TODO determine which managers kick off in postInit.
		//
		PlayerStatusMonitor.postInit();
		CommandQueue.postInit();
		
		aiSystemState = AIReference.AI_STATE_IDLE;
		LogHelper.info("AI Post-Initialization Complete");
	}
	
	public static void runAI(){
		LogHelper.info("AI Run Started");

		aiSystemState = AIReference.AI_STATE_ACTIVE;
		long startTime = System.currentTimeMillis();
		long lastTime = System.currentTimeMillis();
				
		while (System.currentTimeMillis()- startTime < 20000) {
			CommandQueue.run();
			try {
			    Thread.sleep(233);	// I want to pause for roughly 1/4 second; I use a prime number to reduce patterns (yes I could have used a random number but didn't want to
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
		}
		
		aiSystemState = AIReference.AI_STATE_IDLE;
		LogHelper.info("AI Run Completed");
	}

	
	public String getState(){
		return aiSystemState;
	}
}
