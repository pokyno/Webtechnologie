package nl.pietervanberkel.model;

import java.util.ArrayList;
import java.util.HashSet;


public class Model{

	private HashSet<User> users = new HashSet<User>(); // gebruikers te selecteren met
												// hun gebruikers naam
	private ArrayList<Room> rooms = new ArrayList<Room>(); // kan ook een treeset zijn als we er
											// een compare voor zouden maken 

	public Model() {
		
		// admin toevoegen want die moet vast staan
		users.add(new User("test", User.ADMIN,"henk"));
		
		fill_with_dummie_data();
	}
	
	public ArrayList<User> getUsers() {
		return new ArrayList<User>(users);
	}

	public void fill_with_dummie_data() {

		users.add(new User("test", User.HUURDER,"pieter"));
		users.add(new User("test", User.VERHUURDER,"karin"));
		users.add(new User("test", User.HUURDER,"thimo"));
		users.add(new User("test", User.HUURDER,"quinten"));
		users.add(new User("test", User.VERHUURDER,"anne"));
		users.add(new User("test", User.HUURDER,"harold"));
		
		// rooms dummie data
		
		addRoom(0, 70, 16, 120,"Enschede","karin");
		addRoom(5, 65, 5, 130,"haarlem","karin");
		addRoom(1, 120, 16, 8, "Hengelo","anne");
		addRoom(2, 30, 16, 67, "Borculo","anne");
		addRoom(3, 170, 16, 136, "Ruurlo","karin");
		addRoom(4, 245, 16, 1, "Geesteren","anne");
		

	}
	/**
	 * Add a new User to the system
	 * @param username String the name of the user
	 * @param password	String the password of the user	
	 * @param rol int de rol die de user heeft
	 */
	public void addUser(String username, String password, int rol) {
		assert username != null : "null type username";
		assert password != null : "null type password";

		assert!password.isEmpty() : "empty string password";

		users.add(new User(password, rol, username));
	}
	
	/**
	 * Add a new room to the system.
	 * @param roomNumber Integer of the room's number.
	 * @param monthlyPrice Integer of the room's monthly cost.
	 * @param distanceFromCurrentLocation Integer distance in kilometers from current location.
	 * @param surface Integer size of the room in square meters.
	 * @param city String name of the city the room is located in.
	 */
	public void addRoom(int roomNumber, int monthlyPrice, int distanceFromCurrentLocation,int surface, String city, String owner){
		assert roomNumber >= 0 : "roomNumber " + roomNumber + " is not a valid room number.";
		assert monthlyPrice > 0 : "monthly price " + monthlyPrice + " should be more than 0 euro's";
		assert distanceFromCurrentLocation >= 0 : "distanceFromCurrentLocation " + distanceFromCurrentLocation + " is not a valid distance.";
		assert surface > 0 : "surface " + surface + " is not a valid surface size.";
		
		rooms.add(new Room(roomNumber,monthlyPrice,distanceFromCurrentLocation,surface,city,owner));
		
	}
	
	/**
	 * Returns and list of rooms that meet the qualifications.
	 * @param monthlyPrice Integer of the maximum price the room may have.
	 * @param distanceFromCurrentLocation Integer of the maximum distance the room may be away from the current location.
	 * @param surface Integer of the minimum surface the room must have.
	 * @return ArrayList of Room instances that meet the qualifications.
	 */
	public ArrayList<Room> getRooms(int monthlyPrice,int distanceFromCurrentLocation,int surface){
		ArrayList<Room> foundRooms = new ArrayList<Room>();
		for(Room r: rooms){
			if (r.getMonthlyPrice() <= monthlyPrice &&
					r.getDistanceFromCurrentLocation() <= distanceFromCurrentLocation &&
					r.getSurface() >= surface){
				foundRooms.add(r);
			}
		}
		return foundRooms;
	}
	/**
	 * gets a user by using a name
	 * @param name String the name of the User to find
	 * @return the User
	 */
	public User getUser(String name){
		for(User u: users){
			if (u.getName().equals(name)){
				return u;
			}
		}
		return null;
	}
	
	/**
	 * Gives a list with all the landlords
	 * @return the landlords
	 */
	public ArrayList<User> getLandlords(){
		ArrayList<User> landLords = new ArrayList<User>();
		for (User u : users){
			if (u.getRol() == User.VERHUURDER){
				landLords.add(u);
			}
		}
		return landLords;
	}
	
	/**
	 * Gives a list with all the renters
	 * @return the renters
	 */
	public ArrayList<User> getRenters(){
		ArrayList<User> renters = new ArrayList<User>();
		for (User u : users){
			if (u.getRol() == User.HUURDER){
				renters.add(u);
			}
		}
		return renters;
	}
	
	/**
	 * Gives all the rooms that correspond with the users name
	 * @param name the name of the user
	 * @return	list of the rooms that correspond with the users name 
	 */
	public ArrayList<Room> getRoomsByUser(String name){
		ArrayList<Room> roomlist = new ArrayList<Room>();
		for(Room room: this.rooms){
			if(room.getOwner().equals(name)){
				roomlist.add(room);
			}
		}
		return roomlist;
	}

}
