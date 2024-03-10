package org.example.Bo.Custom;

import org.example.Bo.AdminBo;
import org.example.Dao.AdminDao;
import org.example.Dao.Custom.DaoFactory;
import org.example.Entity.Admin;

public class AdminBoImpl implements AdminBo {

    AdminDao adminDao = (AdminDao) DaoFactory.getDaoFactory().getDao( DaoFactory.DaoType.admin );

    public static int UserId = 0;
    @Override
    public boolean getData(String Id, String Password) {
        Admin data = adminDao.getData(Id);

        if (data != null && Password.equals(data.getPassword())){
            UserId = data.getId();
            return true;
        }
        else {
            return false;
        }
    }
}
