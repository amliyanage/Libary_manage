package org.example.Dao.Custom;

import org.example.Dao.AdminDao;
import org.example.Entity.Admin;
import org.example.unill.SessionFactoryConfiguration;
import org.hibernate.Session;

import java.util.List;

public class AdminDaoImpl implements AdminDao {

    Session session = SessionFactoryConfiguration.getInstance().getSession();
    @Override
    public Admin getData(int Id) {
         return session.get(Admin.class, Id);
    }

    @Override
    public List<String> getOneData() {
        return null;
    }
}
