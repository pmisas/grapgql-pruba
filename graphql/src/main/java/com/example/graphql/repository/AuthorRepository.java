package com.example.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.graphql.models.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
