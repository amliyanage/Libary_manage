package org.example.Bo.Custom;

import org.example.Bo.MemberDashboardServer;
import org.example.Dao.Custom.RepositoryFactory;
import org.example.Dao.MemberRepository;
import org.example.Dto.MemberDto;
import org.example.Entity.Member;
import org.example.unill.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MemberDashboardServerImpl implements MemberDashboardServer {
    private final MemberRepository memberRepository = (MemberRepository) RepositoryFactory.getDaoFactory().getDao(RepositoryFactory.DaoType.Member);
    private Session session;
    private Transaction transaction;
    @Override
    public MemberDto getData(String username) {
        session = SessionFactoryConfiguration.getInstance().getSession();
        memberRepository.SetSession(session);
        Member data = memberRepository.getData(username);

        return new MemberDto(data.getId(), data.getFull_name(), data.getUsername(), data.getPassword(), data.getEmail());
    }

    @Override
    public void Update(MemberDto memberDto) {
        session = SessionFactoryConfiguration.getInstance().getSession();
        memberRepository.SetSession(session);
        memberRepository.Update(new Member(memberDto.getId(), memberDto.getFull_name(), memberDto.getUsername(), memberDto.getPassword(), memberDto.getEmail()));
        transaction = session.beginTransaction();
        transaction.commit();
    }
}
