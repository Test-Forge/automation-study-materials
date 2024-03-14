package assertions_example;

public class Book {
    private String title;
    private String author;
    private String language;
    private int numberOfPages;
    private int year;
    private double price;

    public Book() {
    }

    public Book(String title, String author, String language, int numberOfPages, int year, double price) {
        if (title == null || title.trim().isEmpty())
            throw new IllegalArgumentException();

        this.title = title;
        this.author = author;
        this.language = language;
        this.numberOfPages = numberOfPages;
        this.year = year;
        this.price = price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setNumberOfPages(int numberOfPages) {
        if (numberOfPages > 0) {
            this.numberOfPages = numberOfPages;
        }
    }

    public void setYear(int year) {
        if (year > 0)
            this.year = year;
    }

    public void setPrice(double price) {
        if (price > 0.0)
            this.price = price;
    }

    public String getTitle() {

        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getLanguage() {
        return language;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }
}