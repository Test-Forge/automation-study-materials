/**
 * In this example, we have created the two packages pack and mypack. The A class of pack package is public, so can be accessed from outside the package. But msg method of this package
 * is declared as protected, so it can be accessed from outside the class only through inheritance.
 */

//save by A.java
package pack;

public class A {
    protected void msg() {
        System.out.println("Hello");
    }
}

//save by B.java
        package mypack;
                import pack.*;

class B extends A {
    public static void main(String args[]) {
        B obj = new B();
        obj.msg();
    }
}

/**
 * On executing the program, you will get the following result:
 * Hello
 */