package com.company.summative2.repository;

import com.company.summative2.model.Author;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AuthorRepositoryTest {

    @Autowired
    private AuthorRepository authorRepository;


    @Before
    public void setUp() throws Exception {
        authorRepository.deleteAll();
    }

    /* testing create, get, delete */
    @Test
    public void addGetDeleteAuthor() {

        Author author = new Author();

        author.setFirstName("jung gi");
        author.setLastName("kim");
        author.setStreet("123 fake street");
        author.setCity("seoul");
        author.setState("NA");
        author.setPostalCode("858503");
        author.setPhone("90930930");
        author.setEmail("fake@fake.com");

        author = authorRepository.save(author);

        Optional<Author> author1 = authorRepository.findById(author.getAuthorId());

        assertEquals(author1.get(), author);

        authorRepository.deleteById(author.getAuthorId());

        author1 = authorRepository.findById(author.getAuthorId());

        assertFalse(author1.isPresent());
    }

    /* making sure all the authors are retrieved */
    @Test
    public void getAllAuthors() {

        Author author = new Author();
        author.setFirstName("jung gi");
        author.setLastName("kim");
        author.setStreet("123 fake street");
        author.setCity("seoul");
        author.setState("NA");
        author.setPostalCode("858503");
        author.setPhone("90930930");
        author.setEmail("fake@fake.com");

        authorRepository.save(author);

        Author author2 = new Author();
        author2.setFirstName("karl");
        author2.setLastName("kopinski");
        author2.setStreet("123 fake street");
        author2.setCity("superani land");
        author2.setState("NA");
        author2.setPostalCode("858503");
        author2.setPhone("90930930");
        author2.setEmail("fake@fake.com");

        authorRepository.save(author2);

        List<Author> authorList = authorRepository.findAll();

        assertEquals(authorList.size(), 2);
    }

    /* making sure the author was successfully updated */
    @Test
    public void updateAuthor() {

        Author author = new Author();
        author.setFirstName("jung gi");
        author.setLastName("kim");
        author.setStreet("123 fake street");
        author.setCity("seoul");
        author.setState("NA");
        author.setPostalCode("858503");
        author.setPhone("90930930");
        author.setEmail("fake@fake.com");

        authorRepository.save(author);

        author.setFirstName("karl");
        author.setLastName("kopinski");
        author.setStreet("123 fake street");
        author.setCity("superani land");
        author.setState("NA");
        author.setPostalCode("858503");
        author.setPhone("90930930");
        author.setEmail("fake@fake.com");

        authorRepository.save(author);

        Optional<Author> updatedAuthor = authorRepository.findById(author.getAuthorId());
        assertEquals(updatedAuthor.get(), author);
    }
}