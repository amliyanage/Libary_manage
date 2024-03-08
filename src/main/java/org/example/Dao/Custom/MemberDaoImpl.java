package org.example.Dao.Custom;

import org.example.Dao.MemberDao;
import org.example.Entity.Member;
import org.example.unill.SessionFactoryConfiguration;
import org.hibernate.Session;

import java.util.List;

public class MemberDaoImpl implements MemberDao {

    Session session = SessionFactoryConfiguration.getInstance().getSession();

    @Override
    public Member getData ( int Id ) {
        return session.get(Member.class, Id);
    }

    @Override
    public List<String> getOneData() {
        return null;
    }
}
