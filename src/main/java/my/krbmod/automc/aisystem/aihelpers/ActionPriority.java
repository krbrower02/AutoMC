package my.krbmod.automc.aisystem.aihelpers;

public class ActionPriority {
	// TODO - Put these all in a single class along with the Action Manager Name for ease of balancing AI
	
	//
	// Default baseline priorities for Command Queue entries
	// This will give Combat the advantage over movement over inventory checks, etc.
	// If a manager needs attention, it can bump up the priority on each iteration.
	//
	public static final int PRIORITY_NULL = 0;
	public static final int PRIORITY_TERRAFORMER = 1;
	public static final int PRIORITY_EXPLORATION = 3;
	public static final int PRIORITY_FARMER = 5;
	public static final int PRIORITY_CRAFTER = 6;
	public static final int PRIORITY_MINER = 8;
	public static final int PRIORITY_LUMBERJACK = 10;
	public static final int PRIORITY_INVENTORY = 12;
	public static final int PRIORITY_MOVEMENT = 14;
	public static final int PRIORITY_COMBAT = 16;
	
	//
	// Timer resets (milliseconds) for when a Action Managers will check the Command Queue for status updates
	// this prevents Action Managers from getting OCD and constantly checking their status
	//
	public static final int TIMER_NULL = 300000;  // there is no Null Manager so this could be any time; its only here for consistency
	public static final int TIMER_TERRAFORMER = 10000;
	public static final int TIMER_EXPLORATION = 10000;
	public static final int TIMER_FARMER = 10000;
	public static final int TIMER_CRAFTER = 1000;
	public static final int TIMER_MINER = 1000;
	public static final int TIMER_LUMBERJACK = 1000;
	public static final int TIMER_INVENTORY = 1000;
	public static final int TIMER_MOVEMENT = 1000;
	public static final int TIMER_COMBAT = 1000;
	
}
