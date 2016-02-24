package my.krbmod.automc.aisystem.status;
//
//Class to manage threat level surrounding player (primarily from nearby mobs)
//
public class ThreatLevel {

	int currentLevel;
	String source;
	
	public ThreatLevel() {
		currentLevel = 0;
		source = "None";
	}
	
	public int getLevel(){
		return currentLevel;
	}
	
	public String getSource(){
		return source;
	}

	public void setLevel(int level){
		currentLevel = level;
	}
	
	public void setSource(String s){
		source = s;
	}
}
