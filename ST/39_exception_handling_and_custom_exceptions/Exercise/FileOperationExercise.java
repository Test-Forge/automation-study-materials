import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;

public class FileOperationExercise {

    private static final Logger logger = Logger.getLogger(FileOperationExercise.class.getName());

    //Run this method by clicking on Run FileOperationExercise.main()
    public static void main(String[] args) {
        try {
            //Change fileName to get IOException
            performFileOperations("sample_file.txt");
        } catch (IOException e) {
            logger.severe("IOException occurred: " + e.getMessage());
        } catch (InvalidDataException e) {
            logger.severe("InvalidDataException occurred: " + e.getMessage());
        } catch (ArithmeticException e) {
            logger.severe("ArithmeticException occurred: " + e.getMessage());
        }
    }

    private static void performFileOperations(String fileName) throws IOException, InvalidDataException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int number = convertToInteger(line);
                // Performs division on 0 if provided value "10" - throws an ArithmeticException
                if (number == 10) {
                    int divideOnZero = number / 0;
                }
            }
        }
    }

    //This method is trying to parse value from file to Integer , if fails throws your InvalidDataException
    private static int convertToInteger(String input) throws NumberFormatException, InvalidDataException {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidDataException("Invalid data format: " + input);
        }
    }
}
