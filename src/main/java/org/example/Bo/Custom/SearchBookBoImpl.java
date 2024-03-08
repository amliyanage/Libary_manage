package org.example.Bo.Custom;


import org.example.Bo.SearchBookBo;
import org.example.Dao.BookDao;
import org.example.Dao.Custom.BookDaoImpl;
import org.example.Dao.Custom.DaoFactory;
import org.example.Dto.BookDto;
import org.example.Entity.Books;

import java.util.List;

public class SearchBookBoImpl implements SearchBookBo {

    BookDao bookDao = (BookDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DaoType.Books);

    @Override
    public BookDto getData(String title) {

        Books data = bookDao.getData(title);

        return new BookDto( data.getId() , data.getTitle() , data.getAutor(), data.getDis(), data.getGenre() , data.getAvailable());
    }

    @Override
    public List<String> getTitles() {
        return bookDao.getOneData();
    }

}
