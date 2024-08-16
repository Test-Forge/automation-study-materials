import java.util.*;
import java.util.stream.Collectors;

public class PaymentStreamExamples {

    public static void main(String[] args) {
        List<Transaction> transactions = getTransactions();

        // filter operation - Filters transactions based on a condition (ex. "CREDIT" type)
        transactions.stream()
                .filter(t -> t.getType().equals("CREDIT"))
                .forEach(System.out::println);

        // map operation - Transforms each transaction to its amount
        transactions.stream()
                // a method reference that calls the "getAmount" method on each "Transaction" object in the stream.
                // each Transaction object is transformed into its amount value
                .map(Transaction::getAmount)
                .forEach(System.out::println);

        // flatMap operation - it transforms a stream of multiple lists into a single stream of elements by merging or "flattening" them.
        // In this case, it's flattening the list of lists of transactions into a single stream of transactions.
        List<List<Transaction>> transactionLists = Arrays.asList(transactions, transactions);
        transactionLists.stream()
                .flatMap(List::stream)
                .forEach(System.out::println);

        // distinct operation - removes duplicate transactions (based on transaction id)
        transactions.stream()
                .map(Transaction::getId)
                .distinct()
                .forEach(System.out::println);

        // sorted operation - sorts transactions by amount
        transactions.stream()
                .sorted(Comparator.comparingDouble(Transaction::getAmount))
                .forEach(System.out::println);

        // peek operation- performs an action on each element WITHOUT altering the stream
        transactions.stream()
                .peek(t -> System.out.println("Processing: " + t))
                .collect(Collectors.toList());

        // limit operation - Limits the stream to the first 5 transactions
        transactions.stream()
                .limit(5)
                .forEach(System.out::println);

        // collect operation - collects transactions into a list
        List<Transaction> creditTransactions = transactions.stream()
                .filter(t -> t.getType().equals("CREDIT"))
                .collect(Collectors.toList());

        // reduce operation - combines all the amounts to a total sum
        double totalAmount = transactions.stream()
                .map(Transaction::getAmount)
                .reduce(0.0, Double::sum);

        // count operation - counts the number of DEBIT transactions
        long debitCount = transactions.stream()
                .filter(t -> t.getType().equals("DEBIT"))
                .count();

        // anyMatch operation - Checks if there is any transaction with an amount greater than 1000
        boolean hasHighValueTransaction = transactions.stream()
                .anyMatch(t -> t.getAmount() > 1000);

        // allMatch operation - Checks if all transactions are COMPLETED
        boolean allCompleted = transactions.stream()
                .allMatch(t -> t.getStatus().equals("COMPLETED"));

        // findFirst operation - finds the first transaction (if any)
        Optional<Transaction> firstTransaction = transactions.stream()
                .findFirst();

        System.out.println("Credit Transactions: " + creditTransactions);
        System.out.println("Total Amount: " + totalAmount);
        System.out.println("Number of DEBIT Transactions: " + debitCount);
        System.out.println("Has High Value Transaction: " + hasHighValueTransaction);
        System.out.println("All Transactions Completed: " + allCompleted);
        firstTransaction.ifPresent(t -> System.out.println("First Transaction: " + t));
    }

    private static List<Transaction> getTransactions() {
        // Dummy data for transactions
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction("T1", 200.0, "CREDIT", "COMPLETED"));
        transactions.add(new Transaction("T2", 500.0, "DEBIT", "PENDING"));
        transactions.add(new Transaction("T3", 1500.0, "CREDIT", "COMPLETED"));
        transactions.add(new Transaction("T4", 750.0, "DEBIT", "COMPLETED"));
        return transactions;
    }
}

// Dummy Transaction class for the sake of the examples above
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

    public String getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", amount=" + amount +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}