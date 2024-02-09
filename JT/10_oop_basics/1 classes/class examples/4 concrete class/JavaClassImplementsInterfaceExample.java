/*
In the bellow code DemoInterface is an interface implemented by the abstract class DemoAbstract.
The class 'JavaClassImplementsInterfaceExample' implements the methods inherited from both the interface and the abstract class.
 */

// This is an interface
interface DemoInterface {
    int product(int a, int b);

    int sum(int a, int b);
}

// This is an abstract class that implements interface
abstract class DemoAbstract implements DemoInterface {

    // This method calculates product of two numbers
    public int product(int a, int b) {
        return a * b;
    }
}

// This is a concrete class that extends abstract class
class JavaClassImplementsInterfaceExample extends DemoAbstract {

    // This method calculates sum of two numbers
    public int sum(int a, int b) {
        return a + b;
    }

    // Main method
    public static void main(String args[]) {
        DemoJava obj = new DemoJava();
        int p = obj.product(19, 16);
        int s = obj.sum(1155, 190);

        // Print product
        System.out.println("Product: " + p);

        // Print sum
        System.out.println("Sum: " + s);
    }
}