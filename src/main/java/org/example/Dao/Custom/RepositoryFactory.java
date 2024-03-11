package org.example.Dao.Custom;

import org.example.Dao.SuperRepository;

public class RepositoryFactory {
    private static RepositoryFactory repositoryFactory;
    private RepositoryFactory(){}

    public static RepositoryFactory getDaoFactory() {
        return  (repositoryFactory == null) ? repositoryFactory = new RepositoryFactory() : repositoryFactory;
    }

    public enum DaoType{
        Member ,admin, Books, Branch
    }

    public SuperRepository getDao(DaoType daoType ){
        switch ( daoType ){
            case Member :
                return new MemberRepositoryImpl();

            case admin:
                return new AdminRepositoryImpl();
            case Books:
                return new BookRepositoryImpl();
            case Branch:
                return new BranchRepositoryImpl();
            default:
                return null;
        }
    }
}
