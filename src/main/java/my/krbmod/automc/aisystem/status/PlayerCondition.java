package my.krbmod.automc.aisystem.status;
//
//Class to manage timed conditions that have been added to player
//
public class PlayerCondition {
	String condition; // condition name
	int duration; // in seconds
	
	public PlayerCondition() {
		condition = "None";
		duration = 0;
	}
	
	public int getduration(){
		return duration;
	}
	
	public String getcondition(){
		return condition;
	}

	public void setDuration(int level){
		duration = level;
	}
	
	public void setCondition(String s){
		condition = s;
	}
	
	// Helper Classes
	// TODO - search Java Library for these functions
	public static int toSeconds(String time){
		//TODO - Convert time string as "mm:ss" to integer time in seconds
		return 0;
	}
	
	public static String toTimeString(int s){
		//TODO - Convert integer time in seconds to time string as "mm:ss"
		return "00:00";
	}
}
