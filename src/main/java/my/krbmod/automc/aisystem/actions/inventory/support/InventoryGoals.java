package my.krbmod.automc.aisystem.actions.inventory.support;

import java.util.ArrayList;

import my.krbmod.automc.aisystem.actions.inventory.InventoryGoal;
import my.krbmod.automc.aisystem.aihelpers.MaterialLevel;

public class InventoryGoals {
	
	public ArrayList<InventoryGoal> inventoryGoalList = new ArrayList<InventoryGoal>();
	
	//
	// build default list of InventoryGoals when constructed
	//
	public InventoryGoals() {
			//
			// using mlevel variable allows items to be easily moved up or down a level to balance AI
			//
			MaterialLevel mlevel = MaterialLevel.DEFAULT;
			inventoryGoalList.add(new InventoryGoal(mlevel, "None", 0, 0));
			mlevel = MaterialLevel.BAREHAND;
			inventoryGoalList.add(new InventoryGoal(mlevel, "Wood Block", 4, 0));
			inventoryGoalList.add(new InventoryGoal(mlevel, "Dirt", 5, 0));
			mlevel = MaterialLevel.WOOD;
			inventoryGoalList.add(new InventoryGoal(mlevel, "Wood Block", 10, 0));
			inventoryGoalList.add(new InventoryGoal(mlevel, "Wood Plank", 10, 0));
			inventoryGoalList.add(new InventoryGoal(mlevel, "Stick", 10, 0));
			inventoryGoalList.add(new InventoryGoal(mlevel, "Wood Axe", 1, 0));
			inventoryGoalList.add(new InventoryGoal(mlevel, "Wood Pick", 1, 0));
			mlevel = MaterialLevel.STONE;
			inventoryGoalList.add(new InventoryGoal(mlevel, "Wood Block", 20, 0));
			inventoryGoalList.add(new InventoryGoal(mlevel, "Wood Plank", 20, 0));
			inventoryGoalList.add(new InventoryGoal(mlevel, "Stick", 20, 0));
			inventoryGoalList.add(new InventoryGoal(mlevel, "Cobble Stone", 20, 0));
			inventoryGoalList.add(new InventoryGoal(mlevel, "Coal", 10, 0));
			inventoryGoalList.add(new InventoryGoal(mlevel, "Torch", 10, 0));
			inventoryGoalList.add(new InventoryGoal(mlevel, "Stone Axe", 2, 0));
			inventoryGoalList.add(new InventoryGoal(mlevel, "Stone Pick", 2, 0));
			inventoryGoalList.add(new InventoryGoal(mlevel, "Stone Shovel", 2, 0));
			inventoryGoalList.add(new InventoryGoal(mlevel, "Stone Hoe", 2, 0));
			mlevel = MaterialLevel.IRON;
			inventoryGoalList.add(new InventoryGoal(mlevel, "Wood Block", 40, 0));
			inventoryGoalList.add(new InventoryGoal(mlevel, "Wood Plank", 40, 0));
			inventoryGoalList.add(new InventoryGoal(mlevel, "Stick", 40, 0));
			inventoryGoalList.add(new InventoryGoal(mlevel, "Cobble Stone", 10, 0));
			inventoryGoalList.add(new InventoryGoal(mlevel, "Coal", 40, 0));
			inventoryGoalList.add(new InventoryGoal(mlevel, "Torch", 40, 0));
			inventoryGoalList.add(new InventoryGoal(mlevel, "Iron Ore", 20, 0));
			inventoryGoalList.add(new InventoryGoal(mlevel, "Iron", 20, 0));
			inventoryGoalList.add(new InventoryGoal(mlevel, "Iron Axe", 2, 0));
			inventoryGoalList.add(new InventoryGoal(mlevel, "Iron Pick", 2, 0));
			inventoryGoalList.add(new InventoryGoal(mlevel, "Iron Shovel", 2, 0));
			inventoryGoalList.add(new InventoryGoal(mlevel, "Stone Hoe", 2, 0));
			inventoryGoalList.add(new InventoryGoal(mlevel, "Iron Helmet", 1, 0));
			inventoryGoalList.add(new InventoryGoal(mlevel, "Iron Chestplate", 1, 0));
			inventoryGoalList.add(new InventoryGoal(mlevel, "Iron Leggings", 1, 0));
			inventoryGoalList.add(new InventoryGoal(mlevel, "Iron Boots", 1, 0));
			mlevel = MaterialLevel.DIAMOND;
			inventoryGoalList.add(new InventoryGoal(mlevel, "Wood Block", 64, 0));
			inventoryGoalList.add(new InventoryGoal(mlevel, "Wood Plank", 64, 0));
			inventoryGoalList.add(new InventoryGoal(mlevel, "Stick", 40, 0));
			inventoryGoalList.add(new InventoryGoal(mlevel, "Cobble Stone", 64, 0));
			inventoryGoalList.add(new InventoryGoal(mlevel, "Coal", 64, 0));
			inventoryGoalList.add(new InventoryGoal(mlevel, "Torch", 64, 0));
			inventoryGoalList.add(new InventoryGoal(mlevel, "Iron Ore", 40, 0));
			inventoryGoalList.add(new InventoryGoal(mlevel, "Iron", 40, 0));
			inventoryGoalList.add(new InventoryGoal(mlevel, "Diamond", 20, 0));
			inventoryGoalList.add(new InventoryGoal(mlevel, "Diamond Axe", 1, 0));
			inventoryGoalList.add(new InventoryGoal(mlevel, "Diamond Pick", 1, 0));
			inventoryGoalList.add(new InventoryGoal(mlevel, "Diamond Shovel", 1, 0));
			inventoryGoalList.add(new InventoryGoal(mlevel, "Stone Hoe", 2, 0));
			inventoryGoalList.add(new InventoryGoal(mlevel, "Diamond Helmet", 1, 0));
			inventoryGoalList.add(new InventoryGoal(mlevel, "Diamond Chestplate", 1, 0));
			inventoryGoalList.add(new InventoryGoal(mlevel, "Diamond Leggings", 1, 0));
			inventoryGoalList.add(new InventoryGoal(mlevel, "Diamond Boots", 1, 0));
	};
	
	//
	// Allow inventory manager to add goals dynamically
	//
	public void addGoal(MaterialLevel mlevel, String item, int quantity) {
		inventoryGoalList.add(new InventoryGoal(mlevel, item, quantity, 0));
	}
	
}
