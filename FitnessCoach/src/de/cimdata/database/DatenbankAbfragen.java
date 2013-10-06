package de.cimdata.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Hashtable;
import java.util.Vector;

import de.cimdata.data.NewUserData;

public class DatenbankAbfragen {
	
	DBConnect db = DBConnect.getInstance();
	Connection con;

	public DatenbankAbfragen() {
		con = db.getConnection();
		
		
	}
	
	public long findUserID(String name) {
		long id = 0;
		
		String query = "SELECT id FROM user WHERE username LIKE ?"; // %?
		try {
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, name);
			ResultSet rs = st.executeQuery();
			id = rs.getLong("id");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}


	public String findFirstname(long id) {
		String firstname = null;
		String query = "SELECT * FROM user WHERE id LIKE ?"; // %?
		try {
			PreparedStatement st = con.prepareStatement(query);
			st.setLong(1, id);
			ResultSet rs = st.executeQuery();
			firstname = rs.getString("firstname");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return firstname;
	}
	
	public String findLastname(long id) {
		String lastname = null;
		String query = "SELECT * FROM user WHERE id LIKE ?"; // %?
		try {
			PreparedStatement st = con.prepareStatement(query);
			st.setLong(1, id);
			ResultSet rs = st.executeQuery();
			lastname = rs.getString("lastname");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lastname;
	}
	
	public String findSex(long id) {
		String sex = null;
		String query = "SELECT * FROM user WHERE id LIKE ?"; // %?
		try {
			PreparedStatement st = con.prepareStatement(query);
			st.setLong(1, id);
			ResultSet rs = st.executeQuery();
			int bool = rs.getInt("sex");
			
			if(bool == 0){
				sex = "f";
			}
			sex = "m";
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return sex;
	}
	
	public int findYearbirth(long id) {
		int yearbirth = 0;
		String query = "SELECT * FROM user WHERE id LIKE ?"; // %?
		try {
			PreparedStatement st = con.prepareStatement(query);
			st.setLong(1, id);
			ResultSet rs = st.executeQuery();
			yearbirth = rs.getInt("yearbirth");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return yearbirth;
	}
	
	public double findHeight(long id) {
		double height = 0F;
		String query = "SELECT * FROM user WHERE id LIKE ?"; // %?
		try {
			PreparedStatement st = con.prepareStatement(query);
			st.setLong(1, id);
			ResultSet rs = st.executeQuery();
			height = rs.getDouble("height");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return height;
	}
	
	public double findWeight(long id) {
		double weight = 0F;
		String query = "SELECT * FROM user WHERE id LIKE ?"; // %?
		try {
			PreparedStatement st = con.prepareStatement(query);
			st.setLong(1, id);
			ResultSet rs = st.executeQuery();
			weight = rs.getDouble("weight");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return weight;
	}
	
	public boolean findRun(String username) {
		return false;
		
	}
	
	public boolean findBike(String username) {
		return false;
		
	}
	
	public boolean findSwim(String username) {
		return false;
		
	}
	
	public boolean findPump(String username) {
		return false;
		
	}
	
	public boolean checkExistingUser(String username, String password) {
		boolean exists = false;
		String query = "SELECT * FROM user WHERE username LIKE ? AND password LIKE ?"; // %?
		try {
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, username);
			st.setString(2, password);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				exists = true;
				return exists;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return exists;
	}
	
	public void createNewAccount(NewUserData u) {
		
		try {
Statement insertStatement = con.createStatement();
			
			int d = insertStatement.executeUpdate("INSERT INTO user(id, username, password,firstname,lastname,email,yearbirth,sex,height) VALUE (NULL, 'tester','test','Paul', 'Muster','pm@muster.de',1982,1,1.75)");
			System.out.println("Anzahl Datensätze eingefügt: "+d);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public Hashtable<Long,Float> fillWeightList(String username) {
		return null;
		
	}
	
	private static Vector<Vector<?>> getDataSet(ResultSet result) {
		Vector<Vector<?>> data = new Vector<>();
		try {
			while (result.next()) {

				Vector<Object> datensatz = new Vector<>();
				datensatz.add(result.getInt("id"));
				datensatz.add(result.getString("firstname"));
				datensatz.add(result.getString("lastname"));
//				datensatz.add(result.getString("plz"));
//				datensatz.add(result.getString("ort"));
//				datensatz.add(result.getString("strasse"));
//				datensatz.add(result.getString("telefon"));
//				datensatz.add(result.getString("mob"));
//				datensatz.add(result.getString("email"));
				data.add(datensatz);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
