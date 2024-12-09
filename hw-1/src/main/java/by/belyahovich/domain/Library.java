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

    public void printBooksInLibrary() {
        bookArrayList.forEach(Book::displayInfo);
    }

    public void printBooksAvailableInLibrary() {
        findAvailableBooks().forEach(Book::displayInfo);
    }

    public void printBooksFindingByAuthor(String author) {
        List<Book> booksByAuthor = findBooksByAuthor(author);
        if (booksByAuthor.size() == 0){
            System.out.printf("No books by %s were found in the library\n", author);
        }
        booksByAuthor.forEach(Book::displayInfo);
    }

    private List<Book> findAvailableBooks() {
        return bookArrayList.stream()
                .filter(Book::isAvailable)
                .collect(Collectors.toList());
    }

    private List<Book> findBooksByAuthor(String author) {
        if (author == null) {
            throw new IllegalArgumentException("Author cannot be null");
        }
        return bookArrayList.stream()
                .filter(book -> book.getAuthor().equals(author))
                .collect(Collectors.toList());
    }


}
