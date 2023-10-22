package domain.factory;

import domain.models.Customer;
import domain.models.Membership;

public class CustomerFactory {

    private final MembershipFactory membershipFactory;

    public CustomerFactory(MembershipFactory membershipFactory) {
        this.membershipFactory = membershipFactory;
    }

    public Customer createCustomer(String name, String email, String membershipType, int discount) {
        Membership membership = membershipFactory.createMembership(membershipType, discount);
        if(membership == null) {
            System.out.println("Error creating membership.");
            return null;
        }
        return new Customer(name, email, membership);
    }

    public Customer createCustomer(String name, String email, Membership membership) {
        return null;
    }
}
