package nl.pietervanberkel.model;

public class Room {
	private int roomNumber, monthlyPrice, distanceFromCurrentLocation,surface;
	private String city, owner;

	public Room(int roomNumber, int monthlyPrice, int distanceFromCurrentLocation,int surface,String city, String owner) {
		this.roomNumber = roomNumber;
		this.monthlyPrice = monthlyPrice;
		this.distanceFromCurrentLocation = distanceFromCurrentLocation;
		this.surface = surface;
		this.city = city;
		this.owner = owner;
	}
	
	public int getDistanceFromCurrentLocation() {
		return distanceFromCurrentLocation;
	}
	
	public int getMonthlyPrice() {
		return monthlyPrice;
	}
	
	public int getRoomNumber() {
		return roomNumber;
	}
	
	public String getCity() {
		return city;
	}
	
	public int getSurface() {
		return surface;
	}
	
	public String getOwner(){
		return owner;
	}
	
	public String toString(){
		return    "room nr: " + roomNumber + "\n"
				+ "monthly prize: " + monthlyPrice + "\n"
				+ "distance: " +distanceFromCurrentLocation+"\n"
				+ "surface:"+ surface + "\n"
				+ "city: " + city +"\n"
				+ "owner: "+ owner;
	}
}
