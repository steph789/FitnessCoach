package de.cimdata.database;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DBProp {
	
	private static Properties prop;
	
	private DBProp(){}
	
	static{
		prop = new Properties();
		
		try {
			prop.load(new BufferedInputStream(new FileInputStream("db.properties")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String get(String key){
		return prop.getProperty(key);
	}

}
