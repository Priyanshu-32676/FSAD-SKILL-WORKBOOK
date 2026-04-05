package com.klef.exp6.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klef.exp6.Model.Book;

@RestController
@RequestMapping("/Library")
public class LibraryController {
	
	 List<Book> bookList = new ArrayList<>();
	
	@GetMapping("/welcome")
	public static String welcome() {
		return "Welcome to Library store";
	}
	
	@GetMapping("/count")
	public static int getbookcount() {
		return 100;
	}
	
	@GetMapping("/price")
	public static double getprice() {
		return 149.5;
	}
		
	 @GetMapping("/books")
    public List<String> getBooks() {
        List<String> books = new ArrayList<>();
        books.add("Java Programming");
        books.add("Spring Boot Guide");
        books.add("Data Structures");
        return books;
    }
	 
	 @GetMapping("/books/{id}")
	    public String getBookById(@PathVariable int id) {
	        return "Details of Book with ID: " + id;
	    }

	    @GetMapping("/search")
	    public String searchBook(@RequestParam String title) {
	        return "You searched for book: " + title;
	    }

	    @GetMapping("/author/{name}")
	    public String getAuthor(@PathVariable String name) {
	        return "Books written by Author: " + name;
	    }

	    @PostMapping("/addbook")
	    public String addBook(@RequestBody Book book) {
	        bookList.add(book);
	        return "Book Added Successfully";
	    }

	    @GetMapping("/viewbooks")
	    public List<Book> viewBooks() {
	        return bookList;
	    }
	    
	
	

}
