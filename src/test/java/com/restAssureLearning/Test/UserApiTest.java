package com.restAssureLearning.Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.restAssureLearning.Endpoints.UserEndoints;
import com.restAssureLearning.Payloads.Users;
import com.restAssureLearning.Utilities.UserTestCaseDataProvider;

import io.restassured.response.Response;

public class UserApiTest {
	
	/*
	@Test(dataProvider="getAllExceldata",dataProviderClass=UserTestCaseDataProvider.class)
	public void testPostUser(Users user) throws IOException {
		
		Response resp = UserEndoints.createUser(user);
		Assert.assertEquals(resp.getStatusCode(), 200);
		
	}
	*/
	@Test(dataProvider="getAllFieldValueExceldata",dataProviderClass=UserTestCaseDataProvider.class)
	public void testGetUserName(String userName) throws IOException {
		
		Response resp = UserEndoints.getUser(userName);
		
		Users u1= resp.getBody().as(Users.class);
		ObjectMapper obj = new ObjectMapper ();
		Users u = obj.readValue(resp.getBody().asString(),Users.class );
		Assert.assertEquals(resp.getStatusCode(), 200);
		Assert.assertEquals(u.getUsername(), userName);
		
	}
}