# Generics applied
<p>
    <img width="50%" src=images/Generics.png> 
</p>  

## Table of Contents
1. [Introduction to Generics](#1-introduction-to-generics)
2. [Syntax and Notation](#2-syntax-and-notation)
3. [Generic Methods](generic_methods.md)
4. [Generic Classes and Interfaces](generic_classes_and_interfaces.md)
5. [Generics in Collections](generic_collections.md)
6. [Best Practices and Design Patterns](#6-best-practices-and-design-patterns)
7. [Practical Examples and Case Studies](#7-practical-examples-and-case-studies)   
[References](#references)  


## 1. Introduction to Generics
*What are Generics?*  
Generics, in the context of computer programming, refer to a feature that allows the creation of functions, classes, or data structures that can operate on different data types without specifying the actual type until the code is used or compiled. Generics provide a way to write flexible and reusable code by making it possible to write algorithms and data structures that are independent of the specific types they manipulate.  

*Advantages of using Generics*  
Using generics in programming offers several advantages that contribute to writing more flexible, reusable, and type-safe code. Here are some key reasons why you should consider using generics:  
**Reusability**: Generics enable writing code that can be reused for different data types, promoting efficiency and avoiding redundancy.  
**Flexibility**: With generics, you can create more abstract code that works with various data types, eliminating the need for separate implementations for each type.  
**Type Safety**: Generics help maintain type safety by catching type-related errors at compile time, improving code reliability.  
**Cleaner Code**: Generics lead to cleaner and more concise code, reducing the need for duplicate implementations for similar operations on different data types.  
**Better Abstraction**: Generics provide abstraction, allowing code to be written without specifying concrete types, making it adaptable to different scenarios.  
**Improved Readability**: Generics enhance code readability by expressing the code's intent clearly, especially when functions or classes are designed to work with any data type.   
**Reduced Development Time**: Generics can save development time by eliminating the need to write specialized code for each data type. This can lead to faster development cycles and easier maintenance.    
**Consistent Interfaces**: Generics enable creating consistent interfaces for functions or classes, facilitating better understanding and use by other developers for a cohesive and maintainable codebase.  
**Easier Refactoring**: Generics simplify refactoring as changes to the generic code apply uniformly across various data types, making modifications more straightforward.  

*Where Generics are commonly used?*  
**Collections**: Generics play a crucial role in the development of collections like lists, sets, and maps. This ensures type safety and adaptability, permitting the inclusion of elements of different types while maintaining compile-time verification.  
**Algorithms**: Generic algorithms provide a foundation for designing functions that operate on various data types. Sorting, searching, and other algorithmic processes benefit from generics, offering a single implementation that adapts to different input types.  
**Frameworks and Libraries**: Many programming frameworks and libraries leverage generics to provide generic APIs, enabling developers to work with different types seamlessly. This is particularly evident in GUI frameworks, database access libraries, and other high-level abstractions.  
**Language Features**: Integral to languages like Java, C#, and Swift, generics enhance expressiveness and versatility. These languages leverage generics to empower developers to craft more concise and type-safe code, enriching the overall language capabilities.  
**Custom Data Structures**: When constructing custom data structures such as linked lists, trees, and queues, developers frequently turn to generics. This enables the instantiation of structures with diverse data types while upholding type safety and code integrity.

## 2. Syntax and Notation

Understanding the syntax and notation associated with generics is crucial for effective usage. This chapter breaks down key elements, including generic type parameters, constraints, and wildcards.

### 2.1 Generic Type Parameters

Generic type parameters allow you to create flexible and reusable components by introducing placeholders for data types. In languages like Java or C#, generic type parameters are typically denoted by single uppercase letters, such as 'T' or 'E'. Here's a basic example of a generic class with a type parameter:

```java
public class Box<T> {
private T value;

    public Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
```
In this example, 'T' is a generic type parameter representing the type of data the Box class can store.

### 2.2 Generic Constraints
Generic constraints allow you to impose limitations on the types that can be used with generic parameters. Constraints are particularly useful when you want to ensure that certain operations or properties are available for the generic type. In C#, for instance, you can use constraints like where T : SomeInterface to ensure 'T' implements a specific interface. Here's an example:
```csharp
public class GenericConstraintExample<T> where T : IComparable<T> {
    public bool IsFirstGreaterThanSecond(T first, T second) {
        return first.CompareTo(second) > 0;
    }
}
```
### 2.3 Wildcards
<p>
    <img width="50%" src=images/Wildcards.png> 
</p>  
Wildcards, provide a level of flexibility when dealing with generic types. In Java, wildcards are denoted by '?' and come in three forms: unbounded (<?>), upper-bounded (<? extends T>), and lower-bounded (<? super T>).

Unbounded Wildcard: Represents an unknown type.
```java
public void processList(List<?> list) {
// Process the list without knowing its element type
}
```
Upper Bounded Wildcard: Accepts a list of a specific type and its subtypes.
```java
public double sumOfList(List<? extends Number> list) {
// Calculate the sum of the list elements
}
```
Lower Bounded Wildcard: Accepts a list of a specific type and its supertypes.
```java
public void addIntegers(List<? super Integer> list) {
// Add integers to the list
}
```
Understanding and applying these syntax elements is crucial for harnessing the full power and flexibility of generics in your programming endeavors.

## 3. [Generic Methods](generic_methods.md)

## References  
1. [Generics in Java](https://www.geeksforgeeks.org/generics-in-java/)
2. [Constraints on type parameters (C#)](https://learn.microsoft.com/en-us/dotnet/csharp/programming-guide/generics/constraints-on-type-parameters)
3. [Type Parameter vs Wildcard in Java Generics](https://www.baeldung.com/java-generics-type-parameter-vs-wildcard)
4. [5 Best Practices To Get Familiar With Java Generics](https://blog.devgenius.io/5-best-practices-to-get-familiar-with-java-generics-25b10e27a3c)
5. [Java Generics Design Patterns](https://www.javatpoint.com/java-generics-design-patterns)
6. [Java Generics Tutorial with Examples](https://www.javaguides.net/2018/08/java-generics-tutorial-with-examples.html)
5. [ChatGPT](https://chat.openai.com/)

[Back to Table of Contents](#table-of-contents)  

Created by:  
Valentina Țurcanu  
Email: valentina.turcanu@endava.com