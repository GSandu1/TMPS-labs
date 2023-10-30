package domain.interfaces;

import domain.models.Book;
import domain.models.Customer;

public interface IReviewService {
    void leaveReview(Customer customer, Book book, String comment, int rating);
}
