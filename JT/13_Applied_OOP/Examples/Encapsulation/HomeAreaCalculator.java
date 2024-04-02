package Examples.Encapsulation;


public class HomeAreaCalculator {

    public static void main(String args[]) {

        //Create instance of Rectangle class calling the default constructor
        Rectangle room1 = new Rectangle();
        room1.setWidth(25);
        room1.setLength(50);
        double areaOfRoom1 = room1.calculateArea();

        //Create instance of Rectangle class calling the 2nd constructor
        Rectangle room2 = new Rectangle(30, 75);
        double areaOfRoom2 = room2.calculateArea();

        double totalArea = areaOfRoom1 + areaOfRoom2;

        System.out.println("Area of both rooms: " + totalArea);
    }

}