package domain.factory;

import domain.models.Membership;

public class MembershipFactory {
    public Membership createMembership(String type, int discount) {
        return new Membership(type, discount);
    }
}