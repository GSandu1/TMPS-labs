# Topic: *SOLID Principles*

## Author: Gazea Sandu

----

## Objectives:

* Study and understand the SOLID Principles.
* Choose a domain, define its main classes/models/entities and apply appropriate design principles.
* Create a sample project that respects SOLID Principles.

## Main tasks:
* Choose an OO programming language and a suitable IDE or Editor (No frameworks/libs/engines allowed).
* Select a domain area for the sample project.
* Define the main involved classes and apply principles for solid design.
* Ensure SOLID Principles are respected in your project.

## Theory:
SOLID principles are a pivotal concept in object-oriented programming that, when effectively applied, lead to clean, maintainable, and scalable code. These principles comprise the Single Responsibility Principle, Open/Closed Principle, Liskov Substitution Principle, Interface Segregation Principle, and Dependency Inversion Principle.

## Implementation
__SRP (Single Responsibility Principle)__

* Classes like **Book**, **Customer**, and **Review** are clear instances of SRP. They are designed with a single, clear focus. For instance, the **Book** class is solely focused on book-related properties and behaviors.
* The service classes (**OfferService** and **ReviewService**) are another demonstration of SRP, handling specific functionalities individually.

__OCP (Open/Closed Principle)__

* The system is structured to allow the extension of book types or customer behaviors without modifying existing code. New functionalities or entities can be added without altering established code, adhering to the OCP.

__LSP (Liskov Substitution Principle)__

* Achieved through the use of polymorphism. The **SpecialMember** class extends the **Customer** class, ensuring substitutability while extending behaviors, respecting LSP.

__ISP (Interface Segregation Principle)__

* Achieved by creating specific interfaces like **Buyable**, **Discountable**, and **Reviewable**. Classes implement these interfaces based on their specific needs, ensuring that they aren’t forced to implement unnecessary methods.

__DIP (Dependency Inversion Principle)__

* The **Customer** class, for instance, isn’t directly dependent on the **Book** class. Dependencies are based on abstractions, which is a clear adherence to DIP.

## Output:


## Output:
```
John Doe is a special member and bought the book: How to win friends and influence people
John Doe left a review for the book: How to win friends and influence people
```


## Conclusions / Screenshots / Results
&ensp; In developing this book store application, the SOLID principles have proved instrumental in ensuring a clean, efficient, and well-structured codebase. The SRP is evident in the distinct and focused roles of each class, from handling book information to managing customers and reviews. OCP is embedded in the flexible structure that allows for easy extensions without modifications to existing code. LSP is realized through the seamless substitution and extension of classes, ensuring consistent behaviors. ISP is integrated by aligning classes with relevant interfaces, promoting a focused and efficient design. Lastly, DIP is highlighted in the reliance on abstractions, reducing direct dependencies and enhancing modularity. The application not only embodies the essence of these principles but underscores their pivotal role in fostering a scalable, maintainable, and robust software architecture.


