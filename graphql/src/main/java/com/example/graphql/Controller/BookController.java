package com.example.graphql.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import com.example.graphql.models.Author;
import com.example.graphql.models.Book;
import com.example.graphql.models.Review;
import com.example.graphql.repository.AuthorRepository;
import com.example.graphql.repository.BookRepository;
import com.example.graphql.repository.ReviewRepository;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    // --- Query Mappings ---
    @QueryMapping
    public Book bookById(@Argument Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @QueryMapping
    public List<Book> books() {
        return bookRepository.findAll();
    }

    @QueryMapping
    public Review reviewById(@Argument Long id) {
        return reviewRepository.findById(id).orElse(null);
    }

    @SchemaMapping
    public Author author(Book book) {
        return authorRepository.findById(book.getAuthorId()).orElse(null);
    }

    @SchemaMapping
    public Book book(Review review) {
        return bookRepository.findById(review.getBookId()).orElse(null);
    }

    // --- Mutation Mappings ---
    @MutationMapping
    public Book addBook(@Argument String name, @Argument int pageCount, @Argument Long authorId) {
        Book book = new Book();
        book.setName(name);
        book.setPageCount(pageCount);
        book.setAuthorId(authorId);
        return bookRepository.save(book);
    }

    @MutationMapping
    public Author addAuthor(@Argument String firstName, @Argument String lastName) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);
        return authorRepository.save(author);
    }

    @MutationMapping
    public Review addReview(@Argument Long bookId, @Argument String reviewer, @Argument int rating, @Argument String comment) {
        Review review = new Review();
        review.setBookId(bookId);
        review.setReviewer(reviewer);
        review.setRating(rating);
        review.setComment(comment);
        return reviewRepository.save(review);
    }
}
