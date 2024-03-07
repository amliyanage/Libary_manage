package org.example.Dao.Custom;

import org.example.Dao.SuperDao;

public class DaoFactory {
    private static DaoFactory daoFactory;
    private DaoFactory(){}

    public static  DaoFactory getDaoFactory() {
        return  (daoFactory == null) ? daoFactory = new DaoFactory() : daoFactory;
    }

    public enum DaoType{
        Member ,admin
    }

    public SuperDao getDao( DaoType daoType ){
        switch ( daoType ){
            case Member :
                return new MemberDaoImpl();

            case admin:
                return new AdminDaoImpl();

            default:
                return null;
        }
    }
}
