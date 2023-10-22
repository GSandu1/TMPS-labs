package domain.models;

public class Membership {
    private String type;
    private int discount;  // Percentage discount for members.

    public Membership(String type, int discount) {
        this.type = type;
        this.discount = discount;
    }

    public int getDiscount() {
        return discount;
    }
}