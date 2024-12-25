package by.belyahovich.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Student {
    private String name;
    private List<Book> bookArrayList;
}
