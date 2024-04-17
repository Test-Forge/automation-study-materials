package Examples.Abstraction.viaClass;

public abstract class Shape {
    // abstract method in an abstract class
    abstract double calculateArea();
    abstract double calculatePerimeter();

    // method in an abstract class
    public void print() {
        System.out.println("I am a shape");
    }
}
