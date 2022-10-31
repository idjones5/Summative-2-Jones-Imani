package com.company.summative2.repository;

import com.company.summative2.model.Publisher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PublisherRepositoryTest {

    @Autowired
    private PublisherRepository publisherRepository;

    @Before
    public void setUp() throws Exception {
        publisherRepository.deleteAll();;
    }

    /* testing create, get, delete */
    @Test
    public void getAddDeletePublisher() {
        Publisher publisher = new Publisher();

        publisher.setName("Superani");
        publisher.setStreet("123 fake street");
        publisher.setCity("S");
        publisher.setPostalCode("90483");
        publisher.setState("NA");
        publisher.setPhone("89385022");
        publisher.setEmail("fake@superani.com");

        publisher = publisherRepository.save(publisher);

        Optional<Publisher> publisher1 = publisherRepository.findById(publisher.getPublisher_id());

        assertEquals(publisher1.get(), publisher);

        publisherRepository.deleteById(publisher.getPublisher_id());

        publisher1 = publisherRepository.findById(publisher.getPublisher_id());

        assertFalse(publisher1.isPresent());
    }

    /* testing that getting all publishers works */
    @Test
    public void getAllAuthors() {

        Publisher publisher = new Publisher();

        publisher.setName("Superani");
        publisher.setStreet("123 fake street");
        publisher.setCity("S");
        publisher.setPostalCode("90483");
        publisher.setState("NA");
        publisher.setPhone("89385022");
        publisher.setEmail("fake@superani.com");

        publisherRepository.save(publisher);

        Publisher publisher1 = new Publisher();

        publisher1.setName("Superani2");
        publisher1.setStreet("123 fake street");
        publisher1.setCity("SE");
        publisher1.setPostalCode("90483");
        publisher1.setState("NA");
        publisher1.setPhone("89385022");
        publisher1.setEmail("fake@superani.com");

        publisherRepository.save(publisher1);

        assertEquals(2, publisherRepository.findAll().size());
    }

    /* testing that updating publisher works */
    @Test
    public void updatePublisher() {
        Publisher publisher = new Publisher();

        publisher.setName("Superani");
        publisher.setStreet("123 fake street");
        publisher.setCity("S");
        publisher.setPostalCode("90483");
        publisher.setState("NA");
        publisher.setPhone("89385022");
        publisher.setEmail("fake@superani.com");

        publisherRepository.save(publisher);

        publisher.setName("NEW PUBLISHER NAME");
        publisher.setEmail("NEWEMAIL@FAKE.com");
        publisher.setState("NE");

        publisherRepository.save(publisher);

        Optional<Publisher> publisherTest = publisherRepository.findById(publisher.getPublisher_id());
        assertEquals(publisherTest.get(), publisher);
    }
}