package my.krbmod.automc.aisystem.status;

import my.krbmod.automc.utility.TimeString;

//
//Class to manage timed conditions that have been added to player
//
public class PlayerCondition {
	String condition; // condition name
	TimeString duration; // in seconds
	
	public PlayerCondition() {
		this("None", "00:00");
	}
	
	public PlayerCondition(String c, String d) {
		condition = c;
		duration = new TimeString(d);
	}
	
	public int getduration(){
		return duration.toSeconds();
	}
	
	public String getcondition(){
		return condition;
	}

	public void setDuration(int level){
		duration = new TimeString(level);
	}
	
	public void setCondition(String s){
		condition = s;
	}
	
	public String toString(){
		return (String) "["+condition+" for "+duration.toString()+"("+duration.toSeconds()+") seconds ]";
	}
}
