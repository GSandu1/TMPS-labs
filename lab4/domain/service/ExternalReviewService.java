package domain.service;
public class ExternalReviewService {
    public void addReview(String bookTitle, String comment, int rating) {
        // Assume this is an external service with a different method to add a review
        System.out.println("External Service: Review added for book " + bookTitle);
    }
}
