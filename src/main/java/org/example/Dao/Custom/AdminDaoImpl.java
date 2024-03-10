package org.example.Dao.Custom;

import org.example.Dao.AdminDao;
import org.example.Entity.Admin;
import org.example.Entity.Member;
import org.example.unill.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class AdminDaoImpl implements AdminDao {

    Session session = SessionFactoryConfiguration.getInstance().getSession();
    @Override
    public Admin getData(String Id) {
        String hql = "FROM Admin WHERE Username = :username";
        Query<Admin> query = session.createQuery(hql, Admin.class);
        query.setParameter("username", Id);
        return query.uniqueResult();
    }

    @Override
    public List<String> getOneData() {
        return null;
    }

    @Override
    public int saved(Admin data) {
        Transaction transaction = session.beginTransaction();
        int value = (int) session.save(data);
        transaction.commit();
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
    public void Update(Admin Data) {

    }

    @Override
    public void Delete(int Id) {

    }
}
