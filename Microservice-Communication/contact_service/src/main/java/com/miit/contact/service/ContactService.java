package com.miit.contact.service;

import java.util.List;
import com.miit.contact.entity.Contact;

public interface ContactService {
    public List<Contact> getContactsOfUser(Long userId);
}
