# Prueba Técnica: Desarrollo de una Aplicación Backend para Gestión de Libros

Este proyecto consiste en una aplicación backend que gestiona una pequeña base de datos de libros utilizando Spring Boot para el backend y una implementación sencilla de HTML, CSS y JavaScript para el frontend.

## Funcionalidades

- CRUD (Crear, Leer, Actualizar y Eliminar) de libros.
- Interfaz de usuario sencilla para interactuar con la API REST.

## Tecnologías Utilizadas

- Java
- Spring Boot
- H2 Database (base de datos en memoria)
- HTML
- CSS
- JavaScript
- Bootstrap

## Ejecución del Proyecto

### Requisitos Previos

- Java Development Kit (JDK) instalado en tu sistema.
- Un IDE para ejecutar la aplicación localmente.
- Postman instalado para probar la API directamente.

### Pasos para Ejecutar

1. Clona este repositorio en tu máquina local utilizando el siguiente comando:

    git clone git@github.com:oswaldofonseca08/Prueba_Tecnica_API_LibrosH2.git
   
2. Abre el proyecto en tu IDE favorito (como IntelliJ IDEA, Eclipse o Visual Studio Code).

3. Ejecuta la aplicación desde tu IDE.

4. Una vez que la aplicación esté en funcionamiento, puedes acceder a la interfaz de usuario desde tu navegador web en la siguiente dirección:

    [http://localhost:8080/index.html](http://localhost:8080/index.html)
    
    o simplemente
    
    [http://localhost:8080](http://localhost:8080)

A través de la interfaz, podrás realizar acciones como agregar, actualizar o borrar libros, además de mostrarte un listado con todos los libros dentro de la base de datos.

Dentro del proyecto, en la carpeta `resources`, se encuentra un archivo `import.sql` que contiene 10 inserciones de libros, los cuales se mostrarán por defecto cada vez que se ejecute la aplicación.

## Uso de la API REST

Puedes interactuar con la API REST utilizando herramientas como Postman. A continuación, se muestra un resumen de las operaciones disponibles:

- `GET /api/v1/books`: Obtiene todos los libros.
- `GET /api/v1/books/{id}`: Obtiene un libro por su ID.
- `POST /api/v1/books`: Crea un nuevo libro.
- `PUT /api/v1/books/{id}`: Actualiza un libro existente.
- `DELETE /api/v1/books/{id}`: Elimina un libro por su ID.

Para más detalles sobre cómo utilizar cada una de estas operaciones, consulta la documentación de la API o realiza pruebas utilizando Postman.

Adicionalmente, se ha agregado un archivo "Prueba_LibrosH2.postman_collection.json" dentro de la carpeta `resources`, el cual puede importarse en tu aplicación local de Postman para realizar las solicitudes con el formato requerido para que estas sean válidas.
