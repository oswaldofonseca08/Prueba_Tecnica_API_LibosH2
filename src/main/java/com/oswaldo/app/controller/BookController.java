package com.oswaldo.app.controller;

import com.oswaldo.app.entity.Book;
import com.oswaldo.app.service.BookService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Clase controladora que maneja las solicitudes relacionadas con los libros
@Log4j2
// Permite solicitudes desde cualquier origen
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    // Inyección de dependencia del servicio de libros
    @Autowired
    BookService bookService;

    // Maneja la solicitud GET para obtener todos los libros
    @GetMapping
    public List<Book> getAllBooks() {
        // Obtiene todos los libros del servicio
        List<Book> books = bookService.getAllBooks();
        return books;
    }

    // Maneja la solicitud GET para obtener un libro por su ID
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable("id") Long bookId) {
        // Registra la solicitud en el log
        log.info("Se solicita los datos del id: " + bookId);
        // Obtiene el libro del servicio utilizando el ID proporcionado
        Book book = bookService.getBookById(bookId);
        return book;
    }

    // Maneja la solicitud POST para crear un nuevo libro
    @PostMapping
    public Book createBook(@RequestBody Book book) {
        // Registra la creación del nuevo libro en el log
        log.info("Se está creando un nuevo libro");
        log.info(book);
        // Crea un nuevo libro utilizando el servicio
        Book newBook = bookService.createBook(book);
        return newBook;
    }

    // Maneja la solicitud PUT para actualizar un libro existente
    @PutMapping("/{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable("id") Long bookId) {
        // Actualiza el libro existente utilizando el servicio
        return bookService.updateBook(book, bookId);
    }

    // Maneja la solicitud DELETE para eliminar un libro por su ID
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable("id") Long bookId) {
        // Elimina el libro utilizando el servicio
        bookService.deleteBook(bookId);
        return "Se eliminó el libro con ID " + bookId;
    }
}