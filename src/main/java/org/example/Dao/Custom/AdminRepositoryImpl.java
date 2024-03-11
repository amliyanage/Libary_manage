package org.example.Dao.Custom;

import org.example.Dao.AdminRepository;
import org.example.Entity.Admin;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.OptimisticLockException;
import java.util.ArrayList;
import java.util.List;

public class AdminRepositoryImpl implements AdminRepository {

    private Session session;


    @Override
    public Admin getData(String Id) {
        String hql = "FROM Admin WHERE Username = :username";
        Query<Admin> query = session.createQuery(hql, Admin.class);
        query.setParameter("username", Id);
        List<Admin> results = query.getResultList();
        if (!results.isEmpty()) {
            return results.get(0); // Matching admin found
        } else {
            return null; // No matching admin found
        }
    }


    @Override
    public List<String> getOneData() {
        return null;
    }

    @Override
    public int saved(Admin data) {
        return  (int) session.save(data);
    }

    @Override
    public ArrayList<Admin> getAll() {
        String sqlQuery = "FROM Admin";
        Query query = session.createQuery(sqlQuery);
        List list = query.list();
        return (ArrayList<Admin>) list;
    }


    @Override
    public void Update(Admin Data) throws OptimisticLockException {
        session.update(Data);
    }


    @Override
    public void Delete(int Id) {
        Admin admin = session.get(Admin.class, Id);
        session.delete(admin);
    }

    @Override
    public long Count() {
        return 0;
    }

    @Override
    public Admin getData() {
        return null;
    }

    @Override
    public void SetSession(Session session) {
        this.session = session;
    }
}
