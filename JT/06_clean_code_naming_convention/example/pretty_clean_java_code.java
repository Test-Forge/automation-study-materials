public class Rectangle {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double calculateArea() {
        return length * width;
    }

    public void printArea() {
        double area = calculateArea();
        System.out.println("Area: " + area);
    }
}
