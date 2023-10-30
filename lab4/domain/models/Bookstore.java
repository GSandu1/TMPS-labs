package domain.models;

import java.util.List;
import java.util.ArrayList;

public class Bookstore {
    private String name;
    private List<Book> inventory = new ArrayList<>();

    public Bookstore(String name) {
        this.name = name;
    }

    public void addBook(Book book) {
        inventory.add(book);
    }
}