package nl.pietervanberkel.model;

public class User {
	private String name; 
	private String password;
	private int rol;
	
	public static final int HUURDER = 0, VERHUURDER = 1, ADMIN = 2;
	
	public User(String password, int rol,String name){
		this.password = password;
		this.rol = rol;
		this.name = name;
	}
	
	
	public String getPassword(){
		return password;
	}
	
	public int getRol(){
		return rol;
	}
	
	public String toString(){
		return name + " " + password + " " + rol;
	}
	
	public String getName(){
		return name;
	}
	
}
