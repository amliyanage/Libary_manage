package org.example.Dao.Custom;

import org.example.Controller.LoginPageController;
import org.example.Dao.AdminDao;
import org.example.Entity.Admin;
import org.example.Entity.Member;
import org.example.unill.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.OptimisticLockException;
import java.util.ArrayList;
import java.util.List;

public class AdminDaoImpl implements AdminDao {

    Session session = SessionFactoryConfiguration.getInstance().getSession();
    Transaction transaction = session.beginTransaction();

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
        int value = (int) session.save(data);
        transaction.commit();
        if (value < 0){
             transaction.rollback();
        }
        return value;
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
        transaction.commit();
    }


    @Override
    public void Delete(int Id) {
        Admin admin = session.get(Admin.class, Id);
        session.delete(admin);
        transaction.commit();
    }

    @Override
    public Admin getData() {
        return null;
    }
}
