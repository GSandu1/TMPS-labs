package domain.service;

import domain.interfaces.Discountable;
import domain.models.Customer;

public class OfferService {
    public void applyDiscount(Customer john, Discountable item, int discountPercentage) {
        item.applyDiscount(discountPercentage);
    }
}

