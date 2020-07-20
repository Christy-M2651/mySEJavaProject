package mobileApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;



public class Database {
	
	@SuppressWarnings("null")
	public Database(String firstName, String lastName) {
		
		Connection connection = null;
		Statement statement = null;
		try {
		
			Class.forName( "net.ucanaccess.jdbc.UcanaccessDriver");
		
		} 
		catch (ClassNotFoundException cnfex) { 
			System.out.println("Problem in loading or " + "registering MS Access JDBC driver"); 
			cnfex.printStackTrace();
		}
		
		try {
			String msAccDB = "C:/Temp/Employee.accdb"; 
			String dbURL = "jdbc:ucanaccess://" + msAccDB;
		
		DriverManager.getConnection(dbURL);
		
		statement = connection.createStatement();
		} 
		catch (SQLException sqlex) {
			sqlex.printStackTrace(); 
		} 
		finally {
		  try {
		    if (connection != null) {
		    		connection.close(); 
		    }
		  } 
		  catch(SQLException sqlex) { 
			  sqlex.printStackTrace();
		  } 
		}
		
		String insertSQL =
				  "INSERT INTO USER (NAME) " +
				  "VALUES (" + firstName + " " + lastName + ")";
				
				try {
					statement.executeUpdate(insertSQL);
				} 
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		}
	
}



