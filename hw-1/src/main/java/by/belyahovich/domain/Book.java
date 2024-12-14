package by.belyahovich.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Book {

    private static final short DEFAULT_UNKNOWN_YEAR = -1;

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
        if (this.isAvailable) {
            this.isAvailable = false;
            System.out.println("Successfully borrowed the book: " + this.title);
        } else {
            System.out.println("Book already borrowed");
        }
    }

    public void returnBook() {
        if (!this.isAvailable) {
            this.isAvailable = true;
            System.out.println("Successfully return the book: " + this.title);
        } else {
            System.out.println("Book already returned");
        }
    }

    public void displayInfo() {
        System.out.println(this);
    }
}
