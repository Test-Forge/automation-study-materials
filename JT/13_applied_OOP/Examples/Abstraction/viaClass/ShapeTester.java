package Examples.Abstraction.viaClass;

public class ShapeTester {

    public static void main(String[] args) {
//        abstract class cannot be instantiated directly without declaring all it's methods, otherwise will produce compile error
//        Shape defaultShape = new Shape();

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
