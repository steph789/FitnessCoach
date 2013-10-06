package de.cimdata.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBTest {

	public static void main(String[] args) {
		
		//Class.forName("com.mysql.jdbc.Driver").newInstance();
		//---------------- URL+DBName, Username, Passwort
		try {
			///Connection con  = DriverManager.getConnection("jdbc:mysql://localhost:3306/java2","root","");
			
			Connection con  = DriverManager.getConnection(	DBProp.get("url")+DBProp.get("db"),
															DBProp.get("user"),
															DBProp.get("password")
															);
			
			Statement  statement = con.createStatement();
			
			// alle Datensätze von allen Spalten der Tabelle user
			ResultSet  result =  statement.executeQuery("SELECT * FROM user");
			
			
			while(result.next()){
				int id = result.getInt("id");
				
				String username = result.getString("username");
				String firstname = result.getString("firstname");
				String lastname = result.getString("lastname");
				double height = result.getDouble("height");
				
				
				System.out.println("id: "+id+ ", Name: "+ username + " "+firstname +" " + lastname +", Größe: "+height);
				
				
			}
			
			
			
			//--------------------------- Insert -----------------------------------
			
			Statement insertStatement = con.createStatement();
			
			int d = insertStatement.executeUpdate("INSERT INTO user(id, username, password,firstname,lastname,email,yearbirth,sex,height) VALUE (NULL, 'tester','test','Paul', 'Muster','pm@muster.de',1982,1,1.75)");
			System.out.println("Anzahl Datensätze eingefügt: "+d);
			
			//---------------------------- Delete ---------------------------------------------------------------
			
			String delQuery = "DELETE FROM user WHERE id = ?";
			PreparedStatement pstatement = con.prepareStatement(delQuery);
			pstatement.setInt(1, 4); // ? , id (? wird durch wert ersetzt)
			
			pstatement.executeUpdate();
			
			//------------------------ Update -------------------------------------------
			
			String updateQuery = "UPDATE gehalt SET lastname = ? WHERE id = ?";
			PreparedStatement prepStatement = con.prepareStatement(updateQuery);
			prepStatement.setString(1, "Mayer"); // (?-INDEX,name)
			prepStatement.setInt(2, 3);			//(?-INDEX,id) 
			prepStatement.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
}
