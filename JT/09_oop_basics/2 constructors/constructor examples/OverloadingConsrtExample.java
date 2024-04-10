public class OverloadingConsrtExample {

    int id;
    String name;
    int age;

    // Creating 2 arg constructor
    OverloadingConsrtExample(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Creating 3 arg constructor
    OverloadingConsrtExample(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    /*
     Creating the objects of the class 'OverloadingConsrtExample' by passing different arguments
    */
    public static void main(String[] args) {

        // Invoke the constructor with 2 arguments
        OverloadingConsrtExample obj1 = new OverloadingConsrtExample(1, "FirstObject");

        // Invoke the constructor with 3 arguments
        OverloadingConsrtExample obj2 = new OverloadingConsrtExample(2, "SecondObject", 13);
    }
}