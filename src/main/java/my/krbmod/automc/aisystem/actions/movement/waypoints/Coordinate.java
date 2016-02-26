package my.krbmod.automc.aisystem.actions.movement.waypoints;

public class Coordinate {

	public int xCoord = 0;
	public int zCoord = 0;
	public int yCoord = 0;
	
	public void Coordinate(){
		Coordinate(0,0,0);
	}
	
	public void Coordinate(int x, int z, int y){
		this.xCoord = x;
		this.zCoord = z;
		this.yCoord = y;
	}
	
	// Calculate the distance between coordinates when moving as if on city blocks
	// Good for quick calculation of relative distances between waypoints
	//
	public int distanceCityBlock(Coordinate c){
		return (int) (Math.abs(this.xCoord-c.xCoord)+
				Math.abs(this.zCoord-c.zCoord));
	}
	
	// Calculate the distance between coordinates assuming that the surface is flat and there are no elevation changes
	//
	public int distanceFlat(Coordinate c){
		return (int) (Math.sqrt(Math.abs(
				(this.xCoord-c.xCoord)^2+
				(this.zCoord-c.zCoord)^2)));
	}
	
	// Calculate the absolute distance between coordinates as if using a laser pointer
	//
	public int distanceLaser(Coordinate c){
		return (int) (Math.sqrt(Math.abs(
				(this.xCoord-c.xCoord)^2+
				(this.zCoord-c.zCoord)^2+
				(this.yCoord-c.yCoord)^2)));
	}
	
	// Calculate height difference between two points as if using an elevator
	//
	public int distanceElevator(Coordinate c){
		return (int) (Math.abs(this.yCoord-c.yCoord));
	}
}
