package org.example.Dao.Custom;

import org.example.Dao.BookTransactionRepository;

import org.example.Entity.Book_Transaction;
import org.example.Entity.TransactionDetailPK;
import org.hibernate.Session;

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
    public int saved(Book_Transaction data) {
        return (int) session.save(data);
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

}
