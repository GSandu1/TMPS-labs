package domain.models;

import domain.interfaces.DiscountStrategy;

public class DiscountedBook extends Book {
    private DiscountStrategy discountStrategy;

    // Constructor that accepts a Book object and a DiscountStrategy
    public DiscountedBook(Book book, DiscountStrategy discountStrategy) {
        super(book.getTitle(), book.getAuthor(), book.getGenre(), book.getPrice(), book.getStockCount());
        this.discountStrategy = discountStrategy;
        applyDiscount();
    }

    private void applyDiscount() {
        double discountedPrice = discountStrategy.applyDiscount(getPrice());
        setPrice(discountedPrice);
    }

    // If you have other methods specific to DiscountedBook, you can add them here

    // Example: If you want to change the discount strategy later and reapply it
    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
        applyDiscount();
    }

    // Any other functionalities you want to add to DiscountedBook...
}
