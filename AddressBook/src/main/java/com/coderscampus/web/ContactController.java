package com.coderscampus.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.coderscampus.domain.Contact;
import com.coderscampus.repositories.ContactRepository;

@Controller
public class ContactController {
  @Autowired
  private ContactRepository contactRepo;
  
  @GetMapping("/contacts")
  public String getContacts(ModelMap model) {
    List<Contact> contacts = contactRepo.findAll();
    
    Contact contact = new Contact();
    
    model.put("contact", contact);
    model.put("contacts", contacts);
    
    return "contacts";
  }
  
  @PostMapping("/contacts")
  public String createContact(@ModelAttribute Contact contact) {
    contact = contactRepo.save(contact);
    return "redirect:/contacts";
  }
}
