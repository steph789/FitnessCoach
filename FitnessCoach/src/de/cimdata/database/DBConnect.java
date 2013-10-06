package de.cimdata.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DBConnect {
	
	private static DBConnect instance = null;
	private Connection con;
	
	private DBConnect(){
		
		 try {
			con  = DriverManager.getConnection(	
					DBProp.get("url")+DBProp.get("db"),
					DBProp.get("user"),
					DBProp.get("password")
					);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static DBConnect getInstance(){
		if(instance == null){
			instance = new DBConnect();
		}
		return instance;
	}
	
	public Connection getConnection(){
		return con;
	}
	
	public void closeConnection(){
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
