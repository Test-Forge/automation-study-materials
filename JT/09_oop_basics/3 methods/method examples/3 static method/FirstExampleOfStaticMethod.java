/*
 Java program to demonstrate that the static method does not have access to the instance variable.

 The JVM runs the static method first, followed by the creation of class instances.
 Because no objects are accessible when the static method is used.
 A static method does not have access to instance variables.
 As a result, a static method can’t access a class’s instance variable.
 */

import java.io.*;

public class FirstExampleOfStaticMethod {
    // Static variable
    static int a = 40;

    // Instance variable
    int b = 50;

    void simpleDisplay() {
        System.out.println(a);
        System.out.println(b);
    }

    // Declaration of a static method.
    static void staticDisplay() {
        System.out.println(a);
    }

    // Main method
    public static void main(String[] args) {
        FirstExampleOfStaticMethod obj = new FirstExampleOfStaticMethod();
        obj.simpleDisplay();

        // Calling static method.
        staticDisplay();
    }
}