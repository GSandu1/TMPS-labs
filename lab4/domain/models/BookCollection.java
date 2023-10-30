package domain.models;

import java.util.ArrayList;
import java.util.List;

public class BookCollection extends BookComponent {
    List<BookComponent> bookComponents = new ArrayList<>();

    @Override
    public void add(BookComponent bookComponent) {
        bookComponents.add(bookComponent);
    }

    @Override
    public void remove(BookComponent bookComponent) {
        bookComponents.remove(bookComponent);
    }

    @Override
    public BookComponent get(int index) {
        return bookComponents.get(index);
    }

    @Override
    public double getPrice() {
        return bookComponents.stream().mapToDouble(BookComponent::getPrice).sum();
    }
}
