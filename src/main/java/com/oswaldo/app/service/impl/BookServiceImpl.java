package com.oswaldo.app.service.impl;

import com.oswaldo.app.entity.Book;
import com.oswaldo.app.repository.BookRepository;
import com.oswaldo.app.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book getBookById(Long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isPresent()) {
            return bookOptional.get();
        } else {
            throw new IllegalStateException("Book does not exist with id " + id);
        }
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book createBook(Book book) {
        book.setId(null); // Para asegurarse de que se cree un nuevo libro en lugar de actualizar uno existente
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Book book, Long id) {
        Book existingBook = getBookById(id); // Verifica si el libro existe
        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setPublicationYear(book.getPublicationYear());
        return bookRepository.save(existingBook);
    }

    @Override
    public void deleteBook(Long id) {
        Book existingBook = getBookById(id);
        bookRepository.delete(existingBook);
    }
}
