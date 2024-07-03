/**
 * In order to test your understanding of Lambda Expressions, try to solve the problems below.
 * (You can then check your solutions against the proposed solutions below)
 * <p>
 * Before solving the questions, it is highly recommended to read/analyze the following:
 * "Complete_Guide_Streams_Lambda_Expressions_Java_Payments_README.md" and LambdaExpressionExamples.java
 * <p>
 * Question 1: How would you write a lambda expression to sort a list of transactions by their amount?
 * Question 2: Create a lambda expression for a functional interface that validates if a transaction is above a certain amount
 * Question 3: Given a list of strings, write a lambda expression to filter out all strings that are shorter than 3 characters.
 * Question 4: How would you use a lambda expression to transform a map's values (e.g., applying a tax percentage to all prices in a map)?
 */

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import javax.swing.*;
import java.awt.event.*;

public class LambdaTestYourKnowledge {

    public static void main(String[] args) {
        // Solutions for each question (mentioned above) is implemented as a separate method
        solutionForQuestion1();
        solutionForQuestion2();
        solutionForQuestion3();
        solutionForQuestion4();
    }

    // Solution for Question 1
    // How would you write a lambda expression to sort a list of transactions by their amount?
    private static void solutionForQuestion1() {
        // Assuming "Transaction" is a class with a method "getAmount()"
        List<Transaction> transactions = new ArrayList<>();
        // Sorting transactions by amount using lambda expression
        transactions.sort((t1, t2) -> Double.compare(t1.getAmount(), t2.getAmount()));
        transactions.forEach(System.out::println);
    }

    // Solution for Question 2
    // Create a lambda expression for a functional interface that validates if a transaction is above a certain amount (say "1000" dollars)
    private static void solutionForQuestion2() {
        // Functional interface for validating a transaction
        Predicate<Transaction> isLargeTransaction = transaction -> transaction.getAmount() > 1000;
        // Assuming 'transaction' is an instance of Transaction
        Transaction transaction = new Transaction("id", 1200.0, "type", "status");
        System.out.println("Is large transaction: " + isLargeTransaction.test(transaction));
    }

    // Solution for Question 3
    // Given a list of strings, write a lambda expression to filter out all the strings that are shorter than 3 characters.
    private static void solutionForQuestion3() {
        List<String> strings = Arrays.asList("a", "ab", "abc", "abcd");
        // Filtering out strings shorter than 3 characters
        List<String> filteredStrings = strings.stream().filter(str -> str.length() >= 3).collect(Collectors.toList());
        System.out.println(filteredStrings);
    }

    // Solution for Question 4
    // Write a lambda expression to transform a map's values (applying a tax percentage to all prices in a map).
    private static void solutionForQuestion4() {
        Map<String, Double> prices = new HashMap<>();
        prices.put("iPhone15", 799.9);
        prices.put("XiaomiRedmiNote12", 159.9);
        // Applying a tax of 10% to each price (value) in the map. In our case the value of the map is the price of the phone.
        prices.replaceAll((key, value) -> value + value * 0.10);
        System.out.println(prices);
    }
}

class Transaction {
    private String id;
    private double amount;
    private String type;
    private String status;

    public Transaction(String id, double amount, String type, String status) {
        this.id = id;
        this.amount = amount;
        this.type = type;
        this.status = status;
    }

    public double getAmount() {
        return amount;
    }
    // Other getters and setters
}
