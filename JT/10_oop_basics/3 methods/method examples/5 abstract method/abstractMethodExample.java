// Abstract class
abstract class abstractMethodExample {
    // Abstract method declaration
    abstract void display();
}

public class MyClass extends Demo {
    // Method impelmentation
    void display() {
        System.out.println("Abstract method?");
    }

    public static void main(String args[]) {
        // Creating object of abstract class
        AbstractMethodExample obj = new MyClass();

        // Invoking abstract method
        obj.display();
    }
}