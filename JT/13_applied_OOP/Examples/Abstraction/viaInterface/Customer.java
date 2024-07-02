package Examples.Abstraction.viaInterface;

public class Customer {
    public static void main(String[] args) {

        Product book = new Book();
        book.setPrice(9.95);
        System.out.println(book.getPrice());
        System.out.println(book.getBarcode());
    }
}
