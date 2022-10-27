package com.company.summative2.controller;

import com.company.summative2.model.Publisher;
import com.company.summative2.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PublisherController {

    @Autowired
    PublisherRepository publisherRepository;

    /* create a publisher */
    @PostMapping(value = "/publisher")
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher addPublisher(@RequestBody Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    /* get all publishers */
    @GetMapping(value = "/publisher")
    @ResponseStatus(HttpStatus.OK)
    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }

    /* get publisher by id */
    @GetMapping(value = "/publisher/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Publisher getPublisherById(@PathVariable int id) {
        Optional<Publisher> foundPublisher = publisherRepository.findById(id);
        return foundPublisher.orElse(null);
    }

    /* update book by id */
    @PutMapping(value = "/publisher/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Publisher updatePublisherById(@RequestBody Publisher publisher, @PathVariable int id) {

        Publisher updatedPublisher = publisherRepository.findById(id)
                .map(p -> {
                    p.setName(publisher.getName());
                    p.setStreet(publisher.getStreet());
                    p.setCity(publisher.getCity());
                    p.setState(publisher.getState());
                    p.setPostalCode(publisher.getPostalCode());
                    p.setPhone(publisher.getPhone());
                    p.setEmail(publisher.getEmail());
                    return publisherRepository.save(publisher);
                })
                .orElseGet(() -> {
                    publisher.setPublisher_id(id);
                    return publisherRepository.save(publisher);
                });
        return publisherRepository.save(publisher);
    }

    /* delete publisher by id */
    @DeleteMapping(value = "/publisher/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePublisherById(@PathVariable int id) {
        publisherRepository.deleteById(id);
    }
}
