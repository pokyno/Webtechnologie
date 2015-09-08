package nl.pietervanberkel.model;

public class User {
	private String naam; //let op normale naam niet gebruikersnaam
	private String password;
	private int rol;
	
	public static final int HUURDER = 0, VERHUURDER = 1;
	
	public User(String naam, String password, int rol){
		this.naam = naam;
		this.password = password;
		this.rol = rol;
	}
	
	
	public String getNaam(){
		return naam;
	}
	
	public String getPassword(){
		return password;
	}
	
	public int getRol(){
		return rol;
	}
	
}
