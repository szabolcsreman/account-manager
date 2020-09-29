package edu.ing.accountmanager.model;

public class AuthenticationResponse {

	private String jwtToken;

	public AuthenticationResponse(String jwtToken) {
		super();
		this.jwtToken = jwtToken;
	}

	public String getJwtToken() {
		return jwtToken;
	}

	@Override
	public String toString() {
		return "AuthenticationResponse [jwtToken=" + jwtToken + "]";
	}
	
	
}
