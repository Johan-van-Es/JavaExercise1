package service;

import domain.Book;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This is a test class. Within this class we write methods to verify that are methods work as intended.
 * As you can see there are some methods that not work. The goal is to make sure that all these tests are succeeding.
 * As an extra assignment you can try to write a valid test case for the last method.
 * In IntelliJ you can use CTRL+Shift+F10, or click the run test symbol to run all the tests in this class.
 */
class BookServiceTest {

    private final BookService bookService = new BookServiceImpl();

    @AfterEach
    void afterEach() {
        bookService.deleteAllBooks();
    }

    @Test
    void addBook() {
        Book book = new Book();

        bookService.addBook(book);
        List<Book> allBooks = bookService.getAllBooks();

        assertEquals(allBooks.size(), 1);
    }

    @Test
    void findBookByISBN() {
        Book book = insertOneBook();

        Book bookByISBN = bookService.findBookByISBN(book.getISBN());

        assertNotNull(bookByISBN);
    }

    @Test
    void deleteBook() {
        Book bookOne = this.insertOneBook();
        Book bookTwo = this.insertOneBook();

        bookService.deleteBook(bookOne.getISBN());
        List<Book> allBooks = bookService.getAllBooks();

        assertEquals(allBooks.size(), 1);
    }

    @Test
    void getAllBooks() {
        Book hb;
        hb = this.insertOneBook();
        hb = this.insertOneBook();
        bookService.addBook(hb);
        bookService.addBook(hb);

        List<Book> allBooks = bookService.getAllBooks();

        assertEquals(allBooks.size(), 4);
    }

    @Test
    void getAllBooksOrderedByReleaseDate() {
        Book bookOne = new Book();
        bookOne.setReleaseDate(2000,1,1);
        Book bookTwo = new Book();
        bookTwo.setReleaseDate(1950,4,4);
        Book bookThree = new Book();
        bookThree.setReleaseDate(1975,8,8);

        bookService.addBook(bookOne);
        bookService.addBook(bookTwo);
        bookService.addBook(bookThree);

        List<Book>Gesorteerd = bookService.getAllBooksOrderedByReleaseDate();
        int x = 1;
        Date rDatum = Gesorteerd.get(0).getReleaseDate();
        for (int i=1 ; i < Gesorteerd.size() ; i++) {
            if (Gesorteerd.get(i).getReleaseDate().before(rDatum)) {
                x = -1;
                break;
            }
            rDatum = Gesorteerd.get(i).getReleaseDate();
        }

        assertEquals(x, 1);

    }

    private Book insertOneBook() {
        Book book = new Book();

        bookService.addBook(book);

        return book;
    }
}