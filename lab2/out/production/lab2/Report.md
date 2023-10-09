# Topic: *SOLID Principles*

## Author: Grama Alexandru

----

## Objectives:

* Study and understand the SOLID Principles.
* Choose a domain, define its main classes/models/entities and choose the appropriate instantiation mechanisms.
* Create a sample project that respects SOLID Principles.

## Main tasks:
* Choose an OO programming language and a suitable IDE or Editor (No frameworks/libs/engines allowed).

* Select a domain area for the sample project.

* Define the main involved classes and think about what instantiation mechanisms are needed.

* Respect SOLID Principles in your project.



## Theory:
&ensp; SOLID is a set of five object-oriented design principles intended to make software designs more maintainable, flexible, and easy to understand. The acronym stands for Single Responsibility Principle, Open-Closed Principle, Liskov Substitution Principle, Interface Segregation Principle, and Dependency Inversion Principle. Each principle addresses a specific aspect of software design, such as the organization of responsibilities, the handling of dependencies, and the design of interfaces. By following these principles, software developers can create more modular, testable, and reusable code that is easier to modify and extend over time. These principles are widely accepted and adopted in the software development community and can be applied to any object-oriented programming language.


## Implementation
__SRP (Single Responsibility Principle)__

* __Shoe and Customer classes:__ They focus only on representing data related to shoes and customers, respectively.
* __BuyingService:__ Handles the buying process, ensuring it's separate from the core entities.
* __Factories (ShoeFactory and CustomerFactory):__ They deal with the creation of their respective entities, ensuring that object instantiation is abstracted away.

Thus, each class/component retains a single, focused responsibility.

__OCP (Open/Closed Principle)__

* The code allows for the addition of new types of shoes or customers without necessitating alterations to the **MainApp**.
* If there's a need to introduce a new buying method, a new method can be added to BuyingService without modifying the existing ones.
* Extensibility is apparent: If you need to add more shoe or customer types, you can merely append them to the existing lists without modifying any switch-case structures.

__LSP (Liskov Substitution Principle)__

* Is demonstrated through the **SpecialOnlineBuyer** subclass. This subclass enhances the behavior of the superclass (**Customer**) without changing its original behavior, thus ensuring that the **SpecialOnlineBuyer** is a perfect substitute for the **Customer** class.

__ISP (Interface Segregation Principle)__

* The code integrates the buying behavior from two Interfaces into BuyingService class.
* ISP is achieved by segregating the buying actions into two separate interfaces. This means if we have customers who only shop online or only in-store, they can implement only the relevant interface.

__DIP (Dependency Inversion Principle)__

* MainApp utilizes abstractions, like **ShoeFactory** and **CustomerFactory**, to instantiate objects. This abstraction ensures MainApp isn't tightly coupled with concrete classes.
* The introduction of a service (**BuyingService**) also aligns with DIP.

## Output:
```
Alex Johnson chose Shoe{brand='Adidas', size=40, type='sports', price=128.0, stockCount=12}
Alex Johnson bought a shoe online.

Benjamin Lee chose Shoe{brand='Adidas', size=40, type='sports', price=128.0, stockCount=12}
Benjamin Lee bought a shoe in-store.

Jessica Ramirez chose Shoe{brand='Puma', size=43, type='sports', price=134.0, stockCount=13}
Jessica Ramirez bought a shoe online.
Jessica Ramirez received a special online discount.
```


## Conclusions / Screenshots / Results
&ensp; In crafting this Shoe Store Simulation, I've seen firsthand how the SOLID principles can streamline and enhance software design. By using the ShoeFactory for creating shoe instances, I've adhered to the Single Responsibility Principle, ensuring each class does one thing well. The introduction of OnlineBuyer and InStoreBuyer interfaces exemplifies the Interface Segregation Principle, allowing for flexibility in purchase methods without burdening the Customer class. Overall, these principles haven't just made the code more organized; they've made it intuitive and ready for future growth.


