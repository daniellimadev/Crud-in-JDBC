package com.contact.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	// MySQL username
	private static final String USERNAME = "root";
	
	//Database password
	private static final String PASSWORD = "admin";
	
	// Database path, port, database name
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/contact";
	
	/*
	 * Connection to database
	 */
	
	public static Connection createConnectionToMySql() throws Exception {
		
		// Create the connection to the database
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		
		return connection;
	}
	
	public static void main(String[] args) throws Exception {
		
		// Retrieve a connection to the database
		Connection connection = createConnectionToMySql();
		
		// Test whether the connection is null
		System.out.println("Connection successful!");
		connection.close();
	}
	
}
