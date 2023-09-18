package client;

import domain.models.*;
import domain.factory.*;
import domain.service.*;

import java.util.*;

public class MainApp {
    public static void main(String[] args) {
        BookFactory bookFactory = new BookFactory();
        Book recommendedBook = bookFactory.createBook("How to win friends and influence people", "Dale Carnegie", "Literature on self-development", 15.00, 30);

        MembershipFactory membershipFactory = new MembershipFactory();
        Membership premiumMembership = membershipFactory.createMembership("Premium", 10);

        Customer john = new Customer("John Doe", "john@example.com", premiumMembership);

        Bookstore bookstore = new Bookstore("MyLibrary");
        bookstore.addBook(recommendedBook);

        OfferService offerService = new OfferService();
        if(premiumMembership != null) {
            offerService.applyDiscount(john, recommendedBook, premiumMembership.getDiscount());
        }

        john.buy(recommendedBook);

        ReviewService reviewService = new ReviewService();
        reviewService.leaveReview(john, recommendedBook, "Great read!", 5);
    }
}
