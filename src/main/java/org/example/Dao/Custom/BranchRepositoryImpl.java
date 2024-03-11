package org.example.Dao.Custom;

import org.example.Dao.BranchRepository;
import org.example.Entity.Branch;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class BranchRepositoryImpl implements BranchRepository {

    private Session session;
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
    }

    @Override
    public void Delete(int Id) {
        Branch data = session.get(Branch.class, Id);
        session.delete(data);
    }

    @Override
    public long Count() {
        String sql = "select count(*) from Branch";
        org.hibernate.Query query = session.createQuery(sql);
        return (long) query.uniqueResult();
    }

    @Override
    public void SetSession(Session session) {
        this.session = session;
    }
}
