package domain.service;

import domain.factory.CustomerFactory;
import domain.factory.MembershipFactory;  // Import the MembershipFactory
import domain.models.Customer;
import domain.models.Membership;

public class CustomerService {
    private final CustomerFactory customerFactory;

    public CustomerService() {
        MembershipFactory membershipFactory = new MembershipFactory();  // Create a MembershipFactory instance
        this.customerFactory = new CustomerFactory(membershipFactory);  // Provide the MembershipFactory instance when creating the CustomerFactory
    }

    public Customer createCustomer(String name, String email, Membership membership) {
        return customerFactory.createCustomer(name, email, membership);
    }
}
