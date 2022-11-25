import domain.Book;
import service.BookService;
import service.BookServiceImpl;
import java.util.List;

import java.util.ArrayList;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Date datum1 = new Date(1935,1,1);
        Book book1 = new Book("Lord of the Rings", "Engels", datum1, 1500, "J.R.R.Tolkien", "F0001");
        Book book2 = new Book("La Peste", "Frans", 1950, 2, 2, 250, "Albert Camus", "F0002");
        Book book3 = new Book("Don Quichote",1500, 1, 1, "Cervantes", "F0003");

        ArrayList<Book> boekenLijst = new ArrayList<>();
        boekenLijst.add(book1);
        boekenLijst.add(book2);
        boekenLijst.add(book3);

        Book hulpboek;
        BookService bookService = new BookServiceImpl();
        hulpboek = boekenLijst.get(0);
        bookService.addBook(hulpboek);
        hulpboek = boekenLijst.get(1);
        bookService.addBook(hulpboek);
        hulpboek = boekenLijst.get(2);
        bookService.addBook(hulpboek);
        List<Book> uitDeKast ;
        uitDeKast = bookService.getAllBooks();
        int teller = 0;
        int aantalBoeken = uitDeKast.size();
        for (teller = 0 ; teller < aantalBoeken; teller++ ) {
            hulpboek = uitDeKast.get(teller);
            System.out.print("Uit de Boekenkast : ");
            System.out.println(hulpboek.getName());
        }

        String isbnNummer = "F0002";
        hulpboek = bookService.findBookByISBN(isbnNummer);
        if (hulpboek == null) {
            System.out.println("Boek niet gevonden");
        }
        else
            System.out.println("ISBN "+isbnNummer+" is het boek "+hulpboek.getName());

        List<Book>Gesorteerd;
        Gesorteerd = bookService.getAllBooksOrderedByReleaseDate();
        System.out.println("Gesorteerd op datum");
        for (Book boekje : Gesorteerd) {
            System.out.println(boekje.getName()+"  "+boekje.getReleaseDateStr());
        }

        List<Book>AantalPaginas;
        AantalPaginas = bookService.getAllBooksOrderedByPages();
        System.out.println("Gestorteerd op paginas");
        for (Book boekje : Gesorteerd) {
            System.out.println(boekje.getName()+"  "+boekje.getNumberOfPages());
        }

        bookService.deleteBook("F0002");
        uitDeKast = bookService.getAllBooks();
        aantalBoeken = uitDeKast.size();
        for (teller = 0 ; teller < aantalBoeken; teller++ ) {
            hulpboek = uitDeKast.get(teller);
            System.out.print("Uit de Boekenkast : ");
            System.out.println(hulpboek.getName());
        }

        bookService.deleteAllBooks();
    }
}
