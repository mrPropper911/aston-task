package by.belyahovich.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Book {

    private static final short DEFAULT_YEAR = 1999; //todo подумать возможно -1 и в tostring проверятьn

    private String title;
    private String author;
    private short year;
    private boolean isAvailable = true;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.year = DEFAULT_YEAR;
    }

    public Book(String title, String author, short year, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.isAvailable = isAvailable;
    }

    public void borrowBook() {
        this.isAvailable = false;
    }

    public void returnBook() {
        this.isAvailable = true;
    }

    public void displayInfo() {
        System.out.println(this);
    }
}
