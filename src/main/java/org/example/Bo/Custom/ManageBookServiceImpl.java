package org.example.Bo.Custom;

import org.example.Bo.ManageBookService;
import org.example.Dao.BookRepository;
import org.example.Dao.Custom.RepositoryFactory;
import org.example.Dto.BookDto;
import org.example.Entity.Books;
import org.example.unill.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ManageBookServiceImpl implements ManageBookService {

    private final BookRepository bookRepository = (BookRepository) RepositoryFactory.getDaoFactory().getDao(RepositoryFactory.DaoType.Books);
    private Session session;
    private Transaction transaction;
    @Override
    public ArrayList<BookDto> getAll() {
        session = SessionFactoryConfiguration.getInstance().getSession();
        bookRepository.SetSession(session);
        ArrayList<Books> all = bookRepository.getAll();

        ArrayList<BookDto> books = new ArrayList<>();

        for (Books books1 : all){
            books.add(new BookDto(books1.getId(),books1.getTitle(),books1.getAutor(),books1.getDis(),books1.getGenre(),books1.getAvailable()));
        }

        return books;
    }

    @Override
    public void Update(BookDto Data) {
        session = SessionFactoryConfiguration.getInstance().getSession();
        bookRepository.SetSession(session);
        bookRepository.Update(new Books(Data.getId(),Data.getTitle(),Data.getAutor(),Data.getDis(),Data.getGenre(),Data.getAvailable(),AdminServiceImpl.admin));
        transaction = session.beginTransaction();
        transaction.commit();
    }

    @Override
    public void Delete(int Id) {
        session = SessionFactoryConfiguration.getInstance().getSession();
        bookRepository.SetSession(session);
        bookRepository.Delete(Id);
        transaction = session.beginTransaction();
        transaction.commit();
    }

    @Override
    public int Save(BookDto yes) {
        session = SessionFactoryConfiguration.getInstance().getSession();
        bookRepository.SetSession(session);
        int saved = bookRepository.saved(new Books(yes.getId(), yes.getTitle(), yes.getAutor(), yes.getDis(), yes.getGenre(), yes.getAvailable(),AdminServiceImpl.admin));
        transaction = session.beginTransaction();
        transaction.commit();
        if (saved > 0) {
            return saved;
        }
        else {
            transaction.rollback();
            return -1;
        }
    }

    @Override
    public BookDto search(String text) {
        session = SessionFactoryConfiguration.getInstance().getSession();
        bookRepository.SetSession(session);
        Books data = bookRepository.getData(text);
        return new BookDto(data.getId(), data.getTitle(), data.getAutor(), data.getDis(), data.getGenre(), data.getAvailable());
    }

    @Override
    public List<String> getTitles() {
        session = SessionFactoryConfiguration.getInstance().getSession();
        bookRepository.SetSession(session);
        return bookRepository.getOneData();
    }

}
