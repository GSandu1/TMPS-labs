package domain.service;

import domain.models.*;

public class ReviewService {
    public void leaveReview(Customer customer, Book book, String comment, int rating) {
        Review review = new Review(customer, comment, rating);
        book.addReview(review);
        System.out.println(customer.getName() + " left a review for the book: " + book.getTitle());
    }
}
