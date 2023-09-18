package domain.models;

import domain.interfaces.Buyable;
import domain.interfaces.Reviewable;
import domain.interfaces.Discountable;
import java.util.ArrayList;
import java.util.List;

public class Book implements Buyable, Reviewable, Discountable {
    private String title;
    private String author;
    private String genre;
    private double price;
    private int stockCount;
    private List<Review> reviews = new ArrayList<>();

    public Book(String title, String author, String genre, double price, int stockCount) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.price = price;
        this.stockCount = stockCount;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }
    @Override
    public void addReview(Review review) {
        reviews.add(review);
    }

    @Override
    public void applyDiscount(int percentage) {
        double discountedPrice = price - (price * percentage / 100.0);
        setPrice(discountedPrice);
    }
}
