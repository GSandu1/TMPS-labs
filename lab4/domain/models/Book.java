package domain.models;

import domain.interfaces.Buyable;
import domain.interfaces.Reviewable;
import domain.interfaces.Discountable;
import domain.interfaces.Subject;
import domain.interfaces.Observer;

import java.util.ArrayList;
import java.util.List;

public class Book implements Buyable, Reviewable, Discountable, Cloneable, Subject {
    private String title;
    private String author;
    private String genre;
    private double price;
    private int stockCount;
    private List<Review> reviews = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();

    public Book(String title, String author, String genre, double price, int stockCount) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.price = price;
        this.stockCount = stockCount;
    }

    // Implementing clone method
    @Override
    public Book clone() {
        try {
            return (Book) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); // Can't happen as we implement Cloneable
        }
    }

    // Getter and Setter methods
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    public int getStockCount() {
        return stockCount;
    }

    public void setStockCount(int stockCount) {
        this.stockCount = stockCount;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    // Other methods
    @Override
    public void applyDiscount(int percentage) {
        double discountedPrice = price - (price * percentage / 100.0);
        setPrice(discountedPrice);
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update("A new review has been added to the book: " + this.getTitle());
        }
    }

    @Override
    public void addReview(Review review) {
        reviews.add(review);
        notifyObservers();
    }

}