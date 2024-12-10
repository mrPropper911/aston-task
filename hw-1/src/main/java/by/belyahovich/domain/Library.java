package by.belyahovich.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@EqualsAndHashCode
@ToString
public class Library {

    private final List<Book> bookArrayList = new ArrayList<>();

    public void addBook(Book... book) {
        bookArrayList.addAll(Arrays.asList(book));
    }

    public void borrowBookByTitle(String title) {
        if (title == null) {
            throw new IllegalArgumentException("Title cannot be null");
        }

        bookArrayList.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .filter(Book::isAvailable)
                .findFirst()
                .ifPresentOrElse(
                        Book::borrowBook,
                        () -> System.out.println("There is no available book with this title: " + title)
                );
    }

    public void returnBookByTitle(String title) {
        if (title == null) {
            throw new IllegalArgumentException("Title cannot be null");
        }

        bookArrayList.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .ifPresentOrElse(
                        Book::returnBook,
                        () -> System.out.println("There is no book with this title: " + title)
                );
    }

    public void printBooksInLibrary() {
        if (bookArrayList.isEmpty()) {
            System.out.println("Library is empty");
        } else {
            bookArrayList.forEach(Book::displayInfo);
        }
    }

    public void printBooksAvailableInLibrary() {
        List<Book> availableBooks = findAvailableBooks();
        if (availableBooks.isEmpty()) {
            System.out.println("No available books on library");
        } else {
            availableBooks.forEach(Book::displayInfo);
        }
    }

    public void printBooksFindingByAuthor(String author) {
        if (author == null) {
            throw new IllegalArgumentException("Author cannot be null");
        }

        List<Book> booksByAuthor = findBooksByAuthor(author);

        if (booksByAuthor == null || booksByAuthor.isEmpty()) {
            System.out.printf("No books by %s were found in the library\n", author);
        } else {
            booksByAuthor.forEach(Book::displayInfo);
        }
    }

    private List<Book> findAvailableBooks() {
        return bookArrayList.stream()
                .filter(Book::isAvailable)
                .collect(Collectors.toList());
    }

    private List<Book> findBooksByAuthor(String author) {
        return bookArrayList.stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }
}
