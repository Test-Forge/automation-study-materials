package assertions_example;

import org.assertj.core.api.SoftAssertions;
import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.jupiter.api.*;

import java.util.*;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.AnyOf.anyOf;
import static org.hamcrest.core.CombinableMatcher.both;
import static org.hamcrest.core.Every.everyItem;
import static org.hamcrest.object.HasToString.hasToString;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class TestAssertions {

    Book book1 = new Book("Nineteen Eighty-Four", " George Orwell", "English", 465, 2002, 120.55);
    Book book2 = new Book("Animal Farm", " George Orwell", "English", 210, 2005, 89.90);
    Book book3 = new Book("451 Fahrenheit", "Ray Bradbury", "Romanian", 560, 2010, 120.50);
    Book book4 = new Book();
    Book book5 = book1;
    Book book6 = new Book("A Tale of Two Cities", "Charles Dickens", "English", 213, 1859, 86099.00);
    List<Book> books = new ArrayList<>(Arrays.asList(book1, book2, book3));

    // junit assert validations
    @Test
    @DisplayName("JUnit assert true validation")
    public void junitAssertTrueTest() {
        assertTrue(book1.getNumberOfPages() < book3.getNumberOfPages(), String.format("Book with title %s has no less number of pages than book with title %s", book1.getTitle(), book3.getTitle()));
    }

    @Test
    @DisplayName("JUnit assert null validation")
    public void junitAssertNullTest() {
        assertNull(book4.getTitle(), "Book have a title");
    }

    @Test
    @DisplayName("JUnit assert same validation")
    public void junitAssertSameTest() {
        assertSame(book5, book1, "Variables does not refer to the same object");
    }

    @Test
    @DisplayName("JUnit assert equals validation")
    public void junitAssertEqualTest() {
        assertEquals(book1.getAuthor(), book2.getAuthor(), () -> "Books have different authors");
    }

    @Test
    @DisplayName("JUnit floating point assert equals validation")
    public void junitAssertEqualFloatingPointTest() {
        assertEquals(book1.getPrice(), book3.getPrice(), 0.1, () -> "Books have about the same price with delta of 10 bani");
    }

    @Test
    @DisplayName("JUnit assert array equals validation")
    public void junitAssertArrayEqualsTest() {
        int[] expectedNumberOfPages = {465, 210, 560};
        int[] actualNumberOfPages = books.stream()
                .map(Book::getNumberOfPages).mapToInt(x -> x).toArray();

        assertArrayEquals(expectedNumberOfPages, actualNumberOfPages);
    }

    @Test
    @DisplayName("JUnit assert all validation")
    void junitAssertAllTest() {
        assertAll(
                "Running multiple assertions",
                () -> assertTrue(book2.getYear() < book1.getYear()),
                () -> assertEquals(book1.getLanguage(), book3.getLanguage()),
                () -> assertNull(book3.getTitle(), "object is null")
        );
    }

    @Test
    @DisplayName("JUnit assert throws validation")
    public void assertThrowsTest() {
        String title = "";
        assertThrows(IllegalArgumentException.class, () -> new Book(title, "Unknown", "Chinese", 100, 1200), "Title shouldn't be empty!");
    }

    // hamcrest matchers validations
    @Test
    @DisplayName("Hamcrest describdAs validation")
    public void hamcrestDescribedAsTest() {
        assertThat(book3.getTitle(), describedAs("Title should contain words [451] and [Fahrenheit]", both(containsString("451")).and(containsString("Fahrenheit"))));
    }

    @Test
    @DisplayName("Hamcrest is validation")
    public void hamcrestIsTest() {
        assertThat(book3.getAuthor(), is(equalToIgnoringCase("RAY BRADBURY")));
    }

    @Test
    @DisplayName("Hamcrest allOff validation")
    public void hamcrestAllOfTest() {
        assertThat(book1.getTitle(), allOf(startsWith("Nineteen"), containsString("-"), endsWith("Four")));
    }

    @Test
    @DisplayName("Hamcrest anyOf validation")
    public void hamcrestAnyOf() {
        assertThat(book2.getAuthor(), anyOf(startsWith(" George"), containsString("Unknown")));
    }

    @Test
    @DisplayName("Hamcrest not validation")
    public void hamcrestNotTest() {
        assertThat(book1.getLanguage(), not("Russian"));
    }

    @Test
    @DisplayName("Hamcrest equalTo validation")
    public void hamcrestEqualToTest() {
        assertThat(book1.getAuthor(), equalTo(book2.getAuthor()));
    }

    @Test
    @DisplayName("Hamcrest has ToString validation")
    public void hamcrestHasToStringTest() {
        assertThat(book3.getLanguage(), describedAs("books.Book should be written in romanian", hasToString("Romanian")));
    }

    @Test
    @DisplayName("Hamcrest instanceOf validation")
    public void hamcrestInstanceOfTest() {
        assertThat(book1, describedAs("book1 should be instance of books.Book class", instanceOf(Book.class)));
    }

    @Test
    @DisplayName("Hamcrest nullValue validation")
    public void hamcrestNullValueTest() {
        assertThat(book4.getTitle(), describedAs("book4 has a title, but it should not", nullValue()));
    }

    @Test
    @DisplayName("Hamcrest sameInstance validation")
    public void hamcrestSameInstanceTest() {
        assertThat(book1, describedAs("compared books does not point to the same object", sameInstance(book5)));
    }

    @Test
    @DisplayName("Hamcrest array validation")
    public void hamcrestArrayTest() {
        Integer[] yearsOfPublication = books.stream().map(Book::getYear).mapToInt(x -> x).boxed().toArray(Integer[]::new);
        assertThat(yearsOfPublication, array(equalTo(2002), equalTo(2005), equalTo(2010)));
    }

    @Test
    @DisplayName("Hamcrest map matchers validation")
    public void hamcrestMapMatchersTest() {
        String expectedKey = book1.getTitle();
        String expectedValue = book1.getAuthor();

        Map<String, String> map = books.stream()
                .collect(Collectors.toMap(Book::getTitle, Book::getAuthor));

        assertThat(map, hasKey(expectedKey));
        assertThat(map, hasValue(expectedValue));
    }

    @Test
    @DisplayName("Hamcrest hasItem validation")
    public void hamcrestHasItemTest() {
        List<String> authors = books.stream()
                .map(Book::getAuthor)
                .collect(Collectors.toList());

        assertThat(authors, hasItems(
                containsString("Ray Bradbury"),
                containsString("George Orwell")));
    }

    @Test
    @DisplayName("Hamcrest closeTo validation")
    public void hamcrestCloseToTest() {
        assertThat(book2.getPrice(), is(closeTo(90.0, 0.1)));
    }

    @Test
    @DisplayName("Hamcrest greaterThen validation")
    public void hamcrestGreaterThenTest() {
        assertThat("The book with title " + book3.getTitle() + " should cost more than 100 lei", book3.getPrice(), greaterThan(100.0));
    }

    @Test
    @DisplayName("Hamcrest equalToIgnoringWhiteSpace validation")
    public void hamcrestEqualToIgnoringWhiteSpaceTest() {
        String expectedTitle = "  451 Fahrenheit    ";
        assertThat(book3.getTitle(), equalToIgnoringWhiteSpace(expectedTitle));
    }

    @Test
    @DisplayName("Hamcrest text machers validation")
    public void hamcrestTextMatchersTest() {
        assertThat(book1.getLanguage(), containsString("En"));
        assertThat(book1.getTitle(), endsWith("Four"));
        assertThat(book3.getTitle(), startsWith("451"));
    }

    //assertj validations
    @Test
    @DisplayName("Assertj soft assert validation")
    public void assertjSoftAssertTest() {
        SoftAssertions softly = new SoftAssertions();

        softly.assertThat(book1.getPrice()).as("The price for book number one should be 110.0").isEqualTo(110.0);
        softly.assertThat(book2.getPrice()).as("The cost of second book should be 10.0").isEqualTo(10.0);
        softly.assertThat(book3.getLanguage()).as("The book number 3 is published in russian language").isEqualTo("Russian");

        softly.assertAll();
    }

    @Test
    @DisplayName("Assertj multiple hard asser validation")
    public void assertjMultipleHardAssertTest() {
        assertThat(book1.getPrice()).as("The price for book number one should be 110.0").isEqualTo(110.0);
        assertThat(book2.getPrice()).as("The cost of second book should be 10.0").isEqualTo(10.0);
        assertThat(book3.getLanguage()).as("The book number 3 is published in russian language").isEqualTo("Russian");
    }

    @Test
    @DisplayName("Assertj soft assert validation with assertSoftly")
    public void assertjSoftAssertionWithAssertSoftly() {
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(book1.getPrice()).as("The price for book number one should be 110.0").isEqualTo(110.0);
            softly.assertThat(book2.getPrice()).as("The cost of second book should be 10.0").isEqualTo(10.0);
            softly.assertThat(book3.getLanguage()).as("The book number 3 is published in russian language").isEqualTo("Russian");
        });
    }

    @Test
    @DisplayName("Assertj soft assert with chained assertions")
    public void assertjSoftAssertWithChainedAssertion() {
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(book1.getTitle())
                    .startsWith("Nineteer")
                    .contains("Eightr")
                    .endsWith("Foud");
            softly.assertThat(book1.getNumberOfPages())
                    .isLessThan(50)
                    .isZero();
        });
    }

    @Test
    @DisplayName("Assertj run custom assert")
    public void assertjTestIfBookIsAntiquarian() {
        BookAssert.assertThat(book6).isAntiquarian();
    }
}
