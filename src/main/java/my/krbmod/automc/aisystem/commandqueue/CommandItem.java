package my.krbmod.automc.aisystem.commandqueue;

import my.krbmod.automc.aisystem.aihelpers.Actions;

//
// All the possible commands that the action helpers can be asked to implement from external sources
// They can still do their own internal actions, but these are called from elsewhere.
//
public class CommandItem {
	public Actions commandSource;
	public String commandValue;
	
	public CommandItem() {
		this(Actions.NULL, "No Action");
	}
	
	public CommandItem(Actions s, String c) {
		commandSource = s;
		commandValue = c;
	}
	
	public String toString(){
		return (commandSource.toString()+": "+commandValue);
	}
	
}
