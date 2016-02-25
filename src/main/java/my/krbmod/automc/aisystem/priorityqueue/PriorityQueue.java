package my.krbmod.automc.aisystem.priorityqueue;

//TODO - confirm whether java.util.List or java.awt.List should be used here.
import java.util.List;

import my.krbmod.automc.utility.LogHelper;

import java.util.LinkedList;
import java.util.ArrayList;

//
//All actions (other than inits) are managed through a priority queue.
//Each action manager puts in a request at a certain priority based on perceived need
//priority queue manager will authorize requests bases on priority levels
//individual action managers can only perform tasks if there are no competing priorities
//

public class PriorityQueue {
	private static List<PriorityQueueItem> priorityQueue;
	
	public static void init() {
		LogHelper.info("Priority Queue Initialization Started");

		// priorityQueue = new ArrayList<PriorityQueueItem>;
		LogHelper.info("Priority Queue Initialization Complete");
	}
	
	public void add(){
		
	}
	
	public void remove(){
		
	}
	
	public PriorityQueueItem nextItem() {
		PriorityQueueItem p = null;
		
		return p;
	}
}
