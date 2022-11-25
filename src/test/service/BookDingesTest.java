package service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import domain.Book;
import java.util.List;

public class BookDingesTest {
    private final BookService bookDinges = new BookServiceImpl();

    @Test
    void addBook() {
        Book book = new Book();

        bookDinges.addBook(book);
        List<Book> allBooks = bookDinges.getAllBooks();

        assertEquals(allBooks.size(), 1);
    }


}
