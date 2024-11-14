package com.example.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.graphql.models.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
