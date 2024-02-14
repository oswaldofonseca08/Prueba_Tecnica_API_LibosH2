package com.oswaldo.app.repository;

import com.oswaldo.app.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// Repositorio que maneja la interacción con la base de datos para la entidad Book
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	
	// Los siguientes métodos no se utilizan en esta aplicación,
    // pero están disponibles en caso de que se necesiten en el futuro.
    
    // Encuentra libros cuyo título contiene la palabra clave, ignorando mayúsculas y minúsculas
    List<Book> findByTitleContainingIgnoreCase(String keyword);
    
    // Encuentra libros cuyo autor contiene la palabra clave, ignorando mayúsculas y minúsculas
    List<Book> findByAuthorContainingIgnoreCase(String keyword);
}
