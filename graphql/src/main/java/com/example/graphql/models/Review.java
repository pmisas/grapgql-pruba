package com.example.graphql.models;

import java.util.Arrays;
import java.util.List;

public record Review(String id, String bookId, String reviewer, int rating, String comment) {

    private static List<Review> reviews = Arrays.asList(
            new Review("review-1", "book-1", "Bloch", 5, "Great book!"),
            new Review("review-2", "book-2", "Adams", 4, "Good read"),
            new Review("review-3", "book-3", "Paula", 5, "Badjob")
    );

    public static Review getById(String id) {
        return reviews.stream()
                .filter(review -> review.id().equals(id))
                .findFirst()
                .orElse(null);
    }
}
