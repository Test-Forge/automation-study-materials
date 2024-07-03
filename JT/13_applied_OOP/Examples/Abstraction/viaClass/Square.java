package Examples.Abstraction.viaClass;

public class Square extends Shape{
    private double length;

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public Square(double length){
        setLength(length);
    }

    // implementation of abstract method calculateArea()
    double calculateArea(){
        return length * length;
    }
    // implementation of abstract method calculatePerimeter()
    @Override
    double calculatePerimeter() {
        return 4 * length;
    }

}