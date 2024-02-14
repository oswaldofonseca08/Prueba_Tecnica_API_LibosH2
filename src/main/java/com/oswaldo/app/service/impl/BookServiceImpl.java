package com.oswaldo.app.service.impl;

import com.oswaldo.app.entity.Book;
import com.oswaldo.app.repository.BookRepository;
import com.oswaldo.app.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Implementación del servicio que gestiona la lógica de la aplicacion de libros
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    // Obtiene un libro por su ID
    @Override
    public Book getBookById(Long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isPresent()) {
            return bookOptional.get();
        } else {
            throw new IllegalStateException("Book does not exist with id " + id);
        }
    }

    // Obtiene todos los libros
    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Crea un nuevo libro
    @Override
    public Book createBook(Book book) {
        book.setId(null); // Para asegurarse de que se cree un nuevo libro en lugar de actualizar uno existente
        return bookRepository.save(book);
    }

    // Actualiza un libro existente
    @Override
    public Book updateBook(Book book, Long id) {
        Book existingBook = getBookById(id); // Verifica si el libro existe
        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setPublicationYear(book.getPublicationYear());
        return bookRepository.save(existingBook);
    }

    // Elimina un libro por su ID
    @Override
    public void deleteBook(Long id) {
        Book existingBook = getBookById(id);
        bookRepository.delete(existingBook);
    }
}
