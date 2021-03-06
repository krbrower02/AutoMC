package my.krbmod.automc.aisystem.actions.inventory.personal;

import my.krbmod.automc.aisystem.actions.inventory.chest.Chest;
import my.krbmod.automc.aisystem.actions.inventory.item.ModItemOld;
import my.krbmod.automc.aisystem.actions.inventory.support.SearchType;

//
// Class to manage Personal Inventory 
// Basic Actions include:
//    Offload: Transfer from Personal Inventory to Chest
//    Acquire: Transfer from Chest to Personal Inventory
//	  Resync: Resynchronize with the In-Game Personal Inventory
//    Dispose: Dispose of an unneeded item
//    Search: Return true if Item is in Personal Inventory
//
public class PersonalInventory {

	public void offload(ModItemOld item, Chest chest){
		// TODO Implement offload function
	}
	
	public void acquire(ModItemOld item, Chest chest){
		// TODO Implement acquire function
	}
	
	public void resync() {
		// TODO recynchronize with the In-Game Personal Inventory
	}
	
	public void dispose(ModItemOld item) {
		// TODO Throw unneeded item into a hole, off a cliff or into lava
	}
	
	public boolean search(ModItemOld item) {
		boolean found = false;
		found = search(item, SearchType.IGNORE_MBT);
		return found;
	}
	
	public boolean search(ModItemOld item, SearchType stype) {
		boolean found = false;
		switch (stype){
		case EXACT: 
			// TODO Conduct an Exact Search
			break;
		case IGNORE_MBT: 
			// TODO // search ignores damage and enchants 
			break;
		case ORE_DICT: 
			// TODO Conduct an Exact Search
			break;
		default:
			// TODO Trap incorrect SearchType
			break;
		}
				
		return found;
	}
}
