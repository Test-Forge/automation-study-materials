import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SimpleInputToFile {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for input
        System.out.println("Enter some text:");
        String userInput = scanner.nextLine();

        // Define the filename
        String filename = "userInput.txt";

        // Use FileWriter to write the input to a file
        FileWriter writer = new FileWriter(filename);
        writer.write(userInput);
        writer.close();

        System.out.println("Your input was saved to " + filename);

        scanner.close();
    }
}