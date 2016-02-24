package my.krbmod.automc.aisystem.actions.actionhelpers;
//
// Counter for making unique action IDs used in Priority Queue
//
public class ActionID {

	private static boolean actionInit = false;
	private static int actionID = 0;
	
	public ActionID() {
		actionInit = true;
		actionID = 0;
	}
		
	public static int newID() {
		if (actionInit == false) {
			actionInit = true;
			actionID = 0;
		}
		//
		// TODO - Prevent or catch overflow of actionID
		//
		return actionID++;
	}

}
