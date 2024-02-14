// URL de la API
const baseUrl = 'http://localhost:8080/api/v1/books';

// Función para cargar la lista de libros desde la API
function loadBooks() {
  fetch(baseUrl)
    .then(response => response.json())
    .then(data => {
      // La solicitud se completó exitosamente
      const bookList = document.getElementById('book-list');
      bookList.innerHTML = '';
      data.forEach(book => {
        const listItem = document.createElement('li');
        listItem.className = 'list-group-item';
        listItem.textContent = `${book.title} - ${book.author} (${book.publicationYear})`;

        // Agregar botones para editar y borrar
        const editButton = document.createElement('button');
        editButton.textContent = 'Editar';
        editButton.className = 'btn btn-primary btn-sm ms-2';
        editButton.addEventListener('click', () => editBook(book));

        const deleteButton = document.createElement('button');
        deleteButton.textContent = 'Eliminar';
        deleteButton.className = 'btn btn-danger btn-sm ms-2';
        deleteButton.addEventListener('click', () => confirmDelete(book.id));

        listItem.appendChild(editButton);
        listItem.appendChild(deleteButton);

        bookList.appendChild(listItem);
      });
    })
    .catch(error => {
      // Hubo un error en la solicitud
      console.error('Error al cargar libros:', error);
    });
}

// Función para mostrar el formulario de editar libro con los datos del libro seleccionado
function editBook(book) {
  const editForm = document.getElementById('edit-book-form');
  editForm.classList.remove('d-none');
  document.getElementById('edit-book-id').value = book.id;
  document.getElementById('edit-title').value = book.title;
  document.getElementById('edit-author').value = book.author;
  document.getElementById('edit-publicationYear').value = book.publicationYear;
}

// Evento para cancelar la edición de un libro
document.getElementById('cancel-edit').addEventListener('click', function () {
  document.getElementById('edit-book-form').classList.add('d-none');
});

// Función para mostrar el formulario de confirmación para eliminar un libro
function confirmDelete(bookId) {
  const deleteForm = document.getElementById('delete-book-form');
  deleteForm.classList.remove('d-none');
  document.getElementById('delete-book-id').value = bookId;
}

// Evento para cancelar la eliminación de un libro
document.getElementById('cancel-delete').addEventListener('click', function () {
  document.getElementById('delete-book-form').classList.add('d-none');
});

// Evento para enviar el formulario de agregar libro
document.getElementById('add-book-form').addEventListener('submit', function (event) {
  event.preventDefault();
  const title = document.getElementById('title').value;
  const author = document.getElementById('author').value;
  const publicationYear = document.getElementById('publicationYear').value;
  const newBook = { title, author, publicationYear };

  fetch(baseUrl, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(newBook)
  })
    .then(response => response.json())
    .then(data => {
      // La solicitud se completó exitosamente
      console.log('Libro agregado:', data);
      loadBooks();
    })
    .catch(error => {
      // Hubo un error en la solicitud
      console.error('Error al agregar libro:', error);
    });

  this.reset();
});

// Evento para enviar el formulario de editar libro
document.getElementById('edit-book-form').addEventListener('submit', function (event) {
  event.preventDefault();
  const id = document.getElementById('edit-book-id').value;
  const title = document.getElementById('edit-title').value;
  const author = document.getElementById('edit-author').value;
  const publicationYear = document.getElementById('edit-publicationYear').value;
  const editedBook = { id, title, author, publicationYear };

  fetch(`${baseUrl}/${id}`, {
    method: 'PUT',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(editedBook)
  })
    .then(response => response.json())
    .then(data => {
      // La solicitud se completó exitosamente
      console.log('Libro editado:', data);
      loadBooks();
    })
    .catch(error => {
      // Hubo un error en la solicitud
      console.error('Error al editar libro:', error);
    });

  this.reset();
});

// Evento para enviar el formulario de eliminar libro
document.getElementById('delete-book-form').addEventListener('submit', function (event) {
  event.preventDefault();
  const id = document.getElementById('delete-book-id').value;

  fetch(`${baseUrl}/${id}`, {
    method: 'DELETE'
  })
    .then(response => {
      // La solicitud se completó exitosamente
      console.log('Libro eliminado:', id);
      loadBooks();
    })
    .catch(error => {
      // Hubo un error en la solicitud
      console.error('Error al eliminar libro:', error);
    });

  this.reset();
});

// Llama a la función loadBooks cuando se carga la página para mostrar los libros existentes
loadBooks();