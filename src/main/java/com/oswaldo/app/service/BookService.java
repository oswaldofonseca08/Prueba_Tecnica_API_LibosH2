package com.oswaldo.app.service;

import java.util.List;
import com.oswaldo.app.entity.Book;

public interface BookService {
	
	Book getBookById(Long id);
    List<Book> getAllBooks();
    Book createBook(Book book);
    Book updateBook(Book book, Long id);
    void deleteBook(Long id);

}
