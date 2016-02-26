package my.krbmod.automc.aisystem.aihelpers;
//
// Each enum represents a different action helper.
// Used to organize items in the priority queue and other locations.
//
// TODO - Put these into a single class along with the Action Manager Name for ease of balancing AI
//
public enum Actions {
	NULL("Null",0,300000), // there is no Null Manager so timer could be anything; its only here for consistency
	COMBAT("Combat",16,1000),
	CRAFTER("Crafter",6,1000),
	EXPLORATION("Exploration",3,10000),
	FARMER("Farmer",5,10000),
	INVENTORY("Inventory",12,1000),
	LUMBERJACK("Lumberjack",10,1000),
	MINER("Miner",8,1000),
	MOVEMENT("Movement",14,1000),
	TERRAFORMER("Terraformer",1,10000);
	
	private final String name;
	//
	// Default baseline priorities for Command Queue entries
	// This will give Combat the advantage over movement over inventory checks, etc.
	// If a manager needs attention, it can bump up the priority on each iteration.
	//
	private final  int priority;
	//
	// Timer resets (milliseconds) for when a Action Managers will check the Command Queue for status updates
	// this prevents Action Managers from getting OCD and constantly checking their status
	//
	private final long timer;
	
	private Actions(String name, int priority, long timer)
    {
        this.name = name;
        this.priority = priority;
        this.timer = timer;
    }
	
	public String getName(){
		return this.name;
	}
	
	public int getPriority(){
		return this.priority;
	}
	
	public long getTimer(){
		return this.timer;
	}
}
