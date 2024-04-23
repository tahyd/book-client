package com.bookapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bookapp.client.model.Book;
import com.bookapp.services.IBookClientService;

@RestController
public class BookClientController {
	
	
	@Autowired
	@Qualifier("restclient")
	IBookClientService bookclient;
	@GetMapping("/hello")
	public String index() {
		return "Hello";
	}
	
	@GetMapping("/getbook/{bookid}")
	public Book getBook(@PathVariable("bookid") int id) {
		System.out.println("X");
		return bookclient.getBook(id);
	}
	

	@GetMapping("/getbook")
	public List<Book> getBooks(){
		
		return bookclient.getAllBooks();
	}
}
