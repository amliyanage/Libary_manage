package org.example.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookDto {
    private int Id;
    private String title;
    private String Autor;
    private String dis;
    private String genre;
    private String available;
}
