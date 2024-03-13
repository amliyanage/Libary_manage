package org.example.Dao.Custom;

import org.example.Dao.BookTransactionRepository;

import org.example.Entity.Admin;
import org.example.Entity.Book_Transaction;
import org.example.Entity.BorrowBook;
import org.example.Entity.Member;
import org.example.unill.GetIdNumber;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class BookTransactionRepositoryImpl implements BookTransactionRepository {
    private Session session;
    @Override
    public Book_Transaction getData(String Id) {
        return null;
    }

    @Override
    public List<String> getOneData() {
        return null;
    }

    @Override
    public int saved(Book_Transaction transaction) {
        System.out.println(transaction.getTransaction().getId());
        System.out.println(transaction.getBook().getId());
        int save = (int) session.save(transaction);
        return save;
    }


    @Override
    public ArrayList<Book_Transaction> getAll() {
        return null;
    }

    @Override
    public void Update(Book_Transaction Data) {

    }

    @Override
    public void Delete(int Id) {

    }

    @Override
    public long Count() {
        return 0;
    }

    @Override
    public void SetSession(Session session) {
        this.session = session;
    }

    @Override
    public List<Book_Transaction> bookTransactionData(String id) {
        String sql = "SELECT B FROM Book_Transaction AS B WHERE B.id =: id";
        Query query = session.createQuery(sql);
        query.setParameter("id",id);
        return query.list();
    }
}
