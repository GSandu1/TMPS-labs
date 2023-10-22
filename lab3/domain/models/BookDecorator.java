package domain.models;

public abstract class BookDecorator extends Book {
    protected Book decoratedBook;

    public BookDecorator(Book decoratedBook) {
        super(decoratedBook.getTitle(), decoratedBook.getAuthor(), decoratedBook.getGenre(),
                decoratedBook.getPrice(), decoratedBook.getStockCount());
        this.decoratedBook = decoratedBook;
    }

    @Override
    public double getPrice() {
        return decoratedBook.getPrice();
    }
}
