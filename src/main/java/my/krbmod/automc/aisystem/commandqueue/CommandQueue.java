package my.krbmod.automc.aisystem.commandqueue;

//TODO - confirm whether java.util.List or java.awt.List should be used here.
import java.util.List;

import my.krbmod.automc.aisystem.aihelpers.Actions;
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
	private static List<CommandItem> commandList;
	private static int nowServing = 0;
	
	//
	// Maintain list of all active commands.  AI system will add or remove commands as they are processed.
	//
	private static List<CommandQueueItem> priorityQueue;
	
	public static void init() {
		LogHelper.info("Priority Queue Initialization Started");
		// commandList = new ArrayList<itemItem>;
		// commandQueue = new ArrayList<PriorityQueueItem>;
		LogHelper.info("Priority Queue Initialization Complete");
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

	
	public static void registerCommand(Actions s, String c) {
		//TODO - See if command is already registered.  If not, add it.
		CommandItem cmd = new CommandItem(s, c);
		LogHelper.info("Registering Command"+cmd.toString());
	}
	
	public static void unregisterCommand(CommandItem c) {
		//TODO - See if command is registered.  If so, remove it.
		
	}
	
}
