package assertions_example;

import org.assertj.core.api.AbstractAssert;
import java.util.ArrayList;

public class BookAssert extends AbstractAssert<BookAssert, Book> {

    public BookAssert(Book actual) {
        super(actual, BookAssert.class);
    }

    public static BookAssert assertThat(Book actual) {
        return new BookAssert(actual);
    }

    public BookAssert isAntiquarian() {
        if (actual.getYear()>1900)
            failWithMessage("Book with title %s published in %d is not antiquarian", actual.getTitle(), actual.getYear());
        return this;
    }
}