package domain.models;

public class BookBuilder {
    private String title;
    private String author;
    private String genre;
    private double price;
    private int stockCount;

    public BookBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public BookBuilder setAuthor(String author) {
        this.author = author;
        return this;
    }

    public BookBuilder setGenre(String genre) {
        this.genre = genre;
        return this;
    }

    public BookBuilder setPrice(double price) {
        this.price = price;
        return this;
    }

    public BookBuilder setStockCount(int stockCount) {
        this.stockCount = stockCount;
        return this;
    }

    public Book build() {
        return new Book(title, author, genre, price, stockCount);
    }
}
