package domain.models;

import domain.interfaces.ICustomer;
import domain.models.Book;
import domain.models.Membership;

public class Customer implements ICustomer {
    private final String name;
    private final String email;
    private Membership membership;

    public Customer(String name, String email, Membership membership) {
        this.name = name;
        this.email = email;
        this.membership = membership;
    }

    @Override
    public void buy(Book book) {
        if (book.getStockCount() > 0) {
            System.out.println(name + " bought the book: " + book.getTitle());
            book.setStockCount(book.getStockCount() - 1); // Reducing the stock count
        } else {
            System.out.println("Sorry, the book " + book.getTitle() + " is out of stock.");
        }
    }

    @Override
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email; // If needed, you can also add this method to the ICustomer interface
    }

    @Override
    public Membership getMembership() {
        return membership;
    }

    public void setMembership(Membership membership) {
        this.membership = membership; // Same as getEmail(), add this to ICustomer if needed
    }
}
