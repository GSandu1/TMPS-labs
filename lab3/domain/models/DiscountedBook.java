package domain.models;

public class DiscountedBook extends BookDecorator {
    private double discountRate;

    public DiscountedBook(Book decoratedBook, double discountRate) {
        super(decoratedBook);
        this.discountRate = discountRate;
    }

    @Override
    public double getPrice() {
        double originalPrice = super.getPrice();
        return originalPrice - (originalPrice * discountRate / 100);
    }
}
