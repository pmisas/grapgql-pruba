package com.example.graphql.Controller;


import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import com.example.graphql.models.Author;
import com.example.graphql.models.Book;
import com.example.graphql.models.Review;

import java.util.List;

@Controller
public class BookController {
    @QueryMapping
    public Book bookById(@Argument String id) {
        return Book.getById(id);
    }

    @QueryMapping
    public List<Book> books() {
        return Book.getAll();
    }

    @QueryMapping
    public Review reviewById(@Argument String id) {
        return Review.getById(id);
    }

    @SchemaMapping
    public Book book(Review review) {
        return Book.getById(review.bookId());
    }

    @SchemaMapping
    public Author author(Book book) {
        return Author.getById(book.authorId());
    }
}