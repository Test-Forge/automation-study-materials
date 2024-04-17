package Examples.Abstraction.viaInterface;

public interface Product {

    double getPrice();

    void setPrice(double price);

    String getName();

    void setName(String name);

    String getColor();

    void setColor(String color);

    //implemented method
    default String getBarcode() {
        return "no barcode";
    }
}
