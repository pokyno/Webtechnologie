package nl.pietervanberkel.model;

public class User {
	private String naam; //let op normale naam niet gebruikersnaam
	private String password;
	private String rol;
	
	public User(String naam, String password, String rol){
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
	
	public String getRol(){
		return rol;
	}
	
}
