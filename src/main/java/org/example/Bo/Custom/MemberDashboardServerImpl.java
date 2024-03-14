package org.example.Bo.Custom;

import org.example.Bo.MemberDashboardServer;
import org.example.Dao.BorrowBookRepository;
import org.example.Dao.Custom.RepositoryFactory;
import org.example.Dao.MemberRepository;
import org.example.Dto.MemberDto;
import org.example.Entity.Member;
import org.example.unill.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MemberDashboardServerImpl implements MemberDashboardServer {
    private final MemberRepository memberRepository = (MemberRepository) RepositoryFactory.getDaoFactory().getDao(RepositoryFactory.DaoType.Member);

    private final BorrowBookRepository borrowBook = (BorrowBookRepository) RepositoryFactory.getDaoFactory().getDao(RepositoryFactory.DaoType.BorrowBook);
    private Session session;
    private Transaction transaction;
    @Override
    public MemberDto getData(String username) {
        session = SessionFactoryConfiguration.getInstance().getSession();
        memberRepository.SetSession(session);
        Member data = memberRepository.getData(username);
        session.close();
        return new MemberDto(data.getId(), data.getFull_name(), data.getUsername(), data.getPassword(), data.getEmail());
    }

    @Override
    public void Update(MemberDto memberDto) {
        session = SessionFactoryConfiguration.getInstance().getSession();
        memberRepository.SetSession(session);
        memberRepository.Update(new Member(memberDto.getId(), memberDto.getFull_name(), memberDto.getUsername(), memberDto.getPassword(), memberDto.getEmail()));
        transaction = session.beginTransaction();
        transaction.commit();
        session.close();
    }

    @Override
    public int BookCount(String memberUsername) {
        session = SessionFactoryConfiguration.getInstance().getSession();
        memberRepository.SetSession(session);
        Member data = memberRepository.getData(memberUsername);
        borrowBook.SetSession(session);
        int bookCount = borrowBook.BookCount(data);
        session.close();
        return bookCount;
    }
}
