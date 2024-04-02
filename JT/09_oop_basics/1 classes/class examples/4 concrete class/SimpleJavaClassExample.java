/*
    Java calculator class to perform arithmetic operations.
    SimpleJavaCalculator = SimpleJavaClassExample

    In the bellow code, the JavaCalculator class has 4 methods that perform arithmetic operations.
    All four methods add, subtract, multiply, divide are implemented and return the result.
    As all the methods of the class have been implemented JavaCalculator is a Java class.
 */
class Calculator {
    static int add(int a, int b) {
        // This method calculates the sum of two numbers
        return a + b;
    }

    static int subtract(int a, int b) {
        // This method calculates the difference between two numbers
        return a - b;
    }

    static int multiply(int a, int b) {
        // This method calculates product of two numbers
        return a * b;
    }

    static int divide(int a, int b) {
        // This method calculates the division of two numbers
        return a / b;
    }

    //Main method
    public static void main(String[] args) {
        int sum = add(100, 154); // Calls method add and stores result
        int diff = subtract(154, 79); // Calls method subtract and stores result
        int prod = multiply(7, 8); // Calls method multiply and stores result
        int div = divide(345, 5); // Calls method divide and stores result

        // Print results of all the operations
        System.out.println("Addition result: " + sum);
        System.out.println("Subtraction result: " + diff);
        System.out.println("Multiplication result: " + prod);
        System.out.println("Division result: " + div);
    }
}