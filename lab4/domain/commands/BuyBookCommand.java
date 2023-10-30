package domain.commands;

import domain.interfaces.Command;
import domain.models.Book;
import domain.models.Customer;

public class BuyBookCommand implements Command {
    private final Customer customer;
    private final Book book;

    public BuyBookCommand(Customer customer, Book book) {
        this.customer = customer;
        this.book = book;
    }

    @Override
    public void execute() {
        customer.buy(book);
    }

    @Override
    public void undo() {
        book.setStockCount(book.getStockCount() + 1);
        System.out.println(customer.getName() + " has returned the book: " + book.getTitle());
    }
}
