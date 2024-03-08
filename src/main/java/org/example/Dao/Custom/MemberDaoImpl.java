package org.example.Dao.Custom;

import org.example.Dao.MemberDao;
import org.example.Entity.Member;
import org.example.unill.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class MemberDaoImpl implements MemberDao {

    Session session = SessionFactoryConfiguration.getInstance().getSession();
    Transaction transaction = session.beginTransaction();

    @Override
    public Member getData ( int Id ) {
        return session.get(Member.class, Id);
    }

    @Override
    public List<String> getOneData() {
        return null;
    }

    @Override
    public int saved(Member data) {
        int value = (int) session.save(data);
        transaction.commit();
        return value;
    }
}
