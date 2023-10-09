package domain.service;

import domain.factory.CustomerFactory;
import domain.models.Customer;
import domain.models.Membership;

public class CustomerService {
    private final CustomerFactory customerFactory;

    public CustomerService() {
        this.customerFactory = new CustomerFactory();
    }

    public Customer createCustomer(String name, String email, Membership membership) {
        return customerFactory.createCustomer(name, email, membership);
    }
}
