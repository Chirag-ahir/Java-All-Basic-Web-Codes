package com.miit.contact.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.miit.contact.entity.Contact;

@Service
public class ContactServiceImpl implements ContactService{
	
	//Fake contacts
	 List<Contact> list = List.of(
			 new Contact(1L, "amit@gmail.com", "Amit", 101L),
	         new Contact(2L, "anil@gmail.com", "Anil", 101L),
	         new Contact(3L, "rohan@gmail.com", "Rohan", 102L),
	         new Contact(4L, "sameer@gmail.com", "Sameer", 103L),
	         new Contact(5L, "sameer@gmail.com", "Sameer", 103L)
	 );

	@Override
	public List<Contact> getContactsOfUser(Long userId) {
        return list.stream().filter(contact -> contact.getUserId().equals(userId)).collect(Collectors.toList());
	}

}

