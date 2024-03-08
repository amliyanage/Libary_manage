package org.example.Bo;

import org.example.Dto.BookDto;

import java.util.List;

public interface SearchBookBo extends SuperBo{
    BookDto getData(String title);
    List<String> getTitles();
}
