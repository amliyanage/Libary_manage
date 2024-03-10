package org.example.Bo.Custom;

import org.example.Bo.AdminBo;
import org.example.Dao.AdminDao;
import org.example.Dao.Custom.DaoFactory;
import org.example.Dto.AdminDto;
import org.example.Entity.Admin;

public class AdminBoImpl implements AdminBo {

    AdminDao adminDao = (AdminDao) DaoFactory.getDaoFactory().getDao( DaoFactory.DaoType.admin );

    public static AdminDto data;
    @Override
    public boolean getData(String Id, String Password) {
        Admin data = adminDao.getData(Id);

        if (data != null && Password.equals(data.getPassword())){
            this.data = new AdminDto(data.getId(),data.getName(),data.getUsername(),data.getPassword(),data.getEmail());
            return true;
        }
        else {
            return false;
        }
    }
}
