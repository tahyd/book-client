package com.bookapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bookapp.client.model.Book;
@Component
@Qualifier("resttemplate")
public class BookClientService implements IBookClientService {

	@Autowired
	private RestTemplate restTemplate;
	
	
	
	public BookClientService() {
		super();
		
		
	}

	@Override
	public Book createNewBook(Book book) {
		
		return null;
	}

	@Override
	public Book getBook(int bookId) {
		System.out.println("Y");
		
		return restTemplate.getForEntity("http://localhost:9091/book/"+bookId, Book.class).getBody();
	}

	@Override
	public List<Book> getAllBooks() {
		
		return null;
	}

	@Override
	public boolean deleteBookById(int bookId) {
		
		return false;
	}

	@Override
	public Book updateBook(Book book) {
		
		return null;
	}

}
