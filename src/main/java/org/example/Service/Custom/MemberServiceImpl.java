package org.example.Service.Custom;

import org.example.Service.MemberService;
import org.example.Repository.Custom.RepositoryFactory;
import org.example.Repository.MemberRepository;
import org.example.Entity.Member;
import org.example.unill.SessionFactoryConfiguration;
import org.hibernate.Session;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository = (MemberRepository) RepositoryFactory.getDaoFactory().getDao( RepositoryFactory.DaoType.Member );

    private Session session;

    public static Member member;
    @Override
    public boolean Login(String Username, String Password) {
        session = SessionFactoryConfiguration.getInstance().getSession();
        memberRepository.SetSession(session);
        Member data = memberRepository.getData(Username);

        if (data != null && data.getPassword().equals(Password)){
            member = data;
            session.close();
            return true;
        }
        else {
            session.close();
            return false;
        }
    }
}
