package client;

import domain.factory.BookFactory;
import domain.factory.CustomerFactory;
import domain.factory.MembershipFactory;
import domain.models.*;
import domain.service.OfferService;
import domain.service.ReviewService;
import utility.Configuration;

public class MainApp {
    public static void main(String[] args) throws CloneNotSupportedException {
        // Singleton Pattern
        Configuration config = Configuration.getInstance();
        System.out.println("App Version: " + config.getAppVersion());

        // Factory Method Pattern
        BookFactory bookFactory = new BookFactory();
        MembershipFactory membershipFactory = new MembershipFactory();

        Book book1 = bookFactory.createBook("Harry Potter", "J.K. Rowling", "Fantasy", 39.99, 10);
        Membership goldMembership = membershipFactory.createMembership("Gold", 20);

        // Builder Pattern
        Book book2 = new BookBuilder()
                .setTitle("The Hobbit")
                .setAuthor("J.R.R. Tolkien")
                .setGenre("Fantasy")
                .setPrice(29.99)
                .setStockCount(15)
                .build();

        // Prototype Pattern
        BookPrototype prototype = new BookPrototype(book2);
        BookPrototype clonedPrototype = prototype.clone();
        Book clonedBook = clonedPrototype.getBook();

        // Using CustomerFactory
        CustomerFactory customerFactory = new CustomerFactory();
        Customer specialMember = customerFactory.createCustomer("Alice", "alice@example.com", goldMembership);

        // Applying discount
        OfferService offerService = new OfferService();
        offerService.applyDiscount(specialMember, book1, goldMembership.getDiscount());

        // Leaving a review
        ReviewService reviewService = new ReviewService();
        reviewService.leaveReview(specialMember, book1, "Great book!", 5);

        // Print out details
        System.out.println(specialMember.getName() + " bought: " + book1.getTitle() + " at a discounted price of $" + book1.getPrice());
        specialMember.buy(book2);
        System.out.println("Cloned Book Title: " + clonedBook.getTitle());
    }
}
