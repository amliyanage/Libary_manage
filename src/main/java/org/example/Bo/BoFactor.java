package org.example.Bo;

import org.example.Bo.Custom.*;

public class BoFactor {

    private static BoFactor boFactor;
    private BoFactor(){

    }

    public static BoFactor getBoFactory(){
        return (boFactor == null) ? boFactor = new BoFactor() : boFactor;
    }

    public enum BoType{
        Member,Admin,Search_Book,Register,Manage_Book,UserMange,Branch
    }

    public SuperBo getBo(BoType boType){
        switch (boType){
            case Member :
                return new MemberBoImpl();
            case Admin:
                return new AdminBoImpl();
            case Search_Book:
                return new SearchBookBoImpl();
            case Register:
                return new RegisterBoImpl();
            case Manage_Book:
                return new ManageBookBoImpl();
            case UserMange:
                return new UserManageBImpl();
            case Branch:
                return new BranchBoImpl();
            default:
                return null;
        }
    }
}
