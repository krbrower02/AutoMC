package my.krbmod.automc.aisystem.actions.inventory.chest;

import my.krbmod.automc.aisystem.actions.movement.waypoints.Coordinate;
import my.krbmod.automc.aisystem.aihelpers.UniqueID;

//
// Class identifying id, location and capacity of a chest
//
public class Chest {
	long id = 0;
	int capacity = 0;
	int onHand = 0;
	Coordinate location;
	ChestItem[][] chestItem;
	
	public enum ChestSize {
		SINGLE("Single", 5, 5),
		DOUBLE("Double", 5, 5);
		
		private final String name;
		private final int rows, columns;
	
		private ChestSize(String n, int r, int c){
			this.name = n;
			this.rows = r;
			this.columns = c;
		}
		
		String getName() {
			return name;			
		}
		
		int getRows() {
			return this.rows;			
		}
		
		int getColumns() {
			return this.columns;			
		}
	}
	
	public Chest(){
		this(ChestSize.SINGLE);
	}
	
	public Chest(ChestSize s){
		id = UniqueID.newID();
		capacity = s.getRows() * s.getColumns();
		onHand = 0;
		location = new Coordinate();
		chestItem = new ChestItem[s.getRows()][s.getColumns()];
	}

}
