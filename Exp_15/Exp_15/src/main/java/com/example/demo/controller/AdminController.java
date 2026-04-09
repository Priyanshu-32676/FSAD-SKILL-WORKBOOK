package com.example.demo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @PostMapping("/add")
    public String addEmployee() {
        return "Employee Added";
    }

    @DeleteMapping("/delete")
    public String deleteEmployee() {
        return "Employee Deleted";
    }
}