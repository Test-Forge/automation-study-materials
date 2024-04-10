import java.util.Scanner;

public class UserDefinedMethodExample {
    public static void main(String args[]) {
        // Creating Scanner class object
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number: ");

        // Reading value from user
        int num = scan.nextInt();

        // Method calling
        findEvenOdd(num);
    }

    // User defined method
    public static void findEvenOdd(int num) {
        // Method body
        if (num % 2 == 0)
            System.out.println(num + " is even");
        else
            System.out.println(num + " is odd");
    }
}