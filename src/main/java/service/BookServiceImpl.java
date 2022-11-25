package service;

import domain.Book;
import domain.SortByPages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookServiceImpl implements BookService {
    ArrayList<Book> boekenKast = new ArrayList<>();

    public void addBook(Book book) {
        boekenKast.add(book);
    }

    @Override
    public void deleteBook(String ISBN) {
        int indeks = this.findISBN(ISBN);
        if (indeks>-1){
            boekenKast.remove(indeks);
            System.out.println("Boek "+ISBN+" verwijderd");
        }
        else {
            System.out.println("Boek bestaat niet");
        }

    }

    @Override
    public List<Book> getAllBooks() {

        return boekenKast;

    }

    @Override
    public Book findBookByISBN(String ISBN) {
        int indeks = this.findISBN(ISBN);
        if (indeks>-1) {
            return boekenKast.get(indeks);
        }
        else return null;
    }

    @Override
    public List<Book> getAllBooksOrderedByReleaseDate() {
        Collections.sort(boekenKast);
        return boekenKast;
    }

    @Override
    public List<Book> getAllBooksOrderedByPages() {
        Collections.sort(boekenKast, new SortByPages());
        return boekenKast;
    }

    @Override
    public void deleteAllBooks() {
        boekenKast.clear();
        System.out.println("Alle boeken verwijderd");
    }

    private int findISBN(String ISBN) {
        Book hb ;
        int x = -1;
        for (int i = 0 ; i < boekenKast.size() ; i++){
            hb = boekenKast.get(i);
            if (hb.getISBN().equals(ISBN)){
                x = i;
                break;
            }
        }
        return x;
    }
}
