package domain;

import java.util.Comparator;

public class SortByPages implements Comparator<Book> {
    public int compare (Book a, Book b) {
        return (a.getNumberOfPages() - b.getNumberOfPages());
    }
}
