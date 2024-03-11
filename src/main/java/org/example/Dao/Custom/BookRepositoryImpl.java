package org.example.Dao.Custom;

import org.example.Dao.BookRepository;
import org.example.Entity.Books;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class BookRepositoryImpl implements BookRepository {

    private Session session;
    @Override
    public Books getData(String title) {
        String sql = "SELECT B FROM Books AS B WHERE B.title =: title";
        Query query = session.createQuery(sql);
        query.setParameter("title",title);
        return (Books) query.getSingleResult();
    }


    @Override
    public List<String> getOneData() {
        String sql = "SELECT B.title FROM Books AS B";
        Query query = session.createQuery(sql);
        List<String> titles = query.getResultList();
        return titles;
    }

    @Override
    public int saved(Books data) {
        Transaction transaction = session.beginTransaction();
        int value = (int) session.save(data);
        transaction.commit();
        if (value > 0) {
            return value;
        }
        else {
            transaction.rollback();
            return -1;
        }
    }

    @Override
    public ArrayList<Books> getAll() {
        String sql = "SELECT B FROM Books AS B";
        Query query = session.createQuery(sql);
        List list = query.list();
        return (ArrayList<Books>) list;
    }

    @Override
    public void Update(Books Data) {
        Transaction transaction = session.beginTransaction();
        session.update(Data);
        transaction.commit();
    }

    @Override
    public void Delete(int Id) {
        Transaction transaction = session.beginTransaction();
        Books books = session.get(Books.class, Id);
        session.delete(books);
        transaction.commit();
    }

    @Override
    public long Count() {
        String sql = "select count(*) from Books";
        Query query = session.createQuery(sql);
        return (long) query.uniqueResult();
    }

    @Override
    public void SetSession(Session session) {
        this.session = session;
    }

}
