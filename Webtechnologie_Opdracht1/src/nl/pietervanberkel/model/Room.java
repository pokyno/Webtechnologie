package nl.pietervanberkel.model;

public class Room {
	private int roomNumber, monthlyPrice, distanceFromCurrentLocation,surface;
	private String city;

	public Room(int roomNumber, int monthlyPrice, int distanceFromCurrentLocation,int surface,String city) {
		this.roomNumber = roomNumber;
		this.monthlyPrice = monthlyPrice;
		this.distanceFromCurrentLocation = distanceFromCurrentLocation;
		this.surface = surface;
		this.city = city;
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
}
