package org.example.Service.Custom;

import org.example.Service.UserMangeService;
import org.example.Repository.Custom.RepositoryFactory;
import org.example.Repository.MemberRepository;
import org.example.Dto.MemberDto;
import org.example.Entity.Member;
import org.example.unill.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class UserManageServiceImpl implements UserMangeService {

    private final MemberRepository memberRepository = (MemberRepository) RepositoryFactory.getDaoFactory().getDao(RepositoryFactory.DaoType.Member);
    private Session session = SessionFactoryConfiguration.getInstance().getSession();

    private Transaction transaction;
    @Override
    public ArrayList<MemberDto> getAll() {
        session = SessionFactoryConfiguration.getInstance().getSession();
        memberRepository.SetSession(session);

        ArrayList<Member> all = memberRepository.getAll();

        ArrayList<MemberDto> admins = new ArrayList<>();

        for (Member admin : all) {
            admins.add(new MemberDto(admin.getId(), admin.getFull_name(), admin.getUsername(), admin.getPassword(), admin.getEmail()));
        }
        session.close();
        return admins;
    }

    @Override
    public void delete(int Id) {
        session = SessionFactoryConfiguration.getInstance().getSession();
        memberRepository.SetSession(session);
        memberRepository.Delete(Id);
        transaction = session.beginTransaction();
        transaction.commit();
        session.close();
    }


}
