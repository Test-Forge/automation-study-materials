# Java Streams and Lambda Expressions
## Table of Contents
1. [Introduction](#introduction)
2. [Lambda Expressions](#lambda-expressions)
   1. [Definition](#definition)
   2. [Syntax](#syntax)
   3. [Functional Interfaces](#functional-interfaces)
   4. [Method References](#method-references)
3. [Streams](#streams)
   1. [Definition](#definition)
   2. [Syntax](#syntax)
   3. [Main Characteristics](#main-characteristics)
   4. [Elements of a Stream](#elements-of-a-stream)
   3. [Parallel Streams](#parallel-streams)
4. [Resources](#resources)

## Introduction
This document explores Java's Streams and Lambda Expressions.

Lambda Expressions and Streams have modernized Java by introducing a style of programming that emphasizes simplicity and effectiveness.
Lambda Expressions, or lambdas, are a compact way to carry out operations traditionally requiring more verbose code, such as sorting or filtering data. 
Streams complement lambdas by enabling advanced operations on data sets, similar to database queries, but within Java itself. 
These features are particularly beneficial in processing large volumes of data, enhancing both the
speed of development and the performance of the applications themselves.

## Lambda Expressions
### Definition
Lambda expressions in Java are a concise representation of an anonymous function that
can be used to implement a method defined by a functional interface.
They provide a clear and compact way to represent a method interface using an expression.
They enable functional programming by allowing functions to be passed 
as arguments, returned as values, and stored in variables.


#### A lambda expression consists of three parts:

 1. **Argument List**: Enclosed in parentheses (), the argument list defines the parameters required by the expression. 
 2. **Arrow Token:** The "**->**" symbol denotes that the expression before it is the arguments and the expression after it is the body.
 3. **Body**: Contains the code that defines the actions of the lambda expression. It can be a single expression or a block of statements enclosed in {}.

![LamdaExpression.png](resources%2FLamdaExpression.png)

### Syntax
```java
// Example: Comparator using lambda expression for sorting transactions by amount
Comparator<Transaction> byAmount = (Transaction t1, Transaction t2) -> t1.getAmount().compareTo(t2.getAmount());
```
In this example:

* "(Transaction t1, Transaction t2)" is the **argument list**.
* "->" is the **arrow token**.
* t1.getAmount().compareTo(t2.getAmount()) is the **body**, which implements the comparator logic.

### Functional Interfaces
A functional interface has exactly one abstract method and is often used as the assignment target for a lambda expression.

```java
// Example: Functional interface for checking transaction validity
@FunctionalInterface
interface TransactionValidator {
    boolean isValid(Transaction t);
}

// Usage
TransactionValidator isLargeTransaction = (Transaction t) -> t.getAmount() > 1000;
```

* This single line of code creates an instance of **TransactionValidator** named **isLargeTransaction**.
* It uses a lambda expression **"(Transaction t) -> t.getAmount() > 1000"** to define the behavior of the **isValid** method.
* In this lambda expression:
**(Transaction t)** specifies the input parameter to the **isValid** method, which is a Transaction object named t.
* **t.getAmount() > 1000** is the implementation of the **isValid** method. It checks if the amount of 
the transaction (t.getAmount()) is greater than 1000 and returns **true** if it is, indicating that 
the transaction is considered valid for being "**large**."

**To sum up:**
This code defines a functional interface TransactionValidator with a single abstract method isValid. 
It then creates an instance of this interface using a lambda expression to define the logic for checking if a transaction is considered "large" based on its amount.

### Method References
Method references are a shorthand notation for lambda expressions, allowing to refer to methods by their names.

```java
// Example: Method reference for printing transaction details
transactions.forEach(System.out::println);
```
In this code:

1. **transactions** is assumed to be some collection or iterable (e.g., a list, array, or stream) that contains objects of a type compatible with the System.out.println method.
   forEach:

2. **forEach** is a method available on collections and streams in Java. It is used for iterating over the elements in the collection and performing an action on each element.

3. **System.out::println**: This is a method reference. It refers to the println method of the System.out object.
System.out is the standard output stream in Java, and println is a method used to print a line to the console.

**To sum up:**
When using the "System.out::println" as a method reference within **forEach**, it means that for each element in the transactions collection, 
the println method will be called, and the details of each transaction will be printed to the console.


## Streams

### Definition
Streams in Java represent a sequence of elements sourced from collections, arrays, or I/O channels, and support aggregate operations on them. 
They are designed to express calculations in a functional style, leveraging the capabilities of Lambda Expressions. 
Unlike collections, streams do not store data but rather convey elements from a source, such as a data structure, an array, or an I/O channel, 
through a pipeline of operations.

### Main Characteristics
- Non-Storage: Streams do not have a storage structure, they process data from a source.
- Functional Style Operations: Streams support operations like filter, map, and reduce, facilitating functional-style programming.
- Lazy Execution: Stream operations are lazy; computation on the source data is only performed when necessary.
- Possibility of Parallel Execution: Streams can be processed in parallel, which can lead to significant performance improvements.

### Elements of a Stream
A stream consists of the following components:
- **Source**: The data source for the stream, such as a collection or array.
- **Zero or More Intermediate Operations**: These are operations that transform the stream into another stream, such as "filter", "map", and "sorted".
- **A Terminal Operation**: These operations produce a result or a side-effect and trigger the processing of the stream. Examples include "forEach", "collect", "reduce" etc.

Here is an example of a stream that uses a collection as its source:

```java
import java.util.*;
import java.util.stream.*;

public class PaymentStreamExample {
   public static void main(String[] args) {
      // List of transaction amounts
      List<Double> transactionAmounts = Arrays.asList(100.0, 1500.5, 200.75, 3000.0, 450.0);

      // Define a threshold for filtering high-value transactions
      double threshold = 1000.0;

      // Creating a Stream from the list of transaction amounts ("transactionAmounts")
      // Intermediate Operation: Filtering transactions greater than the threshold (1000.0)
      // Using lambda expression "amount -> amount > threshold" which defines the filtering logic.
      Stream<Double> highValueTransactions = transactionAmounts.stream().filter(amount -> amount > threshold);

      // Terminal Operation: Collecting filtered transactions into a List
      List<Double> highValueTransactionList = highValueTransactions.collect(Collectors.toList());

      // Outputting the Result
      System.out.println("High-value transactions: " + highValueTransactionList);
   }
}
```
In the code above:
- The list "transactionAmounts" represents a list of transaction amounts.
- We set a threshold of $1000 to filter high-value transactions.
- The stream is created from this list, and we apply a filter operation to retain only those transactions that exceed the threshold (1000.0).
- Finally, we collect these filtered transactions into a new list (highValueTransactionList) and print them.
- Collectors are used to combine stream elements into a single summary result.



### Parallel Streams
Parallel streams in Java is a feature that allows for concurrent processing of stream elements, 
allowing multiple threads, which can lead to significant performance improvements especially when dealing with large datasets.

```java
// Example: Parallel stream to process transactions concurrently
transactions.parallelStream()
            .filter(Transaction::isSuspicious)
            .forEach(alertSystem::flagTransaction);
```

In the code above:
Using "transactions.parallelStream()", a parallel stream is created from a collection ("transactions") 
allowing for concurrent execution of operations across multiple threads, as opposed to the sequential execution in a regular stream.
NOTE: Parallel Streams may not guarantee the order of processing and can introduce overhead, potentially reducing efficiency for smaller datasets or simpler tasks.

![StreamsCheatsheet.png](resources%2FStreamsCheatsheet.png)

## Resources
***
- [Lambda Expressions](https://java-8-tips.readthedocs.io/en/stable/lambdas.html#/)
- [Functional Interface/Method Reference](https://java-8-tips.readthedocs.io/en/stable/funcinterfaces.html#/)
- [Streams (Official Documentation)](https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html)
- [Intro to Streams](http://java-8-tips.readthedocs.io/en/stable/streams.html#/)
- [Stream API, main methods explained ](https://java-8-tips.readthedocs.io/en/stable/streamsapi.html#/)
- [Collectors](https://java-8-tips.readthedocs.io/en/stable/collectors.html#/)