package by.belyahovich;

import by.belyahovich.domain.Book;
import by.belyahovich.domain.Library;

public class Application {

    public static Library libraryMain = new Library();

    static {
        libraryMain.addBook(
                new Book("The Great Gatsby", "The Great Gatsby"),
                new Book("War and Peace", "James White"),
                new Book("To Kill a Mockingbird", "Emily Johnson", (short) 1995, false),
                new Book("The Lord of the Rings", "David Lee", (short) 2005, true),
                new Book("The Lord of the Rings 2", "David Lee", (short) 2008, true),
                new Book("The Lord of the Rings 3", "David Lee", (short) 2009, false)
        );
    }

    public static void main(String[] args) {
        System.out.println("\nBooks in library");
        libraryMain.printBooksInLibrary();

        System.out.println("\nAvailable books in library");
        libraryMain.printBooksAvailableInLibrary();

        System.out.println("\nAvailable books by the author");
        libraryMain.printBooksFindingByAuthor("David Lee");

        System.out.println("\nAvailable books in library after you borrowed one");
        libraryMain.borrowBookByTitle("The Lord of the Rings 2");
        libraryMain.printBooksAvailableInLibrary();

        System.out.println("\nAvailable books in library after you return one");
        libraryMain.returnBookByTitle("The Lord of the Rings 2");
        libraryMain.printBooksAvailableInLibrary();

        System.out.println("\nBooks in library after add new book");
        var newBook = new Book("War and Peace 2", "James White", (short) 1813, true);
        libraryMain.addBook(newBook);
        libraryMain.printBooksInLibrary();
    }
}
