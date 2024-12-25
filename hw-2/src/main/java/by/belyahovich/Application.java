package by.belyahovich;

import by.belyahovich.domain.Book;
import by.belyahovich.domain.Student;

import java.util.*;

public class Application {

    public static void main(String[] args) {
        Book book1_1 = new Book("The Great Gatsby", 1233, 2000);
        Book book2_1 = new Book("War and Peace", 423, 1923);
        Book book3 = new Book("To Kill a Mockingbird", 678, 1813);
        Book book4 = new Book("The Lord of the Rings", 1321, 2001);
        Book book5 = new Book("The Lord of the Rings 2", 478, 2002);
        Book book6 = new Book("The Lord of the Rings 3", 2411, 2003);
        Book book7 = new Book("Harry Potter", 1221, 2023);
        Book book8 = new Book("Sweet home", 5312, 1736);
        Book book9 = new Book("Home alone", 223, 1313);

        Student student1 = new Student("Sidorov Alan", List.of(book1_1, book2_1, book3, book4, book5));
        Student student2 = new Student("Zahaorov Kirill", List.of(book6, book7, book8, book9, book5, book1_1, book3));
        Student student3 = new Student("Grebaedov Nikolay", List.of(book7, book2_1, book8, book4, book9));
        Student student4 = new Student("Kiian Mbape", List.of(book8, book9, book3, book4, book5));
        Student student5 = new Student("Cristiano Ronaldo", List.of(book1_1, book2_1, book9, book8, book7));

        List<Student> students = List.of(student1, student2, student3, student4, student5);

        students.stream()
                .peek(System.out::println)
                .flatMap(student -> student.getBookArrayList().stream())
                .sorted(Comparator.comparingInt(Book::getPageCount))
                .distinct()
                .filter(book -> book.getYear() > 2000)
                .limit(3)
                .map(Book::getYear)
                .findFirst()
                .ifPresentOrElse(year -> System.out.println("Year of publication of the book found: " + year),
                        () -> System.out.println("Such a book does not exist."));
    }
}
