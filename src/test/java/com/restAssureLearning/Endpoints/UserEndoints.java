package com.restAssureLearning.Endpoints;

import com.restAssureLearning.Payloads.UserBuilder;
import com.restAssureLearning.Payloads.Users;
import com.restAssureLearning.Utilities.PropertyRead;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static  io.restassured.RestAssured.*;
import static  io.restassured.matcher.RestAssuredMatchers.*;
import static  org.hamcrest.Matchers.*;

import java.io.IOException;

public class UserEndoints {

	public static Response createUser(Users user) throws IOException {
		
		Response response = given()
		 .contentType(ContentType.JSON)
		 .accept(ContentType.JSON)
		 .body(user)
		.when ()
		.post(PropertyRead.getProperty("User_post"));
		
		return response;
			
	}
	
	public static Response getUser(String userName) throws IOException {
		Response response = given()
				.accept(ContentType.JSON)
				.pathParam("username", userName)
				.when ()
				.get(PropertyRead.getProperty("User_get"));
		return response;
	}
	
public static Response updateUser(Users user,String userName) throws IOException {
		
		Response response = given()
		 .contentType(ContentType.JSON)
		 .accept(ContentType.JSON)
		 .pathParam("username", userName)
		 .body(user)
		.when ()
		.put(PropertyRead.getProperty("User_update"));
		
		return response;
			
	}

public static Response deleteUser(String userName) throws IOException {
	Response response = given()
			.pathParam("username", userName)
			.when ()
			.delete(PropertyRead.getProperty("User_delete"));
	return response;
}
}
