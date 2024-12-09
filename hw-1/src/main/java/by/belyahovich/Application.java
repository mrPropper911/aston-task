package by.belyahovich;

import by.belyahovich.domain.Book;
import by.belyahovich.domain.Library;

public class Application {

    public static Library libraryMain = new Library();

    static {
        Book book1 = new Book("The Great Gatsby", "The Great Gatsby");
        Book book2 = new Book("War and Peace", "James White");
        Book book3 = new Book("To Kill a Mockingbird", "Emily Johnson", (short) 1995, true);
        Book book4 = new Book("The Lord of the Rings", "David Lee", (short) 2005, true);
        Book book5 = new Book("The Lord of the Rings 2", "David Lee", (short) 2008, true);
        Book book6 = new Book("The Lord of the Rings 3", "David Lee", (short) 2009, false);

        libraryMain.addBook(book1, book2, book3, book4, book5, book6);
    }

    public static void main(String[] args) {
        System.out.println("\nAvailable books in library");
        libraryMain.printAvailableBooks();

        System.out.println("\nAvailable books in library after");
        libraryMain.getBookArrayList().get(5).borrowBook();
        for (Book book : libraryMain.findBooksByAuthor("David Lee")) {
            book.displayInfo();
        }

        System.out.println("\nAvailable books by the author");
        for (Book book : libraryMain.findBooksByAuthor("David Lee")) {
            book.displayInfo();
        }




    }
}
