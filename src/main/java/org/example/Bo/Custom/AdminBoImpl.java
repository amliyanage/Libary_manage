package org.example.Bo.Custom;

import org.example.Bo.AdminBo;
import org.example.Dao.AdminDao;
import org.example.Dao.Custom.DaoFactory;
import org.example.Entity.Admin;

public class AdminBoImpl implements AdminBo {

    AdminDao adminDao = (AdminDao) DaoFactory.getDaoFactory().getDao( DaoFactory.DaoType.admin );
    @Override
    public boolean getData(int Id, String Password) {
        try {

            Admin data = adminDao.getData(Id);

            if (data !=null || Password.equals(data.getPassword())){
                return true;
            }
            else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
