package domain.models;

public class BookProxy extends Book {
    private Book realBook;

    public BookProxy(String title, String author, String genre, double price, int stockCount) {
        super(title, author, genre, price, stockCount);
        realBook = new Book(title, author, genre, price, stockCount);
    }

    @Override
    public double getPrice() {
        System.out.println("Accessing book price");
        return realBook.getPrice();
    }
}
