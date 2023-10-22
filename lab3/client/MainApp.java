package client;

import domain.factory.BookFactory;
import domain.factory.CustomerFactory;
import domain.factory.MembershipFactory;
import domain.interfaces.IReviewService;
import domain.models.*;
import domain.service.ExternalReviewService;
import domain.service.ExternalReviewServiceAdapter;
import domain.service.OfferService;
import domain.service.ReviewService;



public class MainApp {
    public static void main(String[] args) {
        BookFactory bookFactory = new BookFactory();
        MembershipFactory membershipFactory = new MembershipFactory();  // This should initialize the membershipFactory
        CustomerFactory customerFactory = new CustomerFactory(membershipFactory);


        Book book1 = bookFactory.createBook("Harry Potter", "J.K. Rowling", "Fantasy", 39.99, 100);
        Book book2 = bookFactory.createBook("The Hobbit", "J.R.R. Tolkien", "Fantasy", 19.99, 100);

        BookProxy bookProxy1 = new BookProxy("Harry Potter", "J.K. Rowling", "Fantasy", 39.99, 100);

        DiscountedBook discountedBook = new DiscountedBook(book1, 20); // 20% discount

        Customer john = customerFactory.createCustomer("John", "john@gmail.com", "Premium", 10);

        if (john == null || john.getMembership() == null) {
            System.out.println("Error creating customer or membership.");
            return;
        }

        ExternalReviewService externalReviewService = new ExternalReviewService();
        IReviewService adaptedReviewService = new ExternalReviewServiceAdapter(externalReviewService);

        adaptedReviewService.leaveReview(john, book1, "Great book!", 5);

        BookComponent bookCollection = new BookCollection();
        bookCollection.add(new BookLeaf(book1));
        bookCollection.add(new BookLeaf(book2));
        System.out.println("Total price of book collection: $" + bookCollection.getPrice());

        OfferService offerService = new OfferService();
        offerService.applyDiscount(john, discountedBook, john.getMembership().getDiscount());
        System.out.println(john.getName() + " bought: " + book1.getTitle() + " at a discounted price of $" + discountedBook.getPrice());

        System.out.println(bookProxy1.getTitle() + " price via proxy: $" + bookProxy1.getPrice());
    }
}