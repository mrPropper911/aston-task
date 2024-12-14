package by.belyahovich.domain;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@EqualsAndHashCode
@ToString
public class Library {

    private final List<Book> bookArrayList = new ArrayList<>();

    public void addBook(Book... books) {
        for (var book : books) {
            if (!findBookByTitle(book.getTitle()).isEmpty()) {
                System.out.printf("Book with title: \"%s\" already exists\n", book.getTitle());
                continue;
            }
            bookArrayList.add(book);
        }
    }

    public void borrowBookByTitle(String title) {
        if (title == null) {
            throw new IllegalArgumentException("Title cannot be null");
        }
        bookArrayList.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .filter(Book::getIsAvailable)
                .findAny()
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
                .findAny()
                .ifPresentOrElse(
                        Book::returnBook,
                        () -> System.out.println("There is no book with this title: " + title)
                );
    }

    public List<Book> getBooksInLibrary() {
        if (bookArrayList.isEmpty()) {
            System.out.println("Library is empty");
            return Collections.emptyList();
        }
        return bookArrayList;
    }

    public List<Book> getBooksAvailableInLibrary() {
        var availableBooks = findAvailableBooks();
        if (availableBooks.isEmpty()) {
            System.out.println("No available books on library");
            return Collections.emptyList();
        } else {
            return availableBooks;
        }
    }

    public List<Book> getBooksFindingByAuthor(String author) {
        if (author == null) {
            throw new IllegalArgumentException("Author cannot be null");
        }
        var booksByAuthor = findBooksByAuthor(author);
        if (booksByAuthor == null || booksByAuthor.isEmpty()) {
            System.out.printf("No books by %s were found in the library\n", author);
            return Collections.emptyList();
        } else {
            return booksByAuthor;
        }
    }

    private List<Book> findAvailableBooks() {
        return bookArrayList.stream()
                .filter(Book::getIsAvailable)
                .collect(Collectors.toList());
    }

    private List<Book> findBooksByAuthor(String author) {
        return bookArrayList.stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    private List<Book> findBookByTitle(String title) {
        return bookArrayList.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
    }
}
