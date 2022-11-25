package domain;

import java.util.Date;

public class Book implements Comparable<Object>{
    private String name;
    private String language;
    private Date releaseDate;
    private int numberOfPages;
    private String author;
    private String ISBN;

    public Book (String naam, String taal, int jaar, int maand, int dag, int paginas, String auteur, String isbnNummer) {
        this.name = naam;
        this.language = taal;
        Date datum = new Date (jaar, maand, dag);
        this.releaseDate = datum;
        this.numberOfPages = paginas;
        this.author = auteur;
        this.ISBN = isbnNummer;
    }
    public Book (String naam, String taal, Date rdatum, int paginas, String auteur, String isbnNummer) {
        this.name = naam;
        this.language = taal;
        this.releaseDate = rdatum;
        this.numberOfPages = paginas;
        this.author = auteur;
        this.ISBN = isbnNummer;
    }
    public Book (String naam, int jaar, int maand, int dag, String auteur, String isbnNummer) {
        this.name = naam;
        this.language = "Nederlands";
        Date datum = new Date (jaar, maand, dag);
        this.releaseDate = datum;
        this.numberOfPages = 100;
        this.author = auteur;
        this.ISBN = isbnNummer;
    }

    public Book() {
        this.name = "";
        this.language = "";
        Date datum = new Date (2000,1,1);
        this.releaseDate = datum;
        this.numberOfPages = 0;
        this.author = "";
        this.ISBN = "";
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Date getReleaseDate() {
        return this.releaseDate;
    }

    public String getReleaseDateStr () {
        int gdate = this.releaseDate.getDate();
        int gmonth = this.releaseDate.getMonth();
        int gyear = this.releaseDate.getYear();
        String datumString;
        String dagString;
        String maandString;
        String jaarString;
        if (gdate < 10) {dagString = "0" + String.valueOf(gdate);}
           else {dagString = String.valueOf(gdate);}
        if (gmonth < 10) {maandString = "0" + String.valueOf(gmonth);}
           else {maandString = String.valueOf(gmonth);}
        jaarString = String.valueOf(gyear);
        datumString = dagString+"-"+maandString+"-"+jaarString;
        return datumString;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setReleaseDate(int year, int month, int day) {
        Date datum = new Date(year, month, day);
        this.releaseDate = datum;
    }

    public int getNumberOfPages() {
        return this.numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBN() {
        return this.ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    @Override
    public int compareTo(Object b) {
        Book a = (Book) b;
        int x;
        if (this.releaseDate.after (a.releaseDate)) {x = 1;}
           else
              if (this.releaseDate.equals (a.releaseDate)) {x = 0;}
                 else {x = -1;}
        return x;
    }
}
