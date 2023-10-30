package domain.service;

import domain.interfaces.IReviewService;
import domain.models.Book;
import domain.models.Customer;
import domain.service.ExternalReviewService;

public class ExternalReviewServiceAdapter implements IReviewService {

    private ExternalReviewService externalReviewService;

    public ExternalReviewServiceAdapter(ExternalReviewService externalReviewService) {
        this.externalReviewService = externalReviewService;
    }

    @Override
    public void leaveReview(Customer customer, Book book, String comment, int rating) {
        externalReviewService.addReview(book.getTitle(), comment, rating);
    }
}
