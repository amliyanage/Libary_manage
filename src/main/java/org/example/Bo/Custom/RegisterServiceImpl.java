package org.example.Bo.Custom;

import org.example.Bo.RegisterService;
import org.example.Dao.Custom.RepositoryFactory;
import org.example.Dao.MemberRepository;
import org.example.Dto.MemberDto;
import org.example.Entity.Member;
import org.example.unill.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RegisterServiceImpl implements RegisterService {

    private final MemberRepository memberRepository = (MemberRepository) RepositoryFactory.getDaoFactory().getDao(RepositoryFactory.DaoType.Member);
    private Session session;
    private Transaction transaction;
    @Override
    public int Register(MemberDto member) {
        session = SessionFactoryConfiguration.getInstance().getSession();
        memberRepository.SetSession(session);
        int saved = memberRepository.saved(new Member(member.getId(),member.getFull_name(),member.getUsername(),member.getPassword(),member.getEmail()));
        transaction = session.beginTransaction();
        if (saved > 0) {
            transaction.commit();
        }
        else {
            transaction.rollback();
        }
        return saved;
    }
}
