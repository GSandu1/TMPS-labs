package domain.interfaces;

import domain.models.Book;
import domain.models.Membership;  // Import Membership class

public interface ICustomer {
    void buy(Book book);
    String getName();
    Membership getMembership();  // Ensure return type is Membership
}
