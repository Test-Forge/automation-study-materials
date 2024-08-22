/**
 * In order to test your understanding of Streams in Java, try to solve the problems below.
 * (You can then check your solutions against the proposed solutions below)
 * <p>
 * Before solving the questions below, it is highly recommended to read/analyze the following:
 * "Streams_And_Lambda_Expressions.adoc" and StreamExamples.java
 * <p>
 * Question 1: Given a list of transactions, how would you use streams to find the average amount of all transactions?
 * Question 2: How would you use streams to group a list of transactions by their status (e.g., COMPLETED, PENDING)?
 * Question 3: Using streams, how can you create a list of unique customer IDs from a list of transactions?
 * Question 4: Write a stream pipeline to check if any transaction in a list exceeds a certain threshold amount.
 */

import java.util.*;
import java.util.stream.*;
import java.util.function.Predicate;

public class StreamsTestYourKnowledge {

    public static void main(String[] args) {
        // Solutions for each question (mentioned above) is implemented as a separate method
        solutionForQuestion1();
        solutionForQuestion2();
        solutionForQuestion3();
        solutionForQuestion4();
    }

    // Solution for Question 1
    // Given a list of transactions, how would you use streams to find the average amount of all transactions?
    private static void solutionForQuestion1() {
        // Creating a list to hold transactions. (In a real-world application, this list would be populated from a data source)
        List<Transaction> transactions = new ArrayList<>();
        double averageAmount = transactions.stream()
                // Mapping each transaction to its amount
                .mapToDouble(Transaction::getAmount)
                .average()
                // Providing a default value if there are no transactions
                .orElse(0.0);
        System.out.println("Average Transaction Amount: " + averageAmount);
    }


    // Alternative Solution for Question 1 (in case we don't want to set a default value for missing transactions in the stream, but throw an exception)
    private static void solutionForQuestion1() {
        // Creating a list to hold transactions. (In a real-world application, this list would be populated from a data source)
        List<Transaction> transactions = new ArrayList<>();
        double averageAmount;

        try {
            averageAmount = transactions.stream()
                    // Mapping each transaction to its amount
                    .mapToDouble(Transaction::getAmount)
                    .average()
                    // Throwing an exception if there are no transactions to calculate the average
                    .orElseThrow(() -> new NoSuchElementException("No transactions available in the stream to calculate the average."));
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
            // Exit the method if there is an exception
            return;
        }

        System.out.println("Average Transaction Amount: " + averageAmount);
    }


    // Solution for Question 2
    // How would you use streams to group a list of transactions by their status (e.g., COMPLETED, PENDING)?
    private static void solutionForQuestion2() {
        List<Transaction> transactions = new ArrayList<>();
        // Grouping transactions by their status
        Map<String, List<Transaction>> transactionsByStatus = transactions.stream()
                // Grouping by transaction status
                .collect(Collectors.groupingBy(Transaction::getStatus));
        System.out.println(transactionsByStatus);
    }

    // Solution for Question 3
    // Using streams, how can you create a list of unique customer IDs from a list of transactions?
    private static void solutionForQuestion3() {
        List<Transaction> transactions = new ArrayList<>();

        List<String> uniqueCustomerIds = transactions.stream()
                .map(Transaction::getCustomerId)
                // Filtering out duplicate IDs
                .distinct()
                // Collecting the result into a list
                .collect(Collectors.toList());
        System.out.println(uniqueCustomerIds);
    }

    // Solution for Question 4
    // Write a stream pipeline to check if any transaction in a list exceeds a certain threshold amount (1000.0 euros).
    private static void solutionForQuestion4() {
        List<Transaction> transactions = new ArrayList<>();
        // Setting a threshold amount (1000.0 euros)
        double threshold = 1000.0;

        // Checking if any transaction in the list exceeds the threshold
        boolean anyLargeTransaction = transactions.stream()
                // Checking if any transaction's amount is greater than the threshold
                .anyMatch(t -> t.getAmount() > threshold);
        System.out.println("Any transaction exceeds threshold: " + anyLargeTransaction);
    }
}

class Transaction {
    private String id;
    private String customerId;
    private double amount;
    private String status;

    public Transaction(String id, String customerId, double amount, String status) {
        this.id = id;
        this.customerId = customerId;
        this.amount = amount;
        this.status = status;
    }

    public double getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }

    public String getCustomerId() {
        return customerId;
    }
    // Other getters and setters
}
