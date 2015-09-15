package nl.pietervanberkel.util;

import javax.servlet.http.Cookie;

public class UserCookie extends Cookie {
	
	public UserCookie(String name, String value) {
		super(name, System.currentTimeMillis() + "");
	}
	
	/**
	 * Updates Cookie with currentTime
	 * @param newValue can be left a null
	 */
	@Override
	public void setValue(String newValue) {
		super.setValue(getValue() + "," + System.currentTimeMillis());
	}

}
