package Examples.Abstraction.viaClass;

public class ShapeTester {

    public static void main(String[] args) {

        Shape rectangle = new Rectangle(4, 5);
        rectangle.print();
        System.out.println(rectangle.calculateArea());
        System.out.println(rectangle.calculatePerimeter());

        Shape square = new Square(3);
        square.print();
        System.out.println(square.calculateArea());
        System.out.println(square.calculatePerimeter());

    }
}
