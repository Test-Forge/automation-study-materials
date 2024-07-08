package Examples.Abstraction.viaInterface;

public class Customer {
    public static void main(String[] args) {

        Book defaultBook = new Book();
        defaultBook.setBestseller(true);
        defaultBook.setPages(356);

        Product book = (Product) defaultBook;
        book.setPrice(9.95);
        book.setName("Clean Code");

        Bestseller bestseller = (Bestseller) book;
        bestseller.isBestseller();
        System.out.println(book.getPrice());
        System.out.println(book.getBarcode());
    }
}
