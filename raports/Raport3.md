# Topic: *Structural Design Patterns*

## Author: Gazea Sandu

----

## Objectives:

* Study and understand the StructuralDesign Patterns.
* Choose a domain, define its main classes/models/entities and choose the appropriate instantiation mechanisms.
* Implement some additional functionalities, or create a new project using structural design patterns.

## Main tasks:
* Choose an OO programming language and a suitable IDE or Editor (No frameworks/libs/engines allowed).

* Select a domain area for the sample project.

* Define the main involved classes and think about what instantiation mechanisms are needed.

* Based on the previous point, implement at least 2 structral design patterns in your project.



## Theory:
&ensp; Structural design patterns are a category of design patterns that focus on the composition of classes and objects to form larger structures and systems. They provide a way to organize objects and classes in a way that is both flexible and efficient, while allowing for the reuse and modification of existing code. Structural design patterns address common problems encountered in the composition of classes and objects, such as how to create new objects that inherit functionality from existing objects, how to create objects that share functionality without duplicating code, or how to define relationships between objects in a flexible and extensible way.
## Implementation
__Decorator Pattern__
* The decorator pattern is used to add new functionality to an object without altering its structure. This type of design pattern comes under structural pattern as this pattern acts as a wrapper for existing classes.
* __Class: DiscountedBook, BookDecorator__ 
* The __DiscountedBook__ class is a decorator around the __Book__ class. It extends Book and takes a Book instance as a parameter in its constructor. The __DiscountedBook__ class then overrides the getPrice() method to return the discounted price instead of the original price.__BookDecorator__ is prepared to be a base class for creating decorators for __Book__ objects, it's not used as a classical decorator in the code. 
* __Code: Example__
```java
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

```

__Proxy Pattern__
* The Proxy Pattern provides a surrogate or placeholder for another object to control access to it. It can add a level of control over the interaction with an object.
* __Classes: BookProxy__
*  The __BookProxy__ class is used to control access to the __Book__ class. It’s particularly used for accessing the book's price, where it instantiates the real __Book__ object and delegates the call to the getPrice() method, allowing for operations like logging, which is demonstrated by the System.out.println("Accessing book price"); line.
* __Code: Example__
```java
public class BookProxy extends Book {
    private Book realBook;

    public BookProxy(String title, String author, String genre, double price, int stockCount) {
        super(title, author, genre, price, stockCount);
        realBook = new Book(title, author, genre, price, stockCount);
    }

    @Override
    public double getPrice() {
        System.out.println("Accessing book price");
        return realBook.getPrice();
    }
}

```
__Composite Pattern__
* The Composite Pattern composes objects into tree structures to represent part-whole hierarchies. It allows clients to treat individual objects and compositions of objects uniformly.
* __Class: BookComponent,BookLeaf,BookCollection__
* __BookComponent__ is the abstract class that can be overridden by leaf or composite classes. __BookLeaf__ represents individual Book objects, while __BookCollection__ is a composite that can hold multiple __BookLeafs__ and other __BookCollections__. This allows to calculate the total price of books in a collection easily, treating individual and composite objects uniformly.
* __Code: Example__
```java
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

public class BookCollection extends BookComponent {
    List<BookComponent> bookComponents = new ArrayList<>();

    @Override
    public void add(BookComponent bookComponent) {
        bookComponents.add(bookComponent);
    }

    @Override
    public double getPrice() {
        return bookComponents.stream().mapToDouble(BookComponent::getPrice).sum();
    }
}

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

```
__Adapter Pattern__
* The Adapter Pattern allows incompatible interfaces to work together. It converts the interface of a class into another interface that a client expects.
* __Class: ExternalReviewServiceAdapter,ExternalReviewService,IReviewService__
* __ExternalReviewServiceAdapter__ makes __ExternalReviewService__ compatible with the __IReviewService__ interface. It allows the external service to be used in places where __IReviewService__ is expected, ensuring smooth integration
* __Code: Example__
```java
public class ExternalReviewServiceAdapter implements IReviewService {
    private ExternalReviewService externalReviewService;

    public ExternalReviewServiceAdapter(ExternalReviewService externalReviewService) {
        this.externalReviewService = externalReviewService;
    }

    @Override
    public void leaveReview(Customer customer, Book book, String comment, int rating) {
        externalReviewService.addReview(book.getTitle(), comment, rating);
    }
}

```

## Output:
```
External Service: Review added for book Harry Potter
Total price of book collection: $59.980000000000004
Discount applied for John
John bought: Harry Potter at a discounted price of $31.992
Accessing book price
Harry Potter price via proxy: $39.99
```


## Conclusions 
&ensp; Software engineering faces challenges in scalability, maintainability, and adaptability, addressed by design patterns like Decorator, Proxy, Composite, and Builder. Decorator adds features to objects dynamically, enhancing flexibility. Proxy controls access to objects, offering enhanced control and security. Composite simplifies complex structures, promoting uniformity. Builder aids in the creation of objects with numerous parameters, enhancing clarity and control. These patterns collectively improve code quality, promoting robust, efficient, and scalable software.
