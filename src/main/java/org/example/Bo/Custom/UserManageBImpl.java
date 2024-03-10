package org.example.Bo.Custom;

import org.example.Bo.UserMangeBo;
import org.example.Dao.AdminDao;
import org.example.Dao.Custom.DaoFactory;
import org.example.Dto.AdminDto;
import org.example.Entity.Admin;

import java.util.ArrayList;

public class UserManageBImpl implements UserMangeBo {

    AdminDao adminDao = (AdminDao) DaoFactory.getDaoFactory().getDao( DaoFactory.DaoType.admin );
    @Override
    public ArrayList<AdminDto> getAll() {
        ArrayList<Admin> all = adminDao.getAll();

        ArrayList<AdminDto> admins = new ArrayList<>();

        for (Admin admin : all){
            admins.add(new AdminDto(admin.getId(),admin.getName(),admin.getUsername(),admin.getPassword(),admin.getEmail()));
        }

        return admins;
    }

    @Override
    public int save(AdminDto admin) {
        return adminDao.saved(new Admin(admin.getId(),admin.getName(),admin.getUsername(),admin.getPassword(),admin.getEmail()));
    }
}
