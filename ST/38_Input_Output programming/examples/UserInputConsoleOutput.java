import java.util.Scanner;

    /*
    The program will wait for the user to enter some text.
    After the user enters the text and presses Enter,
    the program will display the entered text back to the user.
    */

public class UserInputExample {
    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter some text
        System.out.print("Enter some text: ");

        // Read the input provided by the user
        String userInput = scanner.nextLine();

        // Display the input back to the user
        System.out.println("You entered: " + userInput);

        // Close the Scanner object to release resources
        scanner.close();
    }
}


