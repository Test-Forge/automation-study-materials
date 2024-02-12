import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to choose the conversion type
        System.out.println("Choose the conversion type:");
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");
        System.out.print("Enter your choice (1 or 2): ");

        // Read the choice provided by the user
        int choice = scanner.nextInt();

        double temperature;
        double convertedTemperature;

        // Perform the conversion based on the user's choice
        if (choice == 1) {
            // Convert Celsius to Fahrenheit
            System.out.print("Enter temperature in Celsius: ");
            temperature = scanner.nextDouble();
            convertedTemperature = celsiusToFahrenheit(temperature);
            System.out.println("Temperature in Fahrenheit: " + convertedTemperature);
        } else if (choice == 2) {
            // Convert Fahrenheit to Celsius
            System.out.print("Enter temperature in Fahrenheit: ");
            temperature = scanner.nextDouble();
            convertedTemperature = fahrenheitToCelsius(temperature);
            System.out.println("Temperature in Celsius: " + convertedTemperature);
        } else {
            System.out.println("Invalid choice. Please enter either 1 or 2.");
        }

        // Close the Scanner object to release resources
        scanner.close();
    }

    // Function to convert Celsius to Fahrenheit
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    // Function to convert Fahrenheit to Celsius
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
}