/*
 Java program to demonstrate that in both static and non-static methods, static methods are directly accessed.
 */

import java.io.*;

public class secondExampleOfStaticMethod {

    static int num = 100;
    static String str = "GeeksForGeeks";

    // This is Static method
    static void display() {
        System.out.println("static number is " + num);
        System.out.println("static string is " + str);
    }

    // Non-static method
    void nonstatic() {
        // Static method can accessed in non static method
        display();
    }

    // Main method
    public static void main(String args[]) {
        StaticExample obj = new StaticExample();

        // This is object to call non static function
        obj.nonstatic();

        // Static method can called directly without an object
        display();
    }
}