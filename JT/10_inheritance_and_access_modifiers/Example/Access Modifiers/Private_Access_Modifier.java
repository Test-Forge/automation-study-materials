/**
 * In this example, we have created two classes A and Simple. A class contains private data member and private method. We are accessing these private members from outside the class, so there is a
 * compile-time error.
 */

class A {
    private int data = 40;

    private void msg() {
        System.out.println("Hello java");
    }
}

public class Simple {
    public static void main(String args[]) {
        A obj = new A();
        System.out.println(obj.data);//Compile Time Error
        obj.msg();//Compile Time Error
    }
}


/**
 * Role of Private Constructor
 * If you make any class constructor private, you cannot create the instance of that class from outside the class. For example:
 */

class A {
    private A() {
    }//private constructor

    void msg() {
        System.out.println("Hello java");
    }
}

public class Simple {
    public static void main(String args[]) {
        A obj = new A();//Compile Time Error
    }
}