public class PaymentLambdaExamples {

    public static void main(String[] args) {
        // Example of a simple lambda expression for comparing transaction amounts
        Comparator<Transaction> byAmount = (Transaction t1, Transaction t2) -> t1.getAmount().compareTo(t2.getAmount());
        // Example of a block lambda expression for complex transaction processing
        PaymentProcessor processor = (Transaction transaction) -> {
            if (transaction.getAmount() > 1000) {
                return "High-value transaction";
            }
            return "Regular transaction";
        };

        // Using a functional interface to filter transactions
        List<Transaction> transactions = getTransactions();
        Predicate<Transaction> filter = (Transaction t) -> t.getStatus().equals("COMPLETED");
        transactions.stream().filter(filter).forEach(System.out::println);
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

// "PaymentProcessor" is a functional interface with one abstract method ("process").
// In the code above a lambda expression provides the implementation for the "process" method of the PaymentProcessor interface
interface PaymentProcessor {
    String process(Transaction transaction);
}