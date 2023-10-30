package domain.models;

import domain.interfaces.Cloneable;

public class BookPrototype implements Cloneable {
    private final Book book;

    public BookPrototype(Book book) {
        this.book = book;
    }

    @Override
    public BookPrototype clone() {
        return new BookPrototype(book.clone());
    }

    public Book getBook() {
        return book;
    }
}
