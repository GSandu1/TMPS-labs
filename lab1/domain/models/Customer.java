package domain.models;

public class Customer {
    private final String name;
    private final String email;
    private Membership membership;



    public Customer(String name, String email, Membership membership) {
        this.name = name;
        this.email = email;
        this.membership = membership;
    }

    public String getName() {
        return name;
    }

    public void buy(Book book) {
        System.out.println(name + " bought the book: " + book.getTitle());
    }

    public Membership getMembership() {
        return membership;
    }
}
