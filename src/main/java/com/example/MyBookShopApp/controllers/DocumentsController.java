package com.example.MyBookShopApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DocumentsController {

    @Autowired
    public DocumentsController() {
    }

    @GetMapping("/documents")
    public String documentsPage() {
        return "documents/index";
    }
}
