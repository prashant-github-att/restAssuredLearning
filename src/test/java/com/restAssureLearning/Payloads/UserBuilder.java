package com.restAssureLearning.Payloads;

public class UserBuilder {
	private int id;
	private String username;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String phone;
	private int userStatus;
	
	private UserBuilder() {
		
	}
	
	public static UserBuilder builder() {
		
		return new UserBuilder();
	}
	

	public UserBuilder setId(int id) {
		this.id = id;
		return this;
	}
	public UserBuilder setUsername(String username) {
		this.username = username;
		return this;
	}
	public UserBuilder setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}
	public UserBuilder setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}
	public UserBuilder setEmail(String email) {
		this.email = email;
		return this;
	}
	public UserBuilder setPassword(String password) {
		this.password = password;
		return this;
	}
	public UserBuilder setPhone(String phone) {
		this.phone = phone;
		return this;
	}
	public UserBuilder setUserStatus(int userStatus) {
		this.userStatus = userStatus;
		return this;
	}
	
	public Users build() {
		return new Users(id, username, firstName, lastName, email, password, phone, userStatus);
	}
	
	
}
