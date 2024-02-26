// Class 1: Outer class
class Outer {
    private static void outerMethod() {
        System.out.println("inside outerMethod");
    }

    // Class 2: Inner class
    class Inner {
        public static void display() {
            System.out.println("inside inner class Method");

            // Calling method inside main() method
            outerMethod();
        }
    }
}

// Class 3: Main class
class Main {
    public static void main(String args[]) {
        // Calling method static display method rather than an instance of that class.
        Outer.Inner.display();
    }
}