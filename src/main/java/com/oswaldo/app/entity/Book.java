package com.oswaldo.app.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "libros")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo", nullable = false, length = 100)
    private String title;

    @Column(name = "autor", nullable = false, length = 100)
    private String author;

    @Column(name = "anio_publicacion", nullable = false)
    private Integer publicationYear;
}
