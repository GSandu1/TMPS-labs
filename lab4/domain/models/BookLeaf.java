package domain.models;

public class BookLeaf extends BookComponent {
    private Book book;

    public BookLeaf(Book book) {
        this.book = book;
    }

    @Override
    public String getTitle() {
        return book.getTitle();
    }

    @Override
    public double getPrice() {
        return book.getPrice();
    }
}
