package org.example.Dao.Custom;

import org.example.Bo.Custom.MemberServiceImpl;
import org.example.Dao.BorrowBookRepository;
import org.example.Entity.BorrowBook;
import org.example.Entity.Member;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class BorrowBookRepositoryImpl implements BorrowBookRepository {
    private Session session;
    @Override
    public BorrowBook getData(String Id) {
        Query query = session.createQuery("from BorrowBook where id = :id");
        query.setParameter("id", 9);
        return (BorrowBook) query.uniqueResult();
    }

    @Override
    public List<String> getOneData() {
        return null;
    }

    @Override
    public int saved(BorrowBook data) {
        return (int) session.save(data);
    }

    @Override
    public ArrayList<BorrowBook> getAll() {
        String sql = "SELECT B FROM BorrowBook As B where B.member = :Member";
        Query query = session.createQuery(sql);
        query.setParameter("Member", MemberServiceImpl.member);
        return (ArrayList<BorrowBook>) query.getResultList();
    }

    @Override
    public void Update(BorrowBook Data) {
        session.update(Data);
    }

    @Override
    public void Delete(int Id) {

    }

    @Override
    public long Count() {
        String sql = "SELECT SUM(B.payment) FROM BorrowBook AS B";
        Query query = session.createQuery(sql);
        Double sum = (Double) query.getSingleResult();
        return sum != null ? sum.longValue() : 0; // Return 0 if sum is null
    }

    @Override
    public void SetSession(Session session) {
        this.session = session;
    }

    @Override
    public BorrowBook getData(Member Id) {
        String sql = "SELECT B FROM BorrowBook As B where B.member = :id and B.status = :status";
        Query query = session.createQuery(sql);
        query.setParameter("id", Id);
        query.setParameter("status", "Pending");
        return (BorrowBook) query.uniqueResult();
    }

    @Override
    public int BookCount(Member data) {
        String sql = "SELECT COUNT(B) FROM BorrowBook As B where B.member = :Member";
        Query query = session.createQuery(sql);
        query.setParameter("Member", data);
        return ((Long) query.uniqueResult()).intValue();
    }
}
