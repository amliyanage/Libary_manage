package org.example.Bo.Custom;

import org.example.Bo.RegisterBo;
import org.example.Dao.Custom.DaoFactory;
import org.example.Dao.MemberDao;
import org.example.Dto.MemberDto;
import org.example.Entity.Member;

public class RegisterBoImpl implements RegisterBo {


    MemberDao memberDao = (MemberDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DaoType.Member);
    @Override
    public int Register(MemberDto member) {
        int saved = memberDao.saved(new Member(member.getId(),member.getName(),member.getPassword(),member.getEmail()));
        return saved;
    }
}
