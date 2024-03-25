package com.contact.application;

import java.util.Date;

import com.contact.dao.ContactDAO;
import com.contact.model.Contact;

public class Main {

	public static void main(String[] args) {
		
		ContactDAO contactDAO = new ContactDAO();
		
//		Contact contact = new Contact();
//		contact.setName("Aline");
//		contact.setAge(38);
//		contact.setDateregister(new Date());
//		
//		contactDAO.save(contact);
		
		// View ALL database records
		for (Contact contactAll : contactDAO.contactList()) {
			System.out.println("Contact: " + contactAll.getName());
		}
		
		// Update the contact.
		Contact c1 = new Contact();
		c1.setId(3); // It is the number that is in the PK database
		c1.setName("Aline Muniz");
		c1.setAge(40);
		c1.setDateregister(new Date());
		
		contactDAO.update(c1);
		
	}

}
