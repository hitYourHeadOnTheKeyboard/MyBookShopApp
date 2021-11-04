package com.example.MyBookShopApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SearchController {
    @Autowired
    public SearchController() {
    }

    @GetMapping("/search")
    public String searchPage() {
        return "search/index";
    }

}
