package com.company.summative2.repository;

import com.company.summative2.model.Book;
import com.company.summative2.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Integer> {

}
