package com.oswaldo.app.service;

import java.util.List;
import com.oswaldo.app.entity.Book;

// Interfaz que define los métodos que deben ser implementados por las clases de servicio de libros
public interface BookService {
	
    // Obtiene un libro por su ID
    Book getBookById(Long id);
    // Obtiene todos los libros
    List<Book> getAllBooks();
    // Crea un nuevo libro
    Book createBook(Book book);
    // Actualiza un libro existente
    Book updateBook(Book book, Long id);
    // Elimina un libro por su ID
    void deleteBook(Long id);
}
