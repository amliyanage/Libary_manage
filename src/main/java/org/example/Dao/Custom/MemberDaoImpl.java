package org.example.Dao.Custom;

import org.example.Dao.MemberDao;
import org.example.Entity.Member;
import org.example.unill.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class MemberDaoImpl implements MemberDao {

    Session session = SessionFactoryConfiguration.getInstance().getSession();
    Transaction transaction = session.beginTransaction();

    @Override
    public Member getData ( String Id ) {
        String hql = "FROM Member WHERE username = :username";
        Query<Member> query = session.createQuery(hql, Member.class);
        query.setParameter("username", Id);
        return query.uniqueResult();
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

    @Override
    public ArrayList<Member> getAll() {
        String sqlQuery = "FROM Member";
        Query query = session.createQuery(sqlQuery);
        List list = query.list();
        return (ArrayList<Member>) list;
    }

    @Override
    public void Update(Member Data) {

    }

    @Override
    public void Delete(int Id) {
        Member member = session.get(Member.class, Id);
        session.delete(member);
        transaction.commit();
    }

    @Override
    public long Count() {
        String sql = "select count(*) from Member";
        org.hibernate.Query query = session.createQuery(sql);
        return (long) query.uniqueResult();
    }
}
