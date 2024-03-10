package org.example.Dao.Custom;

import org.example.Dao.SuperDao;

public class DaoFactory {
    private static DaoFactory daoFactory;
    private DaoFactory(){}

    public static  DaoFactory getDaoFactory() {
        return  (daoFactory == null) ? daoFactory = new DaoFactory() : daoFactory;
    }

    public enum DaoType{
        Member ,admin, Books, Branch
    }

    public SuperDao getDao( DaoType daoType ){
        switch ( daoType ){
            case Member :
                return new MemberDaoImpl();

            case admin:
                return new AdminDaoImpl();
            case Books:
                return new BookDaoImpl();
            case Branch:
                return new BranchDaoImpl();
            default:
                return null;
        }
    }
}
