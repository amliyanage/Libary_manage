package org.example.Bo;

import org.example.Dto.BookDto;
import org.example.Dto.MemberDto;

import java.util.ArrayList;

public interface ManageBookBo extends SuperBo{
    ArrayList<BookDto> getAll();
    void Update(BookDto memberDto);

    void Delete(int Id);

    int Save(BookDto yes);
}
