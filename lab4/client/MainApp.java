//package client;
//
//import domain.factory.BookFactory;
//import domain.factory.CustomerFactory;
//import domain.factory.MembershipFactory;
//import domain.interfaces.IReviewService;
//import domain.models.*;
//import domain.service.ExternalReviewService;
//import domain.service.ExternalReviewServiceAdapter;
//import domain.service.OfferService;
//import domain.service.ReviewService;
//
//
//
//public class MainApp {
//    public static void main(String[] args) {
//        BookFactory bookFactory = new BookFactory();
//        MembershipFactory membershipFactory = new MembershipFactory();  // This should initialize the membershipFactory
//        CustomerFactory customerFactory = new CustomerFactory(membershipFactory);
//
//
//        Book book1 = bookFactory.createBook("Harry Potter", "J.K. Rowling", "Fantasy", 39.99, 100);
//        Book book2 = bookFactory.createBook("The Hobbit", "J.R.R. Tolkien", "Fantasy", 19.99, 100);
//
//        BookProxy bookProxy1 = new BookProxy("Harry Potter", "J.K. Rowling", "Fantasy", 39.99, 100);
//
//        DiscountedBook discountedBook = new DiscountedBook(book1, 20); // 20% discount
//
//        Customer john = customerFactory.createCustomer("John", "john@gmail.com", "Premium", 10);
//
//        if (john == null || john.getMembership() == null) {
//            System.out.println("Error creating customer or membership.");
//            return;
//        }
//
//        ExternalReviewService externalReviewService = new ExternalReviewService();
//        IReviewService adaptedReviewService = new ExternalReviewServiceAdapter(externalReviewService);
//
//        adaptedReviewService.leaveReview(john, book1, "Great book!", 5);
//
//        BookComponent bookCollection = new BookCollection();
//        bookCollection.add(new BookLeaf(book1));
//        bookCollection.add(new BookLeaf(book2));
//        System.out.println("Total price of book collection: $" + bookCollection.getPrice());
//
//        OfferService offerService = new OfferService();
//        offerService.applyDiscount(john, discountedBook, john.getMembership().getDiscount());
//        System.out.println(john.getName() + " bought: " + book1.getTitle() + " at a discounted price of $" + discountedBook.getPrice());
//
//        System.out.println(bookProxy1.getTitle() + " price via proxy: $" + bookProxy1.getPrice());
//    }
//}


package client;

import domain.factory.BookFactory;
import domain.factory.CustomerFactory;
import domain.factory.MembershipFactory;
import domain.interfaces.Command;
import domain.interfaces.IReviewService;
import domain.models.*;
import domain.service.ExternalReviewService;
import domain.service.ExternalReviewServiceAdapter;
import domain.service.OfferService;
import domain.commands.CommandInvoker;
import domain.commands.BuyBookCommand;
import domain.observers.AdminObserver;
import domain.interfaces.DiscountStrategy;
import domain.strategy.PercentageDiscountStrategy;

public class MainApp {
    public static void main(String[] args) {
        // Factories
        BookFactory bookFactory = new BookFactory();
        MembershipFactory membershipFactory = new MembershipFactory();
        CustomerFactory customerFactory = new CustomerFactory(membershipFactory);

        // Creating books
        Book book1 = bookFactory.createBook("Harry Potter", "J.K. Rowling", "Fantasy", 39.99, 100);
        Book book2 = bookFactory.createBook("The Hobbit", "J.R.R. Tolkien", "Fantasy", 19.99, 100);

        // Proxy Pattern
        BookProxy bookProxy1 = new BookProxy("Harry Potter", "J.K. Rowling", "Fantasy", 39.99, 100);

        // Strategy Pattern: Applying discount to a book
        DiscountStrategy percentageDiscount = new PercentageDiscountStrategy(20);
        DiscountedBook discountedBook = new DiscountedBook(book1, percentageDiscount);// 20% discount

        // Creating a customer
        Customer john = customerFactory.createCustomer("John", "john@gmail.com", "Premium", 10);
        if (john == null || john.getMembership() == null) {
            System.out.println("Error creating customer or membership.");
            return;
        }

        // Adapter Pattern: Using an external review service
        ExternalReviewService externalReviewService = new ExternalReviewService();
        IReviewService adaptedReviewService = new ExternalReviewServiceAdapter(externalReviewService);

        // Observer Pattern: Admin gets notified of new reviews
        AdminObserver adminObserver = new AdminObserver("AdminName");
        book1.registerObserver(adminObserver);  // Admin now observes book1
        adaptedReviewService.leaveReview(john, book1, "Great book!", 5);

        // Composite Pattern: Book collection
        BookComponent bookCollection = new BookCollection();
        bookCollection.add(new BookLeaf(book1));
        bookCollection.add(new BookLeaf(book2));
        System.out.println("Total price of book collection: $" + bookCollection.getPrice());

        // Strategy Pattern: Applying membership-based discount
        OfferService offerService = new OfferService();
        offerService.applyDiscount(john, discountedBook, john.getMembership().getDiscount());
        System.out.println(john.getName() + " bought: " + book1.getTitle() + " at a discounted price of $" + discountedBook.getPrice());

        // Command Pattern: Buying a book using the command pattern
        CommandInvoker invoker = new CommandInvoker();
        Command buyBookCommand = new BuyBookCommand(john, book2);
        invoker.execute(buyBookCommand);
        System.out.println(john.getName() + " has bought " + book2.getTitle());

        System.out.println(bookProxy1.getTitle() + " price via proxy: $" + bookProxy1.getPrice());
    }
}
