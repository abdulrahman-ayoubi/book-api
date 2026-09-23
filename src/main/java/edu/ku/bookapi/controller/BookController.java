package edu.ku.bookapi.controller;

import edu.ku.bookapi.model.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    private Long nextId = 6L;

    private final List<Book> books = new ArrayList<>(List.of(
            new Book(1L, "Clean Code", "Robert C. Martin",
                    "9780132350884", 2008, "Software Engineering"),

            new Book(2L, "Effective Java", "Joshua Bloch",
                    "9780134685991", 2018, "Java"),

            new Book(3L, "Designing Data-Intensive Applications",
                    "Martin Kleppmann", "9781449373320", 2017,
                    "Distributed Systems"),

            new Book(4L, "Spring in Action", "Craig Walls",
                    "9781617297571", 2022, "Spring"),

            new Book(5L, "Computer Networks", "Andrew S. Tanenbaum",
                    "9780132126953", 2010, "Networking")
    ));

    // POST - Add book
    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {

        book.setId(nextId++);

        books.add(book);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(book);
    }

    // GET - Get all books
    @GetMapping
    public List<Book> getAllBooks() {
        return books;
    }
    // GET book by ID
    @GetMapping("/{bookId}")
    public ResponseEntity<Book> getBookById(@PathVariable Long bookId) {

        for (Book book : books) {

            if (book.getId().equals(bookId)) {
                return ResponseEntity.ok(book);
            }
        }

        return ResponseEntity.notFound().build();
    }
    // PUT - Update book
    @PutMapping("/{bookId}")
    public ResponseEntity<Book> updateBook(
            @PathVariable Long bookId,
            @RequestBody Book input
    ) {

        for (int i = 0; i < books.size(); i++) {

            Book book = books.get(i);

            if (book.getId().equals(bookId)) {

                Book updatedBook = new Book(
                        book.getId(),
                        input.getTitle(),
                        input.getAuthor(),
                        input.getIsbn(),
                        input.getPublishedYear(),
                        input.getCategory()
                );

                books.set(i, updatedBook);

                return ResponseEntity.ok(updatedBook);
            }
        }

        return ResponseEntity.notFound().build();
    }

    // DELETE - Delete book
    @DeleteMapping("/{bookId}")
    public ResponseEntity<Void> deleteBook(
            @PathVariable Long bookId
    ) {

        boolean removed = books.removeIf(
                book -> book.getId().equals(bookId)
        );

        if (removed) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}