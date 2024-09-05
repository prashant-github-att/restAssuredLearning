package com.restAssureLearning.Utilities;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.restAssureLearning.Payloads.Users;
import com.restAssureLearning.Payloads.UserBuilder;

public class UserTestCaseDataProvider {

	@DataProvider(name="getAllExceldata")
	public Users[] provideAllExcelDataToTestAsObject() throws IOException{
		String [][] s = ExcelDataReader.getAllData("user_details", System.getProperty("user.dir")+"/src/test/resources/User.xlsx");
	     Users[] userArray = new Users [s.length];
		for (int i = 0; i<s.length; i++){
			userArray[i] = new Users();
		    for (int j = 0; j<s[i].length; j++){
		    	if(j==0)
		    		userArray[i].setId(Integer.parseInt(s[i][j]));
		    	if(j==1)
		    		userArray[i].setUsername(s[i][j]);
		    	if(j==2)
		    		userArray[i].setFirstName(s[i][j]);
		    	if(j==3)
		    		userArray[i].setLastName(s[i][j]);
		    	if(j==4)
		    		userArray[i].setEmail(s[i][j]);
		    	if(j==5)
		    		userArray[i].setPassword(s[i][j]);
		    	if(j==6)
		    		userArray[i].setPhone(s[i][j]);
		    	if(j==7)
		    		userArray[i].setUserStatus(Integer.parseInt(s[i][j]));	
		    	
		    }
		}
		
		return userArray;
	}
	
	@DataProvider(name="getAllFieldValueExceldata")
	public String[] provideAllFieldValue(Method m) throws IOException {
		String fieldToGet = null;
		if(m.getName().contains("UserName"))
			fieldToGet = "username";
		String [] s = ExcelDataReader.getAllFieldValues("user_details", System.getProperty("user.dir")+"/src/test/resources/User.xlsx",fieldToGet);
		return s;
	}
	
}
