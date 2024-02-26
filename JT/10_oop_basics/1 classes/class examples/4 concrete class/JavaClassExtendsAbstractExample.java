/*
 Declaring abstract class JavaClassExtendsAbstractExample = shape

 In the bellow code, Shape is a abstract class with abstract methods area() and perimeter().
 Classes Circle, Triangle, and Square inherit the abstract class shape and implement both abstract methods.
 As the classes Circle, Triangle and Square have all the methods implemented they are Java Classes.
 */
abstract class JavaClassExtendsAbstractExample {
    abstract double area();   // Unimplemented method area

    abstract double perimeter();  // Unimplemented method perimeter
}

// Declaring class Circle that extends class JavaClassExtendsAbstractExample
class Circle extends JavaClassExtendsAbstractExample {
    // Declaring required varibles
    double r = 5; // Radius of circle

    public double area() {
        // Implementing parent class method area
        return 3.14 * r * r;  // Area of Circle = π r^2
    }

    public double perimeter() {
        // Implementing parent class method perimeter
        return 2 * 3.14 * r; // Perimeter of Circle = 2 π r
    }
}

// Declaring class Triangle that extends class JavaClassExtendsAbstractExample
class Triangle extends JavaClassExtendsAbstractExample {
    // Declaring required variables
    double a = 5; // Side of triangle
    double b = 12; // Base of triangle
    double c = 9; // Side of triangle
    double h = 4; // Height of traingle

    public double area() {
        // Implementing parent class method area
        return b * h / 2; // Area of traingle = ½ × Base × Height
    }

    public double perimeter() {
        // Implementing parent class method perimeter
        return a + b + c; // Perimeter of triangle = a + b + c (Sum of all sides)
    }
}

// Declaring class Square that extends class ConcreteClassExtendsAbstractExample
class Square extends JavaClassExtendsAbstractExample {
    // Declaring required variables
    double a = 8; // Side of square

    public double area() {
        // Implementing parent class method area
        return a * a;  // Area of Square = a * a (side square)
    }

    public double perimeter() {
        // Implementing parent class method perimeter
        return 4 * a; // Perimeter of Square = 4 * side (Sum of all sides)
    }
}

public class DemoMain {
    public static void main(String[] args) {

        // Creating objects of Java class circle
        Circle c = new Circle();

        // Calling methods of Java class circle
        double c_area = c.area();
        double c_perimeter = c.perimeter();

        System.out.println("Area of Circle: " + c_area);
        System.out.println("Perimeter of Circle: " + c_perimeter);


        // Creating objects of Java class triangle
        Triangle t = new Triangle();

        // Calling methods of Java class triangle
        double t_area = t.area();
        double t_perimeter = t.perimeter();

        System.out.println("Area of Triangle: " + t_area);
        System.out.println("Perimeter of Triangle: " + t_perimeter);


        // Creating objects of Java class square
        Square s = new Square();

        // Calling methods of Java class square
        double s_area = s.area();
        double s_perimeter = s.perimeter();

        System.out.println("Area of Square: " + s_area);
        System.out.println("Perimeter of Square: " + s_perimeter)
    }
}