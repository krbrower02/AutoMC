package my.krbmod.automc.aisystem.actions.inventory.support;

import my.krbmod.automc.aisystem.actions.inventory.InventoryManager;
import my.krbmod.automc.aisystem.aihelpers.MaterialLevel;

public class InventoryGoals {
	
	//
	// build default list of InventoryGoals when constructed
	//
	public static void addInventoryGoals() {
			//
			// using mlevel variable allows items to be easily moved up or down a level to balance AI
			//
			MaterialLevel mlevel = MaterialLevel.DEFAULT;
			
			InventoryManager.addGoal(mlevel, "None", 0, 0);
			mlevel = MaterialLevel.BAREHAND;
			InventoryManager.addGoal(mlevel, "Wood Block", 4, 0);
			InventoryManager.addGoal(mlevel, "Dirt", 5, 0);
			mlevel = MaterialLevel.WOOD;
			InventoryManager.addGoal(mlevel, "Wood Block", 10, 0);
			InventoryManager.addGoal(mlevel, "Wood Plank", 10, 0);
			InventoryManager.addGoal(mlevel, "Stick", 10, 0);
			InventoryManager.addGoal(mlevel, "Wood Axe", 1, 0);
			InventoryManager.addGoal(mlevel, "Wood Pick", 1, 0);
			mlevel = MaterialLevel.STONE;
			InventoryManager.addGoal(mlevel, "Wood Block", 20, 0);
			InventoryManager.addGoal(mlevel, "Wood Plank", 20, 0);
			InventoryManager.addGoal(mlevel, "Stick", 20, 0);
			InventoryManager.addGoal(mlevel, "Cobble Stone", 20, 0);
			InventoryManager.addGoal(mlevel, "Coal", 10, 0);
			InventoryManager.addGoal(mlevel, "Torch", 10, 0);
			InventoryManager.addGoal(mlevel, "Stone Axe", 2, 0);
			InventoryManager.addGoal(mlevel, "Stone Pick", 2, 0);
			InventoryManager.addGoal(mlevel, "Stone Shovel", 2, 0);
			InventoryManager.addGoal(mlevel, "Stone Hoe", 2, 0);
			mlevel = MaterialLevel.IRON;
			InventoryManager.addGoal(mlevel, "Wood Block", 40, 0);
			InventoryManager.addGoal(mlevel, "Wood Plank", 40, 0);
			InventoryManager.addGoal(mlevel, "Stick", 40, 0);
			InventoryManager.addGoal(mlevel, "Cobble Stone", 10, 0);
			InventoryManager.addGoal(mlevel, "Coal", 40, 0);
			InventoryManager.addGoal(mlevel, "Torch", 40, 0);
			InventoryManager.addGoal(mlevel, "Iron Ore", 20, 0);
			InventoryManager.addGoal(mlevel, "Iron", 20, 0);
			InventoryManager.addGoal(mlevel, "Iron Axe", 2, 0);
			InventoryManager.addGoal(mlevel, "Iron Pick", 2, 0);
			InventoryManager.addGoal(mlevel, "Iron Shovel", 2, 0);
			InventoryManager.addGoal(mlevel, "Stone Hoe", 2, 0);
			InventoryManager.addGoal(mlevel, "Iron Helmet", 1, 0);
			InventoryManager.addGoal(mlevel, "Iron Chestplate", 1, 0);
			InventoryManager.addGoal(mlevel, "Iron Leggings", 1, 0);
			InventoryManager.addGoal(mlevel, "Iron Boots", 1, 0);
			mlevel = MaterialLevel.DIAMOND;
			InventoryManager.addGoal(mlevel, "Wood Block", 64, 0);
			InventoryManager.addGoal(mlevel, "Wood Plank", 64, 0);
			InventoryManager.addGoal(mlevel, "Stick", 40, 0);
			InventoryManager.addGoal(mlevel, "Cobble Stone", 64, 0);
			InventoryManager.addGoal(mlevel, "Coal", 64, 0);
			InventoryManager.addGoal(mlevel, "Torch", 64, 0);
			InventoryManager.addGoal(mlevel, "Iron Ore", 40, 0);
			InventoryManager.addGoal(mlevel, "Iron", 40, 0);
			InventoryManager.addGoal(mlevel, "Diamond", 20, 0);
			InventoryManager.addGoal(mlevel, "Diamond Axe", 1, 0);
			InventoryManager.addGoal(mlevel, "Diamond Pick", 1, 0);
			InventoryManager.addGoal(mlevel, "Diamond Shovel", 1, 0);
			InventoryManager.addGoal(mlevel, "Stone Hoe", 2, 0);
			InventoryManager.addGoal(mlevel, "Diamond Helmet", 1, 0);
			InventoryManager.addGoal(mlevel, "Diamond Chestplate", 1, 0);
			InventoryManager.addGoal(mlevel, "Diamond Leggings", 1, 0);
			InventoryManager.addGoal(mlevel, "Diamond Boots", 1, 0);
	};
	
}
