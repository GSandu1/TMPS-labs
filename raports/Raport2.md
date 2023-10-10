# Topic: *Creational Design Patterns*

## Author: Gazea Sandu


----

## Objectives:

* Study and understand the Creational Design Patterns.
* Choose a domain, define its main classes/models/entities and choose the appropriate instantiation mechanisms.
* Use some creational design patterns for object instantiation in a sample project.

## Main tasks:
* Choose an OO programming language and a suitable IDE or Editor (No frameworks/libs/engines allowed).

* Select a domain area for the sample project.

* Define the main involved classes and think about what instantiation mechanisms are needed.

* Based on the previous point, implement at least 2 creational design patterns in your project.



## Theory:
&ensp; Creational design patterns are a category of design patterns that focus on the process of object creation. They provide a way to create objects in a flexible and controlled manner, while decoupling the client code from the specifics of object creation. Creational design patterns address common problems encountered in object creation, such as how to create objects with different initialization parameters, how to create objects based on certain conditions, or how to ensure that only a single instance of an object is created. There are several creational design patterns that have their own strengths and weaknesses. Each of it is best suited for solving specific problems related to object creation. By using creational design patterns, developers can improve the flexibility, maintainability, and scalability of their code.

## Implementation
__Singleton Pattern__
*  The Singleton Pattern ensures that a class has only one instance and provides a global point of access to that instance. It's particularly useful for classes that manage resources, such as a configuration object or a connection pool.
* __Class: Configuration__
* The __Configuration__ class is made a singleton to ensure that configuration data is loaded and accessed from a single point in the application. It aids in preventing multiple instances of configuration data loading and provides a global point of access to these configurations.
* __Code: Example__
```java

public class Configuration {
    private static Configuration instance;
    private String appVersion;

    private Configuration() {
        // Private constructor to restrict instantiation
        appVersion = "1.0.0";
    }

    public static Configuration getInstance() {
        if (instance == null) {
            instance = new Configuration();
        }
        return instance;
    }

    public String getAppVersion() {
        return appVersion;
    }


```

__Factory Pattern__
*   The Factory Method Pattern is used to create objects without specifying the exact class of object that will be created. It defines an interface for creating an object, with the subclasses deciding which class to instantiate.
* __Classes: BookFactory, MembershipFactory__
* The __BookFactory__ and __MembershipFactory__ classes use the factory method pattern to create Book and Membership objects, respectively. This abstraction of creation logic ensures that the client code is decoupled from the object instantiation process.
* __Code: Example__
```java
public class BookFactory {
    public Book createBook(String title, String author, String genre, double price, int stockCount) {
        return new Book(title, author, genre, price, stockCount);
    }
}

```
__Builder Pattern__
*   The Builder Pattern is used to construct a complex object step by step. It is a creational design pattern that's useful when an object needs to be created with many optional components or configurations.
* __Concrete Class: BookBuilder__
* The __BookBuilder__ class uses the builder pattern to allow the creation of a Book object in a step-by-step manner. It aids in constructing a Book object with various optional parameters, ensuring that the object is always in a valid state when created.
* __Code: Example__

```java
public class BookBuilder {
    private String title;
    private String author;
    private String genre;
    private double price;
    private int stockCount;

    // ... (Setter methods with 'return this' to allow method chaining)

    public Book build() {
        return new Book(title, author, genre, price, stockCount);
    }
}

```
__Prototype Pattern__
*   The Prototype Pattern is used when the cost of creating a new instance of an object is more expensive than copying an existing instance. It involves creating new objects by copying an existing object, known as the prototype. 
* __Class: BookPrototype__
* The __BookPrototype__ class uses the prototype pattern to allow the creation of a new Book object by copying an existing one. This pattern is especially useful when the cost of creating a new instance is higher than cloning an existing instance.
* __Code: Example__
```java
public class BookPrototype implements Cloneable {
    private final Book book;

    public BookPrototype(Book book) {
        this.book = book;
    }

    @Override
    public BookPrototype clone() throws CloneNotSupportedException {
        Book clonedBook = (Book) book.clone();
        return new BookPrototype(clonedBook);
    }

    public Book getBook() {
        return book;
    }
}

```

## Output:
```
App Version: 1.0.0
Discount applied for Alice
Alice left a review for the book: Harry Potter
Alice bought: Harry Potter at a discounted price of $31.992
Alice bought the book: The Hobbit
Cloned Book Title: The Hobbit

```


## Conclusions
Creational design patterns, including Singleton, Factory Method, Builder, and Prototype, are instrumental in addressing complexities in object creation, promoting code that is manageable and scalable. The Singleton pattern ensures a single instance, optimizing resources. Factory Method offers flexibility and separation of creation logic, enhancing modularity. The Builder pattern is essential for constructing complex objects, ensuring constraint adherence and readability. The Prototype pattern optimizes performance by enabling object copying, reducing complex object creation overhead.

In the sample project, these patterns are effectively integrated, underscoring their individual and collective benefits in optimizing object creation. Their implementation ensures a blend of efficiency, flexibility, and manageability. Through these patterns, developers are equipped to build robust, efficient, and maintainable software, highlighting the role of strategic object creation in advancing adaptable and sustainable software development."
