package com.contact.application;

import java.util.Date;

import com.contact.dao.ContactDAO;
import com.contact.model.Contact;

public class Main {

	public static void main(String[] args) {
		
		ContactDAO contactDAO = new ContactDAO();
		
		Contact contact = new Contact();
		contact.setName("Danilo");
		contact.setAge(38);
		contact.setDateregister(new Date());
		
		contactDAO.save(contact);
	}

}
