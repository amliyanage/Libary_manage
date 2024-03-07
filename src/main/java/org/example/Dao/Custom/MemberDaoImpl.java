package org.example.Dao.Custom;

import org.example.Dao.MemberDao;
import org.example.Entity.Member;
import org.example.unill.SessionFactoryConfiguration;
import org.hibernate.Session;

public class MemberDaoImpl implements MemberDao {

    Session session = SessionFactoryConfiguration.getInstance().getSession();

    @Override
    public Member getData ( int Id ) {
        return session.get(Member.class, Id);
    }
}
