package domain.models;

public abstract class BookComponent {
    public void add(BookComponent bookComponent) {
        throw new UnsupportedOperationException();
    }

    public void remove(BookComponent bookComponent) {
        throw new UnsupportedOperationException();
    }

    public BookComponent get(int index) {
        throw new UnsupportedOperationException();
    }

    public String getTitle() {
        throw new UnsupportedOperationException();
    }

    public double getPrice() {
        throw new UnsupportedOperationException();
    }
}
