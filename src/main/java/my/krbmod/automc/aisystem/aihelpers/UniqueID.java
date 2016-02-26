package my.krbmod.automc.aisystem.aihelpers;
//
// Counter for making unique action IDs used in Priority Queue
//
public class UniqueID {

	private static boolean initialized = false;
	private static long uniqueID = 0;
	
	public UniqueID() {
		initialized = true;
		uniqueID = 0;
	}
		
	public static long newID() {
		if (initialized == false) {
			uniqueID = 0;
			initialized = true;
		}
		//
		// TODO - Prevent or catch overflow of actionID
		//
		return uniqueID++;
	}

}
