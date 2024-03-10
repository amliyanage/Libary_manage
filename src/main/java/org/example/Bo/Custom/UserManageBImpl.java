package org.example.Bo.Custom;

import org.example.Bo.UserMangeBo;
import org.example.Controller.LoginPageController;
import org.example.Dao.AdminDao;
import org.example.Dao.Custom.DaoFactory;
import org.example.Dao.MemberDao;
import org.example.Dto.AdminDto;
import org.example.Dto.MemberDto;
import org.example.Entity.Admin;
import org.example.Entity.Member;

import java.util.ArrayList;
import java.util.List;

public class UserManageBImpl implements UserMangeBo {

    MemberDao memberDao = (MemberDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DaoType.Member);

    @Override
    public ArrayList<MemberDto> getAll() {
        ArrayList<Member> all = memberDao.getAll();

        ArrayList<MemberDto> admins = new ArrayList<>();

        for (Member admin : all) {
            admins.add(new MemberDto(admin.getId(), admin.getFull_name(), admin.getUsername(), admin.getPassword(), admin.getEmail()));
        }

        return admins;
    }

    @Override
    public void delete(int Id) {
        memberDao.Delete(Id);
    }


}
