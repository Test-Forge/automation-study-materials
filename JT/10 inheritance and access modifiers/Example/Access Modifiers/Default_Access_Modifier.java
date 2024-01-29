/**
 * In this example, we have created two packages pack and mypack. We are accessing the A class from outside its package, since A class is not public, so it cannot be accessed from
 * outside the package.
 */

//save by A.java
package pack;

class A {
    void msg() {
        System.out.println("Hello");
    }
}

//save by B.java
        package mypack;
                import pack.*;

class B {
    public static void main(String args[]) {
        A obj = new A();//Compile Time Error
        obj.msg();//Compile Time Error
    }
}

/**
 * In the above example, the scope of class A and its method msg() is default so it cannot be accessed from outside the package.
 */
