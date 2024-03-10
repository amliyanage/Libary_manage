package org.example.Bo.Custom;

import org.example.Bo.DashboardBo;
import org.example.Dao.AdminDao;
import org.example.Dao.BookDao;
import org.example.Dao.BranchDao;
import org.example.Dao.Custom.DaoFactory;
import org.example.Dto.AdminDto;
import org.example.Entity.Admin;

public class DashboardBoImpl implements DashboardBo {

    AdminDao adminDao = (AdminDao) DaoFactory.getDaoFactory().getDao( DaoFactory.DaoType.admin );
    BookDao bookDao = (BookDao) DaoFactory.getDaoFactory().getDao( DaoFactory.DaoType.Books );

    BranchDao branchDao = (BranchDao) DaoFactory.getDaoFactory().getDao( DaoFactory.DaoType.Branch );
    @Override
    public void Update(AdminDto Data) throws Exception {
        adminDao.Update(new Admin(Data.getId(),Data.getName(),Data.getUsername(),Data.getPassword(),Data.getEmail()));
    }

    @Override
    public void Delete(int id) {
        adminDao.Delete(id);
    }

    @Override
    public long BookCount(){
        return bookDao.Count();
    }
    @Override
    public long MemberCount(){
        return adminDao.Count();
    }
    @Override
    public long BranchCount(){
        return branchDao.Count();
    }
}
