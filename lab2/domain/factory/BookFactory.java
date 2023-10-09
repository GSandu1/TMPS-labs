package domain.factory;

import domain.models.Book;

public class BookFactory {
    public Book createBook(String title, String author, String genre, double price, int stockCount) {
        return new Book(title, author, genre, price, stockCount);
    }
}
