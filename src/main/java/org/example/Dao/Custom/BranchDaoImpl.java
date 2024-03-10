package org.example.Dao.Custom;

import org.example.Dao.BranchDao;
import org.example.Entity.Branch;
import org.example.unill.SessionFactoryConfiguration;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BranchDaoImpl implements BranchDao{

    Session session = SessionFactoryConfiguration.getInstance().getSession();
    Transaction transaction = session.beginTransaction();
    @Override
    public Branch getData(String Id) {
        return null;
    }

    @Override
    public List<String> getOneData() {
        return null;
    }

    @Override
    public int saved(Branch data) {
         int value = (int) session.save(data);
         transaction.commit();
         if (value < 0) {
             transaction.rollback();
         }
            return value;
    }

    @Override
    public ArrayList<Branch> getAll() {
        String sql = "SELECT B FROM Branch AS B";
        Query queue = session.createQuery(sql);
        return (ArrayList<Branch>) queue.list();
    }

    @Override
    public void Update(Branch Data) {
        session.update(Data);
        transaction.commit();
    }

    @Override
    public void Delete(int Id) {
        Branch data = session.get(Branch.class, Id);
        session.delete(data);
        transaction.commit();
    }
}
