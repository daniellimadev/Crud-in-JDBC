package com.contact.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.contact.factory.ConnectionFactory;
import com.contact.model.Contact;

public class ContactDAO {
	
	/*
	 * CRUD
	 * c: CREATE = INSERT - OK!
	 * r: READ = SELECT - OK!
	 * u: UPDATE - OK!
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

	public List<Contact> contactList(){
		
		String sql = "SELECT * FROM contacts";
		
		List<Contact> contacts = new ArrayList<Contact>();
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		//Class that will retrieve data from the database. ***SELECT****
		ResultSet resutSet = null;
		
		try {
			connection = ConnectionFactory.createConnectionToMySql();
			
			statement = connection.prepareStatement(sql);
			
			resutSet = statement.executeQuery();
			
			
			while (resutSet.next()) {
				
				Contact contact = new Contact();
				
				//Retrieve the id
				contact.setId(resutSet.getInt("id"));
				
				//Retrieve the name
				contact.setName(resutSet.getString("name"));
				
				//Recover age
				contact.setAge(resutSet.getInt("age"));
				
				//Retrieve the registration date
				contact.setDateregister(resutSet.getDate("dateregister"));
				
				contacts.add(contact);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resutSet != null) {
					resutSet.close();
				}
				
				if (statement != null) {
					statement.close();
				}
				
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return contacts;
	}

	public void update(Contact contact) {
		String sql = "UPDATE contacts SET name = ?, age = ?, dateregister = ? " +
		"WHERE id = ?";
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			// Create connection to the database
			connection = ConnectionFactory.createConnectionToMySql();
			
			// Create the class to execute the query
			statement = connection.prepareStatement(sql);
			
			// Add values to update
			statement.setString(1, contact.getName());
			statement.setInt(2, contact.getAge());
			statement.setDate(3, new Date(contact.getDateregister().getTime()));
			
			// What is the ID of the record you want to update?
			statement.setInt(4, contact.getId());
			
			// Execute the query
			statement.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void deleteById(int id) {
		String sql = "DELETE FROM contacts WHERE id = ?";
		
		Connection connection= null;
		
		PreparedStatement statement = null;
		
		try {
			// Create connection to the database
			connection = ConnectionFactory.createConnectionToMySql();
			
			// Create the class to execute the query
			statement = connection.prepareStatement(sql);
			
			// What is the ID of the record you want to delete?
			statement.setInt(1, id);
			
			// Execute the query
			statement.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}
