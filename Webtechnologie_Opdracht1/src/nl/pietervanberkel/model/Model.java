package nl.pietervanberkel.model;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.sun.xml.internal.ws.developer.UsesJAXBContext;

public class Model{

	private HashMap<String, User> users = new HashMap<String, User>(); // gebruikers te selecteren met
												// hun gebruikers naam
	private ArrayList<Room> rooms = new ArrayList<Room>(); // kan ook een treeset zijn als we er
											// een compare voor maken

	public Model() {
		// TODO Auto-generated method stub
		// hier kan alles bij het opstarten hard coded data in voegen kan later
		// ook veranderd worden met database ini
		fill_with_dummie_data();
	}
	
	public ArrayList<User> getUsers() {
		return new ArrayList<User>(users.values());
	}

	public void fill_with_dummie_data() {

		users.put("pieter", new User("pieter", "test", User.HUURDER));
		users.put("karin", new User("karin", "test", User.VERHUURDER));
		users.put("thimo", new User("thimo", "test", User.HUURDER));
		users.put("quinten", new User("quinten", "test", User.HUURDER));
		users.put("anne", new User("anne", "test", User.VERHUURDER));
		users.put("harold", new User("harold", "test", User.HUURDER));
		users.put("henk", new User("henk", "test", User.HUURDER));

		// rooms dummie data
		
		addRoom(0, 70, 16, 120,"Enschede");
		addRoom(1, 120, 16, 8, "Hengelo");
		addRoom(2, 30, 16, 67, "Borculo");
		addRoom(3, 170, 16, 136, "Ruurlo");
		addRoom(4, 245, 16, 1, "Geesteren");
		

	}

	public void addUser(String username, String naam, String password, int rol) {
		assert username != null : "null type username";
		assert naam != null : "null type naam";
		assert password != null : "null type password";

		assert!username.isEmpty() : "empty string username";
		assert!naam.isEmpty() : "empty string naam";
		assert!password.isEmpty() : "empty string password";

		users.put(username, new User(naam, password, rol));
	}
	
	/**
	 * Add a new room to the system.
	 * @param roomNumber Integer of the room's number.
	 * @param monthlyPrice Integer of the room's monthly cost.
	 * @param distanceFromCurrentLocation Integer distance in kilometers from current location.
	 * @param surface Integer size of the room in square meters.
	 * @param city String name of the city the room is located in.
	 */
	public void addRoom(int roomNumber, int monthlyPrice, int distanceFromCurrentLocation,int surface, String city){
		assert roomNumber >= 0 : "roomNumber " + roomNumber + " is not a valid room number.";
		assert monthlyPrice > 0 : "monthly price " + monthlyPrice + " should be more than 0 euro's";
		assert distanceFromCurrentLocation >= 0 : "distanceFromCurrentLocation " + distanceFromCurrentLocation + " is not a valid distance.";
		assert surface > 0 : "surface " + surface + " is not a valid surface size.";
		
		
		rooms.add(new Room(roomNumber,monthlyPrice,distanceFromCurrentLocation,surface,city));
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
		
		return rooms;
	}
	
	public User getUser(String name){
		return users.get(name);
	}

}
