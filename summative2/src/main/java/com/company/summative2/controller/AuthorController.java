package com.company.summative2.controller;

import com.company.summative2.model.Author;
import com.company.summative2.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    /* create an author */
    @PostMapping(value = "/author")
    @ResponseStatus(HttpStatus.CREATED)
    public Author addAuthor(@RequestBody Author author) {
        return authorRepository.save(author);
    }

    /* get all authors */
    @GetMapping(value = "/author")
    @ResponseStatus(HttpStatus.OK)
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    /* get author by id */
    @GetMapping(value  = "/author/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Author getAuthorById(@PathVariable int id) {
        Optional<Author> foundAuthor = authorRepository.findById(id);
        return foundAuthor.orElse(null);
    }

    /* update author by id */
    @PutMapping(value = "/author/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Author updateAuthor(@RequestBody Author author, @PathVariable int id) {

        Author updatedAuthor = authorRepository.findById(id)
                .map( a -> {
                    a.setFirstName(author.getFirstName());
                    a.setLastName(author.getLastName());
                    a.setStreet(author.getStreet());
                    a.setCity(author.getCity());
                    a.setState(author.getState());
                    a.setPostalCode(author.getPostalCode());
                    a.setPhone(author.getPhone());
                    a.setEmail(author.getEmail());
                    return authorRepository.save(author);
                })
                .orElseGet(() -> {
                    author.setAuthorId(id);
                    return authorRepository.save(author);
                });
        return authorRepository.save(author);
    }

    /* delete author by id */
    @DeleteMapping(value = "/author/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAuthor(@PathVariable int id) {
        authorRepository.deleteById(id);
    }
}
