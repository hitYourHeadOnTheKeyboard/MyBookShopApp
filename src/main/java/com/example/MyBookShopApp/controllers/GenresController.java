package com.example.MyBookShopApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GenresController {

    @Autowired
    public GenresController() {
    }

    @GetMapping("/genres")
    public String genresPage() {
        return "genres/index";
    }
}
