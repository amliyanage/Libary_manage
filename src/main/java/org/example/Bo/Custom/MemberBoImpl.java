package org.example.Bo.Custom;

import org.example.Bo.MemberBo;
import org.example.Dao.Custom.DaoFactory;
import org.example.Dao.MemberDao;
import org.example.Entity.Member;

public class MemberBoImpl implements MemberBo {

    MemberDao memberDao = (MemberDao) DaoFactory.getDaoFactory().getDao( DaoFactory.DaoType.Member );
    @Override
    public boolean Login(String Username, String Password) {
        Member data = memberDao.getData(Username);

        if (data != null && data.getPassword().equals(Password)){
            return true;
        }
        else {
            return false;
        }
    }
}
