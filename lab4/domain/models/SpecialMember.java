package domain.models;

public class SpecialMember extends Customer {

    public SpecialMember(String name, String email, Membership membership) {
        super(name, email, membership);
    }

    @Override
    public void buy(Book book) {
        System.out.println(getName() + " is a special member and bought the book: " + book.getTitle());
    }

}
