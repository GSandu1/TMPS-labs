package domain.factory;

import domain.models.Membership;

public class MembershipFactory {
    public Membership createMembership(String type, int discount) {
        if(type == null || type.isEmpty()) {
            System.out.println("Type is null or empty.");
            return null;
        }
        if(discount < 0) {  // Adjust this check as per your business rules
            System.out.println("Invalid discount value.");
            return null;
        }
        return new Membership(type, discount);
    }
}
