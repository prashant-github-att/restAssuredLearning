package com.restAssureLearning.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.imageio.stream.FileImageInputStream;

public class PropertyRead {
	
	public static String getProperty(String key) throws IOException {
		String user_dir = System.getProperty("user.dir");
		Properties property = new Properties();
		FileInputStream fsi = null;
		try {

			fsi = new FileInputStream(user_dir+"/src/test/resources/config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		property.load(fsi);
		
		return property.getProperty(key);	
	}
	
}
