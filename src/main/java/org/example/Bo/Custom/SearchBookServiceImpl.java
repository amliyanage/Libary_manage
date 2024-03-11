package org.example.Bo.Custom;


import org.example.Bo.SearchBookService;
import org.example.Dao.BookRepository;
import org.example.Dao.Custom.RepositoryFactory;
import org.example.Dto.BookDto;
import org.example.Entity.Books;
import org.example.unill.SessionFactoryConfiguration;
import org.hibernate.Session;

import java.util.List;

public class SearchBookServiceImpl implements SearchBookService {

    private final BookRepository bookRepository = (BookRepository) RepositoryFactory.getDaoFactory().getDao(RepositoryFactory.DaoType.Books);
    private Session session;
    @Override
    public BookDto getData(String title) {
        session = SessionFactoryConfiguration.getInstance().getSession();
        bookRepository.SetSession(session);
        Books data = bookRepository.getData(title);

        return new BookDto( data.getId() , data.getTitle() , data.getAutor(), data.getDis(), data.getGenre() , data.getAvailable());
    }

    @Override
    public List<String> getTitles() {
        session = SessionFactoryConfiguration.getInstance().getSession();
        bookRepository.SetSession(session);
        return bookRepository.getOneData();
    }

}
