package domain.factory;

import domain.models.Customer;
import domain.models.Membership;

public class CustomerFactory {
    public Customer createCustomer(String name, String email, Membership membership) {
        return new Customer(name, email, membership);
    }
}
