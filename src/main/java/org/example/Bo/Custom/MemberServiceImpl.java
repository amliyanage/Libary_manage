package org.example.Bo.Custom;

import org.example.Bo.MemberService;
import org.example.Dao.Custom.RepositoryFactory;
import org.example.Dao.MemberRepository;
import org.example.Entity.Member;
import org.example.unill.SessionFactoryConfiguration;
import org.hibernate.Session;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository = (MemberRepository) RepositoryFactory.getDaoFactory().getDao( RepositoryFactory.DaoType.Member );

    private Session session;
    @Override
    public boolean Login(String Username, String Password) {
        session = SessionFactoryConfiguration.getInstance().getSession();
        memberRepository.SetSession(session);
        Member data = memberRepository.getData(Username);

        if (data != null && data.getPassword().equals(Password)){
            return true;
        }
        else {
            return false;
        }
    }
}
