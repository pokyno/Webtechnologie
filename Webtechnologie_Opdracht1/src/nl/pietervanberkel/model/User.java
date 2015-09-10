package nl.pietervanberkel.model;

public class User {
	private String naam; //let op normale naam niet gebruikersnaam
	private String password;
	private int rol;
	
	public static final int HUURDER = 0, VERHUURDER = 1, ADMIN = 2;
	
	public User(String password, int rol){
		this.password = password;
		this.rol = rol;
	}
	
	
	public String getPassword(){
		return password;
	}
	
	public int getRol(){
		return rol;
	}
	
	public String toString(){
		return naam + " " + password + " " + rol;
	}
	
	public String getName(){
		return naam;
	}
	
}
