package com.bookapp.services;

import java.util.List;

import com.bookapp.client.model.Book;



public interface IBookClientService {
	
	public Book createNewBook(Book book) ;
	public Book getBook(int bookId);
	public List<Book> getAllBooks();
	public boolean deleteBookById(int bookId);
	public Book updateBook(Book book) ;
	

}
