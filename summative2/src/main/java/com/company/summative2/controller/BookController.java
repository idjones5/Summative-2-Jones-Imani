package com.company.summative2.controller;

import com.company.summative2.model.Book;
import com.company.summative2.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    BookRepository bookRepository;

    /* create a book */
    @PostMapping(value = "/book")
    @ResponseStatus(HttpStatus.CREATED)
    public Book addBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    /* get all books */
    @GetMapping(value = "/book")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    /* get book by id */
    @GetMapping(value = "/book/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book getBookById(@PathVariable int id) {
        Optional<Book> foundBook = bookRepository.findById(id);
        return foundBook.orElse(null);
    }

    /* get a book by author id */
    @GetMapping(value = "/book/author/{authorId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getBookByAuthor(@PathVariable int authorId) {
        return bookRepository.findAllBooksByAuthorId(authorId);
    }

    /* update book by id */
    @PutMapping(value = "/book/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Book updateBookById(@RequestBody Book book, @PathVariable int id) {

        Book updatedBook = bookRepository.findById(id)
                .map(b -> {
                    b.setIsbn(book.getIsbn());
                    b.setPublishDate(book.getPublishDate());
                    b.setAuthorId(book.getAuthorId());
                    b.setTitle(book.getTitle());
                    b.setPublisherId(book.getPublisherId());
                    b.setPrice(book.getPrice());
                    return bookRepository.save(book);
                })
                .orElseGet(() -> {
                    book.setBookId(id);
                    return bookRepository.save(book);
                });
        return bookRepository.save(book);
    }

    /* delete book by id */
    @DeleteMapping(value = "/book/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBookById(@PathVariable int id) {
        bookRepository.deleteById(id);
    }

}
