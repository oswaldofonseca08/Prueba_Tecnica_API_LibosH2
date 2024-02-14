package com.oswaldo.app.controller;

import com.oswaldo.app.entity.Book;
import com.oswaldo.app.service.BookService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping
    public List<Book> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return books;
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable("id") Long bookId) {
        log.info("Se solicita los datos del id: " + bookId);
        Book book = bookService.getBookById(bookId);
        return book;
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        log.info("Se está creando un nuevo libro");
        log.info(book);
        Book newBook = bookService.createBook(book);
        return newBook;
    }

    @PutMapping("/{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable("id") Long bookId) {
        return bookService.updateBook(book, bookId);
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable("id") Long bookId) {
        bookService.deleteBook(bookId);
        return "Se eliminó el libro con ID " + bookId;
    }
}