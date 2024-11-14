package com.example.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.graphql.models.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
