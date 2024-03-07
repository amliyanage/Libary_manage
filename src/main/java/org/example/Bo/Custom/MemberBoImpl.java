package org.example.Bo.Custom;

import org.example.Bo.MemberBo;
import org.example.Dao.Custom.DaoFactory;
import org.example.Dao.MemberDao;
import org.example.Entity.Member;

public class MemberBoImpl implements MemberBo {

    MemberDao memberDao = (MemberDao) DaoFactory.getDaoFactory().getDao( DaoFactory.DaoType.Member );
    @Override
    public boolean Login(int Username, String Password) {
        try {
            Member allData = memberDao.getData(Username);

            if (allData !=null || Password.equals(allData.getPassword())){
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
