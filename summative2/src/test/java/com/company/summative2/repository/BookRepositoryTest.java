package com.company.summative2.repository;

import com.company.summative2.model.Author;
import com.company.summative2.model.Book;
import com.company.summative2.model.Publisher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Before
    public void setUp() throws Exception {
        bookRepository.deleteAll();
        authorRepository.deleteAll();
        publisherRepository.deleteAll();
    }

    /* testing get, create, delete */
    @Test
    public void getAddDeleteBook() {

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

        Publisher publisher = new Publisher();

        publisher.setName("Superani");
        publisher.setStreet("123 fake street");
        publisher.setCity("S");
        publisher.setPostalCode("90483");
        publisher.setState("NA");
        publisher.setPhone("89385022");
        publisher.setEmail("fake@superani.com");

        publisherRepository.save(publisher);

        Book book = new Book();

        book.setIsbn("8493842");
        book.setPublishDate(LocalDate.now());
        book.setAuthorId(author.getAuthorId());
        book.setTitle("Kim Jung Gi Sketch Collection");
        book.setPublisherId(publisher.getPublisher_id());
        book.setPrice(new BigDecimal("70.00"));

        bookRepository.save(book);

        Optional<Book> book1 = bookRepository.findById(book.getBookId());

        assertEquals(book1.get(), book);

        bookRepository.deleteById(book.getBookId());

        book1 = bookRepository.findById(book.getBookId());
        assertFalse(book1.isPresent());
    }

    /* testing getting all the books works */
    @Test
    public void getAllBooks() {

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

        Publisher publisher = new Publisher();

        publisher.setName("Superani");
        publisher.setStreet("123 fake street");
        publisher.setCity("S");
        publisher.setPostalCode("90483");
        publisher.setState("NA");
        publisher.setPhone("89385022");
        publisher.setEmail("fake@superani.com");

        publisherRepository.save(publisher);

        Book book = new Book();

        book.setIsbn("8493842");
        book.setPublishDate(LocalDate.now());
        book.setAuthorId(author.getAuthorId());
        book.setTitle("Kim Jung Gi Sketch Collection");
        book.setPublisherId(publisher.getPublisher_id());
        book.setPrice(new BigDecimal("70.00"));

        bookRepository.save(book);

        Author author1 = new Author();
        author1.setFirstName("Dong Ho");
        author1.setLastName("kim");
        author1.setStreet("123 fake street");
        author1.setCity("seoul");
        author1.setState("NA");
        author1.setPostalCode("858503");
        author1.setPhone("90930930");
        author1.setEmail("fake@fake.com");

        authorRepository.save(author1);

        Publisher publisher1 = new Publisher();

        publisher1.setName("Superani");
        publisher1.setStreet("123 fake street");
        publisher1.setCity("S");
        publisher1.setPostalCode("90483");
        publisher1.setState("NA");
        publisher1.setPhone("89385022");
        publisher1.setEmail("fake@superani.com");

        publisherRepository.save(publisher1);

        Book book1 = new Book();

        book1.setIsbn("8493842");
        book1.setPublishDate(LocalDate.now());
        book1.setAuthorId(author.getAuthorId());
        book1.setTitle("Perspective With Kim Dong Ho");
        book1.setPublisherId(publisher.getPublisher_id());
        book1.setPrice(new BigDecimal("70.00"));

        bookRepository.save(book1);

        assertEquals(2, bookRepository.findAll().size());
    }

    /* testing updating book works */
    @Test
    public void updateBook() {

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

        Publisher publisher = new Publisher();

        publisher.setName("Superani");
        publisher.setStreet("123 fake street");
        publisher.setCity("S");
        publisher.setPostalCode("90483");
        publisher.setState("NA");
        publisher.setPhone("89385022");
        publisher.setEmail("fake@superani.com");

        publisherRepository.save(publisher);

        Book book = new Book();

        book.setIsbn("8493842");
        book.setPublishDate(LocalDate.now());
        book.setAuthorId(author.getAuthorId());
        book.setTitle("Kim Jung Gi Sketch Collection");
        book.setPublisherId(publisher.getPublisher_id());
        book.setPrice(new BigDecimal("70.00"));

        bookRepository.save(book);

        book.setTitle("NEW BOOK TITLE");
        book.setIsbn("NEW ISBN");

        bookRepository.save(book);

        Optional<Book> book1 = bookRepository.findById(book.getBookId());
        assertEquals(book1.get(), book);
    }

    /* testing search book by author id */
    @Test
    public void getBookByAuthorId() {

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

        Publisher publisher = new Publisher();

        publisher.setName("Superani");
        publisher.setStreet("123 fake street");
        publisher.setCity("S");
        publisher.setPostalCode("90483");
        publisher.setState("NA");
        publisher.setPhone("89385022");
        publisher.setEmail("fake@superani.com");

        publisherRepository.save(publisher);

        Book book = new Book();

        book.setIsbn("8493842");
        book.setPublishDate(LocalDate.now());
        book.setAuthorId(author.getAuthorId());
        book.setTitle("Kim Jung Gi Sketch Collection");
        book.setPublisherId(publisher.getPublisher_id());
        book.setPrice(new BigDecimal("70.00"));

        bookRepository.save(book);

        List<Book> foundBooks = bookRepository.findAllBooksByAuthorId(author.getAuthorId());

        /* only one book entered so the size of the list should be one */
        assertEquals(1, foundBooks.size());

        /* assigning the book found */
        Book foundBook = foundBooks.get(0);

        /* the found book from the author id should equal the created book */
        assertEquals(foundBook, book);
    }

}