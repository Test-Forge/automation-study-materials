public class EmployeeManagement {

    // Class name: Starts with an uppercase letter, uses nouns (e.g., EmployeeManagement)
    // Describes the purpose of managing employee data

    private int employeeId; // Variable: Starts with a lowercase letter, uses meaningful names
    private String firstName;
    private String lastName;

    public EmployeeManagement(int id, String firstName, String lastName) {
        // Constructor: Follows the class name, initializes instance variables
        this.employeeId = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void displayEmployeeDetails() {
        // Method: Starts with a lowercase letter, uses verbs (e.g., displayEmployeeDetails)
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + firstName + " " + lastName);
    }

    // Constants: All uppercase with underscores (e.g., MAX_AGE)
    private static final int MIN_AGE = 18;
    private static final int MAX_AGE = 60;

    public static void main(String[] args) {
        // Main method: Entry point of the program
        EmployeeManagement emp1 = new EmployeeManagement(101, "John", "Doe");
        emp1.displayEmployeeDetails();

        // Example of using constants
        System.out.println("Minimum age requirement: " + MIN_AGE);
        System.out.println("Maximum retirement age: " + MAX_AGE);
    }
}
