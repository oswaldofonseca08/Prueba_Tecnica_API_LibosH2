package com.oswaldo.app.entity;

import jakarta.persistence.*;
import lombok.*;

// Indica que esta clase es una entidad JPA
@Entity
// Especifica el nombre de la tabla en la base de datos
@Table(name = "libros")
// Anotaciones de Lombok para generar automáticamente constructores, getters, setters y toString
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Book {

    // Indica que este atributo es la clave primaria de la entidad
    @Id
    // Genera automáticamente valores de clave primaria utilizando la estrategia de identidad
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Especifica el nombre de la columna en la tabla de base de datos y su configuración
    @Column(name = "titulo", nullable = false, length = 100)
    private String title;

    @Column(name = "autor", nullable = false, length = 100)
    private String author;

    @Column(name = "anio_publicacion", nullable = false)
    private Integer publicationYear;
}
