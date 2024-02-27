class Calculation {
    int z;

    public void addition(int x, int y) {
        z = x + y;
        System.out.println("The sum of the given numbers:" + z);
    }

    public void Subtraction(int x, int y) {
        z = x - y;
        System.out.println("The difference between the given numbers:" + z);
    }
}

public class My_Calculation extends Calculation {
    public void multiplication(int x, int y) {
        z = x * y;
        System.out.println("The product of the given numbers:" + z);
    }

    public static void main(String args[]) {
        int a = 20, b = 10;
        My_Calculation demo = new My_Calculation();
        demo.addition(a, b);
        demo.Subtraction(a, b);
        demo.multiplication(a, b);
    }
}
/**
 * After executing the program, it will produce the following result:
 * The sum of the given numbers:30
 * The difference between the given numbers:10
 * The product of the given numbers:200
 * <p>
 * In the given program, when an object to My_Calculation class is created, a copy of the contents of the superclass is made within it. That is why, using the object of th
 * subclass you can access the members of a superclass.
 * <p>
 * The Superclass reference variable can hold the subclass object, but using that variable you can access only the members of the superclass, so to access the members of both
 * classes it is recommended to always create reference variable to the subclass.
 * <p>
 * If you consider the above program, you can instantiate the class as given below. But using the superclass reference variable(cal in this case) you cannot call the method
 * multiplication(), which belongs to the subclass My_Calculation.
 * <p>
 * Calculation demo = new My_Calculation();
 * demo.addition(a, b);
 * demo.Subtraction(a, b);
 */
