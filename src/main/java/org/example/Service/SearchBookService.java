package org.example.Service;

import org.example.Dto.BookDto;

import java.util.List;

public interface SearchBookService extends SuperService {
    BookDto getData(String title);
    List<String> getTitles();
}
