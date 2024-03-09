package org.example.Dao.Custom;

import org.example.Dao.AdminDao;
import org.example.Entity.Admin;
import org.example.Entity.Member;
import org.example.unill.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.query.Query;

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
        return -1;
    }
}
