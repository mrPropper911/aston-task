package by.belyahovich.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Book {

    private static final Short DEFAULT_UNKNOWN_YEAR = -1;

    private String title;
    private String author;
    private Short year;
    private Boolean isAvailable = true;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.year = DEFAULT_UNKNOWN_YEAR;
    }

    public Book(String title, String author, short year, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year='" + (year == -1 ? "Unknown year" : year) + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
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
