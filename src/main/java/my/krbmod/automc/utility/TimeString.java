package my.krbmod.automc.utility;
//
// Class to manage time as string "MM:SS" and convert to and from seconds in Integer format.
//
public class TimeString {

	String timeString;

	public TimeString() {
		timeString = "00:00";
	}
	
	public TimeString(String s) {
		//
		// Rather than check if string is valid, use static helper functions to force it to an integer and back
		// Static helper functions will perform the validity checks
		//
		timeString = ModTime.toTimeString(ModTime.toSeconds(s));
	}
	
	public TimeString(int t) {
		//
		// We ignore the sign if parameter is negative
		// 		//
		timeString = ModTime.toTimeString(Math.abs(t));
	}
	
	public String toString() {
		return timeString;
	}
	
	public int toSeconds(){
		return ModTime.toSeconds(timeString);
	}
	
	

}
