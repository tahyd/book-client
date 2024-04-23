package com.bookapp.services;

import java.io.ObjectInputFilter.Status;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import com.bookapp.client.exception.BookNotFoundException;
import com.bookapp.client.model.Book;

@Component
@Qualifier("restclient")
public class BookClientServiceByRestClient implements IBookClientService {

      @Autowired	
	private RestClient client;
	
	
	@Override
	public Book createNewBook(Book book) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book getBook(int bookId) {
		
		return client.get().uri("/book/"+bookId).retrieve()
				.onStatus((status)->status.value()==404, (request,response)-> {throw new BookNotFoundException("Book not found");})
				.body(Book.class);
	}

	@Override
	public List<Book> getAllBooks() {
		
		return  client.get().uri("/book") 
				.retrieve().body(new ParameterizedTypeReference<>() {});
	}

	@Override
	public boolean deleteBookById(int bookId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Book updateBook(Book book) {
		// TODO Auto-generated method stub
		return null;
	}

}
