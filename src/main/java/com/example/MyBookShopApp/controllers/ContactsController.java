package com.example.MyBookShopApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactsController {

    @Autowired
    public ContactsController() {
    }

    @GetMapping("/contacts")
    public String contactsPage() {
        return "contacts";
    }
}
