package org.example.Bo.Custom;

import org.example.Bo.ManageBookBo;
import org.example.Dao.BookDao;
import org.example.Dao.Custom.DaoFactory;
import org.example.Dto.BookDto;
import org.example.Dto.MemberDto;
import org.example.Entity.Books;

import java.util.ArrayList;

public class ManageBookBoImpl implements ManageBookBo {

    BookDao bookDao = (BookDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DaoType.Books);
    @Override
    public ArrayList<BookDto> getAll() {
        ArrayList<Books> all = bookDao.getAll();

        ArrayList<BookDto> books = new ArrayList<>();

        for (Books books1 : all){
            books.add(new BookDto(books1.getId(),books1.getTitle(),books1.getAutor(),books1.getDis(),books1.getGenre(),books1.getAvailable()));
        }

        return books;
    }

    @Override
    public void Update(BookDto Data) {
        bookDao.Update(new Books(Data.getId(),Data.getTitle(),Data.getAutor(),Data.getDis(),Data.getGenre(),Data.getAvailable()));
    }

    @Override
    public void Delete(int Id) {
        bookDao.Delete(Id);
    }

    @Override
    public int Save(BookDto yes) {
        int saved = bookDao.saved(new Books(yes.getId(), yes.getTitle(), yes.getAutor(), yes.getDis(), yes.getGenre(), yes.getAvailable()));
        return saved;
    }

}
