package domain.service;

import domain.interfaces.Discountable;
import domain.interfaces.ICustomer;

public class OfferService {
    public void applyDiscount(ICustomer customer, Discountable item, int discountPercentage) {
        item.applyDiscount(discountPercentage);
        System.out.println("Discount applied for " + customer.getName());
    }
}
