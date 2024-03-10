package org.example.Bo.Custom;

import org.example.Bo.DashboardBo;
import org.example.Dao.AdminDao;
import org.example.Dao.Custom.DaoFactory;
import org.example.Dto.AdminDto;
import org.example.Entity.Admin;

public class DashboardBoImpl implements DashboardBo {

    AdminDao adminDao = (AdminDao) DaoFactory.getDaoFactory().getDao( DaoFactory.DaoType.admin );
    @Override
    public void Update(AdminDto Data) throws Exception {
        adminDao.Update(new Admin(Data.getId(),Data.getName(),Data.getUsername(),Data.getPassword(),Data.getEmail()));
    }

    @Override
    public void Delete(int id) {
        adminDao.Delete(id);
    }
}
