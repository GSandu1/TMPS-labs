# Topic: *Behavioral Design Patterns*

## Author: Gazea Sandu

----

## Objectives:

* Study and understand the Behavioral Design Patterns.
* As a continuation of the previous laboratory work, think about what communication between software entities might be involed in your system.
* Create a new Project or add some additional functionalities using behavioral design patterns.

## Main tasks:
* The implemented design pattern should help to perform the tasks involved in your system.
* The behavioral DPs can be integrated into you functionalities alongside the structural ones.
* There should only be one client for the whole system.


## Theory:
&ensp; Behavioral design patterns are a category of design patterns that focus on the interaction and communication between objects and classes. They provide a way to organize the behavior of objects in a way that is both flexible and reusable, while separating the responsibilities of objects from the specific implementation details. Behavioral design patterns address common problems encountered in object behavior, such as how to define interactions between objects, how to control the flow of messages between objects, or how to define algorithms and policies that can be reused across different objects and classes.
## Implementation
__Strategy Pattern__
* The Strategy Pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable.
* __Class: PercentageDiscountStrategy,DiscountedBook,DiscountStrategy__ 
* My project uses the strategy pattern to allow different discount algorithms to be applied to books. This is particularly evident with the __DiscountedBook__ class, which uses a __DiscountStrategy__ to determine the type and amount of discount. By doing this, you can easily introduce new discount methods in the future without altering the existing discount methods or the __DiscountedBook__ class itself.
* __Code: Example__
```java
public interface DiscountStrategy {
    double applyDiscount(double originalPrice);
}

public class PercentageDiscountStrategy implements DiscountStrategy {
    private double percentage;

    // ... other parts of the code

    @Override
    public double applyDiscount(double originalPrice) {
        return originalPrice * (1 - percentage / 100.0);
    }
}

```

__Observer Pattern__
* The Observer Pattern defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.
* __Classes: AdminObserver,Observer,Book__
* Whenever a review is left on a book , the __AdminObserver__ get notified. For instance, you've set it up such that when a review is added to __book1__, the __AdminObserver__ is notified, which could be used for admin notifications or log monitoring.
* __Code: Example__
```java
public class Book {
    // ... other parts of the code

    private List<Observer> observers = new ArrayList<>();

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }
}

public class AdminObserver implements Observer {
    // ... other parts of the code

    @Override
    public void update(Book book) {
        System.out.println("Admin notified of a new review on book: " + book.getTitle());
    }
}

```
__Command Pattern__
* The Command Pattern encapsulates a request as an object, thereby allowing for parameterization of clients with different requests, queueing of requests, and logging of the operations.
* __Class: BuyBookCommand,Command,CommandInvoker__
* The action of buying a book has been encapsulated as a command (__BuyBookCommand__). The __CommandInvoker__ is responsible for executing these commands. By using this pattern, you have separated the responsibility of who initiates the action from the actual implementation of that action. This provides flexibility for adding new actions or commands in the future without altering existing code.
* __Code: Example__
```java
public class BuyBookCommand implements Command {
    private Customer customer;
    private Book book;

    public BuyBookCommand(Customer customer, Book book) {
        this.customer = customer;
        this.book = book;
    }

    @Override
    public void execute() {
        // Logic for buying the book can be implemented here.
    }
}

public class CommandInvoker {
    public void execute(Command command) {
        command.execute();
    }
}

```

## Output:
```
External Service: Review added for book Harry Potter
Total price of book collection: $59.980000000000004
Discount applied for John
John bought: Harry Potter at a discounted price of $28.7928
John bought the book: The Hobbit
John has bought The Hobbit
Accessing book price
Harry Potter price via proxy: $39.99

```


## Conclusions 
&ensp; In the provided project, behavioral design patterns played a pivotal role in creating a dynamic and flexible system. The Observer Pattern ensured real-time notifications, allowing entities like administrators to stay informed about significant events, such as new book reviews. The Command Pattern decoupled actions from their initiators, offering a structured way to handle operations like buying a book. Additionally, the Strategy Pattern empowered the system with a modular approach to discounts, facilitating effortless introductions of new discounting algorithms without disrupting existing ones. Together, these patterns enhanced the project's maintainability, scalability, and adaptability. Through the strategic use of behavioral patterns, the project exemplifies the advantages of pattern-driven design in real-world applications. The project not only serves as an example of design patterns in practice but also underscores the importance of behavioral patterns in managing system interactions and behaviors.
