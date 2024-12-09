package by.belyahovich.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
@EqualsAndHashCode
public class Library {

    private List<Book> bookArrayList = new ArrayList<>();


    @Override
    public String toString() {
        return "Library{" +
                "bookArrayList=" + bookArrayList +
                '}';
    }

    public void addBook(Book... book) {
        bookArrayList.addAll(Arrays.asList(book));
    }

    public void printAllBooksInLibrary(List<Book> bookList) {
        bookList.forEach(Book::displayInfo);
    }

    public void printAvailableBooks() {
        bookArrayList.stream()
                .filter(Book::isAvailable)
                .forEach(Book::displayInfo);
    }

    public List<Book> findBooksByAuthor(String author) {
        if (author == null){
            return Collections.emptyList();
        }
        return bookArrayList.stream()
                .filter(book -> book.getAuthor().equals(author))
                .collect(Collectors.toList());
    }


}
