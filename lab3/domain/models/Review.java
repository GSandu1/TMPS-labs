package domain.models;

public class Review {
    private Customer reviewer;
    private String comment;
    private int rating;  //stars.

    public Review(Customer reviewer, String comment, int rating) {
        this.reviewer = reviewer;
        this.comment = comment;
        this.rating = rating;
    }
}