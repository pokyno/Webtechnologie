package nl.pietervanberkel.model;

import java.util.ArrayList;
import java.util.HashMap;

public class Model {
	
	private static HashMap<String, User> users; // gebruikers te selecteren met hun gebruikers naam
	private static ArrayList<Room> rooms; // kan ook een treeset zijn als we er een compare voor maken  
	
	public Model() {
		// TODO Auto-generated method stub
		//hier kan alles bij het opstarten hard coded data in voegen kan later ook veranderd worden met database ini
		users = new HashMap<String,User>();
		rooms = new ArrayList<Room>();
		if(users.isEmpty() && rooms.isEmpty()){
			fill_with_dummie_data();
		}
	}
	
	public static void fill_with_dummie_data(){
		
		users.put("pieter", new User("pieter","test","huurder"));
		users.put("karin", new User("karin","test","huurder"));
		users.put("thimo", new User("thimo","test","huurder"));
		users.put("quinten", new User("quinten","test","huurder"));
		users.put("anne", new User("anne","test","huurder"));
		users.put("harold", new User("harold","test","huurder"));
		users.put("henk", new User("henk","test","huurder"));
		
		//rooms dummie data
		
	}
	
	public void addUser(String username, String naam, String password, String rol){
		assert username != null: "null type username";
		assert naam != null: "null type naam";
		assert password != null: "null type password";
		assert rol != null: "null type rol";
		
		assert !username.isEmpty(): "empty string username";
		assert !naam.isEmpty(): "empty string naam";
		assert !password.isEmpty(): "empty string password";
		assert !rol.isEmpty(): "empty string rol";
		
		users.put(username, new User(naam,password,rol));
	}
	
	public boolean checkUserNameWithPassword(String name, String password){
		if(users.containsKey(name)){
			User user = users.get(name);
			return user.getPassword().equals(password);
		}else{
			return false;
		}
	}

}
