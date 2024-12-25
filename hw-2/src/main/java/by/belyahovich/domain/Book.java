package by.belyahovich.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book  {
    private String title;
    private Integer pageCount;
    private Integer year;
}
