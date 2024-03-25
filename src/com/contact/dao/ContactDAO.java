package com.contact.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import com.contact.factory.ConnectionFactory;
import com.contact.model.Contact;

public class ContactDAO {
	
	/*
	 * CRUD
	 * c: CREATE - OK!
	 * r: READ -
	 * u: UPDATE -
	 * d: DELETE -
	 */

	public void save(Contact contact) {
		
		String sql = "INSERT INTO contacts(name, age, dateregister) VALUES (?, ?, ?)";
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			// Create a connection to the database
			connection = ConnectionFactory.createConnectionToMySql();
			
			// We create a PreparedStatement, to execute a query
			statement = connection.prepareStatement(sql);
			
			// Add the values expected by the query
			statement.setString(1, contact.getName());
			statement.setInt(2, contact.getAge());
			statement.setDate(3, new Date(contact.getDateregister().getTime()));
			
			// Execute the query
			statement.execute();
			System.out.println("Contact saved successfully!");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close connections
			try {
				if (statement != null) {
					statement.close();
				}
				
				if (connection != null) {
					statement.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}
